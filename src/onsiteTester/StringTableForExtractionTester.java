package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.StringTableForExtraction;

public class StringTableForExtractionTester {

	@Test
	public void test1() {
		StringTableForExtraction tester=new StringTableForExtraction();
		String[] strs={"foobar", "bar", "foo"};
		System.out.println(tester.createStringTable(strs));
	}
	@Test
	public void test2() {
		StringTableForExtraction tester=new StringTableForExtraction();
		String[] strs={};
		System.out.println(tester.createStringTable(strs));
	}
	@Test
	public void test3() {
		StringTableForExtraction tester=new StringTableForExtraction();
		String[] strs={"nan", "nana", "nang","ana","banana","ananb"};
		System.out.println(tester.createStringTable(strs));
	}

}
