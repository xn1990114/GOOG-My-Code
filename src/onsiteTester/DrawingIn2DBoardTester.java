package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.DrawingIn2DBoard;

public class DrawingIn2DBoardTester {

	@Test
	public void test1() {
		DrawingIn2DBoard tester=new DrawingIn2DBoard();
		int[][] lines={{0,0,0,5},{2,3,7,2},{0,5,2,3},{10,4,2,1}};
		assertTrue(tester.calMinCostToDrawLine(lines)==5);
		System.out.println(tester.minCostToDrawWithDistanceCost(lines));
	}
	@Test
	public void test2() {
		DrawingIn2DBoard tester=new DrawingIn2DBoard();
		int[][] lines={{2,3,7,2},{0,5,2,3},{10,4,2,1},{0,0,0,5}};
		assertTrue(tester.calMinCostToDrawLine(lines)==5);
		System.out.println(tester.minCostToDrawWithDistanceCost(lines));
	}
	@Test
	public void test3() {
		DrawingIn2DBoard tester=new DrawingIn2DBoard();
		int[][] lines={{0,0,10,0},{10,0,10,4},{2,3,7,2},{0,5,2,3},{10,4,2,1},{0,0,0,5}};
		assertTrue(tester.calMinCostToDrawLine(lines)==7);
		System.out.println(tester.minCostToDrawWithDistanceCost(lines));
	}
}
