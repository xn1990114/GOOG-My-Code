package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.RechangleMaxAreaSumLessThanK;

public class RechangleMaxAreaSumLessThankTester {

	@Test
	public void test() {
		int[] array = { 5, 4, 7, 2, 45, 6, 7 };
		int k = 5;
		RechangleMaxAreaSumLessThanK calculator = new RechangleMaxAreaSumLessThanK();
		assertTrue(calculator.findMaxRange(array, k) == 1);
		int[][] matrix = { { 5, 4, 7, 2, 4, 6, 7 }, 
						   { 5, 3, 5, 6, 4, 3, 2 },
						   { 6, 7, 2, 4, 6, 7, 8 } };
		System.out.println(calculator.Solution(matrix, 55));
	}

}
