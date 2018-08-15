package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.N2Graph;

public class N2GraphTester {

	@Test
	public void test1() {
		N2Graph tester=new N2Graph();
		int[][] res=tester.populateMatrix(4);
		tester.printMatrix(res);
	}
	@Test
	public void test2() {
		N2Graph tester=new N2Graph();
		int[][] res=tester.populateMatrix(2);
		tester.printMatrix(res);
	}
	@Test
	public void test3() {
		N2Graph tester=new N2Graph();
		int[][] res=tester.populateMatrix(3);
		tester.printMatrix(res);
	}

}
