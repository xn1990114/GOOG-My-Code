package phoneTester;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import phone.MaxIncreasingPathInBT;
import phone.MaxIncreasingPathInBT.TreeNode;

public class MaxIncreasingPathTester {
/*
 * 				-5
 * 			7					2
 * 		1		2			4		6
 * 	3			 5 		5	  4    7	10
 * 						  2  3 5
 */
	@Test
	public void test() {
		MaxIncreasingPathInBT tester=new MaxIncreasingPathInBT();
		TreeNode n1=tester.new TreeNode(-5);TreeNode n2=tester.new TreeNode(7);
		TreeNode n3=tester.new TreeNode(1);TreeNode n4=tester.new TreeNode(2);
		TreeNode n5=tester.new TreeNode(3);TreeNode n6=tester.new TreeNode(5);
		TreeNode n7=tester.new TreeNode(2);TreeNode n8=tester.new TreeNode(4);
		TreeNode n9=tester.new TreeNode(6);TreeNode n10=tester.new TreeNode(5);
		TreeNode n11=tester.new TreeNode(4);TreeNode n12=tester.new TreeNode(7);
		TreeNode n13=tester.new TreeNode(10);TreeNode n14=tester.new TreeNode(2);
		TreeNode n15=tester.new TreeNode(3);TreeNode n16=tester.new TreeNode(5);
		n1.left=n2;n2.left=n3;n2.right=n4;n3.left=n5;n4.right=n6;
		n1.right=n7;n7.left=n8;n7.right=n9;n8.left=n10;n8.right=n11;n9.left=n12;
		n9.right=n13;n10.right=n14;n11.left=n15;n11.right=n16;
		assertTrue(tester.findMaxIncreasingPath(n1)==5);
		assertTrue(tester.findMaxIncreasingPath(n2)==2);
		assertTrue(tester.findMaxIncreasingPath(n7)==4);
		n8.right=null;
		assertTrue(tester.findMaxIncreasingPath(n7)==3);
	}

}
