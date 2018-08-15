package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.StringSortedSequence;

public class StringSortedSequenceTester {

	@Test
	public void test() {
		StringSortedSequence tester=new StringSortedSequence();
		String order="abcd";
		assertTrue(tester.isCorrectSeq("abwtwbbbcwsd", order));
		assertTrue(!tester.isCorrectSeq("abwtwbbabcwsd", order));
	}

}
