package onsite;
import java.util.*;
/*
给一个长度为n的数组，把数组分为k段，每段至少一个数
每段内的数俩俩相乘的和作为这段的权重，求如何划分数组使得所有段的权重之和最大.
比如数组是这样的
[1, 2, 32, 7, 2, 23, 3, 4, 32, 2]
k是3

如果这样划分
[1, 2, 32, 7,   |   2, 23, 3,   |   4, 32, 2]
则
第一段的权重 s1 = 1 * 2 + 1 * 32 + 1 * 7 + 2 * 32 + 2 * 7 + 32 * 7
第二段的权重 s2 = 2 * 23 + 2 * 3 + 23 * 3
第三段的权重 s3 = 4 * 32 + 4 * 2 + 32 * 2
所有权重的和则是 s = s1 + s2 + s3
返回最大可能得到的所有权重的和s. 
不需要返回怎么划分，只需要返回最大的和
 */
public class WeightSumOfKSubArray {
	public int calMaxSum(int[] nums,int k){
		if(nums.length<k){
			return 0;
		}
		
		int[][] pairs=new int[nums.length][nums.length];
		for(int i=0;i<nums.length;i++){
			int total=0;
			for(int j=i+1;j<nums.length;j++){
				for(int tempS=i;tempS<j;tempS++){
					total=total+nums[tempS]*nums[j];
				}
				pairs[i][j]=total;
			}
		}
		int[] res=new int[nums.length];
		for(int i=0;i<res.length;i++){
			res[i]=pairs[0][i];
		}
		for(int round=1;round<k;round++){
			int start=round;
			int[] next=new int[nums.length];
			Arrays.fill(next, Integer.MIN_VALUE);
			for(int s=start;s<nums.length;s++){
				for(int e=s;e<nums.length;e++){
					next[e]=Math.max(next[e], (s==0?0:res[s-1])+pairs[s][e]);
				}
			}
			res=next;
		}
		return res[res.length-1];
	}
}
