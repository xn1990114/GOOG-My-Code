package onsite;
//亚裔小哥。给一个排好序的数组，中间的空缺的值当做坑，
//要求返回倒数第K个坑的值。[1,2,3,4,6,9,10] 坑就是5，7，8。如果给K=1,就返回8，K=2就返回7。

//assuming the nums[0] and nums[nums.length-1] defines range and k is always valid
public class KthMissingNumber {
	public int linearMethod(int[] nums,int k){
		if(nums==null||nums.length==0||k<=0){
			return -1;
		}
		int nextTarget=nums[nums.length-1];
		int index=nums.length-1;
		while(index>=0){
			if(nextTarget>nums[index]){
				k--;
				if(k==0){
					return nextTarget;
				}
				nextTarget--;
			}
			else if(nextTarget==nums[index]){
				index--;
				nextTarget--;
			}
			else{
				index--;
			}
		}
		return -1;
	}
	// can't have duplicate
	// proper value = high-(nums.length-1-i) ; diff=actual -proper
	// actual position
	public int binarySearch(int[] nums,int k){
		int start=1;
		int end=nums.length-1;
		while(start<=end){
			int mid=start+(end-start)/2;
			int low=calTotalMissing(nums,mid-1);
			int high=calTotalMissing(nums,mid);
			if(low>=k&&high<k){
				return nums[mid]-(k-high);
			}
			else if(high>=k){
				start=mid+1;
			}
			else{
				end=mid-1;
			}
		}
		return -1;
	}
	public int calTotalMissing(int[] nums,int index){
		int properValue=nums[nums.length-1]-(nums.length-1-index);
		return properValue-nums[index];
	}
}
