package onsiteTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import onsite.AppleBucket;

public class AppleBucketTester {

	@Test
	public void test1() {
		AppleBucket tester=new AppleBucket();
		int[][] friendApple={{0,1},{1,2}};
		List<String> res=tester.findAppleBucketCombination(friendApple, 3, 3);
		for(String s:res){
			System.out.println(s);
		}
		System.out.println();
	}
	@Test
	public void test2() {
		AppleBucket tester=new AppleBucket();
		int[][] friendApple={};
		List<String> res=tester.findAppleBucketCombination(friendApple, 3, 2);
		for(String s:res){
			System.out.println(s);
		}
		System.out.println();
	}
}
