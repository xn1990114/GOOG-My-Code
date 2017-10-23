package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SetSumValueGraph;
import onsite.SetSumValueGraph.Node;

public class SetSumValueGraphTester {
/*
 * node ID from 1-n, row by row
 * 			4 - 8 - 25	-15	-  12            4(start2)
 * 					|			|            |
 * 	    4 - 5 - 7 - 8(start1) - 7  -  15-  (-10)
 * 					|                  |
 *                 31(start3)          5
 *                  |	
 *                  9
 */
	@Test
	public void test() {
		SetSumValueGraph tester=new SetSumValueGraph();
		Node n1=tester.new Node(4);Node n2=tester.new Node(8);Node n3=tester.new Node(25);
		Node n4=tester.new Node(15);Node n5=tester.new Node(12);Node n6=tester.new Node(4);
		Node n7=tester.new Node(4);Node n8=tester.new Node(5);Node n9=tester.new Node(7);
		Node n10=tester.new Node(8);Node n11=tester.new Node(7);Node n12=tester.new Node(15);
		Node n13=tester.new Node(-10);Node n14=tester.new Node(31);Node n15=tester.new Node(5);
		Node n16=tester.new Node(9);
		n1.neighbor.add(n2);n2.neighbor.add(n1);n2.neighbor.add(n3);n3.neighbor.add(n2);
		n3.neighbor.add(n4);n4.neighbor.add(n3);n4.neighbor.add(n5);n5.neighbor.add(n4);
		n3.neighbor.add(n10);n10.neighbor.add(n3);n5.neighbor.add(n11);n11.neighbor.add(n5);
		n6.neighbor.add(n13);n13.neighbor.add(n6);n7.neighbor.add(n8);n8.neighbor.add(n7);
		n8.neighbor.add(n9);n9.neighbor.add(n8);n9.neighbor.add(n10);n10.neighbor.add(n9);
		n10.neighbor.add(n11);n11.neighbor.add(n10);n11.neighbor.add(n12);n12.neighbor.add(n11);
		n12.neighbor.add(n13);n13.neighbor.add(n12);n10.neighbor.add(n14);n14.neighbor.add(n10);
		n12.neighbor.add(n15);n15.neighbor.add(n12);n14.neighbor.add(n16);n16.neighbor.add(n14);
		double target=9.3125;
		tester.setSumValue(n10);
		assertTrue(tester.checkResult(n10, target));
		//tester.setSumValue(n6);
		//assertTrue(tester.checkResult(n6, target));
		//tester.setSumValue(n14);
		//assertTrue(tester.checkResult(n14, target));
	}

}
