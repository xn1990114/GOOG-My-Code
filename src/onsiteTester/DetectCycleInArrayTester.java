package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.DetectCycleInArray;

public class DetectCycleInArrayTester {

	@Test
	public void test() {
		DetectCycleInArray tester=new DetectCycleInArray();
		int[] nums1={1,2,3,4,5,6,7,8,9,0};
		int[] nums2={1,2,3,4,5,6,7,8,9,10};
		int[] nums3={1,1,3,4,5,6,7,8,9,10};
		int[] nums4={1,1,3,4,0,6,7,8,9,10};
		int[] nums5={1,1,1};
		int[] nums6={3,7,2,1,4,4,6,0};
		int[] nums7={3,6,2,1,4,4,6,0};
		assertTrue(tester.hasCycle(nums1));
		assertTrue(!tester.hasCycle(nums2));
		assertTrue(!tester.hasCycle(nums3));
		assertTrue(!tester.hasCycle(nums4));
		assertTrue(!tester.hasCycle(nums5));
		assertTrue(tester.hasCycle(nums6));
		assertTrue(!tester.hasCycle(nums7));
	}

}
