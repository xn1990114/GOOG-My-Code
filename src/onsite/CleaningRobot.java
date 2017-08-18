package onsite;

/*
 * Given a robot cleaner in a room modeled as a grid. Each cell in the grid can be 
 * empty or blocked. The robot cleaner can move forward, turn left or turn right. 
 * When it tries to move into a blocked cell, 
 * its bumper sensor detects the obstacle and it stays on the current cell.
The control API:
interface Robot {
  // returns true if next cell is open and robot moves into the cell.
  // returns false if next cell is obstacle and robot stays on the current cell.
  boolean Move();
  // Robot will stay on the same cell after calling Turn*. k indicates how
  // many turns to perform.
  void TurnLeft(int k);
  void TurnRight(int k);

  // Clean the current cell.
  void Clean();

  boolean Move(Direction d);
}
 */
public class CleaningRobot {
	// 0- empty to be cleaned, 1 barrier,2- cleaned
	int[][] room;
	int r;
	int c;
	int dir; // 0-up, 1-right,2-down,3-left

	public CleaningRobot(int[][] room, int r, int c) {
		this.room = room;
		this.r = r;
		this.c = c;
		this.dir=0;
	}

	public void cleanRoom(){
		if(this.room[r][c]==2){
			this.turnLeft(2);
			this.Move();
			return;
		}
		this.clean();
		for(int i=0;i<4;i++){
			if(this.Move()){
				cleanRoom();
				this.turnRight(2);
			}
			this.turnRight(1);
		}
		this.turnLeft(2);
		this.Move();
	}

	public String serializeLocation(){
		return this.r+","+this.c;
	}
	public boolean Move() {
		if (this.dir == 0) {
			if(r-1<0||this.room[r-1][c]==1){
				return false;
			}
			r--;
		} else if (this.dir == 1) {
			if(c+1==room[0].length||room[r][c+1]==1){
				return false;
			}
			c++;
		} else if (this.dir == 2) {
			if(r+1==room.length||room[r+1][c]==1){
				return false;
			}
			r++;
		} else if (this.dir == 3) {
			if(c-1<0||this.room[r][c-1]==1){
				return false;
			}
			c--;
		}
		return true;
	}
	public void clean(){
		this.room[r][c]=2;
	}
	public void turnLeft(int k){
		for(int i=0;i<k;i++){
			this.dir--;
			if(this.dir==-1){
				this.dir=3;
			}
		}
	}
	public void turnRight(int k){
		for(int i=0;i<k;i++){
			this.dir++;
			if(this.dir==4){
				this.dir=0;
			}
		}
	}
	public void displayRoom(){
		for(int i=0;i<this.room.length;i++){
			for(int j=0;j<this.room[0].length;j++){
				System.out.print(this.room[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
