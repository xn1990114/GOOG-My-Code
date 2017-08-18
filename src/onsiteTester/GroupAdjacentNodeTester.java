package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.GroupAdjacentNode;
import onsite.GroupAdjacentNode.Node;
/*
 *  1-2-3-4-5-6-7-8-9-10-11-12-13-14-15-16-17-18-19-20
 */
public class GroupAdjacentNodeTester {

	@Test
	public void test() {
		GroupAdjacentNode tester=new GroupAdjacentNode();
		Node n1=tester.new Node();Node n2=tester.new Node();Node n3=tester.new Node();
		Node n4=tester.new Node();Node n5=tester.new Node();Node n6=tester.new Node();
		Node n7=tester.new Node();Node n8=tester.new Node();Node n9=tester.new Node();
		Node n10=tester.new Node();Node n11=tester.new Node();Node n12=tester.new Node();
		Node n13=tester.new Node();Node n14=tester.new Node();Node n15=tester.new Node();
		Node n16=tester.new Node();Node n17=tester.new Node();Node n18=tester.new Node();
		Node n19=tester.new Node();Node n20=tester.new Node();
		n1.next=n2;n2.previous=n1;n2.next=n3;n3.previous=n2;n3.next=n4;n4.previous=n3;
		n4.next=n5;n5.previous=n4;n5.next=n6;n6.previous=n5;n6.next=n7;n7.previous=n6;
		n7.next=n8;n8.previous=n7;n8.next=n9;n9.previous=n8;n9.next=n10;n10.previous=n9;
		n10.next=n11;n11.previous=n10;
		n11.next=n12;n12.previous=n11;n12.next=n13;n13.previous=n12;n13.next=n14;n14.previous=n13;
		n14.next=n15;n15.previous=n14;n15.next=n16;n16.previous=n15;n16.next=n17;n17.previous=n16;
		n17.next=n18;n18.previous=n17;n18.next=n19;n19.previous=n18;n19.next=n20;n20.previous=n19;
		Node[] g1={};
		assertTrue(tester.countGroup(g1)==0);
		Node[] g2={n4,n2,n6};
		assertTrue(tester.countGroup(g2)==3);
		Node[] g3={n4,n2,n6,n1};
		assertTrue(tester.countGroup(g3)==3);
		Node[] g4={n4,n1,n6,n5,n20,n15,n14,n18,n17,n16};
		assertTrue(tester.countGroup(g4)==4);
		Node[] g5={n4,n1,n6,n5,n20,n15,n14,n18,n17,n16,n19,n10,n8,n9,n10};
		assertTrue(tester.countGroup(g5)==4);
		Node[] g6={n4,n1,n6,n5,n20,n15,n7,n14,n18,n17,n16,n19,n10,n8,n9,n10,n10};
		assertTrue(tester.countGroup(g6)==3);
	}

}
