package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.SplitArrayToSort;

public class SplitArrayToSortTester {

	@Test
	public void test() {
		SplitArrayToSort tester = new SplitArrayToSort();
		int[] nums1 = { 3, 1, 2, 5, 4 };
		int[] nums2 = { 2, 4, 3, 1 };
		int[] nums3 = { 1 };
		assertTrue(tester.findCutPoint(nums1)==2);
		assertTrue(tester.findCutPoint(nums2)==3);
		assertTrue(tester.findCutPoint(nums3)==0);
	}

}
