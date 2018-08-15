package onsiteTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import onsite.ShrinkRepeatingPatternInString;

public class ShrinkRepeatingPatternInStringTester {

	@Test
	public void test() {
		ShrinkRepeatingPatternInString tester=new ShrinkRepeatingPatternInString();
		List<String> r1=tester.encode("abcabeabfabc");
		List<String> r2=tester.encodeOptimized("abcabeabfabc");
		for(String s:r1){
			System.out.println(s+"->");
		}
		System.out.println();
		for(String s:r2){
			System.out.println(s+"->");
		}
		assertTrue(tester.decode(r1).equals("abcabeabfabc"));
		assertTrue(tester.decode(r2).equals("abcabeabfabc"));
	}

}
