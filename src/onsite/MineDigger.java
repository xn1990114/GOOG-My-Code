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
		int res=0;
		// 0 up 1 left 2 down 3 right
		int[][][] maxCount=new int[mine.length][mine[0].length][4];
		for(int i=0;i<mine.length;i++){
			for(int j=0;j<mine[0].length;j++){
				if(mine[i][j]>0){
					updateMax(i,j,mine,new boolean[mine.length][mine[0].length],maxCount);
					for(int k=0;k<4;k++){
						res=Math.max(res,maxCount[i][j][k]);
					}
				}
			}
		}
		return res;
	}
	public void updateMax(int r,int c,int[][] mine,boolean[][] visited,int[][][] maxCount){
		if(visited[r][c]){
			return;
		}
		visited[r][c]=true;
		if(maxCount[r][c][0]==0){
			maxCount[r][c][0]=mine[r][c];
			if(r-1>=0&&mine[r-1][c]>0&&!visited[r-1][c]){
				updateMax(r-1,c,mine,visited,maxCount);
				for(int i=0;i<4;i++){
					if(i==2){
						continue;
					}
					maxCount[r][c][i]=Math.max(maxCount[r][c][i], mine[r][c]+maxCount[r-1][c][i]);
				}
			}
		}
		if(maxCount[r][c][1]==0){
			maxCount[r][c][1]=mine[r][c];
			if(c-1>=0&&mine[r][c-1]>0&&!visited[r][c-1]){
				updateMax(r,c-1,mine,visited,maxCount);
				for(int i=0;i<4;i++){
					if(i==3){
						continue;
					}
					maxCount[r][c][i]=Math.max(maxCount[r][c][i], mine[r][c]+maxCount[r][c-1][i]);
				}
			}
		}
		if(maxCount[r][c][2]==0){
			maxCount[r][c][2]=mine[r][c];
			if(r+1<mine.length&&mine[r+1][c]>0&&!visited[r+1][c]){
				updateMax(r+1,c,mine,visited,maxCount);
				for(int i=0;i<4;i++){
					if(i==0){
						continue;
					}
					maxCount[r][c][i]=Math.max(maxCount[r][c][i], mine[r][c]+maxCount[r+1][c][i]);
				}
			}
		}
		if(maxCount[r][c][3]==0){
			maxCount[r][c][3]=mine[r][c];
			if(c+1<mine[0].length&&mine[r][c+1]>0&&!visited[r][c+1]){
				updateMax(r,c+1,mine,visited,maxCount);
				for(int i=0;i<4;i++){
					if(i==1){
						continue;
					}
					maxCount[r][c][i]=Math.max(maxCount[r][c][i], mine[r][c]+maxCount[r][c+1][i]);
				}
			}
		}
	}
}
