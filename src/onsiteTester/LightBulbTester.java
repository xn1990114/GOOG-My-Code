package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.LightBulb;

public class LightBulbTester {

	@Test
	public void test() {
		LightBulb lb=new LightBulb(10);
		lb.displayResult();
		lb.toggle(1, 4);
		lb.toggle(5, 10);
		lb.displayResult();
		lb.toggle(1, 4);
		lb.displayResult();
		lb.toggle(4, 6);
		lb.displayResult();
		lb.toggle(7, 8);
		lb.displayResult();
		lb.toggle(4, 8);
		lb.displayResult();
		lb.toggle(7, 10);
		lb.displayResult();
		lb.toggle(6, 8);
		lb.displayResult();
		lb.toggle(8, 10);
		lb.displayResult();
		lb.toggle(4,7);
		lb.displayResult();
	}

}
