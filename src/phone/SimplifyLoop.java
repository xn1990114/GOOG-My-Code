package phone;

import java.util.*;

/*
把nested for loop 换成 一个 for loop的
follow up1： 用写出来的for loop 打印2d array
follow up2： 2d array 每个row 长度不同
*/
public class SimplifyLoop {
	// follow up1： 用写出来的for loop 打印2d array
	public List<Integer> print2DPerfectArray(int[][] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0 || nums[0].length == 0) {
			return res;
		}
		int len = nums.length * nums[0].length;
		int col = nums[0].length;
		for (int index = 0; index < len; index++) {
			int val = nums[index / col][index % col];
			res.add(val);
		}
		return res;
	}

	// follow up2： 2d array 每个row 长度不同
	public List<Integer> print2DInPerfectArray(int[][] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null||nums.length==0) {
			return res;
		}
		int len=0;
		for(int i=0;i<nums.length;i++){
			len=len+(nums[i]==null?0:nums[i].length);
		}
		if(len==0){
			return res;
		}
		int r=0;
		int c=0;
		for(int i=0;i<len;i++){
			if(nums[r]==null||c==nums[r].length){
				i--;
				r++;
				c=0;
				continue;
			}
			res.add(nums[r][c]);
			c++;
		}
		return res;
	}

	public boolean isCorrectResult(List<Integer> res) {
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i) != i) {
				return false;
			}
		}
		return true;
	}
}
