package onsite;

import java.util.*;

//一个n的array怎随机挑选k个组成个subset
public class RandomSelectKFromArray {
	public List<Integer> getRandomKValue(int[] nums,int k){
		List<Integer> res=new ArrayList<Integer>();
		if(nums.length==0||nums.length<k){
			return res;
		}
		int totalElementCount=0;
		for(int i=0;i<nums.length;i++){
			totalElementCount++;
			if(i<k){
				res.add(nums[i]);
			}
			else{
				int index=(int)(Math.random()*totalElementCount);
				if(index<k){
					res.set(index, nums[i]);
				}
			}
		}
		return res;
	}
}
