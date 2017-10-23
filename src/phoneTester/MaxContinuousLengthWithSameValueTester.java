package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.MaxContinuousLengthWithSameValue;

public class MaxContinuousLengthWithSameValueTester {

	@Test
	public void test() {
		MaxContinuousLengthWithSameValue tester=new MaxContinuousLengthWithSameValue();
		int[] vals1={1,1,1,1,1,2,2,2,3,3,3,3,3};
		int[][] links1={{0,1},{1,2},{2,3},{4,5},{4,6},{4,7},{4,8},{9,10},
				{10,11},{3,11}};
		assertTrue(tester.findMaxLength(vals1, links1)==3);
		int[] vals2={1,1,1,1,1,2,2,2};
		int[][] links2={{0,1},{1,2},{2,5},{5,7},{5,6},{5,3},{5,4}};
		assertTrue(tester.findMaxLength(vals2, links2)==2);
	}

}
