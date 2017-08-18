package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.StringSubSequence;

public class StringSubSequenceTester {

	@Test
	public void test() {
		StringSubSequence sss=new StringSubSequence();
		String s1="abcdefghijklmnopqrstuvwxyz";
		String s2="";
		String[] array={"a","afxz","acxz","","abcdfega","afz"};
		assertTrue(sss.findLogestSubSequence(s1, array).equals("afxz"));
		assertTrue(sss.findLogestSubSequence(s2, array).equals(""));
	}

}
