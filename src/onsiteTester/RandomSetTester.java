package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.RandomSet;

public class RandomSetTester {

	@Test
	public void test() {
		RandomSet<Integer> mySet=new RandomSet<Integer>();
		mySet.add(1);
		mySet.add(2);
		System.out.println(mySet.getRandom());
		mySet.remove(1);
		assertTrue(mySet.getRandom()==2);
		mySet.add(3);
		mySet.add(3);
		System.out.println(mySet.getRandom());
		mySet.remove(3);
		assertTrue(mySet.getRandom()==2);
		mySet.remove(2);
		assertTrue(mySet.getRandom()==null);
	}

}
