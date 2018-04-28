package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.RotationMovement;

public class RotationMovementTester {

	@Test
	public void test1() {
		RotationMovement tester=new RotationMovement();
		int[][] nums=new int[5][5];
		int[][] res={{1,0,0,0,0},
					 {0,0,0,0,0},
					 {0,0,0,0,0},
					 {0,0,0,0,0},
					 {0,0,0,0,0}};
		tester.firstEdgeLocation(nums, 0, 0);
		assertTrue(tester.sameMatrix(nums, res));
	}
	@Test
	public void test2() {
		RotationMovement tester=new RotationMovement();
		int[][] nums=new int[5][5];
		int[][] res={{0,0,0,0,0},
					 {0,0,0,0,0},
					 {0,1,1,0,0},
					 {0,1,1,0,0},
					 {0,0,1,0,0}};
		tester.firstEdgeLocation(nums, 3, 1);
		assertTrue(tester.sameMatrix(nums, res));
	}
	@Test
	public void test3() {
		RotationMovement tester=new RotationMovement();
		int[][] nums=new int[5][5];
		int[][] res={{0,1,0,0,0},
					 {0,1,1,1,0},
					 {0,1,1,1,0},
					 {0,1,1,1,0},
					 {0,0,0,0,0}};
		tester.firstEdgeLocation(nums, 2, 2);
		assertTrue(tester.sameMatrix(nums, res));
	}
	@Test
	public void test4() {
		RotationMovement tester=new RotationMovement();
		int[][] nums=new int[5][5];
		int[][] res={{0,0,0,0,0},
					 {0,0,0,0,0},
					 {0,0,0,0,0},
					 {0,0,0,0,0},
					 {0,0,1,0,0}};
		tester.firstEdgeLocation(nums, 4, 2);
		assertTrue(tester.sameMatrix(nums, res));
	}

}
