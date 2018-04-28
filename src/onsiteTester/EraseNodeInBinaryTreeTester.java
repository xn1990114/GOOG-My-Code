package onsiteTester;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import onsite.EraseNodeInBinaryTree;
import onsite.EraseNodeInBinaryTree.TreeNode;
/*
 *           				a
                 b                      c
            d       e              f        g
 */
public class EraseNodeInBinaryTreeTester {

	@Test
	public void test() {
		EraseNodeInBinaryTree tester=new EraseNodeInBinaryTree();
		TreeNode a=tester.new TreeNode('a');TreeNode b=tester.new TreeNode('b');
		TreeNode c=tester.new TreeNode('c');TreeNode d=tester.new TreeNode('d');
		TreeNode e=tester.new TreeNode('e');TreeNode f=tester.new TreeNode('f');
		TreeNode g=tester.new TreeNode('g');
		a.left=b;a.right=c;b.left=d;b.right=e;c.left=f;c.right=g;
		Set<TreeNode> toremove=new HashSet<TreeNode>();
		toremove.add(b);toremove.add(f);
		TreeNode[] res={a,d,e};
		List<TreeNode> r=tester.getRemainingNode(a, toremove);
		for(int i=0;i<res.length;i++){
			assertTrue(res[i]==r.get(i));
		}
	}

}
