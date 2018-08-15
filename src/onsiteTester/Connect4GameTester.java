package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.Connect4Game;

public class Connect4GameTester {
/*
 *    1,0,0,0,0,0
 * 	  1,2,2,2,2,2
 *    0,2,2,2,2,2
 *    1,  
 *    0,
 * 
 * 
 * 
 * 
 */
	@Test
	public void test1() {
		Connect4Game tester=new Connect4Game(6,3);
		assertTrue(tester.placePiece(0, 0, 1)==0);
		assertTrue(tester.placePiece(0, 0, 2)==0);
		assertTrue(tester.placePiece(0, 3, 2)==0);
		assertTrue(tester.placePiece(0, 1, 1)==0);
		assertTrue(tester.placePiece(0, 2, 2)==0);
		assertTrue(tester.placePiece(0, 2, 1)==0);
		assertTrue(tester.placePiece(0, 4, 2)==2);
	}

	@Test
	public void test2() {
		Connect4Game tester=new Connect4Game(5,3);
		assertTrue(tester.placePiece(0, 0, 1)==0);
		assertTrue(tester.placePiece(0, 3, 2)==0);
		assertTrue(tester.placePiece(1, 0, 1)==0);
		assertTrue(tester.placePiece(0, 2, 2)==0);
		assertTrue(tester.placePiece(3, 0, 1)==0);
		assertTrue(tester.placePiece(1, 2, 2)==0);
		assertTrue(tester.placePiece(2, 0, 1)==1);
	}
	/*
	 *    1,0,0,0,0,0
	 * 	  1,0,0,0,0,0
	 *    0,0,2,2,0,0
	 *    1,  
	 *    0,
	 * 
	 */
	@Test
	public void test3() {
		Connect4Game tester=new Connect4Game(5,3);
		assertTrue(tester.placePiece(0, 0, 1)==0);
		assertTrue(tester.placePiece(2, 3, 2)==0);
		assertTrue(tester.placePiece(1, 0, 1)==0);
		assertTrue(tester.placePiece(2, 2, 2)==0);
		assertTrue(tester.placePiece(3, 0, 1)==0);
		assertTrue(tester.placePiece(2, 0, 2)==0);
		assertTrue(tester.placePiece(2, 0, 1)==0);
		assertTrue(tester.placePiece(4, 0, 1)==0);
		assertTrue(tester.placePiece(2, 1, 2)==2);
	}
}
