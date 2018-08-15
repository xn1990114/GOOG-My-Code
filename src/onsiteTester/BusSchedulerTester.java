package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.BusScheduler;
import onsite.BusScheduler.Bus;

public class BusSchedulerTester {

	@Test
	public void test1() {
		System.out.println("test 1");
		BusScheduler bs=new BusScheduler(5);
		bs.addBus(bs.new Bus(1,"company1",1));
		bs.addBus(bs.new Bus(2,"company2",1));
		bs.addBus(bs.new Bus(3,"company3",1));
		bs.displayAllBus();
		bs.dispatch();
		bs.displayAllBus();
	}
	@Test
	public void test2() {
		System.out.println("test 1");
		BusScheduler bs=new BusScheduler(5);
		bs.addBus(bs.new Bus(1,"company1",3));
		bs.addBus(bs.new Bus(2,"company2",2));
		bs.addBus(bs.new Bus(3,"company3",1));
		bs.displayAllBus();
		bs.dispatch();
		bs.displayAllBus();
		bs.dispatch();
		bs.displayAllBus();
	}
	@Test
	public void test3() {
		System.out.println("test 3");
		BusScheduler bs=new BusScheduler(5);
		bs.addBus(bs.new Bus(1,"company1",3));
		bs.addBus(bs.new Bus(2,"company2",2));
		bs.addBus(bs.new Bus(3,"company3",1));
		bs.addBus(bs.new Bus(4,"company2",5));
		bs.addBus(bs.new Bus(5,"company3",1));
		bs.displayAllBus();
		bs.dispatch();
		bs.displayAllBus();
		bs.removeAll("company2");
		bs.displayAllBus();
	}

}
