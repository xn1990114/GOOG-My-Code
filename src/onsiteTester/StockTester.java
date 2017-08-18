package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.Stock;

public class StockTester {

	@Test
	public void test() {
		Stock s=new Stock();
		s.update(1, 5);
		assertTrue(s.getCurrentPrice()==5);
		s.update(2, 10);
		assertTrue(s.getCurrentPrice()==10);
		s.update(1, 15);
		assertTrue(s.getCurrentPrice()==10);
		assertTrue(s.getLow()==10);
		assertTrue(s.getHigh()==15);
		s.update(5, 1);
		assertTrue(s.getLow()==1);
		s.update(3, 30);
		assertTrue(s.getHigh()==30);
		s.delete(5);
		assertTrue(s.getLow()==10);
		assertTrue(s.getCurrentPrice()==30);
	}

}
