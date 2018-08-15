package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.KthMinValueOfDataStreamWithMovingK;

public class KthMinValueOfDataStreamWithMovingKTester {

	@Test
	public void test() {
		KthMinValueOfDataStreamWithMovingK tester=new KthMinValueOfDataStreamWithMovingK();
		assertTrue(tester.getKthMinVal(1)==null);
		tester.insertValue(5);tester.insertValue(5);tester.insertValue(5);
		tester.insertValue(3);tester.insertValue(2);
		assertTrue(tester.getKthMinVal(1)==2);
		assertTrue(tester.getKthMinVal(2)==3);
		assertTrue(tester.getKthMinVal(5)==5);
		assertTrue(tester.getKthMinVal(6)==null);
		tester.insertValue(3);tester.insertValue(2);
		tester.insertValue(6);tester.insertValue(6);
		assertTrue(tester.getKthMinVal(6)==5);
		assertTrue(tester.getKthMinVal(2)==2);
		assertTrue(tester.getKthMinVal(3)==3);
	}

}
