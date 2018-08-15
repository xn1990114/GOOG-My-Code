package onsiteTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import onsite.MaxCutToSortArray;

public class MaxCutToSortArrayTester {

	@Test
	public void test1() {
		MaxCutToSortArray tester=new MaxCutToSortArray();
		int[] nums={5,5,2,2,4,6,23,6,21,6,2};
		List<Integer> r1=tester.findCutPoints(nums);
		List<Integer> r2=tester.findCutPointsWithSort(nums);
		for(int n:r1){
			System.out.print(n+",");
		}
		assertTrue(tester.isSame(r1, r2));
		System.out.println();
	}
	@Test
	public void test2() {
		MaxCutToSortArray tester=new MaxCutToSortArray();
		int[] nums={5,5,2,2,4,6,23,6,21,6,25};
		List<Integer> r1=tester.findCutPoints(nums);
		List<Integer> r2=tester.findCutPointsWithSort(nums);
		for(int n:r1){
			System.out.print(n+",");
		}
		assertTrue(tester.isSame(r1, r2));
		System.out.println();
	}
	@Test
	public void test3() {
		MaxCutToSortArray tester=new MaxCutToSortArray();
		int[] nums={5,5,2,2,4,6,23,21,26,25};
		List<Integer> r1=tester.findCutPoints(nums);
		List<Integer> r2=tester.findCutPointsWithSort(nums);
		for(int n:r1){
			System.out.print(n+",");
		}
		assertTrue(tester.isSame(r1, r2));
		System.out.println();
	}
	@Test
	public void test4() {
		MaxCutToSortArray tester=new MaxCutToSortArray();
		int[] nums={5,5,2,2,4,6,23,23,26,26};
		List<Integer> r1=tester.findCutPoints(nums);
		List<Integer> r2=tester.findCutPointsWithSort(nums);
		for(int n:r1){
			System.out.print(n+",");
		}
		assertTrue(tester.isSame(r1, r2));
		System.out.println();
	}
	@Test
	public void test5() {
		MaxCutToSortArray tester=new MaxCutToSortArray();
		int[] nums={5,5,2,2,4,6,23,3,26,26};
		List<Integer> r1=tester.findCutPoints(nums);
		List<Integer> r2=tester.findCutPointsWithSort(nums);
		for(int n:r1){
			System.out.print(n+",");
		}
		assertTrue(tester.isSame(r1, r2));
		System.out.println();
	}
	@Test
	public void test6() {
		MaxCutToSortArray tester=new MaxCutToSortArray();
		int[] nums={5,5,6,6};
		List<Integer> r1=tester.findCutPoints(nums);
		List<Integer> r2=tester.findCutPointsWithSort(nums);
		for(int n:r1){
			System.out.print(n+",");
		}
		assertTrue(tester.isSame(r1, r2));
		System.out.println();
	}
}
