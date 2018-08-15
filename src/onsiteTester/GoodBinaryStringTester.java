package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.GoodBinaryString;

public class GoodBinaryStringTester {

	@Test
	public void test() {
		GoodBinaryString tester=new GoodBinaryString();
		assertTrue(tester.findBreakIndex("0000")==4);
		assertTrue(tester.findBreakIndex("1111")==0);
		assertTrue(tester.findBreakIndex("1101")==0);
		assertTrue(tester.findBreakIndex("10011")==3);
		assertTrue(tester.findBreakIndex("10001")==4);
	}

}
