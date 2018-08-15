package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MethodStackTrace;

public class MethodStackTraceTester {

	@Test
	public void test1() {
		MethodStackTrace tester = new MethodStackTrace();
		String[] logs = { "main,start", "foo,start", "foo,end", "bar,start", "bar,end", "main,end", "main2,start",
				"main2,end" };
		tester.printTrace(logs);
		System.out.println();
	}

	@Test
	public void test2() {
		MethodStackTrace tester = new MethodStackTrace();
		String[] logs = { "main,start", "foo,start", "bar,start", "bar,end", "foo,end", "bar,start", "bar,end",
				"main,end", "main2,start", "bar,start", "bar,end", "bar,start", "bar,end", "main2,end" };
		tester.printTrace(logs);
		System.out.println();
	}
}
