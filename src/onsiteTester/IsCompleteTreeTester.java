package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.IsCompleteTree;
import onsite.IsCompleteTree.TreeNode;

public class IsCompleteTreeTester {
/*
 * 				0
 * 		1				2
 * 	 3    4          5      6
 */
	@Test
	public void test1() {
		IsCompleteTree tester=new IsCompleteTree();
		TreeNode n0=tester.new TreeNode(1);TreeNode n1=tester.new TreeNode(1);
		TreeNode n2=tester.new TreeNode(1);TreeNode n3=tester.new TreeNode(1);
		TreeNode n4=tester.new TreeNode(1);TreeNode n5=tester.new TreeNode(1);
		TreeNode n6=tester.new TreeNode(1);
		n0.left=n1;n0.right=n2;n1.left=n3;n1.right=n4;n2.left=n5;n2.right=n6;
		assertTrue(tester.isCompleteTree(n0));
	}
	/*
	 * 				0
	 * 		1				2
	 * 	 3    4          5     
	 */
	@Test
	public void test2() {
		IsCompleteTree tester=new IsCompleteTree();
		TreeNode n0=tester.new TreeNode(1);TreeNode n1=tester.new TreeNode(1);
		TreeNode n2=tester.new TreeNode(1);TreeNode n3=tester.new TreeNode(1);
		TreeNode n4=tester.new TreeNode(1);TreeNode n5=tester.new TreeNode(1);
		TreeNode n6=tester.new TreeNode(1);
		n0.left=n1;n0.right=n2;n1.left=n3;n1.right=n4;n2.left=n5;
		assertTrue(tester.isCompleteTree(n0));
	}
	/*
	* 				0
	* 		1				2
	* 	 3    4         
	*/
	@Test
	public void test3() {
		IsCompleteTree tester=new IsCompleteTree();
		TreeNode n0=tester.new TreeNode(1);TreeNode n1=tester.new TreeNode(1);
		TreeNode n2=tester.new TreeNode(1);TreeNode n3=tester.new TreeNode(1);
		TreeNode n4=tester.new TreeNode(1);TreeNode n5=tester.new TreeNode(1);
		TreeNode n6=tester.new TreeNode(1);
		n0.left=n1;n0.right=n2;n1.left=n3;n1.right=n4;
		assertTrue(tester.isCompleteTree(n0));
	}
	/*
	* 				0
	* 		1				2
	* 	 3              5      6
	*/
	@Test
	public void test4() {
		IsCompleteTree tester=new IsCompleteTree();
		TreeNode n0=tester.new TreeNode(1);TreeNode n1=tester.new TreeNode(1);
		TreeNode n2=tester.new TreeNode(1);TreeNode n3=tester.new TreeNode(1);
		TreeNode n4=tester.new TreeNode(1);TreeNode n5=tester.new TreeNode(1);
		TreeNode n6=tester.new TreeNode(1);
		n0.left=n1;n0.right=n2;n1.left=n3;n2.left=n5;n2.right=n6;
		assertTrue(!tester.isCompleteTree(n0));
	}
	/*
	* 				0
	* 		1				2
	* 	      4         5      6
	*/
	@Test
	public void test5() {
		IsCompleteTree tester=new IsCompleteTree();
		TreeNode n0=tester.new TreeNode(1);TreeNode n1=tester.new TreeNode(1);
		TreeNode n2=tester.new TreeNode(1);TreeNode n3=tester.new TreeNode(1);
		TreeNode n4=tester.new TreeNode(1);TreeNode n5=tester.new TreeNode(1);
		TreeNode n6=tester.new TreeNode(1);
		n0.left=n1;n0.right=n2;n1.right=n4;n2.left=n5;n2.right=n6;
		assertTrue(!tester.isCompleteTree(n0));
	}
	/*
	* 				0
	* 		1				2
	* 	  3    4         5      
	*   6
	*/
	@Test
	public void test6() {
		IsCompleteTree tester=new IsCompleteTree();
		TreeNode n0=tester.new TreeNode(1);TreeNode n1=tester.new TreeNode(1);
		TreeNode n2=tester.new TreeNode(1);TreeNode n3=tester.new TreeNode(1);
		TreeNode n4=tester.new TreeNode(1);TreeNode n5=tester.new TreeNode(1);
		TreeNode n6=tester.new TreeNode(1);
		n0.left=n1;n0.right=n2;n1.left=n3;n1.right=n4;n2.left=n5;n3.left=n6;
		assertTrue(!tester.isCompleteTree(n0));
	}
	/*
	* 				0
	* 		1				2
	* 	  3    4               
	*   6    5
	*/
	@Test
	public void test7() {
		IsCompleteTree tester=new IsCompleteTree();
		TreeNode n0=tester.new TreeNode(1);TreeNode n1=tester.new TreeNode(1);
		TreeNode n2=tester.new TreeNode(1);TreeNode n3=tester.new TreeNode(1);
		TreeNode n4=tester.new TreeNode(1);TreeNode n5=tester.new TreeNode(1);
		TreeNode n6=tester.new TreeNode(1);
		n0.left=n1;n0.right=n2;n1.left=n3;n1.right=n4;n3.right=n5;n3.left=n6;
		assertTrue(!tester.isCompleteTree(n0));
	}
	/*
	* 				0
	* 		1			2	
	* 	              3    4               
	*              6    5
	*/
	@Test
	public void test8() {
		IsCompleteTree tester=new IsCompleteTree();
		TreeNode n0=tester.new TreeNode(1);TreeNode n1=tester.new TreeNode(1);
		TreeNode n2=tester.new TreeNode(1);TreeNode n3=tester.new TreeNode(1);
		TreeNode n4=tester.new TreeNode(1);TreeNode n5=tester.new TreeNode(1);
		TreeNode n6=tester.new TreeNode(1);
		n0.left=n1;n0.right=n2;n2.left=n3;n2.right=n4;n3.left=n6;n3.right=n5;
		assertTrue(!tester.isCompleteTree(n0));
	}
}
