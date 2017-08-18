package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SameMeaning;

public class SameMeaningTester {

	@Test
	public void test() {
		SameMeaning sm = new SameMeaning();
		String[][] dic = { { "Trump", "Amaz" }, 
				{ "is", "" }, { "lot", "much" }, 
				{ "Trump", "Krip" }, { "talk","speak" }, 
				{"speak","talk"} };
		String s1="Krip, does speak lot";
		String s2="Amaz, does speak  much";
		String s3="Trump, does speak few";
		String s4="Amaz, does speak few";
		assertTrue(sm.Solution(s1, s2, dic));
		assertTrue(!sm.Solution(s3, s2, dic));
		assertTrue(!sm.Solution(s1, s3, dic));
		assertTrue(!sm.Solution(s1, s4, dic));
	}

}
