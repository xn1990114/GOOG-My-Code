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

}
