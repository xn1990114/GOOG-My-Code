package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.ProductMachine;

public class ProductMachineTester {

	@Test
	public void test() {
		ProductMachine pm=new ProductMachine();
		int[] machines1={1,2,3,4,5,6,7,8};
		int[] cooldowns1={0,0,0,0,0,0,0,0};
		assertTrue(pm.calTime(3, machines1, cooldowns1)==2);
		assertTrue(pm.calTime(10, machines1, cooldowns1)==5);
		int[] machines2={1,2,3,4,5,6,7,8};
		int[] cooldowns2={10,5,0,0,0,0,0,0};
		assertTrue(pm.calTime(2, machines2, cooldowns2)==2);
		assertTrue(pm.calTime(3, machines2, cooldowns2)==3);
		assertTrue(pm.calTime(5, machines2, cooldowns2)==5);
		int[] machines3={1,2,3};
		int[] cooldowns3={10,5,3};
		assertTrue(pm.calTime(4, machines3, cooldowns3)==9);
		assertTrue(pm.calTime(5, machines3, cooldowns3)==9);
		assertTrue(pm.calTime(6, machines3, cooldowns3)==12);
		assertTrue(pm.calTime(7, machines3, cooldowns3)==15);
		assertTrue(pm.calTime(8, machines3, cooldowns3)==16);
	}

}
