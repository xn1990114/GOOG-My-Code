package onsite;

/*
 * 第二轮： 一个 由 m 个小正方形为长和 n 个小正方形为宽的maze， 问一共能组成的正方形的个数。 
 * Follow up: 
 * 如果有的小正方形被标记为invalid（意思是这样被标记的小正方不能被用来组成正方形）怎么做？
 * below answer is for follow up
 */
// 1 stone 0 empty
public class SquareCount {
	public int countSquare(int[][] matrix) {
		for (int j = 0; j < matrix[0].length; j++) {
			int last = matrix.length;
			for (int i = matrix.length - 1; i >= 0; i--) {
				if (matrix[i][j] == 0) {
					matrix[i][j] = last - i;
				} else {
					last = i;
					matrix[i][j]=0;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int maxHeight = Integer.MAX_VALUE;
				int k=j;
				while(k<matrix[0].length){
					maxHeight=Math.min(maxHeight, matrix[i][k]);
					if(k-j+1>maxHeight){
						break;
					}
					k++;
				}
				count=count+(k-j);
			}
		}
		return count;
	}
	public int countSquareOp(int[][] matrix) {
		int totalCount=0;
		int[][] maxLen=new int[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]==0){
					int min=Math.min(i==0?0:maxLen[i-1][j], j==0?0:maxLen[i][j-1]);
					if(matrix[i-min][j-min]==0){
						min++;
					}
					maxLen[i][j]=min;
					totalCount=totalCount+min;
				}
			}
		}
		return totalCount;
	}
}
