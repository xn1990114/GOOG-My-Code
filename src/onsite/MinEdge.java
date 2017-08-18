package onsite;

import java.util.*;
/*
 * 给一个array，找出最长的连续的sub array，使得这个sub array的两端的元素小于中间所有的元素。
 * lz最开始用的n^3的解法，
 * 然后再提示下到了n^2的解法，最后再面试官的带领下实现了O（n）的解法
 */
public class MinEdge {
	public int findMaxLength(int[] nums){
		int left=0;
		int max=0;
		for(int i=1;i<nums.length;i++){
			if(nums[i]<=nums[left]){
				max=Math.max(max, i-left+1);
				left=i;
			}
		}
		int right=nums.length-1;
		for(int i=nums.length-1;i>=0;i--){
			if(nums[i]<=nums[right]){
				max=Math.max(max, right-i+1);
				right=i;
			}
		}
		
		return max;
	}
}
