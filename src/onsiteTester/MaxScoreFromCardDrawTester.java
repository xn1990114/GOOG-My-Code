package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MaxScoreFromCardDraw;

public class MaxScoreFromCardDrawTester {

	@Test
	public void test1() {
		MaxScoreFromCardDraw tester=new MaxScoreFromCardDraw();
		int[] cards={1000,-10,-10,-10,-10,-10};
		assertTrue(tester.findMaxScore(cards)==960);
	}
	@Test
	public void test2() {
		MaxScoreFromCardDraw tester=new MaxScoreFromCardDraw();
		int[] cards={1000,-10,-10,-10,-10};
		assertTrue(tester.findMaxScore(cards)==970);
	}
	@Test
	public void test3() {
		MaxScoreFromCardDraw tester=new MaxScoreFromCardDraw();
		int[] cards={1000,-10,-10,-10};
		assertTrue(tester.findMaxScore(cards)==-10);
	}
	@Test
	public void test4() {
		MaxScoreFromCardDraw tester=new MaxScoreFromCardDraw();
		int[] cards={1000,500,400,800};
		assertTrue(tester.findMaxScore(cards)==1700);
	}

}
