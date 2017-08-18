package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SudokuInitializer;

public class SudokuInitializerTester {

	@Test
	public void test() {
		SudokuInitializer si=new SudokuInitializer();
		int[][] matrix=si.createSudoku();
		si.display(matrix);
	}

}
