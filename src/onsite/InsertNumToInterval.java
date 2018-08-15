package onsite;
import java.util.*;
/*
 * 给一堆排好序的non-overlapped interval，要插入一个数字，如果这个数字可以和某个interval的起始时间或者结束时间挨着，
 * 就要把这个数字merge到那个interval之中，如果不挨着，就把数字当成interval插入到那堆interval当中，
 * 比如给定的interval是[1,2], [4,5], [9,10], 插入7的话，结果是[1,2], [4,5], [7,7], [8, 9]，
 * 插入3的话，结果是[1,5], [9,10]
 */
/*
 * 1, covered by range already
 * 2. not covered by range 
 * 	a. first -> smaller than all
 * 	b. last -> larger than all
 * 	c. no adjacent
 *  d. with 1 or 2 adjacent
 */
public class InsertNumToInterval {
	public List<int[]> insertVal(List<int[]> intervals,int val){
		List<int[]> res=new ArrayList<int[]>();
		int low=val;
		int high=val;
		boolean inserted=false;
		for(int i=0;i<intervals.size();i++){
			int[] curr=intervals.get(i);
			if(inserted){
				res.add(curr);
			}
			else{
				if(curr[0]<=val&&curr[1]>=val){
					return intervals;
				}
				else if(curr[1]==low-1){
					low=curr[0];
				}
				else if(curr[1]<low){
					res.add(curr);
				}
				else if(curr[0]==high+1){
					high=curr[1];
					inserted=true;
					res.add(new int[]{low,high});
				}
				else if(curr[0]>high+1){
					if(!inserted){
						inserted=true;
						res.add(new int[]{low,high});
					}
					res.add(curr);
				}
			}
		}
		if(!inserted){
			res.add(new int[]{low,high});
		}
		return res;
	}
	public boolean checkRes(List<int[]> res,int[][] target){
		if(res.size()!=target.length){
			return false;
		}
		for(int i=0;i<res.size();i++){
			int[] a1=res.get(i);
			int[] a2=target[i];
			if(a1[0]!=a2[0]||a1[1]!=a2[1]){
				return false;
			}
		}
		return true;
	}
}
