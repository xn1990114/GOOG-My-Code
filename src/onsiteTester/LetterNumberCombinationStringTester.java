package onsiteTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import onsite.LetterNumberCombinationString;

public class LetterNumberCombinationStringTester {

	@Test
	public void test() {
		LetterNumberCombinationString tester=new LetterNumberCombinationString();
		List<String> res=tester.getCombination("aa{1,2}bc{3,4}de");
		for(String s:res){
			System.out.println(s);
		}
	}

}
