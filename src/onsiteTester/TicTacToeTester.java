package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.TicTacToe;

public class TicTacToeTester {

	@Test
	public void test1() {
		TicTacToe board=new TicTacToe(4);
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(board.insertNewPiece(1));
	}
	@Test
	public void test2() {
		TicTacToe board=new TicTacToe(4);
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(board.insertNewPiece(1));
		
		board.displayMatrix();
		System.out.println();
	}
	@Test
	public void test3() {
		TicTacToe board=new TicTacToe(4);
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(board.insertNewPiece(0));
		board.displayMatrix();
		System.out.println();
	}
	@Test
	public void test4() {
		TicTacToe board=new TicTacToe(4);
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(1));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(!board.insertNewPiece(0));
		assertTrue(board.insertNewPiece(1));
		board.displayMatrix();
	}
}
