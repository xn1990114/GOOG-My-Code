package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.RecoverSortedArray;

public class RecoverSortedArrayTester {

	@Test
	public void test1() {
		RecoverSortedArray tester=new RecoverSortedArray();
		int[] nums={3,4,1,2};
		tester.printAllPath(tester.findAllPathToSortArray(nums));
	}
	@Test
	public void test2() {
		RecoverSortedArray tester=new RecoverSortedArray();
		int[] nums={};
		tester.printAllPath(tester.findAllPathToSortArray(nums));
	}
	@Test
	public void test3() {
		RecoverSortedArray tester=new RecoverSortedArray();
		int[] nums={3};
		tester.printAllPath(tester.findAllPathToSortArray(nums));
	}
	@Test
	public void test4() {
		RecoverSortedArray tester=new RecoverSortedArray();
		int[] nums={3,4,1,2,-1};
		tester.printAllPath(tester.findAllPathToSortArray(nums));
	}
	@Test
	public void test5() {
		RecoverSortedArray tester=new RecoverSortedArray();
		int[] nums={3,4,2,1};
		tester.printAllPath(tester.findAllPathToSortArray(nums));
	}
	@Test
	public void test6() {
		RecoverSortedArray tester=new RecoverSortedArray();
		int[] nums={-1,1,4,3,2};
		tester.printAllPath(tester.findAllPathToSortArray(nums));
	}
}
