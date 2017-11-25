package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.WeightSumOfKSubArray;

public class WeightSumOfKSubArrayTester {

	@Test
	public void test() {
		WeightSumOfKSubArray tester=new WeightSumOfKSubArray();
		int[] nums1={1, 2, 32, 7, 2, 23, 3, 4, 32, 2};
		int k1=3;
		assertTrue(tester.calMaxSum(nums1, k1)==4183);
		int[] nums2={-10, 2, 32, -7, 2, -10};
		int k2=3;
		assertTrue(tester.calMaxSum(nums2, k2)==64+70-14-20);
		int[] nums3={-10, 2, 32};
		int k3=1;
		assertTrue(tester.calMaxSum(nums3, k3)==-340+64);
		int[] nums4={-10, 2, 32,-10,-40,-50};
		int k4=3;
		assertTrue(tester.calMaxSum(nums4, k4)==64+2900);
		int[] nums5={1000,-5,-10,40,-50};
		int k5=3;
		assertTrue(tester.calMaxSum(nums5, k5)==50-600);
		int[] nums6={-10,2,-5,1};
		int k6=3;
		assertTrue(tester.calMaxSum(nums6, k6)==-5);
	}

}
