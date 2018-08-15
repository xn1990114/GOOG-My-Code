package onsiteTester;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import onsite.NonInclusiveSubString;

public class NonInclusiveSubStringTester {

	@Test
	public void test1() {
		NonInclusiveSubString tester=new NonInclusiveSubString();
		String s="abcbbbdad";
		Set<Character> dic=new HashSet<Character>();
		dic.add('a');dic.add('b');dic.add('c');
		String[] target={"a","ab","b","bc","bcb","bcbb","bcbbb","bcbbbd","c","cb","cbb","cbbb","cbbbd",
				"b","bb","bbb","bbbd","bbbda","bbbdad","b","bb","bbd","bbda","bbdad",
				"b","bd","bda","bdad","d","da","dad","a","ad","d"};
		tester.checkResult(tester.getValidSubstring(s, dic), target);
	}
	@Test
	public void test2() {
		NonInclusiveSubString tester=new NonInclusiveSubString();
		String s="a";
		Set<Character> dic=new HashSet<Character>();
		dic.add('a');dic.add('b');dic.add('c');
		String[] target={};
		tester.checkResult(tester.getValidSubstring(s, dic), target);
	}
	@Test
	public void test3() {
		NonInclusiveSubString tester=new NonInclusiveSubString();
		String s="";
		Set<Character> dic=new HashSet<Character>();
		dic.add('a');dic.add('b');dic.add('c');
		String[] target={};
		tester.checkResult(tester.getValidSubstring(s, dic), target);
	}
	@Test
	public void test4() {
		NonInclusiveSubString tester=new NonInclusiveSubString();
		String s="de";
		Set<Character> dic=new HashSet<Character>();
		dic.add('a');dic.add('b');dic.add('c');
		String[] target={"d","de","e"};
		tester.checkResult(tester.getValidSubstring(s, dic), target);
	}
}
