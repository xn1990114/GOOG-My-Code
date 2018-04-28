package onsite;
/*
 * 给我一个list of int， 找出其中最小cycle的长度。 比如 1， 2， 1， 2， cycle的长度就是2。
 * 然后1， 2， 1， 2， 1 的最小长度也是2。 
 * 然后1， 2， 1， 2， 3 的长度应该是5， 因为整个list没有在repeat。 
 * 然后1， 2， 1， 2， 1， 2，1，2的最小长度也是2.  
 * 然后1， 2， 1， 2， 3，1，2的最小长度是5.  
 */
public class MinimumIntegerCycle {
	public int findMinReapeatingCycle(int[] nums){
		if(nums==null||nums.length==0){
			return 0;
		}
		int res=1;
		int patternPointer=0;
		for(int scanPointer=1;scanPointer<nums.length;scanPointer++){
			if(nums[patternPointer]!=nums[scanPointer]){
				patternPointer=0;
				res=scanPointer-patternPointer+1;
			}
			else{
				patternPointer++;
			}
		}
		return res;
	}
}
