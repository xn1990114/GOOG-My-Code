package onsiteTester;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import onsite.FillWordBoard;

public class FillWordBoardTester {

	@Test
	public void test1() {
		FillWordBoard tester=new FillWordBoard();
		String[] dic={"apple","peope","everyI","abcde"};
		tester.dic=dic;
		String[] hints={"a","peope","ev"};
		int[] lenOfWords={5,5,6};
		int[][] missingWordLocation={{0,0,1,5},{1,0,0,5},{1,4,1,6}};
		char[][] board={{'_',' ',' ',' ',' '},  
					    {'_','_','_','_','_'},
					    {'_',' ',' ',' ','_'},
				        {'_',' ',' ',' ','_'},
				        {'_',' ',' ',' ','_'},
				        {' ',' ',' ',' ','_'},
				        {' ',' ',' ',' ','_'}};
		assertTrue(tester.isSolvable(board, missingWordLocation, hints, lenOfWords));
		tester.printBoard(board);
	}
	@Test
	public void test2() {
		FillWordBoard tester=new FillWordBoard();
		String[] dic={"apple","peope","everyI","abcde","chev"};
		tester.dic=dic;
		String[] hints={"a","peope","ev","c"};
		int[] lenOfWords={5,5,6,4};
		int[][] missingWordLocation={{0,0,1,5},{1,0,0,5},{1,4,1,6},{2,1,0,4}};
		char[][] board={{'_',' ',' ',' ',' '},  
					    {'_','_','_','_','_'},
					    {'_','_','_','_','_'},
				        {'_',' ',' ',' ','_'},
				        {'_',' ',' ',' ','_'},
				        {' ',' ',' ',' ','_'},
				        {' ',' ',' ',' ','_'}};
		assertTrue(tester.isSolvable(board, missingWordLocation, hints, lenOfWords));
		tester.printBoard(board);
	}

}
