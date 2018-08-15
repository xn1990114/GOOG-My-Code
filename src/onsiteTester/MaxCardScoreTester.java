package onsiteTester;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;

import onsite.MaxCardScore;

public class MaxCardScoreTester {

	@Test
	public void test() {
		MaxCardScore tester=new MaxCardScore();
		char[][] board={{'a','b','a','x','c'},{},{},{},{}};
		char[] cards={'a','a','i','o','p','l','e','n','n','u','k'};
		Set<String> dic=new HashSet<String>();
		dic.add("xiao");//11
		dic.add("apple");//17
		dic.add("aplhabetic");//0
		dic.add("banana");//16
		dic.add("junk");//56
		int[] scores={1,3,4,2,4,2,5,1,2,43,2,2,21,5,1,5,1,6,7,2,6,7,2,7,2,5};
		assertTrue(tester.maxScore(board, dic, cards, scores)==11);
	}
	@Test
	public void test2() {
		MaxCardScore tester=new MaxCardScore();
		char[][] board={{'a','b','a','x','c'},{},{},{},{},{},{}};
		char[] cards={'a','a','i','o','p','l','e','n','n','u','k','b','a'};
		Set<String> dic=new HashSet<String>();
		dic.add("xiao");//11
		dic.add("apple");//17
		dic.add("aplhabetic");//0
		dic.add("banana");//16
		dic.add("junk");//56
		int[] scores={1,3,4,2,4,2,5,1,2,43,2,2,21,5,1,5,1,6,7,2,6,7,2,7,2,5};
		assertTrue(tester.maxScore(board, dic, cards, scores)==16);
	}
	@Test
	public void test3() {
		MaxCardScore tester=new MaxCardScore();
		char[][] board={{'a','b','a','x','c','j'},{},{},{},{},{},{}};
		char[] cards={'a','a','i','o','p','l','e','n','n','u','k','p','a'};
		Set<String> dic=new HashSet<String>();
		dic.add("xiao");//11
		dic.add("apple");//17
		dic.add("aplhabetic");//0
		dic.add("banana");//16
		dic.add("junk");//56
		int[] scores={1,3,4,2,4,2,5,1,2,43,2,2,21,5,1,5,1,6,7,2,6,7,2,7,2,5};
		assertTrue(tester.maxScore(board, dic, cards, scores)==56);
	}
	@Test
	public void test4() {
		MaxCardScore tester=new MaxCardScore();
		char[][] board={{'a','b','a','x','c','j'},{},{},{},{},{},{}};
		char[] cards={'a','a','i','o','p','l','e','n','n','u','k','p','a'};
		Set<String> dic=new HashSet<String>();
		dic.add("xiao");//11
		dic.add("apple");//17
		dic.add("aplhabetic");//0
		dic.add("banana");//16
		dic.add("j");//56
		int[] scores={1,3,4,2,4,2,5,1,2,43,2,2,21,5,1,5,1,6,7,2,6,7,2,7,2,5};
		assertTrue(tester.maxScore(board, dic, cards, scores)==43);
	}
}
