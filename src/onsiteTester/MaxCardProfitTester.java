package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MaxCardProfit;

public class MaxCardProfitTester {

	@Test
	public void test() {
		MaxCardProfit tester=new MaxCardProfit();
		System.out.println(tester.getExpectedProfit());
	}

}
