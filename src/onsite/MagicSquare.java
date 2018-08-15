package onsite;
/*
 * Magic Square: given an integer n, build a magic square with size n x n, filled numbers from 1 to n * n, 
 * each number can only be used once. And the sum of each row, each column diagonal and anti-diagonal line are same.
e.g., n is 3. Each row, column, and both diagonals all have the same sum 15.
4 3 8
9 5 1
2 7 6
Follow up1: Optimization

Follow up2: build all possible magic squares for a certain integer n.
//k subset sum 是一个思路, 找到一个pattern后旋转得到该pattern的所有填法是另外一个思路, 同一个pattern的所有填法可以union find.
 */
public class MagicSquare {
	public int[][] createSingleMagicSquare(int n){
		if(n<=0){
			return new int[0][0];
		}
		int[][] res=new int[n][n];
		boolean[] used=new boolean[n*n+1];
		int total=(1+n*n)*n*n/2;
		if(total%n!=0){
			return new int[0][0];
		}
		buildSingleSquare(res,0,new int[n],0,0,used,0,0,total/n);
		return res;
	}
	public boolean buildSingleSquare(int[][] res,int rowSum,int[] colSum,int diag1Sum,int diag2Sum,boolean[] used,int r,int c,int target){
		if(c==res[0].length){
			if(r==res.length-1){
				return meetSumReq(rowSum,colSum,diag1Sum,diag2Sum,target);
			}
			if(rowSum!=target){
				return false;
			}
			r++;
			c=0;
			rowSum=0;
		}
		for(int val=1;val<used.length;val++){
			if(!used[val]){
				used[val]=true;
				res[r][c]=val;
				colSum[c]=colSum[c]+val;
				if(r==c){
					diag1Sum=diag1Sum+val;
				}
				if(r+c==res.length-1){
					diag2Sum=diag2Sum+val;
				}
				if(buildSingleSquare(res,rowSum+val,colSum,diag1Sum,diag2Sum,used,r,c+1,target)){
					return true;
				}
				used[val]=false;
				res[r][c]=0;
				colSum[c]=colSum[c]-val;
				if(r==c){
					diag1Sum=diag1Sum-val;
				}
				if(r+c==res.length-1){
					diag2Sum=diag2Sum-val;
				}
			}
		}
		return false;
	}
	public boolean meetSumReq(int rowSum,int[] colSum,int diag1Sum,int diag2Sum,int target){
		if(rowSum!=target||diag1Sum!=target||diag2Sum!=target){
			return false;
		}
		for(int i=0;i<colSum.length;i++){
			if(colSum[i]!=target){
				return false;
			}
		}
		return true;
	}
	
	public void printMatrix(int[][] res){
		for(int i=0;i<res.length;i++){
			for(int j=0;j<res[0].length;j++){
				System.out.print(res[i][j]+",");
			}
			System.out.println();
		}
	}
}
