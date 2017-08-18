package onsite;

public class ReversePrintN_naryTree {
	public class Node{
		public int val;
		public Node[] child;
		Node next;
		public Node(int val,int len){
			this.val=val;
			this.child=new Node[len];
		}
	}
	public void reversePrint(Node root){
		Node nexthead=root;;
		Node lasthead=root;
		int count=1;
		while(nexthead!=null){
			Node curr=nexthead;
			Node last=null;
			nexthead=null;
			int newcount=0;
			for(int i=0;i<count;i++){
				for(int j=curr.child.length-1;j>=0;j--){
					if(curr.child[j]==null){
						continue;
					}
					newcount++;
					if(nexthead==null){
						nexthead=curr.child[j];
						last=nexthead;
					}
					else{
						last.next=curr.child[j];
						last=last.next;
					}
				}
				curr=curr.next;
			}
			if(last==null){
				break;
			}
			last.next=lasthead;
			lasthead=nexthead;
			count=newcount;
		}
		Node curr=lasthead;
		while(curr!=null){
			System.out.print(curr.val+" ");
			curr=curr.next;
		}
	}
}
