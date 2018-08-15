package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.DoubleIntervalMap;

public class DoubleIntervalMapTester {

	@Test
	public void test() {
		DoubleIntervalMap tester=new DoubleIntervalMap(1.3);
		tester.put(0, "i'm 0");
		tester.put(2.4, "i'm 2.4");
		assertTrue(tester.get(1.2).equals("i'm 0"));
		assertTrue(tester.get(3.699999999).equals("i'm 2.4"));
		assertTrue(tester.get(3.7)==null);
		tester.put(4.999, "i'm 4.999");
		assertTrue(tester.get(3.7).equals("i'm 4.999"));
		tester.put(-5, "i'm -5");
		assertTrue(tester.get(-3.7).equals("i'm -5"));
		assertTrue(tester.get(-6.3).equals("i'm -5"));
	}

}
