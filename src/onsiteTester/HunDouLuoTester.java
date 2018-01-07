package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.HunDouLuo;

public class HunDouLuoTester {
	HunDouLuo tester=new HunDouLuo();
	@Test
	public void test1() {
		String s="UUDDLLRRBBAA";
		assertTrue(tester.checkCheatCode(s));
	}
	@Test
	public void test2() {
		String s="UUDDLLRRBBAAUUDDLLRRBBAA";
		assertTrue(tester.checkCheatCode(s));
	}
	@Test
	public void test3() {
		String s="UUDDDLLRRBBAA";
		assertTrue(!tester.checkCheatCode(s));
	}
	@Test
	public void test4() {
		String s="UUDDLLRRBBUUUUUDDLLRRBBAA";
		assertTrue(tester.checkCheatCode(s));
	}
	@Test
	public void test5() {
		String s="UUDDLLRRBBUUUUUDDLLRRBBA";
		assertTrue(!tester.checkCheatCode(s));
	}
	@Test
	public void test6() {
		String s="UUDDLLRRBABA";
		assertTrue(!tester.checkCheatCode(s));
	}
	@Test
	public void test7() {
		String s="UUUUBUDDLLRRBBAA";
		assertTrue(!tester.checkCheatCode(s));
	}
	@Test
	public void test8() {
		String s="UDDLLRUUUUBUDDLUUDDLLRRBBAALRRBBAAAAUDDLLR";
		assertTrue(tester.checkCheatCode(s));
	}
	@Test
	public void test9() {
		String s="UDDLLRUUUUBUDDLUUUDDLLUUDDLLRRBBAARRBBAAUDDLLRRBBAALRRBBAAAAUDDLLR";
		assertTrue(tester.checkCheatCode(s));
	}
}
