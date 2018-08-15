package onsite;
import java.util.*;
//0和1的grid，1是墙，0是路，从左上角走到右下角，最少多少步。
//follow up 现在说能把grid中的一个1变成0，问新的最小步数是多少步。
public class MazeMinPath {
	public int minStep(int[][] maze){
		if(maze==null||maze.length==0||maze[0].length==0||maze[0][0]==1){
			return -1;
		}
		int[][] move={{-1,0},{1,0},{0,-1},{0,1}};
		Queue<int[]> qu=new LinkedList<int[]>();
		Set<String> visited=new HashSet<String>();
		qu.offer(new int[]{0,0});
		visited.add("0,0");
		int step=0;
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int round=0;round<size;round++){
				int[] top=qu.poll();
				int r=top[0];
				int c=top[1];
				if(r==maze.length-1&&c==maze[0].length-1){
					return step;
				}
				for(int i=0;i<move.length;i++){
					int newR=r+move[i][0];
					int newC=c+move[i][1];
					String tracker=newR+","+newC;
					if(newR>=0&&newC>=0&&newR<maze.length&&newC<maze[0].length&&maze[newR][newC]==0&&!visited.contains(tracker)){
						visited.add(tracker);
						qu.offer(new int[]{newR,newC});
					}
				}
			}
			step++;
		}
		return -1;
	}
	//follow up
	public int minStepWith1Bomb(int[][] maze){
		if(maze==null||maze.length==0||maze[0].length==0){
			return -1;
		}
		int[][] move={{-1,0},{1,0},{0,-1},{0,1}};
		Queue<int[]> qu=new LinkedList<int[]>();
		int[][][] visited=new int[maze.length][maze[0].length][2];
		for(int i=0;i<maze.length;i++){
			for(int j=0;j<maze[0].length;j++){
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
			}
		}
		// r,c,used bomb,step;
		qu.offer(new int[]{0,0,maze[0][0]==0?0:1,0});
		if(maze[0][0]==0){
			visited[0][0][0]=0;
		}
		else{
			visited[0][0][1]=0;
		}
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int round=0;round<size;round++){
				int[] top=qu.poll();
				int r=top[0];
				int c=top[1];
				int usedBomb=top[2];
				int step=top[3];
				for(int i=0;i<move.length;i++){
					int newR=r+move[i][0];
					int newC=c+move[i][1];
					if(newR>=0&&newC>=0&&newR<maze.length&&newC<maze[0].length){
						if(maze[newR][newC]==0){
							if(visited[newR][newC][usedBomb]>step+1){
								visited[newR][newC][usedBomb]=step+1;
								qu.offer(new int[]{newR,newC,usedBomb,step+1});
							}
						}
						else{
							if(usedBomb==0&&visited[newR][newC][1]>step+1){
								visited[newR][newC][1]=step+1;
								qu.offer(new int[]{newR,newC,1,step+1});
							}
						}
					}
				}
			}
		}
		int min=Math.min(visited[maze.length-1][maze[0].length-1][0], visited[maze.length-1][maze[0].length-1][1]);
		return min==Integer.MAX_VALUE?-1:min;
	}
}
