package onsiteTester;

import org.junit.Test;

import onsite.LineToCutPointInHalf;

public class LineToCutPointInHalfTester {

	@Test
	public void test1() {
		LineToCutPointInHalf tester=new LineToCutPointInHalf();
		double[][] points={{5.0,0},
						  {5.0,10}};
		String res1=tester.findCutLine(points);
		String res2=tester.findCutLineWithRandomLine(points);
		System.out.println(res1);
		System.out.println(res2);
		System.out.println();
		int countBelow=0;
		for(int i=0;i<points.length;i++){
			double y=0.6262122208249606*points[i][0]+1.8689388958751962;
			if(y<points[i][1]){
				countBelow++;
			}
		}
		System.out.println(countBelow);
	}
	@Test
	public void test2() {
		LineToCutPointInHalf tester=new LineToCutPointInHalf();
		double[][] points={{5.0,0},
						  {10.0,0}};
		String res1=tester.findCutLine(points);
		String res2=tester.findCutLineWithRandomLine(points);
		System.out.println(res1);
		System.out.println(res2);
		System.out.println();
		int countBelow=0;
		for(int i=0;i<points.length;i++){
			double y=-0.12271734429805307*points[i][0]+0.9203800822353981;
			if(y<points[i][1]){
				countBelow++;
			}
		}
		System.out.println(countBelow);
	}
	@Test
	public void test3() {
		LineToCutPointInHalf tester=new LineToCutPointInHalf();
		double[][] points={{5.0,8.4},{-7,0},{8.5,4.1},{2.0,-6.2},{-5.2,4},
						  {10.0,-7},{1.0,-8},{-8.9,-13},{6.3,-2.3},{-1.0,10}};
		String res1=tester.findCutLine(points);
		String res2=tester.findCutLineWithRandomLine(points);
		System.out.println(res1);
		System.out.println(res2);
		System.out.println();
		int countBelow=0;
		for(int i=0;i<points.length;i++){
			double y=0.023577566657838025*points[i][0]+-1.1417478516697566;
			if(y<points[i][1]){
				countBelow++;
			}
		}
		System.out.println(countBelow);
	}
	@Test
	public void test4() {
		LineToCutPointInHalf tester=new LineToCutPointInHalf();
		double[][] points={{5.0,8.4},{-7,0},{8.5,4.1},{2.0,-6.2},{-5.2,4},
						  {10.0,-7},{1.0,-8},{-8.9,-13},{6.3,-2.3}};
		String res1=tester.findCutLine(points);
		String res2=tester.findCutLineWithRandomLine(points);
		System.out.println(res1);
		System.out.println(res2);
		System.out.println();
		int countBelow=0;
		for(int i=0;i<points.length;i++){
			double y=-0.10449746953084162*points[i][0]+-1.6416659419556978;
			if(y<points[i][1]){
				countBelow++;
			}
		}
		System.out.println(countBelow);
	}
}
