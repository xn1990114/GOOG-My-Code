package onsite;
/*
 * 实现一个简化版的俄罗斯方块，棋盘m*n,每次只会有一个1*1的方块从顶上出现，
 * 垂直掉落到底部。每个小方块都有自己的颜色，一共有三种颜色可选，
 * 如果降落的小方块和之前的小方块能凑成2*2的同颜色的大方块的话就可以消去大方块。
 * 如果降落的小方块能凑成多个2*2的同颜色的大方块（大方块之间可以有重叠），所有的大方块都要消除。
 * 实现一个function， 给定下一个方块出现的位置，算出小方块掉落后的棋盘。
 */
// 3 different colors repreosented by 1,2,3.
public class RussianSquare {
	public void drop(int col,int color,int[][] board){
		int i=0;
		while(i<board.length&&board[i][col]==0){
			i++;
		}
		board[i-1][col]=color;
		boolean update=true;
		while(update){
			update=false;
			for(int index=0;index<board.length;index++){
				for(int j=0;j<board[0].length;j++){
					if(board[index][j]!=0){
						if(update(index,j,board)){
							update=true;
						}
					}
				}
			}
			if(update){
				removeCube(board);
			}
		}
	}
	
	public void removeCube(int[][] board){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]<0){
					board[i][j]=0;
				}
			}
		}
		for(int j=0;j<board[0].length;j++){
			int zeroIndex=board.length-1;
			int index=board.length-1;
			while(zeroIndex>=0){
				if(index==-1){
					board[zeroIndex][j]=0;
					zeroIndex--;
				}
				else if(board[index][j]==0){
					index--;
				}
				else{
					board[zeroIndex][j]=board[index][j];
					index--;
					zeroIndex--;
				}
			}
		}
	}
	
	public boolean update(int r,int c,int[][] board){
		if(r+1==board.length||c+1==board[0].length){
			return false;
		}
		boolean update=true;
		int currColor=Math.abs(board[r][c]);
		for(int i=r;i<=r+1&&update;i++){
			for(int j=c;j<=c+1&&update;j++){
				if(Math.abs(board[i][j])!=currColor){
					update=false;
				}
			}
		}
		if(update){
			for(int i=r;i<=r+1;i++){
				for(int j=c;j<=c+1;j++){
					board[i][j]=-Math.abs(currColor);
				}
			}
		}
		return update;
	}
}
