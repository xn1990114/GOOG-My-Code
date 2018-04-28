package onsite;
/*
 * 在一个sorted array中找第k个缺失元素。比如[2,3,5,7], k = 0: 返回4， k = 1：返回6
 */
public class FirstMissingElement {
	public int findFirstElement(int[] nums, int k){
		if(nums==null||nums.length==0||k<0){
			return 0;
		}
		k++;
		int exp=nums[0];
		for(int i=0;i<nums.length;i++){
			if(nums[i]>exp){
				int countMissing=nums[i]-exp;
				if(countMissing>=k){
					return exp+k-1;
				}
				else{
					k=k-countMissing;
				}
			}
			exp=nums[i]+1;
		}
		return exp+k-1;
	}
}
