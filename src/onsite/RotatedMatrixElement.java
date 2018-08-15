package onsite;
/*
第一道给个2^16次方的二维矩阵 每次以田字形切割 顺序如下
1   2
0   3

然后抽出每个小矩阵 再次切割
比如4*4的矩阵 就会长这样
5   7    9  10
4   6    8   11
1   2   13  14
0   3   12  15
. from: 1point3acres 
现在矩阵是2^16 * 2 ^ 16的 给你一个x， y坐标 让你求那个点的数字是多少， 比如在4*4里面 （3,3） = 8 （3，0） = 14
*/
public class RotatedMatrixElement {
	public long getElement(int r,int c){
		long len=(1<<16);
		long min=0;
		long max=len*len-1;
		while(min<max){
			long perShare=len*len/4;
			int dim=getDimensionNumber(len,r,c);
			int[] newCoordinate=cleanUpCoordinate(len,r,c);
			max=min+(dim+1)*perShare-1;
			min=min+dim*perShare;
			r=newCoordinate[0];
			c=newCoordinate[1];
			len=len/2;
		}
		return min;
	}
	public int getDimensionNumber(long len,int r,int c){
		if(r>=len/2&&c>=len/2){
			return 2;
		}
		else if(r>=len/2){
			return 1;
		}
		else if(c>=len/2){
			return 3;
		}
		return 0;
	}
	public int[] cleanUpCoordinate(long len,int r,int c){
		if(r>=len/2){
			r=r-(int)(len/2);
		}
		if(c>=len/2){
			c=c-(int)(len/2);
		}
		return new int[]{r,c};
	}
}
