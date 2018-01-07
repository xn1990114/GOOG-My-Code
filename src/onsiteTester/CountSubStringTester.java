package onsiteTester;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import onsite.CountSubString;

public class CountSubStringTester {
	static CountSubString tester;
	static int completed;
	static int passed;
	@BeforeClass
	public static void prepare(){
		tester=new CountSubString();
		completed=0;
		passed=0;
	}
	@Test
	public void test1() {
		completed++;
		String s1="aab";
		String sub1="ab";
		assertTrue(tester.countSubstring(s1, sub1)==2);
		passed++;
	}
	@Test
	public void test2() {
		completed++;
		String s2="aabbab";
		String sub2="ab";
		assertTrue(tester.countSubstring(s2, sub2)==7);
		passed++;
	}
	@Test
	public void test3() {
		completed++;
		String s3="aabbab";
		String sub3="abc";
		assertTrue(tester.countSubstring(s3, sub3)==0);
		passed++;
	}
	@Test
	public void test4() {
		completed++;
		String s4="aabbabcabcba";
		String sub4="abc";
		assertTrue(tester.countSubstring(s4, sub4)==18);
		passed++;
	}
	@AfterClass
	public static void cleanUp(){
		System.out.println(passed+" of "+ completed +" test cases are passed");
	}
}
