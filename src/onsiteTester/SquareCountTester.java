package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SquareCount;

public class SquareCountTester {

	@Test
	public void test() {
		SquareCount sc=new SquareCount();
		int[][] matrix1={{0, 0, 0, 0, 0},
						 {0, 1, 0, 0, 0}};
		assertTrue(sc.countSquareOp(matrix1)==11);
		assertTrue(sc.countSquare(matrix1)==11);
		
		int[][] matrix={{0, 0, 0, 0, 0},
						{0, 1, 0, 0, 0},
						{0, 0, 0, 0, 0}};
		assertTrue(sc.countSquareOp(matrix)==19);
		assertTrue(sc.countSquare(matrix)==19);
		
		int[][] matrix2={{0, 0, 0, 0, 0},
						 {0, 1, 0, 1, 0},
						 {0, 0, 0, 0, 0},
						 {0, 0, 1, 0, 1}};
		assertTrue(sc.countSquareOp(matrix2)==17);
		assertTrue(sc.countSquare(matrix2)==17);
		
	}

}
