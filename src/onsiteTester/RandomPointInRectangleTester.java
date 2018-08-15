package onsiteTester;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import onsite.RandomPointInRectangle;
import onsite.RandomPointInRectangle.Rectangle;

public class RandomPointInRectangleTester {

	@Test
	public void test1() {
		RandomPointInRectangle tester=new RandomPointInRectangle();
		Rectangle r1=tester.new Rectangle(1.0,1.0,5.0,5.0);
		Rectangle r2=tester.new Rectangle(2.0,2.0,6.0,6.0);
		List<Rectangle> rectangles=new ArrayList<Rectangle>();
		rectangles.add(r1);
		rectangles.add(r2);
		for(int i=0;i<10;i++){
			double[] r=tester.getRandomPoint(rectangles);
			System.out.println(r[0]+","+r[1]);
		}
		System.out.println();
	}
	@Test
	public void test2() {
		RandomPointInRectangle tester=new RandomPointInRectangle();
		Rectangle r1=tester.new Rectangle(1.0,1.0,5.0,5.0);
		Rectangle r2=tester.new Rectangle(1.0,1.0,5.0,6.0);
		Rectangle r3=tester.new Rectangle(-1.0,-1.0,2.0,2.0);
		List<Rectangle> rectangles=new ArrayList<Rectangle>();
		rectangles.add(r1);
		rectangles.add(r2);
		rectangles.add(r3);
		for(int i=0;i<10;i++){
			double[] r=tester.getRandomPoint(rectangles);
			System.out.println(r[0]+","+r[1]);
		}
	}
}
