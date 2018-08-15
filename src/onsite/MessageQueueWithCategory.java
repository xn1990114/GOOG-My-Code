package onsite;

import java.util.*;

import onsiteTester.AudioMessage;
import onsiteTester.Message;
import onsiteTester.TextMessage;

/*
 * 设计一个数据结构，存message，FIFO。两个功能，往里塞，往外拿。message可能有不同的type，
 * 往外拿可以不管type直接取下一个，或者设定一个type，去这个type的下一个。我用的链表，node能指到其他同type的node。
 */
// message interface and sub classes are implemented in the tester folder.
public class MessageQueueWithCategory {
	class ListNode {
		ListNode pre;
		ListNode next;
		ListNode nextSameType;
		Message mg;

		public ListNode(Message m) {
			this.mg = m;
		}
	}

	ListNode head;
	ListNode tail;
	Map<String, ListNode[]> map;

	public MessageQueueWithCategory() {
		this.head = new ListNode(null);
		this.tail = new ListNode(null);
		head.next = tail;
		tail.pre = head;
		this.map = new HashMap<String, ListNode[]>();
		map.put("Audio", new ListNode[2]);
		map.put("Text", new ListNode[2]);
	}

	public void offer(Message m) {
		if(m==null){
			return;
		}
		ListNode toadd = new ListNode(m);
		toadd.pre = tail.pre;
		tail.pre.next = toadd;
		tail.pre = toadd;
		toadd.next = tail;
		ListNode[] targetList = null;
		if (m instanceof AudioMessage) {
			targetList = map.get("Audio");
		} else if (m instanceof TextMessage) {
			targetList = map.get("Text");
		}
		if (targetList == null) {
			return;
		}
		if (targetList[0] == null) {
			targetList[0] = toadd;
			targetList[1] = toadd;
		} else {
			ListNode last = targetList[1];
			last.nextSameType = toadd;
			targetList[1] = toadd;
		}
	}

	public Message pollAllType() {
		if (head.next == tail) {
			return null;
		}
		ListNode res = head.next;
		res.pre.next = res.next;
		res.next.pre = res.pre;
		ListNode[] targetList = null;
		if (res.mg instanceof AudioMessage) {
			targetList = map.get("Audio");
		} else if (res.mg instanceof TextMessage) {
			targetList = map.get("Text");
		}
		if (targetList == null) {
			return res.mg;
		}
		if (targetList[1] == res) {
			targetList[0] = null;
			targetList[1] = null;
		} else {
			targetList[0] = targetList[0].nextSameType;
		}
		return res.mg;
	}

	public Message pollType(String type) {
		ListNode[] targetList = map.get(type);
		if (targetList == null || targetList[0] == null) {
			return null;
		}
		ListNode res = targetList[0];
		if (targetList[1] == res) {
			targetList[0] = null;
			targetList[1] = null;
		} else {
			targetList[0] = res.nextSameType;
		}
		res.pre.next = res.next;
		res.next.pre = res.pre;
		return res.mg;
	}
}
