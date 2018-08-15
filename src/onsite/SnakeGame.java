package onsite;

import java.util.*;

public class SnakeGame {
	class Snake {
		Deque<int[]> dq;
		int dir;// 0 up,1 right, 2 down, 3 left;

		public Snake(int r, int c) {
			this.dq = new LinkedList<int[]>();
			dq.offer(new int[] { r, c });
			this.dir = 0;
		}
	}

	int[][] board;
	Snake snake;
	int[][] move;
	// 0 empty 1 snake 2 egg
	public SnakeGame(int row, int col, int snakeR, int snakeC) {
		this.snake = new Snake(snakeR, snakeC);
		this.board = new int[row][col];
		board[snakeR][snakeC]=1;
		this.move=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
	}

	public boolean putEgg(int[][] board) {
		int total=0;
		int[] res={-1,-1};
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]==0){
					total++;
					int index=(int)(Math.random()*total);
					if(index==0){
						res[0]=i;
						res[1]=j;
					}
				}
			}
		}
		if(res[0]==-1){
			return false;
		}
		board[res[0]][res[1]]=2;
		return true;
	}
	
	public boolean moveSnake() {
		int[] head=snake.dq.peekFirst();
		int newR=head[0]+move[snake.dir][0];
		int newC=head[1]+move[snake.dir][1];
		if(newR<0||newC<0||newR>=board.length||newC>=board[0].length||board[newR][newC]==1){
			return false;
		}
		snake.dq.offerFirst(new int[]{newR,newC});
		if(board[newR][newC]==0){
			int[] last=snake.dq.pollLast();
			board[last[0]][last[1]]=0;
		}
		board[newR][newC]=1;
		return true;
	}

	public boolean turnSnakeRight() {
		this.snake.dir=(this.snake.dir+1)%4;
		return moveSnake();
	}

	public boolean turnSnakeLeft() {
		this.snake.dir=(this.snake.dir+3)%4;
		return moveSnake();
	}
}
