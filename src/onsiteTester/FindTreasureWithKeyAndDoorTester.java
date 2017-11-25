package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.FindTreasureWithKeyAndDoor;

public class FindTreasureWithKeyAndDoorTester {

	@Test
	public void test() {
		FindTreasureWithKeyAndDoor tester=new FindTreasureWithKeyAndDoor();
		int[][] nums1={{0,-2,1,0,0},
					   {0,1,-3,0,0},
					   {0, 2,0,0,0},
					   {3, 1,0,0,0},
					   {-1,0,0,0,0}};
		assertTrue(tester.findTreasure(nums1, new int[]{0,0}));
		int[][] nums2={{ 0,-2, 1, 0, 0},
				   	   { 0, 1,-3, 0, 0},
				       { 0, 2, 1, 1, 0},
				       { 3, 0, 0, 0, 1},
				       {-1, 1, 0, 0, 0}};
		assertTrue(!tester.findTreasure(nums2, new int[]{0,0}));
		int[][] nums3={{ 0,-2, 1, 0, 0},
			   	       { 0, 1,-3, 0, 0},
			   	       { 0, 2, 1, 3, 0},
			   	       { 3, 0, 0, 0, 2},
			   	       {-1, 1, 0, 0, 0}};
		assertTrue(tester.findTreasure(nums3, new int[]{0,0}));
		int[][] nums4={{ 0,-2, 1, 0, 0},
		   	       	   { 0, 1,-3, 4, 4},
		   	       	   { 0, 2, 1, 3, 0},
		   	       	   { 3, 0, 0, 0, 2},
		   	       	   {-1, 1, 0, 0, 0}};
		assertTrue(!tester.findTreasure(nums4, new int[]{0,4}));
		int[][] nums5={{ 0,-2, 0, 0, 0},
	   	       	       { 0, 1,-3, 4, 4},
	   	       	       { 0, 4, 1, 3, 0},
	   	       	       {-3, 0, 0, 0, 2},
	   	       	       {-1, 1, 0, 0, 0}};
		assertTrue(tester.findTreasure(nums5, new int[]{0,4}));
		int[][] nums6={{ 0,-2, 0, 4,-4},
	       	       	   { 0, 1,-3, 4, 4},
	       	       	   { 0, 4, 1, 3, 0},
	       	       	   { 4, 0, 0, 0, 2},
	       	       	   {-1, 1, 0, 0, 0}};
		assertTrue(tester.findTreasure(nums6, new int[]{0,4}));
		int[][] nums7={{ 0,-2, 0, 4,-4},
    	       	       { 0, 1,-3, 4, 4},
    	       	       { 0, 4, 1, 3, 0},
    	       	       { 4, 0, 0, 0, 2},
    	       	       {-1, 1, 0, 0, 0}};
		assertTrue(!tester.findTreasure(nums7, new int[]{0,0}));
		int[][] nums8={{ 0,-2, 0, 4,-4},
	       	           { 0, 1,-3, 4, 0},
	       	           { 0, 0, 1, 3, 0},
	       	           { 4, 0, 0, 0, 2},
	       	           {-1, 1, 0, 0, 0}};
		assertTrue(tester.findTreasure(nums8, new int[]{0,0}));
	
	}

}
