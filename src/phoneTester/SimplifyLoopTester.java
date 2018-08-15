package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.SimplifyLoop;

public class SimplifyLoopTester {

	@Test
	public void test() {
		SimplifyLoop tester=new SimplifyLoop();
		int[][] nums1={{ 0, 1, 2, 3, 4},
					  { 5, 6, 7, 8, 9},
					  {10,11,12,13,14}};
		assertTrue(tester.isCorrectResult(tester.print2DPerfectArray(nums1)));
		assertTrue(tester.isCorrectResult(tester.print2DInPerfectArray(nums1)));
		
		int[][] nums2={{ 0, 1, 2,},
				  	   { 3, 4, 5, 6, 7, 8, 9},
				  	   {10,11},
				  	   {},
				  	   null,
				  	   {12,13,14},
				  	   {15},
				  	   null,
				  	   {16,17,18,19,20},
				  	   {}};
		assertTrue(tester.isCorrectResult(tester.print2DInPerfectArray(nums2)));
		int[][] nums3={{ 0, 1, 2,},
			  	   	   { 3, 4, 5, 6, 7, 8, 9},
			  	   	   {10,11},
			  	   	   {},
			  	   	   null,
			  	   	   {12,13,14},
			  	   	   {15},
			  	   	   null,
			  	   	   {16,17,18,19,20},
			  	   	   null};
		assertTrue(tester.isCorrectResult(tester.print2DInPerfectArray(nums3)));
	}

}
