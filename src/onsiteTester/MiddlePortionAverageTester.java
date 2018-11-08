package onsiteTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import onsite.MiddlePortionAverage;

public class MiddlePortionAverageTester {

	@Test
	public void test() {
		MiddlePortionAverage tester=new MiddlePortionAverage();
		int[] nums=new int[110];
		for(int i=0;i<nums.length;i++){
			nums[i]=i+1;
		}
		List<Double> res=tester.cal90PercentileAverage(nums, 100);
		for(double val:res) {
			System.out.println(val);
		}
	}

}
