package onsite;

import java.util.Arrays;

/*
 * 给一个正方形矩阵，里面都是正数或0，正数代表金矿的数量, 0 不能走，你可以选择任何一个整数作为起点，
 * 给出可以拿到的最多的金矿，不能往回走。行走只有四个方向，上下左右。
例子：下面例子可以选取 2 2 4 5 6 7 3 4，总和达到最大值。
0 1 0 3 4.
2 2 0 7 0. 
0 4 5 6 2
0 0 0 0 0
0 2 0 0 2
输入中，正数不会形成cycle，比如见不到先面的case
2 3
1 4
 */
public class MineDigger {
	public int findMaxGold(int[][] mine){
		if(mine==null||mine.length==0||mine[0].length==0){
			return 0;
		}
		int max=0;
		int[][] move={{1,0},{-1,0},{0,1},{0,-1}};
		int[][][] count=new int[mine.length][mine[0].length][4];
		for(int i=0;i<mine.length;i++){
			for(int j=0;j<mine[0].length;j++){
				Arrays.fill(count[i][j], -1);
			}
		}
		for(int i=0;i<mine.length;i++){
			for(int j=0;j<mine[0].length;j++){
				findMax(i,j,move,count,mine,-1,-1);
				for(int k=0;k<4;k++){
					max=Math.max(max, count[i][j][k]);
				}
			}
		}
		return max;
	}
	public int findMax(int r,int c,int[][] move,int[][][] count,int[][] mine,int lastR,int lastC){
		if(r<0||c<0||r>=mine.length||c>=mine[0].length||mine[r][c]==0){
			return 0;
		}
		int currMax=0;
		for(int i=0;i<4;i++){
			int newR=r+move[i][0];
			int newC=c+move[i][1];
			if(!(newR==lastR&&newC==lastC)){
				if(count[r][c][i]==-1){
					count[r][c][i]=mine[r][c]+findMax(newR,newC,move,count,mine,r,c);
				}
				currMax=Math.max(currMax, count[r][c][i]);
			}
		}
		return currMax;
	}
}
