package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SortWithMaxMove;

public class SortWithMaxMoveTester {

	@Test
	public void test() {
		SortWithMaxMove sorter=new SortWithMaxMove();
		int[] a1={2,5,3,1,4};
		sorter.sortWithKMove(a1, 2);
		int[] e1={2,1,3,4,5};
		for(int i=0;i<a1.length;i++){
			assertTrue(a1[i]==e1[i]);
		}
	}

}
