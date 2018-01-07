package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MedianIn2DArray;

public class MedianIn2DArrayTester {

	@Test
	public void test() {
		MedianIn2DArray tester=new MedianIn2DArray();
		int[][] nums1={{1,2,3,4,5},
					   {1,2,3,4,5},
					   {1,2,3,4,5},
					   {1,2,3,4,5}};
		assertTrue(Math.abs(tester.findMedian(nums1)-3)<0.01);
		int[][] nums2={{1,2,3,4,7},
				   	   {5,6,7,7,7},
				       {1,1,1,1,7},
				       {1,2,3,4,7}};
		assertTrue(Math.abs(tester.findMedian(nums2)-3.5)<0.01);
		int[][] nums3={{1,22,35,41,50},
		   	   	       {1,16,17,17,47},
		               {1, 2, 3, 4, 7},
		               {1, 2, 3, 4, 8,15,30,70}};
		assertTrue(Math.abs(tester.findMedian(nums3)-8)<0.01);
		int[][] nums4={{1,22,35,41,50},
	   	   	           {1,16,17,17,47},
	                   {1, 2, 3, 4, 7},
	                   {1, 2, 3, 4, 8,15,30,70},
	                   {},
	                   {100,101},
	                   {-5,7,20}};
		assertTrue(Math.abs(tester.findMedian(nums4)-11.5)<0.01);
		int[][] nums5={{1,22,35,41,50},
	   	               {1,16,17,17,47},
	   	               {1, 2, 3, 4, 7},
	   	               {1, 2, 3, 4, 8,15,30,70},
	   	               {0, 2, 3,15,16,17,20},
	   	               {100,101},
	   	               {-5,7,20}};
		assertTrue(Math.abs(tester.findMedian(nums5)-15)<0.01);
		int[][] nums6={{1,22,35,41,50},
	                   {1,16,17,17,47},
	                   {1, 2, 3, 4, 7},
	                   {1, 2, 3, 4, 8,15,30,70,100},
	                   {0, 2, 3,15,16,17,20},
	                   {100,101},
	                   {-5,7,20}};
		assertTrue(Math.abs(tester.findMedian(nums6)-15)<0.01);
		int[][] nums7={{1,22,35,41,50},
                      {1,16,17,17,47},
                      {1, 2, 3, 4, 7},
                      {1, 2, 3, 4, 8,15,30,70,100,100,100},
                      {0, 2, 3,15,16,17,20},
                      {100,101},
                      {-5,7,20}};
		assertTrue(Math.abs(tester.findMedian(nums7)-15.5)<0.01);
		int[][] nums8={{1,22,35,41,50},
                {1,16,17,17,47},
                {1, 2, 3, 4, 7},
                {1, 2, 3, 4, 8,15,30,70,100,100,100,100},
                {0, 2, 3,15,16,17,20},
                {100,101},
                {-5,7,20}};
		assertTrue(Math.abs(tester.findMedian(nums8)-16)<0.01);
	}

}
