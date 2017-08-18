package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.VoteChecker;
import java.util.*;

public class VoteCheckerTester {

	@Test
	public void test() {
		VoteChecker vc=new VoteChecker();
		List<Integer> times=new ArrayList<Integer>();
		times.add(4);
		times.add(15);
		times.add(24);
		times.add(45);
		List<int[]> votes=new ArrayList<int[]>();
		int[][] toadd={{0,5},{1,2},{1,5},{1,3},{5,5},
					   {15,1},{16,1},{17,1},{24,5},
					   {30,1},{40,1},{45,1},{45,5},
					   {85,2},{78,2},{90,2},{120,2},};
		for(int i=0;i<toadd.length;i++){
			votes.add(toadd[i]);
		}
		vc.findTopK(2, times, votes);
	}

}
