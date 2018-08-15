package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.ForestCamera;

public class ForestCameraTester {

	@Test
	public void test() {
		ForestCamera tester=new ForestCamera();
		double[][] trees={{5,0}, {6.8,0}, {4.5,2}, {7.7,5.7}, {-10,5},{-5000,-5000},{-5000,5000},{45,1},{-8000,0},
				{67,-98},{1,-0.0000001},{-0.0000001,1},{-6,-2}};
		assertTrue(tester.minScanNeeded(trees, 360)==1);
		assertTrue(tester.minScanNeeded(trees, 45)==5);
		assertTrue(tester.minScanNeeded(trees, 30)==7);
		assertTrue(tester.minScanNeeded(trees, 120)==3);
		assertTrue(tester.minScanNeeded(trees, 150)==2);
	}

}
