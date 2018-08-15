package onsiteTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import onsite.QuackToSortedList;

public class QuackToSortedListTester {

	@Test
	public void test1() {
		int[] nums={1,2,3,4,5,6};
		QuackToSortedList tester=new QuackToSortedList(nums);
		List<Integer> res=tester.makeDescList();
		assertTrue(res.size()==nums.length);
		for(int i=1;i<res.size();i++){
			int n1=res.get(i-1);
			int n2=res.get(i);
			assertTrue(n1>=n2);
		}
	}
	@Test
	public void test2() {
		int[] nums={1,2,3,4,5,6,7};
		QuackToSortedList tester=new QuackToSortedList(nums);
		List<Integer> res=tester.makeDescList();
		assertTrue(res.size()==nums.length);
		for(int i=1;i<res.size();i++){
			int n1=res.get(i-1);
			int n2=res.get(i);
			assertTrue(n1>=n2);
		}
	}
	@Test
	public void test3() {
		int[] nums={1,2,2,2,3,4,5,5,6,7};
		QuackToSortedList tester=new QuackToSortedList(nums);
		List<Integer> res=tester.makeDescList();
		assertTrue(res.size()==nums.length);
		for(int i=1;i<res.size();i++){
			int n1=res.get(i-1);
			int n2=res.get(i);
			assertTrue(n1>=n2);
		}
	}
	@Test
	public void test4() {
		int[] nums={1,1,2,2,2,3,4,5,5,6,7,8,9,9,9};
		QuackToSortedList tester=new QuackToSortedList(nums);
		List<Integer> res=tester.makeDescList();
		assertTrue(res.size()==nums.length);
		for(int i=1;i<res.size();i++){
			int n1=res.get(i-1);
			int n2=res.get(i);
			assertTrue(n1>=n2);
		}
	}
}
