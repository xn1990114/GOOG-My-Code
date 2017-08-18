package onsite;
/*
 * Write a function.
Input: int[] that is sorted
Output: A int value from the int[]. 
Where the value occurs in the array at least (length of array / 4) times
Example: [1, 2, 3, 4, 1, 6, 7, 2]. Length of array is 8. 8/4 = 2. 
Return item that occurs at least 2 times. Return value 1 or 2.
if sorted
要求不断优化，o(n) space o(n) time -> o(1) space o(n) time -> o(1) space o(logn) time
 */
public class MajorityElement4 {
	public int findMajority(int[] nums){
		if(nums.length==0){
			return 0;
		}
		for(int i=1;i<=4;i++){
			int curr=nums[i*(nums.length-1)/4];
			int s=binarySearch(nums,0,nums.length-1,true,curr);
			int e=binarySearch(nums,0,nums.length-1,false,curr);
			if((e-s+1)*4>=nums.length){
				return curr;
			}
		}
		return 0;
	}
	public int binarySearch(int[] nums,int start,int end, boolean findStart,int target){
		while(start<=end){
			int mid=start+(end-start)/2;
			if(nums[mid]==target){
				if(findStart){
					if(mid==0||nums[mid-1]!=target){
						return mid;
					}
					end=mid-1;
				}
				else if(!findStart){
					if(mid==nums.length-1||nums[mid+1]!=target){
						return mid;
					}
					start=mid+1;
				}
			}
			else if(nums[mid]<target){
				start=mid+1;
			}
			else{
				end=mid-1;
			}
		}
		return 0;
	}
}
