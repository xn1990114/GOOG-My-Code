package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.ReverseTraversalOfNnaryTree;
import onsite.ReverseTraversalOfNnaryTree.TreeNode;

public class ReverseTraversalOfNnaryTreeTester {
/*
 * 					1
 * 			2      3             4
 * 		5    6        7        8
 *                  9   10
 * 
 * 
 * 
 * 
 */
	@Test
	public void test() {
		ReverseTraversalOfNnaryTree tester=new ReverseTraversalOfNnaryTree();
		TreeNode n1=tester.new TreeNode(1);TreeNode n2=tester.new TreeNode(2);
		TreeNode n3=tester.new TreeNode(3);TreeNode n4=tester.new TreeNode(4);
		TreeNode n5=tester.new TreeNode(5);TreeNode n6=tester.new TreeNode(6);
		TreeNode n7=tester.new TreeNode(7);TreeNode n8=tester.new TreeNode(8);
		TreeNode n9=tester.new TreeNode(9);TreeNode n10=tester.new TreeNode(10);
		n1.child.add(n2);n1.child.add(n3);n1.child.add(n4);
		n2.child.add(n5);n2.child.add(n6);n3.child.add(n7);n4.child.add(n8);
		n7.child.add(n9);n7.child.add(n10);
		TreeNode[] r1=tester.convertToArrayWithInOrderTraversal(n1);
		
		for(int i=0;i<r1.length;i++){
			System.out.print(r1[i].val+"->"+r1[i].parentIndex+"\t");
		}
		System.out.println();
		
	}
	@Test
	public void test2() {
		ReverseTraversalOfNnaryTree tester=new ReverseTraversalOfNnaryTree();
		TreeNode n1=tester.new TreeNode(1);TreeNode n2=tester.new TreeNode(2);
		TreeNode n3=tester.new TreeNode(3);TreeNode n4=tester.new TreeNode(4);
		TreeNode n5=tester.new TreeNode(5);TreeNode n6=tester.new TreeNode(6);
		TreeNode n7=tester.new TreeNode(7);TreeNode n8=tester.new TreeNode(8);
		TreeNode n9=tester.new TreeNode(9);TreeNode n10=tester.new TreeNode(10);
		n1.child.add(n2);n1.child.add(n3);n1.child.add(n4);
		n2.child.add(n5);n2.child.add(n6);n3.child.add(n7);n4.child.add(n8);
		n7.child.add(n9);n7.child.add(n10);
		
		TreeNode[] r2=tester.convertToArrayWithPostOrderTraversal(n1);
		
		for(int i=0;i<r2.length;i++){
			System.out.print(r2[i].val+"->"+r2[i].parentIndex+"\t");
		}
	}

}
