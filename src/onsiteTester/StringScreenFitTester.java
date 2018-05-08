package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.StringScreenFit;

public class StringScreenFitTester {

	@Test
	public void test() {
		StringScreenFit tester=new StringScreenFit();
		String s="this is a long string and we are testing if it can be fit into a screen. I'm just added random content to it now.";
		System.out.println(s.length());
		assertTrue(tester.findMaxFontSizeToFit(10,10 , s)==0);
		assertTrue(tester.findMaxFontSizeToFit(20,10 , s)==1);
		assertTrue(tester.findMaxFontSizeToFit(100,100 , s)==8);
		assertTrue(tester.findMaxFontSizeToFit(100,800 , s)==25);
		assertTrue(tester.findMaxFontSizeToFit(500, 800, s)==55);
	}

}
