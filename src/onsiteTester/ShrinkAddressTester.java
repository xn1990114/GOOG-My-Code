package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.ShrinkAddress;

public class ShrinkAddressTester {

	@Test
	public void test() {
		ShrinkAddress sa=new ShrinkAddress();
		String s1="501 E Centerton Blvd";
		int n1=5;
		String s2="abcde123dhs1";
		int n2=5;
		assertTrue(sa.Solution(s1, n1).equals("501 E"));
		assertTrue(sa.Solution(s2, n2).equals("a1231"));
		assertTrue(sa.Solution(s2, 50).equals("abcde123dhs1"));
	}

}
