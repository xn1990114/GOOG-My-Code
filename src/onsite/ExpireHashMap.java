package onsite;
import java.util.*;
/*
 * 实现一个hashmap，其中的每个元素包含一个duration，超出duration的元素需要expire掉，写出get和put方法.
 * follow up，如何实现一个类似iterator的东西使得可以每次get任意数量的结果
 */
/*
 * for followup, simply iterate through the linkedlist.
 * below used a customized list to that delete is faster -- not required above. 
 */
public class ExpireHashMap <T,V>{
	@SuppressWarnings("hiding")
	class Node <T>{
		Node<T> previous;
		Node<T> next;
		T key;
		long timeStamp;
		public Node(T key,long time){
			this.key=key;
			this.timeStamp=time;
		}
	}
	Node<T> head;
	Node<T> tail;
	public Map<T,V> valueMap;// map key and value
	public Map<T,Node<T>> nodeMap;// mapkey and node;
	public ExpireHashMap(){
		this.valueMap=new HashMap<T,V>();
		this.nodeMap=new HashMap<T,Node<T>>();
		this.head=new Node<T>(null,-1);
		this.tail=head;
	}
	public void put(T key,V value,long time){
		if(this.valueMap.containsKey(key)){
			Node<T> temp=this.nodeMap.get(key);
			if(temp==tail){
				tail=temp.previous;
			}
			temp.previous.next=temp.next;
			if(temp.next!=null){
				temp.next.previous=temp.previous;
			}
		}
		Node<T> curr=new Node<T>(key,time);
		tail.next=curr;
		curr.previous=tail;
		tail=curr;
		this.valueMap.put(key, value);
		this.nodeMap.put(key, tail);
	}
	public V get(T key,long time){
		while(head.next!=null&&head.next.timeStamp<time){
			T tempKey=head.next.key;
			this.valueMap.remove(tempKey);
			this.nodeMap.remove(tempKey);
			head.next=head.next.next;
			if(head.next.next!=null){
				head.next.next.previous=head;
			}
		}
		if(head.next==null){
			tail=head;
		}
		return this.valueMap.get(key);
	}
}
