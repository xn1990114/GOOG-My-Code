package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.KthMissingNumber;

public class KthMissingNumberTester {

	@Test
	public void test1() {
		KthMissingNumber tester=new KthMissingNumber();
		int[] nums={1,2,3,4,6,9,10};
		assertTrue(tester.linearMethod(nums, 1)==8);
		assertTrue(tester.linearMethod(nums, 2)==7);
		assertTrue(tester.linearMethod(nums, 3)==5);
		assertTrue(tester.binarySearch(nums, 1)==8);
		assertTrue(tester.binarySearch(nums, 2)==7);
		assertTrue(tester.binarySearch(nums, 3)==5);
	}
	@Test
	public void test2() {
		KthMissingNumber tester=new KthMissingNumber();
		int[] nums={0,2,3,4,6,10};
		assertTrue(tester.linearMethod(nums, 1)==9);
		assertTrue(tester.linearMethod(nums, 2)==8);
		assertTrue(tester.linearMethod(nums, 3)==7);
		assertTrue(tester.linearMethod(nums, 4)==5);
		assertTrue(tester.linearMethod(nums, 5)==1);
		assertTrue(tester.linearMethod(nums, 6)==-1);
		assertTrue(tester.binarySearch(nums, 1)==9);
		assertTrue(tester.binarySearch(nums, 2)==8);
		assertTrue(tester.binarySearch(nums, 3)==7);
		assertTrue(tester.binarySearch(nums, 4)==5);
		assertTrue(tester.binarySearch(nums, 5)==1);
		assertTrue(tester.binarySearch(nums, 6)==-1);
	}
	@Test
	public void test3() {
		KthMissingNumber tester=new KthMissingNumber();
		int[] nums={0,1,2,3};
		assertTrue(tester.linearMethod(nums, 1)==-1);
		assertTrue(tester.linearMethod(nums, 2)==-1);
		assertTrue(tester.binarySearch(nums, 1)==-1);
		assertTrue(tester.binarySearch(nums, 2)==-1);
	}
}
