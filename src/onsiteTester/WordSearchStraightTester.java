package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.WordSearchStraight;

public class WordSearchStraightTester {

	@Test
	public void test() {
		WordSearchStraight tester=new WordSearchStraight();
		char[][] matrix={{'a','m','s','e','t'},
						 {'b','o','t','w','o'},
						 {'y','v','h','p','l'},
						 {'s','e','a','x','b'},
						 {'s','i','r','e','q'},
						 {'h','j','s','f','r'}};
		assertTrue(tester.searchWord("move", matrix));
		assertTrue(tester.searchWord("whes", matrix));
		assertTrue(!tester.searchWord("mtwb", matrix));
		assertTrue(tester.searchWord("eav", matrix));
	}

}
