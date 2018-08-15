package onsiteTester;

import org.junit.Test;

import onsite.FixInvalidBinaryTree;
import onsite.FixInvalidBinaryTree.TreeNode;

public class FixInvalidBinaryTreeTester {

	/*
	 * 						1
	 * 					/        \
	 * 				   2		  3
	 * 					\		/
	 * 					 4		5
	 * 						\ /
	 * 						6
	 * 					   /
	 * 					 7
	 */					
	@Test
	public void test1() {
		FixInvalidBinaryTree tester=new FixInvalidBinaryTree();
		TreeNode n1=tester.new TreeNode(1);TreeNode n2=tester.new TreeNode(2);
		TreeNode n3=tester.new TreeNode(3);TreeNode n4=tester.new TreeNode(4);
		TreeNode n5=tester.new TreeNode(5);TreeNode n6=tester.new TreeNode(6);
		TreeNode n7=tester.new TreeNode(7);
		n1.left=n2;n1.right=n3;n2.right=n4;n3.left=n5;n4.right=n6;n5.left=n6;n6.left=n7;
		tester.fixTree(n1);
		tester.printTree(n1);
		System.out.println();
	}
		
	@Test
	public void test2() {
		FixInvalidBinaryTree tester=new FixInvalidBinaryTree();
		TreeNode n1=tester.new TreeNode(1);
		n1.left=n1;n1.right=n1;
		tester.fixTree(n1);
		tester.printTree(n1);
		System.out.println();
	}
	/*
	 * 						1
	 * 			  / \	/        \
	 * 			/     2		      3
	 * 			\	/	\		/   \
	 * 			 --	   4		5   |
	 * 					/	\ /     |
	 * 				  /   	6 ------
	 * 				  \   /
	 * 					 7
	 */					
	@Test
	public void test3() {
		FixInvalidBinaryTree tester=new FixInvalidBinaryTree();
		TreeNode n1=tester.new TreeNode(1);TreeNode n2=tester.new TreeNode(2);
		TreeNode n3=tester.new TreeNode(3);TreeNode n4=tester.new TreeNode(4);
		TreeNode n5=tester.new TreeNode(5);TreeNode n6=tester.new TreeNode(6);
		TreeNode n7=tester.new TreeNode(7);
		n1.left=n2;n1.right=n3;n2.right=n4;n3.left=n5;n4.right=n6;n5.left=n6;n6.left=n7;
		n6.right=n3;n2.left=n2;n4.left=n7;
		tester.fixTree(n1);
		tester.printTree(n1);
		System.out.println();
	}
	@Test
	public void test4() {
		FixInvalidBinaryTree tester=new FixInvalidBinaryTree();
		TreeNode n1=null;
		tester.fixTree(n1);
		tester.printTree(n1);
		System.out.println();
	}
}
