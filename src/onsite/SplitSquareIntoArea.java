package onsite;

import java.util.*;

/*
 * 需要随机生成4组 每组16个格子 可以是任何形状 只要是上下左右四个方向可以连通就行... 
 * 我一开始思路是random选择一个起点开始往四周random的扩展，如果生成失败就重新再生成一次...
 * 写到一半大概看我写的很煎熬，大叔说，我们简化一下，不要求16个格子是continuous，随便哪16个都可以，写了code，
 * 然后说了大概要调用多少次random... 然后重新回到continuous的case，接着讨论了非常非常非常非常久...
 * 本来应该两点一刻结束的面试 一直说到三点一刻 直到送我上车...还是因为后面一个要用会议室的人来了才收拾东西…- - 
 * 主要纠结的点在，随机生成的时候是有可能把board给分成两个独立的部分，那么就必须验证这样的分割是不会影响后续的assign的... 
 * 大概直到最后上车前我才差不多理清思路... 大叔真的是非常nice了 一直在引导我... 
 */
public class SplitSquareIntoArea {
	public int[][] createAreas() {
		int[][] board = new int[8][8];
		buildBoard(1, 0, board);
		return board;
	}

	public boolean buildBoard(int round, int currLen, int[][] board) {
		if (currLen == 16) {
			if (break16Law(board)) {
				return false;
			}
			round++;
			currLen = 0;
			if (round == 5) {
				return true;
			}
		}
		List<int[]> cand = null;
		if (currLen == 0) {
			cand = getRandomStartPoint(board);
		} else {
			cand = getPossibleNextCell(board, round);
		}
		for (int i = 0; i < cand.size(); i++) {
			int[] targetLocation = cand.get(i);
			int r = targetLocation[0];
			int c = targetLocation[1];
			board[r][c] = round;
			if (buildBoard(round, currLen + 1, board)) {
				return true;
			}
			board[r][c] = 0;
		}
		return false;
	}

	// set start point of one area
	public List<int[]> getRandomStartPoint(int[][] board) {
		List<int[]> res = new ArrayList<int[]>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					res.add(new int[] { i, j });
				}
			}
		}
		shuffleList(res);
		return res;
	}

	public List<int[]> getPossibleNextCell(int[][] board,int currVal){
		List<int[]> res=new ArrayList<int[]>();
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]==0){
					if(hasValidNeighbor(board,currVal,i,j)){
						res.add(new int[]{i,j});
					}
				}
			}
		}
		shuffleList(res);
		return res;
	}

	public boolean hasValidNeighbor(int[][] board, int currVal, int r, int c) {
		return (r - 1 >= 0 && board[r - 1][c] == currVal) || (r + 1 < board.length && board[r + 1][c] == currVal)
				|| (c - 1 >= 0 && board[r][c - 1] == currVal)
				|| (c + 1 < board[0].length && board[r][c + 1] == currVal);
	}

	public void shuffleList(List<int[]> cells) {
		for (int i = cells.size(); i > 0; i--) {
			int index = (int) (Math.random() * i);
			int[] temp = cells.get(index);
			cells.set(index, cells.get(i - 1));
			cells.set(i - 1, temp);
		}
	}

	public boolean break16Law(int[][] board) {
		boolean[][] visited=new boolean[board.length][board[0].length];
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				int countArea=countArea(i,j,board,visited);
				if(countArea%16!=0){
					return true;
				}
			}
		}
		return false;
	}

	public int countArea(int r, int c, int[][] board, boolean[][] visited) {
		if(board[r][c]!=0||visited[r][c]){
			return 0;
		}
		visited[r][c]=true;
		int res=1;
		if(r-1>=0&&board[r-1][c]==0&&!visited[r-1][c]){
			res=res+countArea(r-1,c,board,visited);
		}
		if(r+1<board.length&&board[r+1][c]==0&&!visited[r+1][c]){
			res=res+countArea(r+1,c,board,visited);
		}
		if(c-1>=0&&board[r][c-1]==0&&!visited[r][c-1]){
			res=res+countArea(r,c-1,board,visited);
		}
		if(c+1<board[0].length&&board[r][c+1]==0&&!visited[r][c+1]){
			res=res+countArea(r,c+1,board,visited);
		}
		return res;
	}
	public void displayBoard(int[][] board){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j]+",");
			}
			System.out.println();
		}
	}
}
