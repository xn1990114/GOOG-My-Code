package onsite;
//给一个linked list，让反向打印出来。不能破坏链表（反转输出之后再反转也不行）。空间复杂度需要小于O(n), 
//时间复杂度也要小于O(n^2)。我的解法满足这两个要求，但他还说有更好的解法。
public class ReversePrintLinkedList {
	public class ListNode{
		public ListNode next;
		public int val;
		public ListNode(int val){
			this.val=val;
		}
	}
	public void reversePrint(ListNode head){
		if(head==null){
			System.out.println("Empty");
			return;
		}
		ListNode curr=head;
		while(curr.next!=null){
			curr=curr.next;
		}
		splitList(head,curr);
	}
	public void splitList(ListNode start,ListNode end){
		if(start==null){
			return;
		}
		if(start==end){
			System.out.print(start.val+",");
			return;
		}
		int count=0;
		ListNode curr=start;
		while(curr!=end){
			count++;
			curr=curr.next;
		}
		count=(count-1)/2;
		curr=start;
		for(int i=0;i<count;i++){
			curr=curr.next;
		}
		ListNode mid=curr.next;
		if(mid!=end){
			splitList(mid.next,end);
		}
		System.out.print(mid.val+",");
		splitList(start,curr);
	}
}
