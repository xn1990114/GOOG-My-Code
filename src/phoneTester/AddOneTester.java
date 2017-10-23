package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.AddOne;

public class AddOneTester {

	@Test
	public void test() {
		AddOne tester=new AddOne();
		for(int i=-9999;i<=12000;i++){
			String num=i+"";
			assertTrue(tester.calResult(num.toCharArray()).equals((i+1)+""));
		}
	}

}
