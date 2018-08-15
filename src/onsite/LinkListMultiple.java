package onsite;

/*
 * 两个很大的数字，用LinkedList表示， 比如3->2->1->0，然后要做乘法，输出也是LinkedList，
 * 就brute force模拟了手算的过程，分析了时间复杂度m*n
 */
public class LinkListMultiple {
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode mutipleLinkedList(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return new ListNode(0);
		}
		l1 = reverseAndCleanUp(l1);
		l2 = reverseAndCleanUp(l2);
		int totalLen = 0;
		ListNode counterNode = l1;
		while (counterNode != null) {
			totalLen++;
			counterNode = counterNode.next;
		}
		counterNode = l2;
		while (counterNode != null) {
			totalLen++;
			counterNode = counterNode.next;
		}
		ListNode res = makeEmptyList(totalLen);
		int offset = 0;
		while (l1 != null) {
			ListNode multiRes = multiple(l1.val, l2);
			addNum(res, multiRes, offset);
			offset++;
		}
		return reverseAndCleanUp(res);
	}

	public ListNode makeEmptyList(int size) {
		ListNode head = null;
		ListNode parent = null;
		for (int i = 0; i < size; i++) {
			ListNode toadd = new ListNode(0);
			if (head == null) {
				head = toadd;
			} else {
				parent.next = toadd;
			}
			parent = toadd;
		}
		return head;
	}

	public ListNode multiple(int mul, ListNode list) {
		ListNode newHead = new ListNode(0);
		ListNode parent = new ListNode(0);
		int extra = 0;
		while (list != null) {
			int sum = extra + mul * list.val;
			parent.next = new ListNode(sum % 10);
			extra = sum / 10;
			parent = parent.next;
			list = list.next;
		}
		if (extra > 0) {
			parent.next = new ListNode(extra);
		}
		return newHead.next;
	}

	public void addNum(ListNode l1, ListNode l2, int offSet) {
		int extra = 0;
		for (int i = 0; i < offSet; i++) {
			ListNode toadd = new ListNode(0);
			toadd.next = l2;
			l2 = toadd;
		}
		while (l2 != null || extra > 0) {
			int sum = extra + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : null);

			l1.val = sum % 10;
			extra = extra / 10;
			l1 = l1.next;
			if (l2 != null) {
				l2 = l2.next;
			}
		}
	}

	public ListNode reverseAndCleanUp(ListNode l) {
		ListNode last = null;
		while (l != null) {
			ListNode next = l.next;
			l.next = last;
			last = l;
			l = next;
		}
		while (last != null && last.val == 0) {
			last = last.next;
		}
		if (last == null) {
			return new ListNode(0);
		}
		return last;
	}
}
