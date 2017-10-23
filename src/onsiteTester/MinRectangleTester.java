package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MinRectangle;
/*   -5 -4 -3 -2 -1 0 1 2 3 4 5 6 7 8 9 10
 * 5  *                 *   *     *
 * 4                          * *
 * 3           *        *
 * 2                          *   *
 * 1                          *
 * 0  *     *  *        *
 *-1                *               *
 *-2
 *-3
 *-4  *  *             *
 *-5			  *
 *   -5 -4 -3 -2 -1 0 1 2 3 4 5 6 7 8 9 10
 */
public class MinRectangleTester {

	@Test
	public void test() {
		MinRectangle tester=new MinRectangle();
		int[][] points1={/*{3,-2},*/{5,-5},{0,-5},
						{0,-3},{0,-2},{-1,0},
						{1,5},{0,2},{5,4},
						{-5,-1},{4,6},{3,2},
						{4,5},{2,5},{-4,-4},
						{-1,8},{5,7},{5,4},
						{0,-2},{5,2},{2,7},
						{-5,-1},{-4,1},{-4,-5}};
		int[] r1=tester.findCoordinate(points1);
		int[] e1={0,-5,5,2};
		for(int i=0;i<4;i++){
			assertTrue(r1[i]==e1[i]);
		}
		int[][] points2={{3,-2},{5,-5},{0,-5},
				{0,-3},{0,-2},{-1,0},
				{1,5},{0,2},{5,4},
				{-5,-1},{4,6},{3,2},
				{4,5},{2,5},{-4,-4},
				{-1,8},{5,7},{5,4},
				{0,-2},{5,2},{2,7},
				{-5,-1},{-4,1},{-4,-5}};
		int[] r2=tester.findCoordinate(points2);
		int[] e2={0,-2,3,2};
		for(int i=0;i<4;i++){
			assertTrue(r2[i]==e2[i]);
		}
		int[][] points3={//{3,-2},{5,-5},{0,-5},
				{0,-3},{0,-2},{-1,0},
				{1,5},{0,2},{5,4},
				{-5,-1},{4,6},{3,2},
				{4,5},{2,5},{-4,-4},
				{-1,8},{5,7},{5,4},
				{0,-2},{5,2},{2,7},
				{-5,-1},{-4,1},{-4,-5}};
		int[] r3=tester.findCoordinate(points3);
		for(int i=0;i<4;i++){
			assertTrue(r3.length==0);
		}
	}

}
