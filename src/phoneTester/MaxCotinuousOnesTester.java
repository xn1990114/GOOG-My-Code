package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.MaxCotinuousOnes;

public class MaxCotinuousOnesTester {

	@Test
	public void test() {
		MaxCotinuousOnes tester=new MaxCotinuousOnes();
		int[] nums1={0,1,1,0,1,0,0,1,1,0,0,0,1,1,1,0};
		int k1=3;
		assertTrue(tester.findMaxLenWithKChange(nums1, k1)==8);
	}

}
