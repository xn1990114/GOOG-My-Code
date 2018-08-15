package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SkylineMinTotalHeight;

public class SkylineMinTotalHeightTester {

	@Test
	public void test1() {
		SkylineMinTotalHeight tester=new SkylineMinTotalHeight();
		int[] front={1,5,3,4};
		int[] left={1,2,5,2};
		assertTrue(tester.findMinTotalHeight(front, left)==17);
		
	}
	@Test
	public void test2() {
		SkylineMinTotalHeight tester=new SkylineMinTotalHeight();
		int[] front={3,3};
		int[] left={3};
		assertTrue(tester.findMinTotalHeight(front, left)==6);
		
	}
	@Test
	public void test3() {
		SkylineMinTotalHeight tester=new SkylineMinTotalHeight();
		int[] front={1,5,3,4,3};
		int[] left={1,2,5,2};
		assertTrue(tester.findMinTotalHeight(front, left)==20);
		
	}
}
