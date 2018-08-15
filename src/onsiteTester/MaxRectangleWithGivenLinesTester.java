package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.MaxRectangleWithGivenLines;
import onsite.MaxRectangleWithGivenLines.Line;

public class MaxRectangleWithGivenLinesTester {
/*
 * 8
 * 7________
 * 6
 * 5
 * 4     ________
 * 3_________
 * 2
 * 1_______
 * 0____
 *  0123456789
 */
	@Test
	public void test1() {
		MaxRectangleWithGivenLines tester=new MaxRectangleWithGivenLines();
		Line l1=tester.new Line(0,7,0,0);
		Line l2=tester.new Line(0,6,1,1);
		Line l3=tester.new Line(0,7,7,7);
		Line l4=tester.new Line(5,12,4,4);
		Line l5=tester.new Line(1,1,1,6);
		Line l6=tester.new Line(6,6,0,8);
		Line l7=tester.new Line(0,7,3,3);
		List<Line> lines=new ArrayList<Line>();
		lines.add(l1);lines.add(l2);lines.add(l3);lines.add(l4);lines.add(l5);lines.add(l6);lines.add(l7);
		assertTrue(tester.calMaxArea(lines)==10);
	}
	@Test
	public void test2() {
		MaxRectangleWithGivenLines tester=new MaxRectangleWithGivenLines();
		Line l1=tester.new Line(0,7,0,0);
		Line l2=tester.new Line(0,6,1,1);
		Line l3=tester.new Line(0,7,7,7);
		Line l4=tester.new Line(5,12,4,4);
		Line l5=tester.new Line(1,1,2,7);
		Line l6=tester.new Line(6,6,0,8);
		Line l7=tester.new Line(0,7,3,3);
		List<Line> lines=new ArrayList<Line>();
		lines.add(l1);lines.add(l2);lines.add(l3);lines.add(l4);lines.add(l5);lines.add(l6);lines.add(l7);
		assertTrue(tester.calMaxArea(lines)==20);
	}
	@Test
	public void test3() {
		MaxRectangleWithGivenLines tester=new MaxRectangleWithGivenLines();
		Line l1=tester.new Line(0,7,0,0);
		Line l2=tester.new Line(0,6,1,1);
		Line l3=tester.new Line(0,7,7,7);
		Line l4=tester.new Line(5,12,4,4);
		Line l5=tester.new Line(1,1,2,7);
		Line l6=tester.new Line(6,6,0,8);
		List<Line> lines=new ArrayList<Line>();
		lines.add(l1);lines.add(l2);lines.add(l3);lines.add(l4);lines.add(l5);lines.add(l6);
		assertTrue(tester.calMaxArea(lines)==0);
	}
	@Test
	public void test4() {
		MaxRectangleWithGivenLines tester=new MaxRectangleWithGivenLines();
		Line l1=tester.new Line(0,7,0,0);
		Line l2=tester.new Line(0,6,1,1);
		Line l3=tester.new Line(0,7,7,7);
		Line l4=tester.new Line(5,12,4,4);
		Line l5=tester.new Line(1,1,2,7);
		Line l6=tester.new Line(6,6,0,8);
		Line l7=tester.new Line(0,7,3,3);
		Line l8=tester.new Line(1,1,3,7);
		List<Line> lines=new ArrayList<Line>();
		lines.add(l1);lines.add(l2);lines.add(l3);lines.add(l4);lines.add(l5);lines.add(l6);lines.add(l7);lines.add(l8);
		assertTrue(tester.calMaxArea(lines)==20);
	}
}
