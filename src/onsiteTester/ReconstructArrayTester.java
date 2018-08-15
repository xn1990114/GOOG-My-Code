package onsiteTester;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import onsite.ReconstructArray;

public class ReconstructArrayTester {

	@Test
	public void test1() {
		ReconstructArray tester=new ReconstructArray();
		int[][] seq={{2, 3}, {3, 3, 3}};
		List<Integer> res=tester.reconstructArrayWithDuplicate(seq);
		for(int i=0;i<res.size();i++){
			System.out.print(res.get(i)+",");
		}
		System.out.println();
	}
	@Test
	public void test2() {
		ReconstructArray tester=new ReconstructArray();
		int[][] seq={{2, 2}, {2, 2, 2}};
		List<Integer> res=tester.reconstructArrayWithDuplicate(seq);
		for(int i=0;i<res.size();i++){
			System.out.print(res.get(i)+",");
		}
		System.out.println();
	}
	@Test
	public void test3() {
		ReconstructArray tester=new ReconstructArray();
		int[][] seq={{2, 4, 3}, {3, 3, 3} };
		List<Integer> res=tester.reconstructArrayWithDuplicate(seq);
		for(int i=0;i<res.size();i++){
			System.out.print(res.get(i)+",");
		}
		System.out.println();
	}
	@Test
	public void test4() {
		ReconstructArray tester=new ReconstructArray();
		int[][] seq={{1,5}, {5,1} };
		List<Integer> res=tester.reconstructArrayWithDuplicate(seq);
		for(int i=0;i<res.size();i++){
			System.out.print(res.get(i)+",");
		}
		System.out.println();
	}
}
