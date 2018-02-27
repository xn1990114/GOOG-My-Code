package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.DecompressString;

public class DecompressStringTester {

	@Test
	public void test1() {
		DecompressString tester=new DecompressString();
		String s="a(b(c){2}){2}d";
		String r="abccbccd";
		assertTrue(tester.recoverString(s).equals(r));
	}
	@Test
	public void test2() {
		DecompressString tester=new DecompressString();
		String s="(a(b(c){2}){2}d){2}";
		String r="abccbccdabccbccd";
		assertTrue(tester.recoverString(s).equals(r));
	}
	@Test
	public void test3() {
		DecompressString tester=new DecompressString();
		String s="ad";
		String r="ad";
		assertTrue(tester.recoverString(s).equals(r));
	}
	@Test
	public void test4() {
		DecompressString tester=new DecompressString();
		String s="(a(b(c){2}){2}){2}";
		String r="abccbccabccbcc";
		assertTrue(tester.recoverString(s).equals(r));
	}
}
