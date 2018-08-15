package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SplitSquareIntoArea;

public class SplitSquareIntoAreaTester {

	@Test
	public void test() {
		SplitSquareIntoArea tester=new SplitSquareIntoArea();
		int[][] board=tester.createAreas();
		tester.displayBoard(board);
	}

}
