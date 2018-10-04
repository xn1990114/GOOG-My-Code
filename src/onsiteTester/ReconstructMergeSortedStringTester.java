package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.ReconstructMergeSortedString;

public class ReconstructMergeSortedStringTester {

	@Test
	public void test1() {
		ReconstructMergeSortedString tester=new ReconstructMergeSortedString();
		Set<String> validWords=new HashSet<String>();
		assertTrue(!tester.canReconstruct("cadogt", validWords));
		validWords.add("cat");validWords.add("dog");
		assertTrue(tester.canReconstruct("cadogt", validWords));
	}
	@Test
	public void test2() {
		ReconstructMergeSortedString tester=new ReconstructMergeSortedString();
		Set<String> validWords=new HashSet<String>();
		validWords.add("cag");validWords.add("dot");
		assertTrue(!tester.canReconstruct("cadogt", validWords));
		validWords.add("caog");
		assertTrue(!tester.canReconstruct("cadogt", validWords));
		validWords.add("dt");
		assertTrue(tester.canReconstruct("cadogt", validWords));
	}
}
