package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.FirstMissingElement;

public class findFirstElementTester {

	@Test
	public void test1() {
		FirstMissingElement tester=new FirstMissingElement();
		int[] nums={2,3,5,7};
		assertTrue(tester.findFirstElement(nums, 0)==4);
		assertTrue(tester.findFirstElement(nums, 1)==6);
	}
	@Test
	public void test2() {
		FirstMissingElement tester=new FirstMissingElement();
		int[] nums={};
		assertTrue(tester.findFirstElement(nums, 0)==0);
	}
	@Test
	public void test3() {
		FirstMissingElement tester=new FirstMissingElement();
		int[] nums={-5,-5,-5,-4,-4,0,3,3,3,6,6};
		assertTrue(tester.findFirstElement(nums, 0)==-3);
		assertTrue(tester.findFirstElement(nums, 4)==2);
		assertTrue(tester.findFirstElement(nums, 10)==10);
	}

}
