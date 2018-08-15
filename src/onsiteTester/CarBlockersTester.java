package onsiteTester;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import onsite.CarBlockers;
import onsite.CarBlockers.Car;

public class CarBlockersTester {

	@Test
	public void test1() {
		int[][] board={{0,0,0,2,0,0},
					   {0,0,0,2,0,0},
					   {0,0,0,1,0,0},
					   {0,0,0,1,0,0},
					   {0,0,0,1,4,0},
					   {0,0,0,3,4,0},
					   {0,0,0,3,4,0}};
		CarBlockers tester=new CarBlockers();
		Car c1=tester.new Car(1,2,4,3,3);Car c2=tester.new Car(2,0,1,3,3);Car c3=tester.new Car(3,5,6,3,3);
		Car c4=tester.new Car(4,4,6,4,4);
		Map<Integer,Car> carMap=new HashMap<Integer,Car>();
		carMap.put(1, c1);carMap.put(2, c2);carMap.put(3, c3);carMap.put(4, c4);
		int[] targetRes={2,3};
		assertTrue(tester.checkResult(tester.findBlockers(carMap, board, c1), targetRes));
		
	}
	@Test
	public void test2() {
		int[][] board={{0,0,0,2,0,0},
					   {0,0,0,2,5,5},
					   {6,1,1,1,4,0},
					   {6,0,0,0,4,0},
					   {7,7,7,7,4,0},
					   {0,0,0,3,4,0},
					   {0,0,0,3,4,0}};
		CarBlockers tester=new CarBlockers();
		Car c1=tester.new Car(1,2,2,1,3);Car c2=tester.new Car(2,0,1,3,3);Car c3=tester.new Car(3,5,6,3,3);
		Car c4=tester.new Car(4,2,6,4,4);Car c5=tester.new Car(5,1,1,4,5);Car c6=tester.new Car(6,2,3,0,0);
		Car c7=tester.new Car(7,4,4,0,3);
		Map<Integer,Car> carMap=new HashMap<Integer,Car>();
		carMap.put(1, c1);carMap.put(2, c2);carMap.put(3, c3);carMap.put(4, c4);
		carMap.put(5, c5);carMap.put(6, c6);carMap.put(7, c7);
		int[] targetRes={2,4,5,6,7};
		assertTrue(tester.checkResult(tester.findBlockers(carMap, board, c1), targetRes));
		
	}
	@Test
	public void test3() {
		int[][] board={{0,0,0,2,0,0},
					   {0,0,0,2,0,0},
					   {6,1,1,1,4,0},
					   {6,0,0,0,4,0},
					   {3,7,7,7,4,0},
					   {3,0,0,0,4,0},
					   {5,5,5,5,5,5}};
		CarBlockers tester=new CarBlockers();
		Car c1=tester.new Car(1,2,2,1,3);Car c2=tester.new Car(2,0,1,3,3);Car c3=tester.new Car(3,4,5,0,0);
		Car c4=tester.new Car(4,2,5,4,4);Car c5=tester.new Car(5,6,6,0,5);Car c6=tester.new Car(6,2,3,0,0);
		Car c7=tester.new Car(7,4,4,1,3);
		Map<Integer,Car> carMap=new HashMap<Integer,Car>();
		carMap.put(1, c1);carMap.put(2, c2);carMap.put(3, c3);carMap.put(4, c4);
		carMap.put(5, c5);carMap.put(6, c6);carMap.put(7, c7);
		int[] targetRes={3,4,5,6};
		assertTrue(tester.checkResult(tester.findBlockers(carMap, board, c1), targetRes));
		
	}
	@Test
	public void test4() {
		int[][] board={{0,0,0,2,0,0},
					   {0,0,0,2,0,0},
					   {6,1,1,1,1,1},
					   {6,0,0,0,4,0},
					   {3,7,7,7,4,0},
					   {3,0,0,0,4,0},
					   {5,5,5,5,5,0}};
		CarBlockers tester=new CarBlockers();
		Car c1=tester.new Car(1,2,2,1,5);Car c2=tester.new Car(2,0,1,3,3);Car c3=tester.new Car(3,4,5,0,0);
		Car c4=tester.new Car(4,3,5,4,4);Car c5=tester.new Car(5,6,6,0,4);Car c6=tester.new Car(6,2,3,0,0);
		Car c7=tester.new Car(7,4,4,1,3);
		Map<Integer,Car> carMap=new HashMap<Integer,Car>();
		carMap.put(1, c1);carMap.put(2, c2);carMap.put(3, c3);carMap.put(4, c4);
		carMap.put(5, c5);carMap.put(6, c6);carMap.put(7, c7);
		int[] targetRes={3,5,6};
		assertTrue(tester.checkResult(tester.findBlockers(carMap, board, c1), targetRes));
		
	}
}
