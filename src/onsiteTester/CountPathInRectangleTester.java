package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.CountPathInRectangle;

public class CountPathInRectangleTester {

	@Test
	public void test1() {
		CountPathInRectangle tester=new CountPathInRectangle();
		assertTrue(tester.countPath(5, 10)==835);
		assertTrue(tester.countPath(10, 10)==835);
		assertTrue(tester.countPath(3, 10)==697);
	}
	@Test
	public void test2() {
		CountPathInRectangle tester=new CountPathInRectangle();
		int[][] requiredPoints={{1,2},{0,5},{1,8}};
		assertTrue(tester.countPathWith3Points(3, 10, requiredPoints)==50);
		assertTrue(tester.countPathWith3Points(5, 10, requiredPoints)==50);
		int[][] requiredPoints2={{4,4},{0,0},{0,9}};
		assertTrue(tester.countPathWith3Points(5, 10, requiredPoints2)==5);
		assertTrue(tester.countPathWith3Points(3, 10, requiredPoints2)==0);
		int[][] requiredPoints3={{4,0},{1,0},{0,9}};
		assertTrue(tester.countPathWith3Points(5, 10, requiredPoints3)==0);
	}
	@Test
	public void test3() {
		CountPathInRectangle tester=new CountPathInRectangle();
		assertTrue(tester.countPathWithTargetH(5, 10, 3)==138);
		assertTrue(tester.countPathWithTargetH(5, 9, 4)==1);
		assertTrue(tester.countPathWithTargetH(5, 10, 4)==9);
		assertTrue(tester.countPathWithTargetH(5, 10, 1)==834);
		assertTrue(tester.countPathWithTargetH(5, 10, 0)==835);
	}
	@Test
	public void test4() {
		CountPathInRectangle tester=new CountPathInRectangle();
		int[] rowSeq1={2,1};
		assertTrue(tester.countPathWithRowSequence(4, 5, rowSeq1)==1);
		int[] rowSeq2={1,0,1,0};
		assertTrue(tester.countPathWithRowSequence(4, 6, rowSeq2)==5);
		int[] rowSeq3={1,0,1};
		assertTrue(tester.countPathWithRowSequence(4, 6, rowSeq3)==5);
		int[] rowSeq4={0,2};
		assertTrue(tester.countPathWithRowSequence(4, 4, rowSeq4)==0);
	}
}
