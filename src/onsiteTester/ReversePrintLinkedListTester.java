package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.ReversePrintLinkedList;
import onsite.ReversePrintLinkedList.ListNode;

public class ReversePrintLinkedListTester {

	@Test
	public void test1() {
		ReversePrintLinkedList tester=new ReversePrintLinkedList();
		ListNode l0=tester.new ListNode(0);ListNode l1=tester.new ListNode(1);ListNode l2=tester.new ListNode(2);
		ListNode l3=tester.new ListNode(3);ListNode l4=tester.new ListNode(4);ListNode l5=tester.new ListNode(5);
		ListNode l6=tester.new ListNode(6);
		l0.next=l1;l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;l5.next=l6;
		tester.reversePrint(l0);
		System.out.println();
	}
	@Test
	public void test2() {
		ReversePrintLinkedList tester=new ReversePrintLinkedList();
		ListNode l0=tester.new ListNode(0);ListNode l1=tester.new ListNode(1);ListNode l2=tester.new ListNode(2);
		ListNode l3=tester.new ListNode(3);ListNode l4=tester.new ListNode(4);ListNode l5=tester.new ListNode(5);
		l0.next=l1;l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;
		tester.reversePrint(l0);
		System.out.println();
	}
	@Test
	public void test3() {
		ReversePrintLinkedList tester=new ReversePrintLinkedList();
		ListNode l0=tester.new ListNode(0);ListNode l1=tester.new ListNode(1);ListNode l2=tester.new ListNode(2);
		ListNode l3=tester.new ListNode(3);ListNode l4=tester.new ListNode(4);
		l0.next=l1;l1.next=l2;l2.next=l3;l3.next=l4;
		tester.reversePrint(l0);
		System.out.println();
	}
	@Test
	public void test4() {
		ReversePrintLinkedList tester=new ReversePrintLinkedList();
		ListNode l0=tester.new ListNode(0);ListNode l1=tester.new ListNode(1);ListNode l2=tester.new ListNode(2);
		ListNode l3=tester.new ListNode(3);
		l0.next=l1;l1.next=l2;l2.next=l3;
		tester.reversePrint(l0);
		System.out.println();
	}
	@Test
	public void test5() {
		ReversePrintLinkedList tester=new ReversePrintLinkedList();
		ListNode l0=tester.new ListNode(0);ListNode l1=tester.new ListNode(1);ListNode l2=tester.new ListNode(2);
		l0.next=l1;l1.next=l2;
		tester.reversePrint(l0);
		System.out.println();
	}
	@Test
	public void test6() {
		ReversePrintLinkedList tester=new ReversePrintLinkedList();
		ListNode l0=tester.new ListNode(0);ListNode l1=tester.new ListNode(1);
		l0.next=l1;
		tester.reversePrint(l0);
		System.out.println();
	}
	@Test
	public void test7() {
		ReversePrintLinkedList tester=new ReversePrintLinkedList();
		ListNode l0=tester.new ListNode(0);
		tester.reversePrint(l0);
		System.out.println();
	}
	@Test
	public void test8() {
		ReversePrintLinkedList tester=new ReversePrintLinkedList();
		tester.reversePrint(null);
		System.out.println();
	}
}
