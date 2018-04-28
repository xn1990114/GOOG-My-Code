package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MinimumIntegerCycle;

public class MinimumIntegerCycleTester {

	@Test
	public void test1() {
		MinimumIntegerCycle tester=new MinimumIntegerCycle();
		int[] nums={1,2,1,2};
		assertTrue(tester.findMinReapeatingCycle(nums)==2);
	}
	@Test
	public void test2() {
		MinimumIntegerCycle tester=new MinimumIntegerCycle();
		int[] nums={1,1,1,1};
		assertTrue(tester.findMinReapeatingCycle(nums)==1);
	}
	@Test
	public void test3() {
		MinimumIntegerCycle tester=new MinimumIntegerCycle();
		int[] nums={1,2,1,2,3,1,2};
		assertTrue(tester.findMinReapeatingCycle(nums)==5);
	}
	@Test
	public void test4() {
		MinimumIntegerCycle tester=new MinimumIntegerCycle();
		int[] nums={1,2,1,2,1,2,1,2};
		assertTrue(tester.findMinReapeatingCycle(nums)==2);
	}
	@Test
	public void test5() {
		MinimumIntegerCycle tester=new MinimumIntegerCycle();
		int[] nums={1};
		assertTrue(tester.findMinReapeatingCycle(nums)==1);
	}
}
