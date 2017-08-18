package onsiteTester;

import org.junit.Test;

import onsite.CleaningRobot;

public class CleaningRobotTester {

	@Test
	public void test() {
		int[][] room0={{0,0},
					   {0,0},
					   {0,0}};
		int[][] room1={{0,0,0,0,0,0,0,0,0,0},
					   {0,0,0,0,0,0,0,0,0,0},
				       {0,0,0,1,0,0,0,0,0,0},
				       {0,0,0,0,0,0,0,0,0,0},
				       {1,1,1,1,1,0,1,1,1,1},
				       {0,0,0,0,0,0,1,0,0,0},
				       {0,0,0,0,0,1,0,1,1,1}};

		int[][] room2={{0,1,0,0,0,0,1,1,1,1},
				   	   {1,0,1,0,0,0,1,0,0,0},
				   	   {0,1,0,1,0,0,1,1,1,1},
				   	   {0,0,0,0,0,0,0,0,0,0},
				   	   {1,1,1,1,1,1,1,1,1,1},
				   	   {0,0,0,0,0,0,0,0,0,0},
				   	   {1,0,0,0,0,0,0,0,0,1}};
		CleaningRobot robot=new CleaningRobot(room0,0,0);
		robot.cleanRoom();
		robot.displayRoom();
		robot=new CleaningRobot(room1,5,5);
		robot.cleanRoom();
		robot.displayRoom();
		robot=new CleaningRobot(room2,3,5);
		robot.cleanRoom();
		robot.displayRoom();
	}

}
