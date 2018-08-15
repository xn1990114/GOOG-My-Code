package onsite;

import java.util.Arrays;
import java.util.PriorityQueue;

// move element at most K left, as much sorted as can
public class MoveKLeftToSort {
	public void sortByMoveLeftK(int[] nums,int k){
		if(nums==null||nums.length==0||k<=0){
			return;
		}
		if(k>=nums.length-1){
			Arrays.sort(nums);
			return;
		}
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		int writeIndex=0;
		for(int i=0;i<nums.length;i++){
			pq.offer(nums[i]);
			if(pq.size()>=k+1){
				nums[writeIndex]=pq.poll();
				writeIndex++;
			}
		}
		while(!pq.isEmpty()){
			nums[writeIndex]=pq.poll();
			writeIndex++;
		}
	}
}
