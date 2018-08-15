package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.TopKCPUUser;

public class TopKCPUUserTester {

	@Test
	public void test1() {
		TopKCPUUser tester=new TopKCPUUser();
		List<String> logs=new ArrayList<String>();
		logs.add("abc,1,5,2");// 6
		logs.add("abc,2,3,4");
		logs.add("bcd,1,5,2");// 10
		logs.add("bcd,7,10,10");
		logs.add("bcd,2,7,5");
		logs.add("Nan,0,10,2");//9
		logs.add("Nan,12,14,3");
		logs.add("Nan,15,17,4");
		logs.add("Nan,11,16,5");
		String[] target={"Nan","bcd"};
		assertTrue(tester.validateResult(tester.topKUsageUser(logs, 2), target));
	}
	@Test
	public void test2() {
		TopKCPUUser tester=new TopKCPUUser();
		List<String> logs=new ArrayList<String>();
		logs.add("abc,1,5,2");// 6
		logs.add("abc,2,3,4");
		logs.add("bcd,1,5,2");// 10
		logs.add("bcd,7,10,10");
		logs.add("bcd,2,7,5");
		logs.add("Nan,0,10,2");//9
		logs.add("Nan,12,14,3");
		logs.add("Nan,15,17,4");
		logs.add("Nan,11,16,5");
		String[] target={"bcd"};
		assertTrue(tester.validateResult(tester.topKUsageUser(logs, 1), target));
	}
	@Test
	public void test4() {
		TopKCPUUser tester=new TopKCPUUser();
		List<String> logs=new ArrayList<String>();
		logs.add("abc,1,5,2");// 6
		logs.add("abc,2,3,4");
		logs.add("bcd,1,5,2");// 10
		logs.add("bcd,7,10,10");
		logs.add("bcd,2,7,5");
		logs.add("Nan,0,10,2");//9
		logs.add("Nan,12,14,3");
		logs.add("Nan,15,17,4");
		logs.add("Nan,11,16,5");
		String[] target={"abc","Nan","bcd"};
		assertTrue(tester.validateResult(tester.topKUsageUser(logs, 4), target));
	}
}
