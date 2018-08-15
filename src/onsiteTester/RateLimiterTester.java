package onsiteTester;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import onsite.RateLimiter;

public class RateLimiterTester {

	@Test
	public void test1() {
		RateLimiter limiter=new RateLimiter();
		limiter.setLimitConstant(8);
		limiter.hit(0); limiter.hit(10);
		limiter.hit(15);limiter.hit(15);
		limiter.hit(15);limiter.hit(15);
		limiter.hit(15);limiter.hit(15);
		limiter.hit(15);limiter.hit(15);
		limiter.hit(99);limiter.hit(100);
		limiter.hit(100);limiter.hit(115);
		limiter.hit(215);
		System.out.println();
	}
	@Test
	public void test2() {
		RateLimiter limiter=new RateLimiter();
		limiter.hit(0); limiter.hit(10);
		limiter.hit(15);limiter.hit(15);
		limiter.hit(15);limiter.hit(15);
		limiter.hit(15);limiter.hit(15);
		limiter.hit(15);limiter.hit(15);
		limiter.hit(99);limiter.hit(100);
		limiter.hit(100);limiter.hit(115);
		limiter.hit(215);
		System.out.println();
	}

}
