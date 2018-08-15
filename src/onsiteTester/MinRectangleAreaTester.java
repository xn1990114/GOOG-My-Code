package onsiteTester;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import onsite.MinRectangleArea;

public class MinRectangleAreaTester {
	/*   -5 -4 -3 -2 -1 0 1 2 3 4 5 6 7 8 9 10
	 * 5  *                 *   *     *
	 * 4                          * *
	 * 3           *        *      
	 * 2                          *   *
	 * 1                          *
	 * 0  *     *  *        * 4
	 *-1                *               *
	 *-2
	 *-3					    4
	 *-4  *  *            *
	 *-5			  *
	 *   -5 -4 -3 -2 -1 0 1 2 3 4 5 6 7 8 9 10
	 */
		@Test
		public void test() {
			MinRectangleArea tester=new MinRectangleArea();
			int[][] points1={/*{3,-2},*/{5,-5},{0,-5},
							{0,-3},{0,-2},{-1,0},
							{1,5},{0,2},{5,4},
							{-5,-1},{4,6},{3,2},
							{4,5},{2,5},{-4,-4},
							{-1,8},{5,7},{5,4},
							{0,-2},{5,2},{2,7},
							{-5,-1},{-4,1},{-4,-5}};
			int[] e1={0,-5,5,2};
			assertTrue(tester.minAreaWithOnlyHorizonalRectangle(points1)==35);
			System.out.println(tester.minAreaAllRectangle(points1));
			int[][] points2={{3,-2},{5,-5},{0,-5},
					{0,-3},{0,-2},{-1,0},
					{1,5},{0,2},{5,4},
					{-5,-1},{4,6},{3,2},
					{4,5},{2,5},{-4,-4},
					{-1,8},{5,7},{5,4},
					{0,-2},{5,2},{2,7},
					{-5,-1},{-4,1},{-4,-5}};
			int[] e2={0,-2,3,2};
			assertTrue(tester.minAreaWithOnlyHorizonalRectangle(points2)==12);
			System.out.println(tester.minAreaAllRectangle(points2));
			int[][] points3={//{3,-2},{5,-5},{0,-5},
					{0,-3},{0,-2},{-1,0},
					{1,5},{0,2},{5,4},
					{-5,-1},{4,6},{3,2},
					{4,5},{2,5},{-4,-4},
					{-1,8},{5,7},{5,4},
					{0,-2},{5,2},{2,7},
					{-5,-1},{-4,1},{-4,-5}};
			assertTrue(tester.minAreaWithOnlyHorizonalRectangle(points3)==-1);
			System.out.println(tester.minAreaAllRectangle(points3));
			int[][] points4={//{3,-2},{5,-5},{0,-5},
					{0,-3},{0,-2},{-1,0},
					{1,5},{0,2},{5,4},
					{-5,-1},{4,6},{3,2},
					{4,5},{2,5},{-4,-4},
					{-1,8},{5,7},{5,4},
					{0,-2},{5,2},{2,7},
					{-5,-1},{-4,1},{-4,-5},{0,3},{-3,4}};
			assertTrue(tester.minAreaWithOnlyHorizonalRectangle(points4)==-1);
			System.out.println(tester.minAreaAllRectangle(points4));
		}
}
