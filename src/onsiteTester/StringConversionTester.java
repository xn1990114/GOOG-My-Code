package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.StringConversion;

public class StringConversionTester {

	@Test
	public void test() {
		String s1="abcd";
		String s2="bcde";
		StringConversion sc=new StringConversion();
		assertTrue(sc.countSteps(s1, s2)==4);
		s1="gzef";
		s2="hwcf";
		assertTrue(sc.countSteps(s1, s2)==6);
		s1="bf";
		s2="da";
		assertTrue(sc.countSteps(s1, s2)==23);
		s1="bfcb";
		s2="dagg";
		assertTrue(sc.countSteps(s1, s2)==-1);
	}

}
