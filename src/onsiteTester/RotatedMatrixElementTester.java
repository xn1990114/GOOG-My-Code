package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.RotatedMatrixElement;

public class RotatedMatrixElementTester {

	@Test
	public void test() {
		RotatedMatrixElement tester=new RotatedMatrixElement();
		assertTrue(tester.getElement(0, 0)==0);
		assertTrue(tester.getElement(1,0)==1);
		assertTrue(tester.getElement((1<<16)-1,(1<<16)-1)==(1<<32));
		assertTrue(tester.getElement(0,(1<<16)-1)==(long)Math.pow(2,32)-1);
	}

}
