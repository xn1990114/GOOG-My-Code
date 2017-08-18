package onsite;

import java.util.Arrays;

public class RechangleMaxAreaSumLessThanK {
	public int Solution(int[][] matrix,int k){
		int[] tracker=new int[matrix[0].length];
		int maxArea=0;
		for(int startR=0;startR<matrix.length;startR++){
			for(int r=startR;r<matrix.length;r++){
				for(int c=0;c<matrix[r].length;c++){
					tracker[c]=tracker[c]+matrix[r][c];
				}
				int currMax=findMaxRange(tracker,k);
				maxArea=Math.max(maxArea, (r-startR+1)*currMax);
			}
			Arrays.fill(tracker, 0);
		}
		return maxArea;
	}
	public int findMaxRange(int[] array,int k){
		if(k<=0){
			return 0;
		}
		int max=0;
		int i=0;
		int j=0;
		int currTotal=0;
		while(j<array.length){
			currTotal=currTotal+array[j];
			while(i<=j&&currTotal>k){
				currTotal=currTotal-array[i];
				i++;
			}
			if(currTotal>0){
				max=Math.max(max,j-i+1);
			}
			j++;
		}
		return max;
	}
}
