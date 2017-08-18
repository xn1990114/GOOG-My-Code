package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.TypoChecker;

public class TypoCheckerTester {

	@Test
	public void test() {
		String[] dic={"apple","oppo","opple"};
		String t1="applr";
		String t2="oppor";
		String t3="ottle";
		String t4="opp";
		String t5="oppro";
		TypoChecker tc=new TypoChecker();
		assertTrue(tc.checkTypo(dic, t1));
		assertTrue(tc.checkTypo(dic, t2));
		assertTrue(!tc.checkTypo(dic, t3));
		assertTrue(tc.checkTypo(dic, t4));
		assertTrue(tc.checkTypo(dic, t5));
	}

}
