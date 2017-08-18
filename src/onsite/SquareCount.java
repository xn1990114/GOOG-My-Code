package onsite;
import java.util.*;
/*
 * 第二轮： 一个 由 m 个小正方形为长和 n 个小正方形为宽的maze， 问一共能组成的正方形的个数。 
 * Follow up: 
 * 如果有的小正方形被标记为invalid（意思是这样被标记的小正方不能被用来组成正方形）怎么做？
 * below answer is for follow up
 */
public class SquareCount {
	public int countSquare(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]==0){
					matrix[i][j]=i==0?1:matrix[i-1][j]+1;
				}
				else{
					matrix[i][j]=0;
				}
			}
		}
		int count=0;
		for(int i=0;i<matrix.length;i++){
				for(int j=0;j<matrix[0].length;j++){
					if(matrix[i][j]==0){
					}
					else{
						int tempMax=1;
						int maxHeight=Integer.MAX_VALUE;
						for(int k=j;k>=0&&j-k+1<=maxHeight;k--){
							maxHeight=Math.min(maxHeight, matrix[i][k]);
							tempMax=Math.max(tempMax, Math.min(j-k+1,maxHeight));
						}
						count=count+tempMax;
					}
				}
		}
		return count;
	}
}
