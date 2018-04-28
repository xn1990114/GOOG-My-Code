package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.CharCountStringIterator;

public class CharCountStringIteratorTester {

	@Test
	public void test1() {
		String s="aaaba";
		CharCountStringIterator it=new CharCountStringIterator(s);
		String[] res={"a3","b1","a1"};
		for(int i=0;i<res.length;i++){
			assertTrue(it.hasNext());
			assertTrue(res[i].equals(it.next()));
		}
	}
	@Test
	public void test2() {
		String s="";
		CharCountStringIterator it=new CharCountStringIterator(s);
		assertTrue(!it.hasNext());
	}
	@Test
	public void test3() {
		String s="aaahshysasss";
		CharCountStringIterator it=new CharCountStringIterator(s);
		String[] res={"a3","h1","s1","h1","y1","s1","a1","s3"};
		for(int i=0;i<res.length;i++){
			assertTrue(it.hasNext());
			assertTrue(res[i].equals(it.next()));
		}
	}
}
