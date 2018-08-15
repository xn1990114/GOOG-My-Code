package onsite;
import java.util.*;
// same as cleaning robot, but not allowing any matrix to record
public class CleaningRobotWithoutMatrix {
	public int r;
	public int c;
	int startR;
	int startC;
	int dir;  // 0 up,1 right, 2 down 3 left
	int[][] currRoom;
	int[][] move;
	public CleaningRobotWithoutMatrix(int[][] room,int startR,int startC){
		this.r=0;
		this.c=0;
		this.currRoom=room;
		this.dir=0;
		this.startR=startR;
		this.startC=startC;
		this.move=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
	}
	public void turnRight(int k){
		this.dir=(this.dir+k)%4;
	}
	public void turnLeft(int k){
		this.dir=(this.dir-k)%4;
		if(this.dir<0){
			this.dir=this.dir+4;
		}
	}
	public int[] actualPos(){
		return new int[]{startR-r,startC+c};
	}
	public boolean move(){
		int newR=r+move[dir][0];
		int newC=c+move[dir][1];
		int[] pos=actualPos();
		pos[0]=pos[0]-move[dir][0];
		pos[1]=pos[1]+move[dir][1];
		if(pos[0]<0||pos[1]<0||pos[0]>=currRoom.length||pos[1]>=currRoom[0].length||currRoom[pos[0]][pos[1]]==1){
			return false;
		}
		r=newR;
		c=newC;
		return true;
	}
	public void cleanRoom(){
		Set<String> visited=new HashSet<String>();
		dfs(visited,true);
	}
	public void dfs(Set<String> visited,boolean isBase){
		if(visited.contains(r+","+c)){
			turnRight(2);
			move();
			return;
		}
		clean();
		turnLeft(1);
		visited.add(r+","+c);
		for(int i=0;i<3;i++){
			int newR=r+move[dir][0];
			int newC=c+move[dir][1];
			if(!visited.contains(newR+","+newC)&&move()){
				dfs(visited,false);
				turnRight(2);
			}
			dir=(dir+1)%4;
		}
		if(isBase){
			if(move()){
				dfs(visited,false);
			}
		}
		else{
			move();
		}
	}
	public void clean(){
		int[] pos=actualPos();
		this.currRoom[pos[0]][pos[1]]+=2;
	}
	public void displayRoom(){
		for(int i=0;i<this.currRoom.length;i++){
			for(int j=0;j<this.currRoom[0].length;j++){
				System.out.print(this.currRoom[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
