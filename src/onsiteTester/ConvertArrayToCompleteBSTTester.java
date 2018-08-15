package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.ConvertArrayToCompleteBST;

public class ConvertArrayToCompleteBSTTester {

	@Test
	public void test1() {
		ConvertArrayToCompleteBST tester=new ConvertArrayToCompleteBST();
		int[] nums={1,2,3,4,5,6,7,8,9};
		tester.printTree(tester.convertArrayToCompleteBST(nums));
	}
	@Test
	public void test2() {
		ConvertArrayToCompleteBST tester=new ConvertArrayToCompleteBST();
		int[] nums={1,2,3,4,5,6,7,8,9,10};
		tester.printTree(tester.convertArrayToCompleteBST(nums));
	}
	@Test
	public void test4() {
		ConvertArrayToCompleteBST tester=new ConvertArrayToCompleteBST();
		int[] nums={1,2,3,4,5,6,7,8,9,10,11};
		tester.printTree(tester.convertArrayToCompleteBST(nums));
	}
	@Test
	public void test5() {
		ConvertArrayToCompleteBST tester=new ConvertArrayToCompleteBST();
		int[] nums={1,2,3,4,5,6,7,8,9,10,11,12};
		tester.printTree(tester.convertArrayToCompleteBST(nums));
	}
	@Test
	public void test6() {
		ConvertArrayToCompleteBST tester=new ConvertArrayToCompleteBST();
		int[] nums={1,2,3,4,5,6,7,8,9,10,11,12,13};
		tester.printTree(tester.convertArrayToCompleteBST(nums));
	}
	@Test
	public void test7() {
		ConvertArrayToCompleteBST tester=new ConvertArrayToCompleteBST();
		int[] nums={1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		tester.printTree(tester.convertArrayToCompleteBST(nums));
	}
	@Test
	public void test8() {
		ConvertArrayToCompleteBST tester=new ConvertArrayToCompleteBST();
		int[] nums={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		tester.printTree(tester.convertArrayToCompleteBST(nums));
	}
	@Test
	public void test9() {
		ConvertArrayToCompleteBST tester=new ConvertArrayToCompleteBST();
		int[] nums={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		tester.printTree(tester.convertArrayToCompleteBST(nums));
	}
}
