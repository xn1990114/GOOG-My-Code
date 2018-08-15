package onsiteTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import onsite.DeleteOddNodeInLinkedList;
import onsite.DeleteOddNodeInLinkedList.ListNode;

public class DeleteOddNodeInLinkedListTester {

	@Test
	public void test1() {
		DeleteOddNodeInLinkedList tester=new DeleteOddNodeInLinkedList();
		ListNode n0=tester.new ListNode(0);ListNode n1=tester.new ListNode(1);ListNode n2=tester.new ListNode(2);
		ListNode n3=tester.new ListNode(3);ListNode n4=tester.new ListNode(4);ListNode n5=tester.new ListNode(5);
		n0.next=n1;n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n0;
		int[] target={1, 3, 5, 2, 0, 4};
		List<Integer> res=tester.removeOddNodes(n0);
		for(int i=0;i<target.length;i++){
			assertTrue(target[i]==res.get(i));
		}
	}
	@Test
	public void test2() {
		DeleteOddNodeInLinkedList tester=new DeleteOddNodeInLinkedList();
		ListNode n0=tester.new ListNode(0);ListNode n1=tester.new ListNode(1);ListNode n2=tester.new ListNode(2);
		ListNode n3=tester.new ListNode(3);ListNode n4=tester.new ListNode(4);ListNode n5=tester.new ListNode(5);
		ListNode n6=tester.new ListNode(6);
		n0.next=n1;n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;n6.next=n0;
		int[] target={1, 3, 5, 0, 4, 2,6};
		List<Integer> res=tester.removeOddNodes(n0);
		for(int i=0;i<target.length;i++){
			assertTrue(target[i]==res.get(i));
		}
	}
	@Test
	public void test4() {
		DeleteOddNodeInLinkedList tester=new DeleteOddNodeInLinkedList();
		List<Integer> res=tester.removeOddNodes(null);
			assertTrue(res.size()==0);
		}
	@Test
	public void test3() {
		DeleteOddNodeInLinkedList tester=new DeleteOddNodeInLinkedList();
		ListNode n0=tester.new ListNode(0);
		n0.next=n0;
		int[] target={0};
		List<Integer> res=tester.removeOddNodes(n0);
		for(int i=0;i<target.length;i++){
			assertTrue(target[i]==res.get(i));
		}
	}

}
