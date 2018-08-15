package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.PaintersPartition;

public class PaintersPartitionTester {

	@Test
	public void test1() {
		PaintersPartition tester=new PaintersPartition();
		int[] walls={10, 10, 10, 10};
		assertTrue(tester.calMinTimeDP(walls, 2)==20);
		assertTrue(tester.calMinTimeBinarySearch(walls, 2)==20);
	}
	@Test
	public void test2() {
		PaintersPartition tester=new PaintersPartition();
		int[] walls={10, 20, 30, 40};
		assertTrue(tester.calMinTimeDP(walls, 2)==60);
		assertTrue(tester.calMinTimeBinarySearch(walls, 2)==60);
	}
	
	@Test
	public void test3() {
		PaintersPartition tester=new PaintersPartition();
		int[] walls={10, 80,10, 20, 30, 40, 10, 10};
		assertTrue(tester.calMinTimeDP(walls, 4)==80);
		assertTrue(tester.calMinTimeBinarySearch(walls, 4)==80);
	}
	@Test
	public void test4() {
		PaintersPartition tester=new PaintersPartition();
		int[] walls={10, 20, 30, 40};
		assertTrue(tester.calMinTimeDP(walls, 8)==40);
		assertTrue(tester.calMinTimeBinarySearch(walls, 8)==40);
	}
	@Test
	public void test5() {
		PaintersPartition tester=new PaintersPartition();
		int[] walls={0, 0, 0, 0};
		assertTrue(tester.calMinTimeDP(walls, 8)==0);
		assertTrue(tester.calMinTimeBinarySearch(walls, 8)==0);
	}
}
