package onsite;
import java.util.*;

public class MaxCutToSortArray {
	public List<Integer> findCutPoints(int[] nums){
		List<Integer> res=new ArrayList<Integer>();
		if(nums==null||nums.length==0){
			return res;
		}
		int[] min=new int[nums.length];
		for(int i=nums.length-1;i>=0;i--){
			min[i]=Math.min(nums[i], i==nums.length-1?Integer.MAX_VALUE:min[i+1]);
		}
		int currMax=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++){
			currMax=Math.max(nums[i], currMax);
			if(i==nums.length-1||currMax<=min[i+1]){
				res.add(i);
				currMax=Integer.MIN_VALUE;
			}
		}
		return res;
	}
	public List<Integer> findCutPointsWithSort(int[] nums){
		List<Integer> res=new ArrayList<Integer>();
		if(nums==null||nums.length==0){
			return res;
		}
		int[] sorted=nums.clone();
		Arrays.sort(sorted);
		int numsMax=Integer.MIN_VALUE;
		int numsMaxCount=0;
		int sortedMax=Integer.MIN_VALUE;
		int sortedMaxCount=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]>numsMax){
				numsMax=nums[i];
				numsMaxCount=1;
			}
			else if(nums[i]==numsMax){
				numsMaxCount++;
			}
			if(sorted[i]>sortedMax){
				sortedMax=sorted[i];
				sortedMaxCount=1;
			}
			else if(sorted[i]==sortedMax){
				sortedMaxCount++;
			}
			if(numsMax==sortedMax&&numsMaxCount==sortedMaxCount){
				res.add(i);
				numsMax=Integer.MIN_VALUE;
				numsMaxCount=0;
				sortedMax=Integer.MIN_VALUE;
				sortedMaxCount=0;
			}
		}
		return res;
	}
	public boolean isSame(List<Integer> r1,List<Integer> r2){
		if(r1.size()!=r2.size()){
			return false;
		}
		for(int i=0;i<r1.size();i++){
			int n1=r1.get(i);
			int n2=r2.get(i);
			if(n1!=n2){
				return false;
			}
		}
		return true;
	}
}
