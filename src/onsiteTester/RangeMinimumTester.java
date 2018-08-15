package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.RangeMinimum;

public class RangeMinimumTester {

	@Test
	public void test() {
		int[] nums={8,5,-10,5,2,7,-9,-10};
		RangeMinimum tester=new RangeMinimum(nums);
		assertTrue(tester.query(0, 5)==-10);
		assertTrue(tester.query(3, 5)==2);
		assertTrue(tester.query(3, 6)==-9);
		assertTrue(tester.query(0, 8)==-10);
		tester.update(7, 10);
		assertTrue(tester.query(0, 8)==-10);
		assertTrue(tester.query(5, 8)==-9);
		tester.update(2, 10);
		assertTrue(tester.query(0, 8)==-9);
		assertTrue(tester.query(2, 5)==2);
	}

}
