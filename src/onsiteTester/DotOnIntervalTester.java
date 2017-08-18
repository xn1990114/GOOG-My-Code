package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.DotOnInterval;

public class DotOnIntervalTester {

	@Test
	public void test() {
		int[][] array={{5,8},
				{8,9},{1,2},{4,8},{5,10},{15,20},
				{Integer.MIN_VALUE,-10000},{Integer.MIN_VALUE,-1},
				{-100,100}};
		DotOnInterval doi=new DotOnInterval();
		assertTrue(doi.CountDot(array)==4);
	}

}
