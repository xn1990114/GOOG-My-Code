package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.CountPath;

public class CountPathTester {

	@Test
	public void test() {
		CountPath tester=new CountPath();
		assertTrue(tester.findCount(2)==3);
		int[] res={1,1,3,7,19,51,141,393,1107,3139,8953,25653,73789,212941};
		int[] resLimit={0,0,0,0,1,5,21};
		for(int i=0;i<res.length;i++){
			assertTrue(tester.findCount(i)==res[i]);
			if(i<resLimit.length){
				assertTrue(tester.findCountWithLimit(i, -1, 3)==resLimit[i]);
			}
		}
	}

}
