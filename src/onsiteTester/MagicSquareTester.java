package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MagicSquare;

public class MagicSquareTester {

	@Test
	public void test() {
		MagicSquare tester=new MagicSquare();
		int[][] res=tester.createSingleMagicSquare(3);
		tester.printMatrix(res);
	}

}
