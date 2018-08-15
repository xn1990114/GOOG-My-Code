package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SquareMinValueInMatrix;

public class SquareMinValueInMatrixTester {

	@Test
	public void test1() {
		SquareMinValueInMatrix tester=new SquareMinValueInMatrix();
		int[][] matrix={{5,2,1,5},
						{4,5,2,5},
						{7,2,5,3}};
		int[][] res={{2,1,1},
				     {2,2,2}};
		assertTrue(tester.checkresult(tester.findMinKK(matrix, 2), res));
	}
	@Test
	public void test2() {
		SquareMinValueInMatrix tester=new SquareMinValueInMatrix();
		int[][] matrix={{5,2,8,5},
						{4,5,7,5},
						{7,2,5,3},
						{4,2,6,7},
						{6,7,2,1}};
		int[][] res={{2,2,5},
				     {2,2,3},
				     {2,2,3},
				     {2,2,1}};
		assertTrue(tester.checkresult(tester.findMinKK(matrix, 2), res));
	}
	@Test
	public void test3() {
		SquareMinValueInMatrix tester=new SquareMinValueInMatrix();
		int[][] matrix={{5,2},
						{4,5}};
		int[][] res={{2}};
		assertTrue(tester.checkresult(tester.findMinKK(matrix, 2), res));
	}
}
