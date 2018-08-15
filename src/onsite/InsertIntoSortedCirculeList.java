package onsite;

public class InsertIntoSortedCirculeList {
	public class ListNode{
		int val;
		public ListNode next;
		public ListNode(int val){
			this.val=val;
		}
	}
	public ListNode insertNode(ListNode head,int valueToInsert){
		ListNode toAdd=new ListNode(valueToInsert);
		if(head==null){
			toAdd.next=toAdd;
			return toAdd;
		}
		ListNode curr=head;
		boolean inserted=false;
		while(curr.next!=head){
			if(curr.val<=valueToInsert&&curr.next.val>valueToInsert){
				toAdd.next=curr.next;
				curr.next=toAdd;
				inserted=true;
				break;
			}
			curr=curr.next;
		}
		if(!inserted){
			toAdd.next=head;
			curr.next=toAdd;
		}
		return valueToInsert<head.val?toAdd:head;
	}
	public String serialize(ListNode head){
		ListNode curr=head;
		StringBuilder sb=new StringBuilder();
		do{
			sb.append(curr.val+",");
			curr=curr.next;
		}while(curr!=head);
		return sb.toString();
	}
}
