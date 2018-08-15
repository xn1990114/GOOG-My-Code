package onsite;

public class RandomMazeGeneration {
	class Cell {
		boolean upWall;
		boolean downWall;
		boolean leftWall;
		boolean rightWall;

		public Cell() {
			this.upWall = true;
			this.downWall = true;
			this.leftWall = true;
			this.rightWall = true;
		}
	}

	public Cell[][] createMaze(int r, int c) {
		if (r <= 0 || c <= 0) {
			return new Cell[0][0];
		}
		Cell[][] maze = new Cell[r][c];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				maze[i][j] = new Cell();
			}
		}
		int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		int startR = (int) (Math.random() * r);
		int startC = (int) (Math.random() * c);
		updateCell(startR, startC, visited, maze, move);
		return maze;
	}

	private void updateCell(int r, int c, boolean[][] visited, Cell[][] maze, int[][] move) {
		if (r < 0 || c < 0 || r >= maze.length || c >= maze[0].length||visited[r][c]) {
			return;
		}
		visited[r][c] = true;
		int[] seq = createRandomSeq();
		for (int i = 0; i < seq.length; i++) {
			int newR = r + move[seq[i]][0];
			int newC = c + move[seq[i]][1];
			if (newR >= 0 && newR < maze.length && newC >= 0 && newC < maze[0].length && !visited[newR][newC]) {
				if (seq[i] == 0) {
					maze[r][c].downWall = false;
					maze[newR][newC].upWall = false;
				} else if (seq[i] == 1) {
					maze[r][c].upWall = false;
					maze[newR][newC].downWall = false;
				} else if (seq[i] == 2) {
					maze[r][c].rightWall = false;
					maze[newR][newC].leftWall = false;
				} else {
					maze[r][c].leftWall = false;
					maze[newR][newC].rightWall = false;
				}
				updateCell(newR,newC,visited,maze,move);
			}
		}
	}

	private int[] createRandomSeq() {
		int[] res = { 0, 1, 2, 3 };
		for (int i = 3; i > 0; i--) {
			int targetIndex = (int) (Math.random() * (i + 1));
			int temp = res[i];
			res[i] = res[targetIndex];
			res[targetIndex] = temp;
		}
		return res;
	}

	public void printMaze(Cell[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			if(i==0){
				System.out.print(' ');
				for (int j = 0; j < maze[0].length; j++) {
					System.out.print("- ");
				}
				System.out.println();
			}
			for (int j = 0; j < maze[0].length; j++) {
				if(j==0){
					System.out.print("|");
				}
				if(maze[i][j].rightWall){
					System.out.print("C|");
				}
				else{
					System.out.print("C ");
				}
			}
			System.out.println();
			System.out.print(' ');
			for (int j = 0; j < maze[0].length; j++) {
				if(maze[i][j].downWall){
					System.out.print("- ");
				}
				else{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}
