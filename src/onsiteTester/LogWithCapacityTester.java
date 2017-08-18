package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.LogWithCapacity;

public class LogWithCapacityTester {

	@Test
	public void test() {
		LogWithCapacity lwc=new LogWithCapacity();
		int[] array={10, 20, 20, 50, 70};
		System.out.println(lwc.findBound(array, 90));
		int[] array2={10, 50, 20, 20, 70};
		System.out.println(lwc.findBound(array2, 90));
		int[] array3={50, 20};
		System.out.println(lwc.findBound(array3, 30));
		int[] array4={50, 10,20};
		System.out.println(lwc.findBound(array4, 30));
		int[] array5={50, 10,20,20};
		System.out.println(lwc.findBound(array5, 100));
		int[] array6={50,10,20,20,20};
		System.out.println(lwc.findBound(array6, 100));
	}

}
