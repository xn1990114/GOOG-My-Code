package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.CountIterator;

public class CountIteratorTester {

	@Test
	public void test1() {
		int[] nums = { 3, 1, 0, 9, 2, 4 };
		int[] res = { 1, 1, 1, 4, 4 };
		CountIterator tester = new CountIterator(nums);
		for (int i = 0; i < res.length; i++) {
			assertTrue(tester.hasNext());
			assertTrue(tester.next() == res[i]);
		}
		assertTrue(!tester.hasNext());
	}

	@Test
	public void test2() {
		int[] nums = { 0, 1, 0, 9, 0, 4 };
		int[] res = {};
		CountIterator tester = new CountIterator(nums);
		for (int i = 0; i < res.length; i++) {
			assertTrue(tester.hasNext());
			assertTrue(tester.next() == res[i]);
		}
		assertTrue(!tester.hasNext());
	}

	@Test
	public void test3() {
		int[] nums = {};
		int[] res = {};
		CountIterator tester = new CountIterator(nums);
		for (int i = 0; i < res.length; i++) {
			assertTrue(tester.hasNext());
			assertTrue(tester.next() == res[i]);
		}
		assertTrue(!tester.hasNext());
	}

}
