package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.StringPatternMatch;

public class StringPatternMatchTester {

	@Test
	public void test() {
		StringPatternMatch tester=new StringPatternMatch();
		String p1="abc";
		String s1="abc";
		assertTrue(tester.isMatch(s1, p1));
		String p2="1oc3";
		String s2="aoczzz";
		assertTrue(tester.isMatch(s2, p2));
		String p3="1oc3";
		String s3="aoczzz";
		assertTrue(tester.isMatch(s3, p3));
		String p4="1oc4";
		String s4="aoczzz";
		assertTrue(!tester.isMatch(s4, p4));
		String p5="1oc4";
		String s5="aoczzzas";
		assertTrue(!tester.isMatch(s5, p5));
		String p6="o";
		String s6="";
		assertTrue(!tester.isMatch(s6, p6));
		String p7="";
		String s7="r";
		assertTrue(!tester.isMatch(s7, p7));
		String p8="5";
		String s8="";
		assertTrue(!tester.isMatch(s8, p8));
		String p9="11oc14a";
		String s9="swdsderfta2oczzzasurhdjskcia";
		assertTrue(tester.isMatch(s9, p9));
	}

}
