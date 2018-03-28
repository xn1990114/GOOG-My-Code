package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.AlmostPalindrome;

public class AlmostPalindromeTester {

	@Test
	public void test1() {
		AlmostPalindrome tester=new AlmostPalindrome();
		String s="aba";
		assertTrue(tester.isAlmostPalinEdgeToMiddle(s));
		assertTrue(tester.isAlmostPalinMiddleToEdge(s));
	}
	@Test
	public void test2() {
		AlmostPalindrome tester=new AlmostPalindrome();
		String s="abb";
		assertTrue(tester.isAlmostPalinEdgeToMiddle(s));
		assertTrue(tester.isAlmostPalinMiddleToEdge(s));
	}@Test
	public void test3() {
		AlmostPalindrome tester=new AlmostPalindrome();
		String s="abca";
		assertTrue(tester.isAlmostPalinEdgeToMiddle(s));
		assertTrue(tester.isAlmostPalinMiddleToEdge(s));
	}@Test
	public void test4() {
		AlmostPalindrome tester=new AlmostPalindrome();
		String s="cddc";
		assertTrue(tester.isAlmostPalinEdgeToMiddle(s));
		assertTrue(tester.isAlmostPalinMiddleToEdge(s));
	}@Test
	public void test5() {
		AlmostPalindrome tester=new AlmostPalindrome();
		String s="abcab";
		assertTrue(!tester.isAlmostPalinEdgeToMiddle(s));
		assertTrue(!tester.isAlmostPalinMiddleToEdge(s));
	}
	@Test
	public void test6() {
		AlmostPalindrome tester=new AlmostPalindrome();
		String s="abccb";
		assertTrue(tester.isAlmostPalinEdgeToMiddle(s));
		assertTrue(tester.isAlmostPalinMiddleToEdge(s));
	}
	@Test
	public void test7() {
		AlmostPalindrome tester=new AlmostPalindrome();
		String s="bcba";
		assertTrue(tester.isAlmostPalinEdgeToMiddle(s));
		assertTrue(tester.isAlmostPalinMiddleToEdge(s));
	}
	@Test
	public void test8() {
		AlmostPalindrome tester=new AlmostPalindrome();
		String s="nan787an";
		assertTrue(tester.isAlmostPalinEdgeToMiddle(s));
		assertTrue(tester.isAlmostPalinMiddleToEdge(s));
	}
	@Test
	public void test9() {
		AlmostPalindrome tester=new AlmostPalindrome();
		String s="nn787a";
		assertTrue(!tester.isAlmostPalinEdgeToMiddle(s));
		assertTrue(!tester.isAlmostPalinMiddleToEdge(s));
	}
}
