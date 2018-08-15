package onsite;
import java.util.*;
/*
 * 给定一个Quack class。基本上就是一个a stack or queue，已经按升序排好， 
 * .pop() will randomly pop from head or tail of this data structure. 要求返利用这个.pop()，返回降序排列的array。
 */
public class QuackToSortedList {
	Deque<Integer> dq;
	public QuackToSortedList(int[] nums){
		Arrays.sort(nums);
		this.dq=new LinkedList<Integer>();
		for(int i=0;i<nums.length;i++){
			dq.offerLast(nums[i]);
		}
	}
	private int pop(){
		double r=Math.random();
		if(r<0.5){
			return dq.pollFirst();
		}
		return dq.pollLast();
	}
	public List<Integer> makeDescList(){
		List<Integer> res=new ArrayList<Integer>();
		Stack<Integer> desc=new Stack<Integer>();
		while(!this.dq.isEmpty()){
			int curr=this.pop();
			if(desc.isEmpty()||curr>=desc.peek()){
				desc.push(curr);
			}
			else{
				while(!desc.isEmpty()&&desc.peek()>curr){
					res.add(desc.pop());
				}
				desc.push(curr);
			}
		}
		while(!desc.isEmpty()){
			res.add(desc.pop());
		}
		return res;
	}
}
