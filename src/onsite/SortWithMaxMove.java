package onsite;

import java.util.*;
/*
 * 给一个数组，每个element可以最多backward移动k个位置，
 * 但forward可以移动任意个位置，让尽可能的将这个数组排序，在时间复杂度上讨论了很久，
 * 从最初的n^2算法，到k*n算法，最后改进到logk*n算法
 * 
 */
public class SortWithMaxMove {
	public int[] sortWithKMove(int[] nums,int k){
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		for(int i=0;i<k;i++){
			pq.offer(nums[i]);
		}
		for(int i=0;i<nums.length;i++){
			if(i+k<nums.length){
				pq.offer(nums[i+k]);
			}
			nums[i]=pq.poll();
		}
		return nums;
	}
}
