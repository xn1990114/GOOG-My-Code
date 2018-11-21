package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;
import onsite.CountTurnsInBinaryTree;
import onsite.CountTurnsInBinaryTree.TreeNode;

public class CountTurnsInBinaryTreeTester {
	/*
	 * 				0
	 * 		  1				2
	 * 	 3       4		6
	 * 			5
	 * 		  7
	 */
	
	@Test
	public void test() {
		CountTurnsInBinaryTree tester=new CountTurnsInBinaryTree();
		onsite.CountTurnsInBinaryTree.TreeNode n0=tester.new TreeNode(0);TreeNode n1=tester.new TreeNode(1);TreeNode n2=tester.new TreeNode(2);
		TreeNode n3=tester.new TreeNode(3);TreeNode n4=tester.new TreeNode(4);TreeNode n5=tester.new TreeNode(5);
		TreeNode n6=tester.new TreeNode(6);TreeNode n7=tester.new TreeNode(7);
		n0.left=n1;n0.right=n2;n1.left=n3;n1.right=n4;n4.left=n5;n2.left=n6;n5.left=n7;
		assertTrue(tester.countTurns(4, 5, n0)==0);
		assertTrue(tester.countTurns(0, 5, n0)==2);
		assertTrue(tester.countTurns(2, 5, n0)==3);
		assertTrue(tester.countTurns(7, 6, n0)==4);
		assertTrue(tester.countTurns(2, 7, n0)==3);
	}
}
