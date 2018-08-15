package phoneTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import phone.RGBCombination;

public class RGBCombinationTester {

	@Test
	public void test() {
		RGBCombination tester=new RGBCombination();
		List<String> r1=tester.findAllCombinations(4);
		assertTrue(r1.size()==81);
		
		List<String> r2=tester.findAllCombinations(0);
		assertTrue(r2.size()==1);
	}

}
