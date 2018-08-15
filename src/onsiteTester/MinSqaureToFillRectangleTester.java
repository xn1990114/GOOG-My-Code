package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MinSqaureToFillRectangle;

public class MinSqaureToFillRectangleTester {

	@Test
	public void test() {
		MinSqaureToFillRectangle tester=new MinSqaureToFillRectangle();
		assertTrue(tester.calMinNumberOfSquare(5, 6)==5);
		assertTrue(tester.calMinNumberOfSquare(2, 7)==5);
		assertTrue(tester.calMinNumberOfSquare(5, 5)==1);
		assertTrue(tester.calMinNumberOfSquare(6, 9)==3);
		System.out.println(tester.calMinNumberOfSquareGreedy(6, 9));
		System.out.println(tester.calMinNumberOfSquareGreedy(5, 5));
		System.out.println(tester.calMinNumberOfSquareGreedy(2, 7));
		System.out.println(tester.calMinNumberOfSquareGreedy(5, 6));
	}

}
