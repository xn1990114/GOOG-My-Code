package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MinStepForStringCharReInsert;

public class MinStepForStringCharReInsertTester {

	@Test
	public void test() {
		MinStepForStringCharReInsert tester=new MinStepForStringCharReInsert();
		assertTrue(tester.findMinStep("12314","13241")==4);
		assertTrue(tester.findMinStep("13241","12314")==3);
		assertTrue(tester.findMinStep("baba","abab")==1);
		assertTrue(tester.findMinStep("abcdef","abfdce")==4);
	}

}
