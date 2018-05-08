package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.NodeDistanceInTree;
import onsite.NodeDistanceInTree.TreeNode;

public class NodeDistanceInTreeTester {
/*
 *  		A         
 *        ／ |  |  \
  		B   C  D    E
          	|         \
            F          G
 */
	@Test
	public void test1() {
		NodeDistanceInTree tester=new NodeDistanceInTree();
		TreeNode a=tester.new TreeNode('A');TreeNode b=tester.new TreeNode('B');
		TreeNode c=tester.new TreeNode('C');TreeNode d=tester.new TreeNode('D');
		TreeNode e=tester.new TreeNode('E');TreeNode f=tester.new TreeNode('F');
		TreeNode g=tester.new TreeNode('G');
		a.child.add(b);a.child.add(c);a.child.add(d);a.child.add(e);
		e.child.add(g);c.child.add(f);
		tester.calTotalDistance(a);
		assertTrue(a.getTotalDis()==8);
		assertTrue(b.getTotalDis()==13);
		assertTrue(c.getTotalDis()==11);

		assertTrue(e.getTotalDis()==11);
		assertTrue(g.getTotalDis()==16);
		assertTrue(f.getTotalDis()==16);
	}
	/*
	 *  		A         
	 *        ／ |  |  \
	  		B   C  D    E
	       |   	|         \
	       J    F          G
	            |\			/|\
	            H I        K L M
	  
	            
	            
	 */
	@Test
	public void test2() {
		NodeDistanceInTree tester=new NodeDistanceInTree();
		TreeNode a=tester.new TreeNode('A');TreeNode b=tester.new TreeNode('B');
		TreeNode c=tester.new TreeNode('C');TreeNode d=tester.new TreeNode('D');
		TreeNode e=tester.new TreeNode('E');TreeNode f=tester.new TreeNode('F');
		TreeNode g=tester.new TreeNode('G');TreeNode h=tester.new TreeNode('H');
		TreeNode i=tester.new TreeNode('I');TreeNode j=tester.new TreeNode('J');
		TreeNode k=tester.new TreeNode('K');TreeNode l=tester.new TreeNode('L');
		TreeNode m=tester.new TreeNode('M');
		a.child.add(b);a.child.add(c);a.child.add(d);a.child.add(e);
		e.child.add(g);c.child.add(f);b.child.add(j);f.child.add(h);f.child.add(i);
		g.child.add(k);g.child.add(l);g.child.add(m);
		tester.calTotalDistance(a);
		assertTrue(a.getTotalDis()==25);
		assertTrue(b.getTotalDis()==34);
		assertTrue(f.getTotalDis()==37);
		assertTrue(m.getTotalDis()==44);
	}

}
