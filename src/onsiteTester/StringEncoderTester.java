package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.StringEncoder;

public class StringEncoderTester {

	@Test
	public void test() {
		StringEncoder tester=new StringEncoder();
		assertTrue(tester.encode("abcd").equals("abcd"));
		assertTrue(tester.decode("abcd").equals("abcd"));
		
		assertTrue(tester.encode("aaaa3bbbbb3XXXXcd").equals("4Xa35Xb34XXcd"));
		assertTrue(tester.decode("4Xa35Xb34XXcd").equals("aaaa3bbbbb3XXXXcd"));
		
		assertTrue(tester.encode("aaaa3bbbbb3Xcd").equals("4Xa35Xb31XXcd"));
		assertTrue(tester.decode("4Xa35Xb31XXcd").equals("aaaa3bbbbb3Xcd"));
		
		assertTrue(tester.encode("abXd").equals("ab1XXd"));
		assertTrue(tester.decode("ab1XXd").equals("abXd"));
		
		assertTrue(tester.encode("abXXXXd").equals("ab4XXd"));
		assertTrue(tester.decode("ab4XXd").equals("abXXXXd"));
		
		assertTrue(tester.encode("abXXX").equals("ab3XX"));
		assertTrue(tester.decode("ab3XX").equals("abXXX"));
		
		assertTrue(tester.encode("abXXXXXXXXXXXX").equals("ab9XX3XX"));
		assertTrue(tester.decode("ab9XX3XX").equals("abXXXXXXXXXXXX"));
		
		assertTrue(tester.encode("ab3XAXXXXXXXXXXX").equals("ab31XXA9XX2XX"));
		assertTrue(tester.decode("ab31XXA9XX2XX").equals("ab3XAXXXXXXXXXXX"));
		
		assertTrue(tester.encode("ab3XAAAAXXXXXXXXXXX").equals("ab31XX4XA9XX2XX"));
		assertTrue(tester.decode("ab31XX4XA9XX2XX").equals("ab3XAAAAXXXXXXXXXXX"));
		
		assertTrue(tester.encode("ab3XAAAAXXXXXXXXXXXAAA").equals("ab31XX4XA9XX2XXAAA"));
		assertTrue(tester.decode("ab31XX4XA9XX2XXAAA").equals("ab3XAAAAXXXXXXXXXXXAAA"));
	}

}
