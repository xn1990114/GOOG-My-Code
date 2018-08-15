package onsiteTester;

import static org.junit.Assert.*;
import onsite.MinEdge;

import org.junit.Test;

public class MinEdgeTester {

	@Test
	public void test() {
		MinEdge ed=new MinEdge();
		int[] a1={1,2,3,4,5,4};
		assertTrue(ed.findMaxLength(a1)==3);
		int[] a2={1,2,1,2,5,4};
		assertTrue(ed.findMaxLength(a2)==3);
		int[] a3={1,2,1,2,4,2,4,1};
		assertTrue(ed.findMaxLength(a3)==6);
		int[] a4={1,2,1,5,5,4};
		assertTrue(ed.findMaxLength(a4)==4);
	}

}
