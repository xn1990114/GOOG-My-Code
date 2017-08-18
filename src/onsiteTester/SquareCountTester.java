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
		System.out.println(sc.countSquare(matrix1));

		int[][] matrix={{0, 0, 0, 0, 0},
						{0, 1, 0, 0, 0},
						{0, 0, 0, 0, 0}};
		assertTrue(sc.countSquare(matrix)==19);
		int[][] matrix2={{0, 0, 0, 0, 0},
						 {0, 1, 0, 1, 0},
						 {0, 0, 0, 0, 0},
						 {0, 0, 1, 0, 1}};
		assertTrue(sc.countSquare(matrix2)==17);
	}

}
