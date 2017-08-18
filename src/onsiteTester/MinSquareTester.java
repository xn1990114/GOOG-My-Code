package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MinSquare;

public class MinSquareTester {

	@Test
	public void test() {
		int[][] points={{0,1},{2,3},
				{-1000,-1000},{5,7},
				{4,6},{6,5},{7,5},{5,5},{7,7}};
		MinSquare ms=new MinSquare();
		assertTrue(ms.Solution(points)==4);
		
	}

}
