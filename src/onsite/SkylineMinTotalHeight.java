package onsite;
//代表你往前看，往左看，能看到的最高的building。 然后让你估算这个城市的大概的体积

import java.util.Arrays;

// missing info, assuming need to find the min totalHeight
public class SkylineMinTotalHeight {
	public int findMinTotalHeight(int[] frontView,int[] leftView){
		if(frontView==null||frontView.length==0||leftView==null||leftView.length==0){
			return 0;
		}
		Arrays.sort(frontView);
		Arrays.sort(leftView);
		int[][] matrix=new int[frontView.length][leftView.length];
		int minHeight=0;
		for(int i=0;i<frontView.length;i++){
			int curr=frontView[i];
			int index=binarySearch(leftView,curr);
			minHeight=minHeight+(curr-matrix[i][index]);
			matrix[i][index]=curr;
		}
		for(int i=0;i<leftView.length;i++){
			int curr=leftView[i];
			int index=binarySearch(frontView,curr);
			minHeight=minHeight+(curr-matrix[index][i]);
			matrix[index][i]=curr;
		}
		
		return minHeight;
	}
	public int binarySearch(int[] nums,int target){
		int start=0;
		int end=nums.length-1;
		while(start<=end){
			int mid=start+(end-start)/2;
			if((mid==0||nums[mid-1]<target)&&nums[mid]>=target){
				return mid;
			}
			else if(nums[mid]>=target){
				end=mid-1;
			}
			else{
				start=mid+1;
			}
		}
		return -1;
	}
}
