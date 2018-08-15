package onsiteTester;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import onsite.CharCountIterator;

public class CharCountIteratorTester {

	@Test
	public void test1() {
		//"a", "a", "a", "b", "a"
		List<String> list=new ArrayList<String>();
		list.add("a");list.add("a");list.add("a");list.add("b");list.add("a");
		CharCountIterator tester=new CharCountIterator(list);
		String[] res={"a3","b1","a1"};
		int index=0;
		while(tester.hasNext()){
			assertTrue(res[index].equals(tester.next()));
			index++;
		}
	}
	@Test
	public void test2() {
		List<String> list=new ArrayList<String>();
		CharCountIterator tester=new CharCountIterator(list);
		assertTrue(!tester.hasNext());
	}
	@Test
	public void test3() {
		//"a"
		List<String> list=new ArrayList<String>();
		list.add("a");
		CharCountIterator tester=new CharCountIterator(list);
		String[] res={"a1"};
		int index=0;
		while(tester.hasNext()){
			assertTrue(res[index].equals(tester.next()));
			index++;
		}
	}
	@Test
	public void test4() {
		//"a", "a", "a", "b", "a","a"
		List<String> list=new ArrayList<String>();
		list.add("a");list.add("a");list.add("a");list.add("b");list.add("a");list.add("a");
		CharCountIterator tester=new CharCountIterator(list);
		String[] res={"a3","b1","a2"};
		int index=0;
		while(tester.hasNext()){
			assertTrue(res[index].equals(tester.next()));
			index++;
		}
	}
}
