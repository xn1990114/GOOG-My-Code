package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MinFuelCost;

public class MinFuelCostTester {

	@Test
	public void test() {
		MinFuelCost tester=new MinFuelCost();
		int[] gas1={0,4,7,10,15};
		int[] cost1={5,4,3,2,1};
		assertTrue(tester.calMinCost(gas1, cost1, 15, 20)==51);
		int[] gas2={0,4,7,10,15,17,35};
		int[] cost2={5,4,3,2,1,5,6};
		assertTrue(tester.calMinCost(gas2, cost2, 17, 20)==53);
		int[] gas3={0,4,7,10,15};
		int[] cost3={1,2,1,4,1};
		assertTrue(tester.calMinCost(gas3, cost3, 15, 20)==15);
		int[] gas4={0,4,7,10,20,40,80,90};
		int[] cost4={5,4,3,2,1,1,1,1};
		assertTrue(tester.calMinCost(gas4, cost4, 90, 20)==-1);
		int[] gas5={ 0,14,17,20,35,50,60,70 ,85 ,105,106};
		int[] cost5={4,1,  3, 4, 1, 3, 5, 3, 100,200,  1};
		assertTrue(tester.calMinCost(gas5, cost5, 106, 20)==56+20+3+20+45+60+1500+200);
		int[] gas6={ 0,14,17,20,35,50,60,70 ,85 ,105,106,116,130,140};
		int[] cost6={4,1,  3, 4, 1, 3, 5, 3, 100,200,  5,  2,  1,  0};
		assertTrue(tester.calMinCost(gas6, cost6, 140, 20)==56+20+3+20+45+60+1500+200+50+28+10);
	}

}
