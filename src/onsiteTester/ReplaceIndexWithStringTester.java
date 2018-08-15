package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.ReplaceIndexWithString;

public class ReplaceIndexWithStringTester {

	@Test
	public void test1() {
		ReplaceIndexWithString tester=new ReplaceIndexWithString();
		String s="I am {0} {2}.";
		String[] replacement={"very","apple", "happy"};
		assertTrue(tester.buildNewString(s, replacement).equals("I am very happy."));
	}
	@Test
	public void test2() {
		ReplaceIndexWithString tester=new ReplaceIndexWithString();
		String s="I am {0} {3}.";
		String[] replacement={"very","apple", "happy"};
		assertTrue(tester.buildNewString(s, replacement).equals("I am very {3}."));
	}
	@Test
	public void test3() {
		ReplaceIndexWithString tester=new ReplaceIndexWithString();
		String s="I am {0} {}{{2}}.";
		String[] replacement={"very","apple", "happy"};
		assertTrue(tester.buildNewString(s, replacement).equals("I am very {}{happy}."));
	}
	@Test
	public void test4() {
		ReplaceIndexWithString tester=new ReplaceIndexWithString();
		String s="I am {0} {2}{.";
		String[] replacement={"very","apple", "happy"};
		assertTrue(tester.buildNewString(s, replacement).equals("I am very happy{."));
	}
	@Test
	public void test5() {
		ReplaceIndexWithString tester=new ReplaceIndexWithString();
		String s="{I0 am {0} {2}{.";
		String[] replacement={"very","apple", "happy"};
		assertTrue(tester.buildNewString(s, replacement).equals("{I0 am very happy{."));
	}
	@Test
	public void test6() {
		ReplaceIndexWithString tester=new ReplaceIndexWithString();
		String s="I am {0000000000000000000} {2}{.";
		String[] replacement={"very","apple", "happy"};
		assertTrue(tester.buildNewString(s, replacement).equals("I am very happy{."));
	}
	@Test
	public void test7() {
		ReplaceIndexWithString tester=new ReplaceIndexWithString();
		String s="I am {0000000000000000001} {2}{.";
		String[] replacement={"very","apple", "happy"};
		assertTrue(tester.buildNewString(s, replacement).equals("I am apple happy{."));
	}
	@Test
	public void test8() {
		ReplaceIndexWithString tester=new ReplaceIndexWithString();
		String s="I am {0000000000000000003} {2}{.";
		String[] replacement={"very","apple", "happy"};
		assertTrue(tester.buildNewString(s, replacement).equals("I am {0000000000000000003} happy{."));
	}
	@Test
	public void test9() {
		ReplaceIndexWithString tester=new ReplaceIndexWithString();
		String s="I am {1000000000000000003} {2}{.";
		String[] replacement={"very","apple", "happy"};
		assertTrue(tester.buildNewString(s, replacement).equals("I am {1000000000000000003} happy{."));
	}
	@Test
	public void test10() {
		ReplaceIndexWithString tester=new ReplaceIndexWithString();
		String s="I am {10000000{0000000000000000000}00000000003} {2}{.";
		String[] replacement={"very","apple", "happy"};
		assertTrue(tester.buildNewString(s, replacement).equals("I am {10000000very00000000003} happy{."));
	}
}
