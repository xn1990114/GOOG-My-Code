package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.CleaningRobot;
import onsite.CleaningRobotWithoutMatrix;

public class CleaningRobotWithoutMatrixTester {
	@Test
	public void test1() {
		int[][] room0={{0,0},
					   {0,0},
					   {0,0}};
		CleaningRobotWithoutMatrix robot=new CleaningRobotWithoutMatrix(room0,0,0);
		robot.cleanRoom();
		robot.displayRoom();
	}
	@Test
	public void test2() {
		int[][] room1={{0,0,0,0,0,0,0,0,0,0},
					   {0,0,0,0,0,0,0,0,0,0},
				       {0,0,0,1,0,0,0,0,0,0},
				       {0,0,0,0,0,0,0,0,0,0},
				       {1,1,1,1,1,0,1,1,1,1},
				       {0,0,0,0,0,0,1,0,0,0},
				       {0,0,0,0,0,1,0,1,1,1}};

		CleaningRobotWithoutMatrix robot=new CleaningRobotWithoutMatrix(room1,5,5);
		robot.cleanRoom();
		robot.displayRoom();
	}@Test
	public void test3() {
		int[][] room2={{0,1,0,0,0,0,1,1,1,1},
				   	   {1,0,1,0,0,0,1,0,0,0},
				   	   {0,1,0,1,0,0,1,1,1,1},
				   	   {0,0,0,0,0,0,0,0,0,0},
				   	   {1,1,1,1,1,1,1,1,1,1},
				   	   {0,0,0,0,0,0,0,0,0,0},
				   	   {1,0,0,0,0,0,0,0,0,1}};
		CleaningRobotWithoutMatrix robot=new CleaningRobotWithoutMatrix(room2,3,5);
		robot.cleanRoom();
		robot.displayRoom();
	}
}
