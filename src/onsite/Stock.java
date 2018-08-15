package onsite;
import java.util.*;
/*
 * Design a data structure to show stock information of a company in a day: current price, high price and low price.

        functions that need implementations:
        1. update(timestamp t2, price): timestamp can be an old one or a new one. 
        2. delete(timestamp t1): delete the data at timestamp t1
        3. getCurrentPrice(), getHighPrice(), getLowPrice().


        Example: . 
                                                                current        high         low
                        update(1, 5)                5                           5                        5
                        update(2, 8)                8                           8                        5
                        update(1, 10)                8                           10                        8
                        delete(2)                        10                           10                        10
 */
/*
 * 针对各种情况进行实现和算法复杂度讨论。（
 * 大量更新？  Map<Integer,Double> timeMap time->price
 * 大量查询？	 Double LinkedList price low->high
 * invalidate很多   timeMap<Integer,ListNode>+linkedList
 * invalidate很少？  2 pq + timeMap + currentTimeNode
 * all log N -> create custom class PriceWithTime(double price,int time) + TreeSet<PriceWithTime> TreeMap(time->priceWithTime)
 */
public class Stock {
	class Node{
		int timeStamp;
		int price;
		public Node(int time,int price){
			this.timeStamp=time;
			this.price=price;
		}
	}
	TreeSet<Node> priceSet;
	TreeMap<Integer,Node> map;// map time and node;
	public Stock(){
		this.priceSet=new TreeSet<Node>(new Comparator<Node>(){
			public int compare(Node n1,Node n2){
				return n1.price-n2.price;
			}
		});
		this.map=new TreeMap<Integer,Node>();
	}

	public void update(int time,int price){
		delete(time);
		Node newNode=new Node(time,price);
		this.priceSet.add(newNode);
		this.map.put(time, newNode);
	}
	public void delete(int time){
		if(!this.map.keySet().contains(time)){
			return;
		}
		Node curr=map.get(time);
		map.remove(time);
		this.priceSet.remove(curr);
	}
	
	public int getCurrentPrice(){
		if(this.map.keySet().isEmpty()){
			return 0;
		}
		int time=this.map.lastKey();
		return this.map.get(time).price;
	}
	public int getHigh(){
		if(this.priceSet.isEmpty()){
			return 0;
		}
		return this.priceSet.last().price;
	}
	public int getLow(){
		if(this.priceSet.isEmpty()){
			return 0;
		}
		return this.priceSet.first().price;
	}
}
