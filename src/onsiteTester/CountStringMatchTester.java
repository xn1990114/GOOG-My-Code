package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.CountStringMatch;

public class CountStringMatchTester {

	@Test
	public void test1() {
		CountStringMatch tester=new CountStringMatch();
		String s="abcdefg";
		String t="ab";
		int[] r={0,1};
		assertTrue(tester.compareResult(tester.isUniqueSubstring(s, t), r));
	}
	@Test
	public void test2() {
		CountStringMatch tester=new CountStringMatch();
		String s="abcdabc";
		String t="abc";
		int[] r={};
		assertTrue(tester.compareResult(tester.isUniqueSubstring(s, t), r));
	}
	@Test
	public void test3() {
		CountStringMatch tester=new CountStringMatch();
		String s="abcddefg";
		String t="abdf";
		int[] r={};
		assertTrue(tester.compareResult(tester.isUniqueSubstring(s, t), r));
	}
	@Test
	public void test4() {
		CountStringMatch tester=new CountStringMatch();
		String s="abcdefgg";
		String t="abdeg";
		int[] r={};
		assertTrue(tester.compareResult(tester.isUniqueSubstring(s, t), r));
	}
	@Test
	public void test5() {
		CountStringMatch tester=new CountStringMatch();
		String s="abcd";
		String t="abcde";
		int[] r={};
		assertTrue(tester.compareResult(tester.isUniqueSubstring(s, t), r));
	}
	@Test
	public void test6() {
		CountStringMatch tester=new CountStringMatch();
		String s="abcdefgg";
		String t="abcdefgg";
		int[] r={0,1,2,3,4,5,6,7};
		assertTrue(tester.compareResult(tester.isUniqueSubstring(s, t), r));
	}
}
