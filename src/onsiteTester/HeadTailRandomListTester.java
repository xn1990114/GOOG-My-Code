package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.HeadTailRandomList;

public class HeadTailRandomListTester {
	@Test
	public void test1() {
		HeadTailRandomList tester=new HeadTailRandomList();
		int[] nums={1,2,3,4,5,6,7};
		for(int i=0;i<nums.length;i++){
			tester.push(nums[i]);
		}
		List<Integer> r=tester.getSortedUsingRandomPop();
		for(int i=0;i<nums.length;i++){
			assertTrue(nums[i]==r.get(i));
		}
	}
	@Test
	public void test2() {
		HeadTailRandomList tester=new HeadTailRandomList();
		int[] nums={1,2,2,2,3,4,5,5,5,6,6,6,7,7,7};
		for(int i=0;i<nums.length;i++){
			tester.push(nums[i]);
		}
		List<Integer> r=tester.getSortedUsingRandomPop();
		for(int i=0;i<nums.length;i++){
			assertTrue(nums[i]==r.get(i));
		}
	}
	/*@Test
	public void test3() {
		HeadTailRandomList tester=new HeadTailRandomList();
		int[] nums={1,2,3,4,5,6,7};
		for(int i=0;i<nums.length;i++){
			tester.pushWithRandom(nums[i]);
		}
		List<Integer> r=tester.getSortedUsingRandomPush();
		for(int i=0;i<nums.length;i++){
			assertTrue(nums[i]==r.get(i));
		}
	}*/
	@Test
	public void test4() {
		HeadTailRandomList tester=new HeadTailRandomList();
		int[] nums={1,2,2,2,3,4,5,5,5,6,6,6,7,7,7};
		for(int i=0;i<nums.length;i++){
			tester.pushWithRandom(nums[i]);
		}
		List<Integer> r=tester.getSortedUsingRandomPush();
		for(int i=0;i<nums.length;i++){
			assertTrue(nums[i]==r.get(i));
		}
	}
}
