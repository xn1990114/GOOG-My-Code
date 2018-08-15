package onsiteTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import onsite.BicyclePair;
import onsite.BicyclePair.Pair;

public class BicyclePairTester {

	@Test
	public void test() {
		BicyclePair tester=new BicyclePair();
		int[][] board={{0,0,1,0,0,0},
					   {2,0,2,0,0,1},
					   {0,0,0,1,0,0},
					   {2,0,0,0,0,2},
					   {0,0,1,0,0,0}};
		List<Pair> res=tester.pairBiCycle(board);
		for(int i=0;i<res.size();i++){
			Pair curr=res.get(i);
			int[] p=curr.people;
			int[] b=curr.bicycle;
			System.out.println(p[0]+","+p[1]+" is with "+b[0]+","+b[1]);
		}
	}

}
