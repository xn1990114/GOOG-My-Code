package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.CardMaxScore;
import onsite.MaxScoreFromCardDraw;

public class CardMaxScoreTester {

	@Test
	public void test() {
		CardMaxScore tester=new CardMaxScore();
		int[] cards={5,2,4,7,2,5};
		assertTrue(tester.findMaxScore(cards)==12);
	}
	@Test
	public void test1() {
		CardMaxScore tester=new CardMaxScore();
		int[] cards={-10,-10,-10,-10,-10,1000};
		assertTrue(tester.findMaxScore(cards)==960);
	}
	@Test
	public void test2() {
		CardMaxScore tester=new CardMaxScore();
		int[] cards={-10,-10,-10,-10,1000};
		assertTrue(tester.findMaxScore(cards)==970);
	}
	@Test
	public void test3() {
		CardMaxScore tester=new CardMaxScore();
		int[] cards={-10,-10,-10,1000};
		assertTrue(tester.findMaxScore(cards)==-10);
	}
	@Test
	public void test4() {
		CardMaxScore tester=new CardMaxScore();
		int[] cards={800,400,500,1000};
		assertTrue(tester.findMaxScore(cards)==1700);
	}
}
