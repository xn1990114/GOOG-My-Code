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
	long duration;
	Node<T> head;
	Node<T> tail;
	public CustomHashMap<T,V> valueMap;// map key and value
	public CustomHashMap<T,Node<T>> nodeMap;// map key and node;
	public ExpireHashMap(long duration){
		this.valueMap=new CustomHashMap<T,V>();
		this.nodeMap=new CustomHashMap<T,Node<T>>();
		this.head=new Node<T>(null,-1);
		this.tail=new Node<T>(null,Long.MAX_VALUE);
		head.next=tail;
		tail.previous=head;
		this.duration=duration;
	}
	public void put(T key,V value,long time){
		cleanUp(time);
		if(this.valueMap.containsKey(key)){
			remove(key);
		}
		Node<T> curr=new Node<T>(key,time);
		
		tail.previous.next=curr;
		curr.previous=tail.previous;
		tail.previous=curr;
		curr.next=tail;
		this.valueMap.put(key, value);
		this.nodeMap.put(key, curr);
	}
	public V get(T key,long time){
		cleanUp(time);
		return this.valueMap.get(key);
	}
	public void remove(T key){
		Node<T> curr=nodeMap.get(key);
		if(curr==null){
			return;
		}
		curr.previous.next=curr.next;
		curr.next.previous=curr.previous;
		valueMap.remove(curr.key);
		nodeMap.remove(curr.key);
	}
	public void cleanUp(long timestamp){
		while(head.next!=tail){
			Node<T> curr=head.next;
			if(curr.timeStamp<timestamp-duration){
				remove(curr.key);
			}
			else{
				break;
			}
		}
	}
}
