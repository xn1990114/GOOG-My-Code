package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.RussianSquare;

public class RussianSquareTester {

	@Test
	public void test() {
		// 1 is yellow, 2 is green, 3 is red, 0 is empty
		int[][] array={{0,0,0,0,0},
					   {0,0,0,1,0},
					   {0,0,0,1,0},
					   {0,2,0,2,1},
					   {2,2,0,2,1},
					   {2,3,0,3,2},
					   {2,1,0,1,2},
					   {3,1,1,1,2},
					   {3,3,3,3,2}};
		int[][] expectedResult={{0,0,0,0,0},
				       			{0,0,0,0,0},
				       			{0,0,0,0,0},
				       			{0,0,0,0,0},
				       			{0,0,0,0,0},
				       			{0,0,0,0,0},
				       			{0,0,0,0,0},
				       			{0,0,0,3,2},
				       			{2,0,3,3,2}};
		RussianSquare rs=new RussianSquare();
		rs.drop(2, 1, array);
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[0].length;j++){
				assertTrue(array[i][j]==expectedResult[i][j]);
			}
		}
	}

}
