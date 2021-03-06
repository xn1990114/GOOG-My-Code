package phone;
/*
 * 问了一道题

给一个数组，n的长度（n >=1），含有所有1 - n的数字，要求得到一个最小的index，满足条件: 如果把数组小于等于index的部分排序好，
并且把数组大于index的部分排序好，那么整个数组就排序好了。看题目可能有点绕，以下是当时给的两个examples：
3 1 2 5 4. 
返回的index为2，即如果(3,1,2)和(5,4)分别排序完成，那么整个数组就排序好了。
2 4 3 1
返回的index为3
注意由于含有所有的1-n的数字，所以数组里是没有重复元素的。
 */
public class SplitArrayToSort {
	public int findCutPoint(int[] nums){
		int max=0;
		for(int i=0;i<nums.length;i++){
			max=Math.max(max, nums[i]);
			if(max-1==i){
				return i;
			}
		}
		return nums.length-1;
	}
}
