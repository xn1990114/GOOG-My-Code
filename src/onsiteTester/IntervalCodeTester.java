package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.IntervalCode;
import onsite.IntervalCode.Interval;

public class IntervalCodeTester {

	@Test
	public void test1() {
		IntervalCode tester = new IntervalCode();
		Interval i1 = tester.new Interval(0, 2, 'a');
		Interval i2 = tester.new Interval(2, 5, 'b');
		Interval[] intervals = { i1, i2 };
		assertTrue(tester.findRegion(intervals).equals("(0,2,a)(2,5,b)"));
	}

	@Test
	public void test2() {
		IntervalCode tester = new IntervalCode();
		Interval i1 = tester.new Interval(2, 10, 'a');
		Interval i2 = tester.new Interval(3, 8, 'b');
		Interval i3 = tester.new Interval(4, 5, 'c');
		Interval i4 = tester.new Interval(7, 11, 'd');
		Interval i5 = tester.new Interval(12, 13, 'e');

		Interval[] intervals = { i1, i2, i3, i4, i5 };
		assertTrue(tester.findRegion(intervals)
				.equals("(2,3,a)(3,4,ab)(4,5,abc)(5,7,ab)(7,8,abd)(8,10,ad)(10,11,d)(12,13,e)"));
	}

	@Test
	public void test3() {
		IntervalCode tester = new IntervalCode();
		Interval i1 = tester.new Interval(0, 2, 'a');
		Interval i2 = tester.new Interval(3, 5, 'b');
		Interval i3 = tester.new Interval(4, 5, 'b');
		Interval[] intervals = { i1, i2, i3 };
		assertTrue(tester.findRegion(intervals).equals("(0,2,a)(3,4,b)(4,5,b)"));
	}

	@Test
	public void test4() {
		IntervalCode tester = new IntervalCode();
		Interval i1 = tester.new Interval(2, 10, 'a');
		Interval i2 = tester.new Interval(3, 8, 'b');
		Interval i6 = tester.new Interval(3, 8, 'f');
		Interval i3 = tester.new Interval(4, 5, 'c');
		Interval i4 = tester.new Interval(7, 11, 'd');
		Interval i5 = tester.new Interval(12, 13, 'e');

		Interval[] intervals = { i1, i2, i3, i4, i5,i6 };
		assertTrue(tester.findRegion(intervals)
				.equals("(2,3,a)(3,4,abf)(4,5,abcf)(5,7,abf)(7,8,abdf)(8,10,ad)(10,11,d)(12,13,e)"));
	}

}
