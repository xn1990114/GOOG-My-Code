package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.InsertNumToInterval;

public class InsertNumToIntervalTester {

	@Test
	public void test1() {
		InsertNumToInterval tester=new InsertNumToInterval();
		List<int[]> intervals=new ArrayList<int[]>();
		intervals.add(new int[]{1,2});
		intervals.add(new int[]{4,5});
		intervals.add(new int[]{9,10});
		int[][] target={{1,2}, {4,5},{7,7}, {9,10}};
		assertTrue(tester.checkRes(tester.insertVal(intervals, 7), target));
	}
	@Test
	public void test2() {
		InsertNumToInterval tester=new InsertNumToInterval();
		List<int[]> intervals=new ArrayList<int[]>();
		intervals.add(new int[]{1,2});
		intervals.add(new int[]{4,5});
		intervals.add(new int[]{9,10});
		int[][] target={{1,5}, {9,10}};
		assertTrue(tester.checkRes(tester.insertVal(intervals, 3), target));
	}
	@Test
	public void test3() {
		InsertNumToInterval tester=new InsertNumToInterval();
		List<int[]> intervals=new ArrayList<int[]>();
		intervals.add(new int[]{1,2});
		intervals.add(new int[]{4,5});
		intervals.add(new int[]{9,10});
		int[][] target={{1,2}, {4,5}, {9,10}};
		assertTrue(tester.checkRes(tester.insertVal(intervals, 4), target));
	}
	@Test
	public void test4() {
		InsertNumToInterval tester=new InsertNumToInterval();
		List<int[]> intervals=new ArrayList<int[]>();
		intervals.add(new int[]{1,2});
		intervals.add(new int[]{4,5});
		intervals.add(new int[]{9,10});
		int[][] target={{1,2}, {4,5}, {9,11}};
		assertTrue(tester.checkRes(tester.insertVal(intervals, 11), target));
	}
	@Test
	public void test5() {
		InsertNumToInterval tester=new InsertNumToInterval();
		List<int[]> intervals=new ArrayList<int[]>();
		intervals.add(new int[]{1,2});
		intervals.add(new int[]{4,5});
		intervals.add(new int[]{9,10});
		int[][] target={{0,2}, {4,5}, {9,10}};
		assertTrue(tester.checkRes(tester.insertVal(intervals, 0), target));
	}
	@Test
	public void test6() {
		InsertNumToInterval tester=new InsertNumToInterval();
		List<int[]> intervals=new ArrayList<int[]>();
		intervals.add(new int[]{1,2});
		intervals.add(new int[]{4,5});
		intervals.add(new int[]{9,10});
		int[][] target={{-1,-1},{1,2}, {4,5}, {9,10}};
		assertTrue(tester.checkRes(tester.insertVal(intervals, -1), target));
	}
	@Test
	public void test7() {
		InsertNumToInterval tester=new InsertNumToInterval();
		List<int[]> intervals=new ArrayList<int[]>();
		intervals.add(new int[]{1,2});
		intervals.add(new int[]{4,5});
		intervals.add(new int[]{9,10});
		int[][] target={{1,2}, {4,5}, {9,10},{12,12}};
		assertTrue(tester.checkRes(tester.insertVal(intervals, 12), target));
	}

}
