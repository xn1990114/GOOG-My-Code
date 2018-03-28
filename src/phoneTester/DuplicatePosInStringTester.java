package phoneTester;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import phone.DuplicatePosInString;

public class DuplicatePosInStringTester {

	@Test
	public void test1() {
		DuplicatePosInString tester=new DuplicatePosInString();
		String s="hellloooo";
		int[][] r={{2,4},{5,8}};
		assertTrue(tester.compareRes(tester.findDuplicatePos(s), r));
	}
	@Test
	public void test2() {
		DuplicatePosInString tester=new DuplicatePosInString();
		String s="hellloooob";
		int[][] r={{2,4},{5,8}};
		assertTrue(tester.compareRes(tester.findDuplicatePos(s), r));
	}
	@Test
	public void test3() {
		DuplicatePosInString tester=new DuplicatePosInString();
		String s="heellloo";
		int[][] r={{3,5}};
		assertTrue(tester.compareRes(tester.findDuplicatePos(s), r));
	}
	@Test
	public void test4() {
		DuplicatePosInString tester=new DuplicatePosInString();
		String s="llloooo";
		int[][] r={{0,2},{3,6}};
		assertTrue(tester.compareRes(tester.findDuplicatePos(s), r));
	}
	@Test
	public void test5() {
		DuplicatePosInString tester=new DuplicatePosInString();
		String s="llcoo";
		int[][] r={};
		assertTrue(tester.compareRes(tester.findDuplicatePos(s), r));
	}
}
