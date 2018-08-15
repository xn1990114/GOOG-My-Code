package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.RandomBrickPick;

public class RandomBrickPickTester {

	@Test
	public void test1() {
		int[] nums={2,3,2,3};
		RandomBrickPick tester=new RandomBrickPick(nums);
		for(int i=0;i<11;i++){
			System.out.print(tester.pickBrick()+",");
		}
		System.out.println();
	}
	@Test
	public void test2() {
		int[] nums={2,3,2,3,0,1};
		RandomBrickPick tester=new RandomBrickPick(nums);
		for(int i=0;i<15;i++){
			System.out.print(tester.pickBrick()+",");
		}
		System.out.println();
	}
}
