package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MinDistanceJumpDown;

public class MinDistanceJumpDowTester {

	@Test
	public void test1() {
		/*	5	  s
		 * 	4	 _____
		 *  3   
		 *  2 ______
		 *  1   
		 *  0 1 2 3 4 5 6
		 */
		MinDistanceJumpDown tester=new MinDistanceJumpDown();
		int[] start={3,5};
		int[][] bars={{2,5,4},{0,4,2}};
		assertTrue(tester.findMinDis(start, bars)==2);
	}
	
	@Test
	public void test2() {
		/*	5	  s
		 * 	4	   ___
		 *  3   
		 *  2 ____
		 *  1   
		 *  0 1 2 3 4 5 6
		 */
		MinDistanceJumpDown tester=new MinDistanceJumpDown();
		int[] start={3,5};
		int[][] bars={{3,5,4},{0,3,2}};
		assertTrue(tester.findMinDis(start, bars)==0);
	}
	@Test
	public void test3() {
		/*	5	  s
		 * 	4	   ___
		 *  3   
		 *  2 ______
		 *  1   
		 *  0 1 2 3 4 5 6
		 */
		MinDistanceJumpDown tester=new MinDistanceJumpDown();
		int[] start={3,5};
		int[][] bars={{3,5,4},{0,4,2}};
		assertTrue(tester.findMinDis(start, bars)==1);
	}
	@Test
	public void test4() {
		/*	5	  s
		 * 	4	 _____
		 *  3      _________
		 *  2 ______
		 *  1   
		 *  0 1 2 3 4 5 6
		 */
		MinDistanceJumpDown tester=new MinDistanceJumpDown();
		int[] start={3,5};
		int[][] bars={{2,5,4},{0,4,2},{3,10,3}};
		assertTrue(tester.findMinDis(start, bars)==3);
	}
	@Test
	public void test5() {
		/*	5	      s
		 * 	4	   _____
		 *  3      _______________
		 *  2    _____
		 *  1   
		 *  0 1 2 3 4 5 6
		 */
		MinDistanceJumpDown tester=new MinDistanceJumpDown();
		int[] start={5,5};
		int[][] bars={{3,6,4},{2,5,2},{3,10,3}};
		assertTrue(tester.findMinDis(start, bars)==3);
	}
	@Test
	public void test6() {
		/*	5	      s
		 * 	4	   _____
		 *  3      _________
		 *  2    _____
		 *  1 ________________  
		 *  0 1 2 3 4 5 6 7 8 9
		 */
		MinDistanceJumpDown tester=new MinDistanceJumpDown();
		int[] start={5,4};
		int[][] bars={{3,6,4},{2,5,2},{3,8,3},{0,9,1}};
		assertTrue(tester.findMinDis(start, bars)==4);
	}
	@Test
	public void test7() {
		/*	5	      s
		 * 	4	   _____
		 *  3      _________
		 *  2    _____
		 *  1 ____  ______________  
		 *  0 1 2 3 4 5 6 7 8 9 10
		 */
		MinDistanceJumpDown tester=new MinDistanceJumpDown();
		int[] start={5,4};
		int[][] bars={{3,6,4},{2,5,2},{3,8,3},{0,3,1},{3,11,1}};
		assertTrue(tester.findMinDis(start, bars)==4);
	}
	@Test
	public void test8() {
		/*	5	      s
		 * 	4	   ___
		 *  3            ___
		 *  2    _____
		 *  1 ____  
		 *  0 1 2 3 4 5 6 7 8 9 10
		 */
		MinDistanceJumpDown tester=new MinDistanceJumpDown();
		int[] start={5,4};
		int[][] bars={{3,5,4},{2,5,2},{6,8,3},{0,3,1}};
		assertTrue(tester.findMinDis(start, bars)==0);
	}
}
