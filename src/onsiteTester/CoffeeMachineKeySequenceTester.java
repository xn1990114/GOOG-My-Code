package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.CoffeeMachineKeySequence;

public class CoffeeMachineKeySequenceTester {

	@Test
	public void test1() {
		CoffeeMachineKeySequence tester=new CoffeeMachineKeySequence();
		int[] small={1,1};
		int[] medium={2,5};
		int[] large={3,7};
		assertTrue(tester.getKeySequence(small, medium, large, 5, 7).equals("SSSSS"));
	}
	@Test
	public void test2() {
		CoffeeMachineKeySequence tester=new CoffeeMachineKeySequence();
		int[] small={1,3};
		int[] medium={2,5};
		int[] large={3,7};
		assertTrue(tester.getKeySequence(small, medium, large, 5, 7).equals(""));
	}
	@Test
	public void test3() {
		CoffeeMachineKeySequence tester=new CoffeeMachineKeySequence();
		int[] small={2,2};
		int[] medium={3,3};
		int[] large={4,4};
		assertTrue(tester.getKeySequence(small, medium, large, 3, 3).equals("M"));
	}
	@Test
	public void test4() {
		CoffeeMachineKeySequence tester=new CoffeeMachineKeySequence();
		int[] small={1,2};
		int[] medium={2,5};
		int[] large={3,6};
		assertTrue(tester.getKeySequence(small, medium, large, 19, 40).equals("MMLLLLL"));
	}
	@Test
	public void test5() {
		CoffeeMachineKeySequence tester=new CoffeeMachineKeySequence();
		int[] small={1,2};
		int[] medium={2,5};
		int[] large={3,6};
		assertTrue(tester.getKeySequence(small, medium, large, 19, 38).equals("SLLLLLL"));
	}
}
