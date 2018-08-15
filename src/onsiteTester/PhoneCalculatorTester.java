package onsiteTester;

import org.junit.Test;

import onsite.PhoneCalculator;

public class PhoneCalculatorTester {

	@Test
	public void test1() {
		PhoneCalculator tester=new PhoneCalculator();
		String keys="21+32===";
		for(int i=0;i<keys.length();i++){
			tester.takeInput(keys.charAt(i));
			System.out.println(keys.charAt(i)+"=>"+tester.lastRes);
		}
		System.out.println();
	}
	@Test
	public void test2() {
		PhoneCalculator tester=new PhoneCalculator();
		String keys="21+32=+=+23=+=";
		for(int i=0;i<keys.length();i++){
			tester.takeInput(keys.charAt(i));
			System.out.println(keys.charAt(i)+"=>"+tester.lastRes);
		}
		System.out.println();
	}
	@Test
	public void test3() {
		PhoneCalculator tester=new PhoneCalculator();
		String keys="21-32=+=";
		for(int i=0;i<keys.length();i++){
			tester.takeInput(keys.charAt(i));
			System.out.println(keys.charAt(i)+"=>"+tester.lastRes);
		}
		System.out.println();
	}
}
