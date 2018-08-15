package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.IPAddressBlackList;
import onsite.IPAddressBlackList.TrieNode;

public class IPAddressBlackListTester {

	@Test
	public void test1() {
		String[] bl={"123.123.123.123","123.321.1*"};
		IPAddressBlackList tester=new IPAddressBlackList();
		TrieNode root=tester.initDic(bl);
		assertTrue(tester.searchWithEndAsterisk(root, "123.321.1.1"));
		assertTrue(!tester.searchWithEndAsterisk(root, "123.321.2.1"));
		assertTrue(tester.searchWithEndAsterisk(root, "123.123.123.123"));
		assertTrue(tester.searchWithEndAsterisk(root, "123.321.123.123"));
	}
	@Test
	public void test2() {
		String[] bl={"123.123.123.123","123.321.1*","123*32.123"};
		IPAddressBlackList tester=new IPAddressBlackList();
		TrieNode root=tester.initDic(bl);
		assertTrue(tester.searchWithMiddleAsterisk(root, "123.123.123.123", 0));
		assertTrue(tester.searchWithMiddleAsterisk(root, "123.321.12.1", 0));
		assertTrue(tester.searchWithMiddleAsterisk(root, "123.123.32.123", 0));
		assertTrue(tester.searchWithMiddleAsterisk(root, "123.123.132.123", 0));
		assertTrue(tester.searchWithMiddleAsterisk(root, "123.3.132.123", 0));
	}
}
