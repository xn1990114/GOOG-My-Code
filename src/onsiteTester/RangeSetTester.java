package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.RangeSet;

public class RangeSetTester {

	@Test
	public void test() {
		RangeSet rs=new RangeSet();
		rs.addRange(-100, -10);
		rs.addRange(-99, -5);
		rs.addRange(-1, 10);
		System.out.println(rs.toString());
		System.out.println(rs.find(-2));
		System.out.println(rs.find(1000));
		System.out.println(rs.find(-100));
		rs.addRange(-5, -1);
		System.out.println(rs.toString());
		System.out.println(rs.find(-2));
		
	}

}
