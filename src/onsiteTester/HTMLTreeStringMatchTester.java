package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.HTMLTreeStringMatch;
import onsite.HTMLTreeStringMatch.TreeNode;

public class HTMLTreeStringMatchTester {
/*
 *  			<!html>
            /        |        \
        <I>    </I>    </B>
         /           |          \
      This       <B>       fun
                     |
                     is
 */
	@Test
	public void test() {
		HTMLTreeStringMatch tester=new HTMLTreeStringMatch();
		TreeNode n1=tester.new TreeNode("<!html>");TreeNode n2=tester.new TreeNode("<I>");
		TreeNode n3=tester.new TreeNode("</I>");TreeNode n4=tester.new TreeNode("</B>");
		TreeNode n5=tester.new TreeNode("This");TreeNode n6=tester.new TreeNode("<B>");
		TreeNode n7=tester.new TreeNode("fun");TreeNode n8=tester.new TreeNode("is");
		n1.child.add(n2);n1.child.add(n3);n1.child.add(n4);n2.child.add(n5);
		n3.child.add(n6);n4.child.add(n7);n6.child.add(n8);
		List<TreeNode> r1=tester.findMatchedNodes(n1, "his");
		assertTrue(r1.size()==1&&r1.get(0)==n5);
		List<TreeNode> r2=tester.findMatchedNodes(n1, "isis");
		assertTrue(r2.size()==2&&r2.get(0)==n5&&r2.get(1)==n8);
		List<TreeNode> r3=tester.findMatchedNodes(n1, "hisisfu");
		assertTrue(r3.size()==3&&r3.get(0)==n5&&r3.get(1)==n8&&r3.get(2)==n7);
		List<TreeNode> r4=tester.findMatchedNodes(n1, "Thisisfun");
		assertTrue(r4.size()==3&&r4.get(0)==n5&&r4.get(1)==n8&&r4.get(2)==n7);
	}

}
