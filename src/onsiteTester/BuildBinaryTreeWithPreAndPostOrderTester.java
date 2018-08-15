package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.BuildBinaryTreeWithPreAndPostOrder;
import onsite.BuildBinaryTreeWithPreAndPostOrder.TreeNode;

public class BuildBinaryTreeWithPreAndPostOrderTester {

	@Test
	public void test() {
		BuildBinaryTreeWithPreAndPostOrder tester=new BuildBinaryTreeWithPreAndPostOrder();
		int[] preOrder={1,2,4,5,6,3};
		int[] postOrder={4,6,5,2,3,1};
		TreeNode root=tester.buildTreeOnPreAndPostOrder(preOrder, postOrder);
		tester.displayTree(root);
	}

}
