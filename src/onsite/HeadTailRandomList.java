package onsite;
import java.util.*;
/*
 * 一个奇怪的list，push的时候是push到头上(最后一个元素)，pop的时候按概率从头尾pop一个。
 * 问如果push了一个sorted list进去，怎么pop一个sorted出来。
 * 二问如果pop是从头出来，而push是概率到头尾，怎么pop一个sorted。
 */
public class HeadTailRandomList {
	class Node{
		int val;
		Node pre;
		Node next;
		public Node(int val){
			this.val=val;
		}
	}
	Node head;
	Node tail;
	public HeadTailRandomList(){
		this.head=new Node(0);
		this.tail=new Node(0);
		this.head.next=tail;
		this.tail.pre=head;
	}
	//push的时候是push到头上，pop的时候按概率从头尾pop一个。问如果push了一个sorted list进去，怎么pop一个sorted出来。
	public List<Integer> getSortedUsingRandomPop(){
		List<Integer> res=new ArrayList<Integer>();
		Stack<int[]> high=new Stack<int[]>();
		Queue<int[]> low=new LinkedList<int[]>();
		int[] last={this.popWithRandom(),1};
		while(!this.isEmpty()){
			int next=this.popWithRandom();
			if(next>last[0]){
				low.offer(last);
				last=new int[]{next,1};
			}
			else if(next<last[0]){
				high.push(last);
				last=new int[]{next,1};
			}
			else{
				last[1]++;
			}
		}
		high.push(last);
		while(!low.isEmpty()){
			int[] top=low.poll();
			for(int i=0;i<top[1];i++){
				res.add(top[0]);
			}
		}
		while(!high.isEmpty()){
			int[] top=high.pop();
			for(int i=0;i<top[1];i++){
				res.add(top[0]);
			}
		}
		return res;
	}
	public List<Integer> getSortedUsingRandomPush(){
		List<Integer> l1=new ArrayList<Integer>();
		List<Integer> l2=new ArrayList<Integer>();
		List<Integer> res=new ArrayList<Integer>();
		int last=this.pop();
		l1.add(last);
		while(!this.isEmpty()){
			int curr=this.pop();
			if(curr<last){
				l1.add(curr);
			}
			else if(curr>last){
				l2.add(curr);
			}
			else{
				if(l2.isEmpty()){
					l1.add(curr);
				}
				else{
					l2.add(curr);
				}
			}
			last=curr;
		}
		Collections.reverse(l1);
		int i1=0;
		int i2=0;
		while(i1<l1.size()||i2<l2.size()){
			if(i1<l1.size()&&i2<l2.size()){
				if(l1.get(i1)<l2.get(i2)){
					res.add(l1.get(i1));
					i1++;
				}
				else{
					res.add(l2.get(i2));
					i2++;
				}
			}
			else if(i1<l1.size()){
				res.add(l1.get(i1));
				i1++;
			}
			else{
				res.add(l2.get(i2));
				i2++;
			}
		}
		return res;
	}
	public void push(int val){
		insertAfter(new Node(val),this.tail.pre);
	}
	public void pushWithRandom(int val){
		int num=(int)(Math.random()*2);
		if(num==0){
			insertAfter(new Node(val),this.head);
		}
		else{
			insertAfter(new Node(val),this.tail.pre);
		}
	}
	public void insertAfter(Node toadd,Node pre){
		toadd.next=pre.next;
		pre.next.pre=toadd;
		toadd.pre=pre;
		pre.next=toadd;
	}
	public boolean isEmpty(){
		return this.head.next==this.tail;
	}
	public int pop(){
		return popAfter(this.head);
	}
	public int popWithRandom(){
		int num=(int)(Math.random()*2);
		if(num==0){
			return popAfter(this.head);
		}
		else{
			return popAfter(this.tail.pre.pre);
		}
	}
	public int popAfter(Node pre){
		Node toremove=pre.next;
		toremove.pre.next=toremove.next;
		toremove.next.pre=toremove.pre;
		return toremove.val;
	}
}
