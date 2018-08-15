package onsiteTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import onsite.RandomSelectKFromArray;

public class RandomSelectKFromArrayTester {

	@Test
	public void test1() {
		RandomSelectKFromArray tester=new RandomSelectKFromArray();
		int[] nums={0,1,2,3,4,5,6,7,8,9,10};
		
		int[] count=new int[11];
		for(int i=0;i<1000;i++){
			List<Integer> res=tester.getRandomKValue(nums, 3);
			for(int num:res){
				count[num]++;
			}
		}
		for(int i=0;i<count.length;i++){
			System.out.println(i+" is "+ count[i]);
		}
		
	}
	@Test
	public void test2() {
		RandomSelectKFromArray tester=new RandomSelectKFromArray();
		int[] nums={0,1,2,3,4,5,6,7,8,9,10};
		
		int[] count=new int[11];
		for(int i=0;i<1000;i++){
			List<Integer> res=tester.getRandomKValue(nums, 2);
			for(int num:res){
				count[num]++;
			}
		}
		for(int i=0;i<count.length;i++){
			System.out.println(i+" is "+ count[i]);
		}
		
	}
}
