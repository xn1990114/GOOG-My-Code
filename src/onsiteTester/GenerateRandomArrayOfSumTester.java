package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.GenerateRandomArrayOfSum;

public class GenerateRandomArrayOfSumTester {

	@Test
	public void test() {
		GenerateRandomArrayOfSum tester=new GenerateRandomArrayOfSum();
		int[] a1=tester.randomArrayWithSum(5, 30);
		int[] a2=tester.randomArrayWithSumAndCap(5, 30, 7);
		for(int i=0;i<5;i++){
			System.out.print(a1[i]+",");
		}
		System.out.println();
		for(int i=0;i<5;i++){
			System.out.print(a2[i]+",");
		}
	}

}
