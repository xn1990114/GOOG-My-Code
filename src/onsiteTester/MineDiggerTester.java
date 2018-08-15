package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MineDigger;

public class MineDiggerTester {

	@Test
	public void test1() {
		MineDigger md=new MineDigger();
		int[][] mine={
			{0,1,0,3,4},
			{2,2,0,7,0},
			{0,4,5,6,2},
			{0,0,0,0,0},
			{0,2,0,0,2},
		};
		assertTrue(md.findMaxGold(mine)==33);
	}
	@Test
	public void test2() {
		MineDigger md=new MineDigger();
		int[][] mine={
			{0,1,0,0,4},
			{2,2,0,7,0},
			{0,4,0,0,2},
			{0,0,0,0,0},
			{0,2,0,0,2},
		};
		assertTrue(md.findMaxGold(mine)==8);
	}
	@Test
	public void test3() {
		MineDigger md=new MineDigger();
		int[][] mine={
			{0,1,0,0,4},
			{2,0,6,7,0},
			{0,0,4,0,2},
			{0,0,0,0,0},
			{0,2,0,0,2},
		};
		assertTrue(md.findMaxGold(mine)==17);
	}
	@Test
	public void test4() {
		MineDigger md=new MineDigger();
		int[][] mine={
					{1,0,0,0,2,4,6,0,0,1},
                    {3,1,4,3,0,0,1,2,0,2},
                    {5,0,0,2,1,0,0,3,0,3},
                    {0,0,0,0,5,6,5,4,1,4},
                    {2,4,6,0,4,0,7,0,2,0},
                    {0,0,1,2,3,0,8,0,3,0},
                    {0,0,2,0,0,0,9,0,4,0},
                    {0,0,3,4,5,0,0,0,0,0},
                    {0,0,0,0,6,5,3,4,9,0},
                    {1,2,3,4,5,0,2,0,0,0}};
		assertTrue(md.findMaxGold(mine)==91);
	}
}
