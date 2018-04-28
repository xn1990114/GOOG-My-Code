package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.LeavesNodeSum;
import onsite.LeavesNodeSum.TreeNode;

/*
 * 							5
 * 				4							3
 * 		4				1				7			0
 * 1					  2								6
 * 															4
 * 														  2
 * 
 */
public class LeavesNodeSumTester {

	@Test
	public void test() {
		LeavesNodeSum tester=new LeavesNodeSum();
		TreeNode n1=tester.new TreeNode(5);TreeNode n2=tester.new TreeNode(4);
		TreeNode n3=tester.new TreeNode(3);TreeNode n4=tester.new TreeNode(4);
		TreeNode n5=tester.new TreeNode(1);TreeNode n6=tester.new TreeNode(7);
		TreeNode n7=tester.new TreeNode(0);TreeNode n8=tester.new TreeNode(1);
		TreeNode n9=tester.new TreeNode(2);TreeNode n10=tester.new TreeNode(6);
		TreeNode n11=tester.new TreeNode(4);TreeNode n12=tester.new TreeNode(2);
		n1.left=n2;n1.right=n3;n2.left=n4;n2.right=n5;n3.left=n6;n3.right=n7;
		n4.left=n8; n5.right=n9;n7.right=n10;n10.right=n11;n11.left=n12;
		n2.parent=n1;n3.parent=n1;n4.parent=n2;n5.parent=n2;n6.parent=n3;n7.parent=n3;n8.parent=n4;
		n9.parent=n5;n10.parent=n7;n11.parent=n10;n12.parent=n11;
		assertTrue(tester.findSum(n1)==12);
	}

}
