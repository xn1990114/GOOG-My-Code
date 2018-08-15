package onsiteTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import onsite.FullBinaryTreeWithNLeaf;
import onsite.FullBinaryTreeWithNLeaf.TreeNode;

public class FullBinaryTreeWithNLeafTester {

	@Test
	public void test1() {
		FullBinaryTreeWithNLeaf tester=new FullBinaryTreeWithNLeaf();
		List<TreeNode> res=tester.buildAllTrees(5);
		for(TreeNode root:res){
			tester.displayTree(root);
		}
	}
	@Test
	public void test2() {
		FullBinaryTreeWithNLeaf tester=new FullBinaryTreeWithNLeaf();
		List<TreeNode> res=tester.buildAllTrees(4);
		for(TreeNode root:res){
			tester.displayTree(root);
		}
	}
}
