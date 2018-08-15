package onsite;

import java.util.*;

//一个链表是一个环， 然后我们按照规律删除奇数的节点


// missing info: assume the index of each node is detemined before entering the cycle
public class DeleteOddNodeInLinkedList {
	public class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int val){
			this.val=val;
		}
	}
	public List<Integer> removeOddNodes(ListNode head){
		List<Integer> res=new ArrayList<Integer>();
		ListNode curr=head;
		while(curr!=null){
			if(curr.next==curr){
				res.add(curr.val);
				curr=null;
			}
			else{
				res.add(curr.next.val);
				curr.next=curr.next.next;
				curr=curr.next;
			}
		}
		return res;
	}
}
