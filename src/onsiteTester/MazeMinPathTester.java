package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MazeMinPath;

public class MazeMinPathTester {

	@Test
	public void test1() {
		MazeMinPath tester=new MazeMinPath();
		int[][] maze={{0,0,0,0,0,0},
					  {1,1,1,0,0,0},
					  {0,0,0,0,0,1},
					  {0,1,1,1,1,0},
					  {0,1,0,0,0,0},
					  {0,0,0,0,0,0}};
		assertTrue(tester.minStep(maze)==16);
		assertTrue(tester.minStepWith1Bomb(maze)==10);
	}
	@Test
	public void test2() {
		MazeMinPath tester=new MazeMinPath();
		int[][] maze={{0,0,0,0,0,0},
					  {1,1,1,0,0,0},
					  {1,1,1,0,0,0},
					  {0,0,0,0,1,1},
					  {0,1,1,1,1,1},
					  {0,0,0,0,0,0},
					  {0,1,1,1,0,0},
					  {0,0,0,0,0,0}};
		assertTrue(tester.minStep(maze)==18);
		assertTrue(tester.minStepWith1Bomb(maze)==12);
	}
	@Test
	public void test3() {
		MazeMinPath tester=new MazeMinPath();
		int[][] maze={{1,0,0,0,0,0},
					  {1,1,1,0,0,0},
					  {1,1,1,0,0,0},
					  {0,0,0,0,1,1},
					  {0,1,1,1,1,1},
					  {0,0,0,0,0,0},
					  {0,1,1,1,0,0},
					  {0,0,0,0,0,0}};
		assertTrue(tester.minStep(maze)==-1);
		assertTrue(tester.minStepWith1Bomb(maze)==18);
	}
	@Test
	public void test4() {
		MazeMinPath tester=new MazeMinPath();
		int[][] maze={{0,0,0,0,0,0},
					  {1,1,1,0,0,0},
					  {1,1,1,0,0,0},
					  {0,0,0,0,1,1},
					  {0,1,1,1,1,1},
					  {0,0,0,0,0,0},
					  {0,1,1,1,0,0},
					  {0,0,0,0,0,1}};
		assertTrue(tester.minStep(maze)==-1);
		assertTrue(tester.minStepWith1Bomb(maze)==18);
	}
	@Test
	public void test5() {
		MazeMinPath tester=new MazeMinPath();
		int[][] maze={{0,0,0,0,0,0},
					  {1,1,1,0,0,0},
					  {1,1,1,0,0,0},
					  {0,0,0,1,1,1},
					  {0,1,1,1,1,1},
					  {0,0,0,0,0,0},
					  {0,1,1,1,0,0},
					  {0,0,0,0,0,1}};
		assertTrue(tester.minStep(maze)==-1);
		assertTrue(tester.minStepWith1Bomb(maze)==-1);
	}
	@Test
	public void test6() {
		MazeMinPath tester=new MazeMinPath();
		int[][] maze={{1,0,0,0,0,0},
					  {1,1,1,0,0,0},
					  {1,1,1,0,0,0},
					  {0,0,0,0,1,1},
					  {0,1,1,1,1,1},
					  {0,0,0,0,0,0},
					  {0,1,1,1,0,0},
					  {0,0,0,0,0,1}};
		assertTrue(tester.minStep(maze)==-1);
		assertTrue(tester.minStepWith1Bomb(maze)==-1);
	}
}
