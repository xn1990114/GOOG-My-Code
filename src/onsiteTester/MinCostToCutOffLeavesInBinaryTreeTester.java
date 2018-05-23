package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MinCostToCutOffLeavesInBinaryTree;
import onsite.MinCostToCutOffLeavesInBinaryTree.TreeNode;

public class MinCostToCutOffLeavesInBinaryTreeTester {

	@Test
	public void test1() {
		MinCostToCutOffLeavesInBinaryTree tester=new MinCostToCutOffLeavesInBinaryTree();
		TreeNode n=null;
		assertTrue(tester.findMinCost(n)==0);
	}
	/*
	 * 			5
	 * 		  /
	 * 		6
	 */
	@Test
	public void test2() {
		MinCostToCutOffLeavesInBinaryTree tester=new MinCostToCutOffLeavesInBinaryTree();
		TreeNode n1=tester.new TreeNode(5);TreeNode n2=tester.new TreeNode(6);
		n1.left=n2;
		assertTrue(tester.findMinCost(n1)==5);
	}
	/*
	 * 				100
	 * 		  	/        \
	 * 		  6            9
	 *      /   \  		  /   \
	 *     2	10		2		5	
	 *         /  \ 	 \		/
	 *        3		9     3	    1
	 * 
	 * 
	 */
	@Test
	public void test3() {
		MinCostToCutOffLeavesInBinaryTree tester=new MinCostToCutOffLeavesInBinaryTree();
		TreeNode n1=tester.new TreeNode(100);TreeNode n2=tester.new TreeNode(6);
		TreeNode n3=tester.new TreeNode(9);TreeNode n4=tester.new TreeNode(2);
		TreeNode n5=tester.new TreeNode(10);TreeNode n6=tester.new TreeNode(2);
		TreeNode n7=tester.new TreeNode(5);TreeNode n8=tester.new TreeNode(3);
		TreeNode n9=tester.new TreeNode(9);TreeNode n10=tester.new TreeNode(3);
		TreeNode n11=tester.new TreeNode(1);
		n1.left=n2;n1.right=n3; n2.left=n4;n2.right=n5;n3.left=n6;n3.right=n7;
		n5.left=n8;n5.right=n9;n6.right=n10;n7.left=n11;
		assertTrue(tester.findMinCost(n1)==9);
	}
}
