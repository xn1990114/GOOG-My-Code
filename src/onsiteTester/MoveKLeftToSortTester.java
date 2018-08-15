package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MoveKLeftToSort;

public class MoveKLeftToSortTester {

	@Test
	public void test() {
		MoveKLeftToSort tester=new MoveKLeftToSort();
		int[] nums={3,5,7,8,2,1,3,6,4,1};
		int[] res={3,5,2,1,3,6,4,1,7,8};
		tester.sortByMoveLeftK(nums, 2);
		for(int i=0;i<nums.length;i++){
			assertTrue(nums[i]==res[i]);
		}
	}

}
