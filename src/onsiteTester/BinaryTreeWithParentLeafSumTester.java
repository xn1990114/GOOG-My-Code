package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.BinaryTreeWithParentLeafSum;
import onsite.BinaryTreeWithParentLeafSum.TreeNode;

public class BinaryTreeWithParentLeafSumTester {
/*
 * 				5
 * 		  3				1
 * 	 4       -10
 * 			3
 */
	@Test
	public void test() {
		BinaryTreeWithParentLeafSum tester=new BinaryTreeWithParentLeafSum();
		TreeNode n0=tester.new TreeNode(5);TreeNode n1=tester.new TreeNode(3);TreeNode n2=tester.new TreeNode(1);
		TreeNode n3=tester.new TreeNode(4);TreeNode n4=tester.new TreeNode(-10);TreeNode n5=tester.new TreeNode(3);
		n0.left=n1;n0.right=n2;n1.left=n3;n1.right=n4;n4.left=n5;
		n1.parent=n0;n2.parent=n0;n3.parent=n1;n4.parent=n1;n5.parent=n4;
		assertTrue(tester.calLeafSum(n0)==8);
		assertTrue(tester.calLeafSum(null)==0);
	}

}
