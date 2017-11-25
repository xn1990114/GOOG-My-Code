package phone;
/*
第一题
给一个只含有0和1的输入，求最长连续1的长度。
变种2: 
如果允许把其中一个0变成1，输出同上
变种3:
如果允许把k个0都变成1, 输出同上

 */
public class MaxCotinuousOnes {
	public int findMaxLenWithKChange(int[] nums,int k){
		int max=0;
		int start=0;
		int changed=0;
		for(int end=0;end<nums.length;end++){
			if(nums[end]==0){
				changed++;
			}
			while(changed>k){
				if(nums[start]==0){
					changed--;
				}
				start++;
			}
			max=Math.max(max, end-start+1);
		}
		return max;
	}
}
