package phoneTester;

import org.junit.Test;

import phone.Get24;

public class Get24Tester {

	@Test
	public void test() {
		Get24 tester=new Get24();
		int[] nums1={1,4,7,8};
		tester.findNextPermutation(nums1);
		tester.display(tester.findWayTo24(nums1));
	}

}
