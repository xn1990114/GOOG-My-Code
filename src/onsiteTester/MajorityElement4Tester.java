package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MajorityElement4;

public class MajorityElement4Tester {

	@Test
	public void test() {
		MajorityElement4 tester=new MajorityElement4();
		int[] nums1={1,1,1,6,7,8,9,9};
		assertTrue(tester.findMajority(nums1)==1);
		int[] nums2={1,2,3,6,7,8,9,9};
		assertTrue(tester.findMajority(nums2)==9);
		int[] nums3={1,2,3,3,6,7,8,9,10};
		assertTrue(tester.findMajority(nums3)==0);
		int[] nums4={1,3,3,3,6,7,8,9,10};
		assertTrue(tester.findMajority(nums4)==3);
		int[] nums5={1,2,3,3,3,6,8,9,10};
		assertTrue(tester.findMajority(nums5)==3);
		int[] nums6={1,2,2,3,3,3,8,9,10};
		assertTrue(tester.findMajority(nums6)==3);
		int[] nums7={1,1,2,2,3,3,3,9,10};
		assertTrue(tester.findMajority(nums7)==3);
		int[] nums8={-1,1,1,2,2,3,3,3,10};
		assertTrue(tester.findMajority(nums8)==3);
		int[] nums9={-1,-1,1,1,2,2,3,3,3};
		assertTrue(tester.findMajority(nums9)==3);
		int[] nums10={-3,-2,-1,1,2,2,3,3};
		assertTrue(tester.findMajority(nums10)==2);
		int[] nums11={-4,-3,-2,-1,1,2,3,3};
		assertTrue(tester.findMajority(nums11)==3);
	}
}
