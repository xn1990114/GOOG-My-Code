package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.PalinStringMaker;

public class PalinStringMakerTester {

	@Test
	public void test() {
		PalinStringMaker tester=new PalinStringMaker();
		String s1="abcabc";
		System.out.println(tester.findMinPalin(s1));
		String s2="";
		System.out.println(tester.findMinPalin(s2));
		String s3="ababa";
		System.out.println(tester.findMinPalin(s3));
		String s4="ababc";
		System.out.println(tester.findMinPalin(s4));
		String s5="acbbc";
		System.out.println(tester.findMinPalin(s5));
		String s6="ac";
		System.out.println(tester.findMinPalin(s6));
	}

}
