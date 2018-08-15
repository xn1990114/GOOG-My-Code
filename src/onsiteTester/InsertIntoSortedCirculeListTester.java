package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.InsertIntoSortedCirculeList;
import onsite.InsertIntoSortedCirculeList.ListNode;

public class InsertIntoSortedCirculeListTester {

	@Test
	public void test1() {
		// 1-1-1-2-3-4-5
		InsertIntoSortedCirculeList tester=new InsertIntoSortedCirculeList();
		ListNode n1=tester.new ListNode(1);ListNode n2=tester.new ListNode(1);
		ListNode n3=tester.new ListNode(1);ListNode n4=tester.new ListNode(2);
		ListNode n5=tester.new ListNode(3);ListNode n6=tester.new ListNode(4);
		ListNode n7=tester.new ListNode(5);
		n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;n6.next=n7;n7.next=n1;
		ListNode newHead=tester.insertNode(n1, 0);
		assertTrue(tester.serialize(newHead).equals("0,1,1,1,2,3,4,5,"));
	}
	@Test
	public void test2() {
		// 1-1-1-2-3-4-5
		InsertIntoSortedCirculeList tester=new InsertIntoSortedCirculeList();
		ListNode n1=tester.new ListNode(1);ListNode n2=tester.new ListNode(1);
		ListNode n3=tester.new ListNode(1);ListNode n4=tester.new ListNode(2);
		ListNode n5=tester.new ListNode(3);ListNode n6=tester.new ListNode(4);
		ListNode n7=tester.new ListNode(5);
		n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;n6.next=n7;n7.next=n1;
		ListNode newHead=tester.insertNode(n1, 1);
		assertTrue(tester.serialize(newHead).equals("1,1,1,1,2,3,4,5,"));
	}
	@Test
	public void test3() {
		// 1-1-1-2-3-4-5
		InsertIntoSortedCirculeList tester=new InsertIntoSortedCirculeList();
		ListNode n1=tester.new ListNode(1);ListNode n2=tester.new ListNode(1);
		ListNode n3=tester.new ListNode(1);ListNode n4=tester.new ListNode(2);
		ListNode n5=tester.new ListNode(3);ListNode n6=tester.new ListNode(4);
		ListNode n7=tester.new ListNode(5);
		n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;n6.next=n7;n7.next=n1;
		ListNode newHead=tester.insertNode(n1, 6);
		assertTrue(tester.serialize(newHead).equals("1,1,1,2,3,4,5,6,"));
	}
	@Test
	public void test4() {
		// 1-1-1-2-3-4-5
		InsertIntoSortedCirculeList tester=new InsertIntoSortedCirculeList();
		ListNode n1=tester.new ListNode(1);ListNode n2=tester.new ListNode(1);
		ListNode n3=tester.new ListNode(1);ListNode n4=tester.new ListNode(2);
		ListNode n5=tester.new ListNode(3);ListNode n6=tester.new ListNode(4);
		ListNode n7=tester.new ListNode(5);
		n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;n6.next=n7;n7.next=n1;
		ListNode newHead=tester.insertNode(n1, 5);
		assertTrue(tester.serialize(newHead).equals("1,1,1,2,3,4,5,5,"));
	}
	@Test
	public void test5() {
		InsertIntoSortedCirculeList tester=new InsertIntoSortedCirculeList();
		ListNode n1=tester.new ListNode(1);
		n1.next=n1;
		ListNode newHead=tester.insertNode(n1, 5);
		assertTrue(tester.serialize(newHead).equals("1,5,"));
	}
	@Test
	public void test6() {
		InsertIntoSortedCirculeList tester=new InsertIntoSortedCirculeList();
		ListNode n1=tester.new ListNode(1);
		n1.next=n1;
		ListNode newHead=tester.insertNode(n1, 0);
		assertTrue(tester.serialize(newHead).equals("0,1,"));
	}
	@Test
	public void test7() {
		InsertIntoSortedCirculeList tester=new InsertIntoSortedCirculeList();
		ListNode newHead=tester.insertNode(null, 0);
		assertTrue(tester.serialize(newHead).equals("0,"));
	}
}
