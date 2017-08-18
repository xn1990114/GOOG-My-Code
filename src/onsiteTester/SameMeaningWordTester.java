package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SameMeaningWord;

public class SameMeaningWordTester {

	@Test
	public void test() {
		String[][] dic = { { "Nan", "Allen" }, { "Eric", "Allen" }, 
				{ "Yang", "Tingting" }, { "Yao", "Yueyao" },
				{ "Yao", "Weimin" },{"Chen","Weimin"},{"Yu","Kaixi"},
				{"Tingting","Yao"},{"Kaixi","Weimin"},
				{"Weimin","Yang"}};
		SameMeaningWord smw = new SameMeaningWord();
		assertTrue(smw.Solution(dic, "Nan", "Eric"));
		assertFalse(smw.Solution(dic, "Nan", "Tingting"));
		assertTrue(smw.Solution(dic, "Yueyao", "Tingting"));
		assertFalse(smw.Solution(dic, "Nan", ""));
		assertTrue(smw.Solution(dic, "Weimin", "Yang"));
	}

}
