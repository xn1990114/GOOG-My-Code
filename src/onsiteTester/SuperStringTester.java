package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SuperString;

public class SuperStringTester {

	@Test
	public void test1() {
		SuperString tester=new SuperString();
		String s1="lee";
		String s2="eel";
		assertTrue(tester.findMinSuperString(s1, s2).equals("leel"));
		s1="abcd";
		s2="bc";
		assertTrue(tester.findMinSuperString(s1, s2).equals("abcdbc"));
		s1="abcd";
		s2="aabcd";
		assertTrue(tester.findMinSuperString(s1, s2).equals("abcdaabcd"));
		s1="abcd";
		s2="abcd";
		assertTrue(tester.findMinSuperString(s1, s2).equals("abcd"));
		s1="abcd";
		s2="bcd";
		assertTrue(tester.findMinSuperString(s1, s2).equals("abcd"));
		s1="abcd";
		s2="abcdfg";
		assertTrue(tester.findMinSuperString(s1, s2).equals("abcdfg"));
		s1="";
		s2="abcdfg";
		assertTrue(tester.findMinSuperString(s1, s2).equals("abcdfg"));
	}
	@Test
	public void test2() {
		SuperString tester=new SuperString();
		String[] s={"lee","eel","lucky","you","ok","welcome","comehome","ehome","like","lili"};
		System.out.println(tester.makeShortestSuperString(s));
	}
	@Test
	public void test3() {
		SuperString tester=new SuperString();
		String[] s={"lee","eel","lucky","you","ok","welcome","comehome","ehome","like","lili"};
		System.out.println(tester.makeShortestSuperStringGreedy(s));
	}
}
