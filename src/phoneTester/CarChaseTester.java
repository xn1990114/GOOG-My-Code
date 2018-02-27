package phoneTester;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;
import phone.CarChase;

public class CarChaseTester {

	@Test
	public void test1() {
		CarChase tester=new CarChase();
		int[] cars={2, 4, 1, 3};
		int[] r1={2,2};
		List<Integer> res=tester.calCluster(cars);
		for(int i=0;i<res.size();i++){
			assertTrue(res.get(i)==r1[i]);
		}
		List<List<Integer>> res2=tester.insertNewSpeed(cars);
		int[][] r2={{1,2,2},
					{3,2},
					{3,2},
					{2,3},
					{2,3}};
		for(int i=0;i<res2.size();i++){
			for(int j=0;j<res2.get(i).size();j++){
				assertTrue(res2.get(i).get(j)==r2[i][j]);
			}
		}
	}
	@Test
	public void test2() {
		CarChase tester=new CarChase();
		int[] cars={2, 5, 4, 3, 1};
		int[] r={4,1};
		List<Integer> res=tester.calCluster(cars);
		for(int i=0;i<res.size();i++){
			assertTrue(res.get(i)==r[i]);
		}
		List<List<Integer>> res2=tester.insertNewSpeed(cars);
		int[][] r2={{1,4,1},
					{5,1},
					{5,1},
					{5,1},
					{5,1},
					{4,2}};
		for(int i=0;i<res2.size();i++){
			for(int j=0;j<res2.get(i).size();j++){
				assertTrue(res2.get(i).get(j)==r2[i][j]);
			}
		}
	}
	@Test
	public void test3() {
		CarChase tester=new CarChase();
		// invalid test case for follow up
		int[] cars={2, 5, 4, 3, 1,0,0,4,5,7,2};
		int[] r={4,1,1,5};
		List<Integer> res=tester.calCluster(cars);
		for(int i=0;i<res.size();i++){
			assertTrue(res.get(i)==r[i]);
		}
	}
	@Test
	public void test4() {
		CarChase tester=new CarChase();
		int[] cars={1,2};
		int[] r={2};
		List<Integer> res=tester.calCluster(cars);
		for(int i=0;i<res.size();i++){
			assertTrue(res.get(i)==r[i]);
		}
		List<List<Integer>> res2=tester.insertNewSpeed(cars);
		int[][] r2={{1,2},
					{3},
					{3}};
		for(int i=0;i<res2.size();i++){
			for(int j=0;j<res2.get(i).size();j++){
				assertTrue(res2.get(i).get(j)==r2[i][j]);
			}
		}
	}
	@Test
	public void test5() {
		CarChase tester=new CarChase();
		int[] cars={};
		int[] r={};
		List<Integer> res=tester.calCluster(cars);
		for(int i=0;i<res.size();i++){
			assertTrue(res.get(i)==r[i]);
		}
		List<List<Integer>> res2=tester.insertNewSpeed(cars);
		int[][] r2={{1}};
		for(int i=0;i<res2.size();i++){
			for(int j=0;j<res2.get(i).size();j++){
				assertTrue(res2.get(i).get(j)==r2[i][j]);
			}
		}
	}
	@Test
	public void test6() {
		CarChase tester=new CarChase();
		// invalid test case for follow up
		int[] cars={3,2,2,2};
		int[] r={1,1,1,1};
		List<Integer> res=tester.calCluster(cars);
		for(int i=0;i<res.size();i++){
			assertTrue(res.get(i)==r[i]);
		}
	}
}
