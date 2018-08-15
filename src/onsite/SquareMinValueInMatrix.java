package onsite;
import java.util.*;
/*
 * 问题是给一个m*n的矩阵和一个整数K，返回这个矩阵中的所有K*K的subarray的最小值。
比如 k=2,input matrix:
| 1, 2, 3,  4 |
| 4, 5, 6,100 |
| 7, 8, 9,  2 |
返回：
| 1, 2, 3|
| 4, 5, 2|
 */
public class SquareMinValueInMatrix {
	public int[][] findMinKK(int[][] matrix,int k){
		if(matrix==null||matrix.length<k||matrix[0].length<k||k<=0){
			return new int[0][0];
		}
		int[][] colMin=findColMin(matrix,k);
		int[][] res=findRowMin(colMin,k);
		return res;
	}
	private int[][] findRowMin(int[][] matrix,int k){
		int[][] res=new int[matrix.length][matrix[0].length-k+1];
		for(int r=0;r<matrix.length;r++){
			Deque<Integer> dq=new LinkedList<Integer>();
			for(int c=0;c<matrix[0].length;c++){
				int curr=matrix[r][c];
				while(!dq.isEmpty()&&dq.peekLast()>curr){
					dq.pollLast();
				}
				dq.offerLast(curr);
				if(c-k+1>=0){
					res[r][c-k+1]=dq.peekFirst();
					if(dq.peekFirst()==matrix[r][c-k+1]){
						dq.pollFirst();
					}
				}
			}
		}
		return res;
	}
	private int[][] findColMin(int[][] matrix,int k){
		int[][] res=new int[matrix.length-k+1][matrix[0].length];
		for(int c=0;c<matrix[0].length;c++){
			Deque<Integer> dq=new LinkedList<Integer>();
			for(int r=0;r<matrix.length;r++){
				int curr=matrix[r][c];
				while(!dq.isEmpty()&&dq.peekLast()>curr){
					dq.pollLast();
				}
				dq.offerLast(curr);
				if(r-k+1>=0){
					res[r-k+1][c]=dq.peekFirst();
					if(dq.peekFirst()==matrix[r-k+1][c]){
						dq.pollFirst();
					}
				}
			}
		}
		return res;
	}
	public boolean checkresult(int[][] r1,int[][] r2){
		if(r1.length!=r2.length||r1[0].length!=r2[0].length){
			return false;
		}
		for(int i=0;i<r1.length;i++){
			for(int j=0;j<r1[0].length;j++){
				if(r1[i][j]!=r2[i][j]){
					return false;
				}
			}
		}
		return true;
	}
}
