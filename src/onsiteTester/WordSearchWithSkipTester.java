package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.WordSearchWithSkip;

public class WordSearchWithSkipTester {
/*
 * e.g1., given "GCB", return "GLCB"
e.g2., given "ABO", return "ABGO" or "ABLO" or "ABEO"
e.g3., given "LBC", return "LBC"
e.g4., given "LBF", return empty string
 */
	@Test
	public void test1() {
		WordSearchWithSkip tester=new WordSearchWithSkip();
		char[][] board={{'G', 'O', 'O'},
						{'G', 'L', 'E'},
						{'A', 'B', 'C'}};
		assertTrue(tester.findShortestPath(board, "GCB").equals("GLCB"));
		assertTrue(tester.findShortestPath(board, "ABO").equals("ABLO"));
		assertTrue(tester.findShortestPath(board, "LBC").equals("LBC"));
		assertTrue(tester.findShortestPath(board, "LBF")==null);
	}
	@Test
	public void test2() {
		WordSearchWithSkip tester=new WordSearchWithSkip();
		char[][] board={{'G', 'O', 'O'},
						{'G', 'L', 'E'},
						{'A', 'B', 'C'}};
		String[] words={"GCB","ABO","LBC","LBF"};
		//String[] res={"GLCB","ABLO","LBC",null};
		String[] r=tester.findShortestPathOfMultipleWord(board, words);
		for(int i=0;i<r.length;i++){
			System.out.println(r[i]);
		}
		
	}
}
