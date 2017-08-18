package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.CarTravel;

public class CarTravelTester {

	@Test
	public void test() {
		CarTravel ct=new CarTravel();
		String s1="FFFTT";
		assertTrue(ct.calPos(s1)==15);
		String s2="FFFTFFFT";
		assertTrue(ct.calPos(s2)==1);
		System.out.println(ct.calString(15));
		System.out.println(ct.calString(1));
		System.out.println(ct.calString(4));
	}

}
