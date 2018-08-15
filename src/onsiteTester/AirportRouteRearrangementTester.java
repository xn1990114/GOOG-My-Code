package onsiteTester;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import onsite.AirportRouteRearrangement;

public class AirportRouteRearrangementTester {

	@Test
	public void test1() {
		AirportRouteRearrangement tester=new AirportRouteRearrangement();
		List<String> trip=new ArrayList<String>();
		trip.add("SEA");trip.add("LAX");trip.add("POR");trip.add("LAS");
		List<String> newPath=tester.rearrangeRouteWithMinCost(trip);
		for(int i=0;i<newPath.size();i++){
			System.out.println(newPath.get(i));
		}
	}
	@Test
	public void test2() {
		AirportRouteRearrangement tester=new AirportRouteRearrangement();
		List<String> trip=new ArrayList<String>();
		trip.add("XNA");trip.add("LAZ");trip.add("POR");trip.add("LAS");
		List<String> newPath=tester.rearrangeRouteWithMinCost(trip);
		for(int i=0;i<newPath.size();i++){
			System.out.println(newPath.get(i));
		}
	}
}
