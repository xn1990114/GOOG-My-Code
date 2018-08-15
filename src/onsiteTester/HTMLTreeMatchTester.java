package onsiteTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import onsite.HTMLTreeMatch;
import onsite.HTMLTreeMatch.TreeNode;

public class HTMLTreeMatchTester {
	/*
	 *  			<!html>
	            /        |        \
	        <I>    </I>    </B>
	         /           |          \
	      This       <B>       fun
	                     |
	                     is
	 */
	/*
	 *  			<!html>
	            /        |        \
	        <I>    </I>    </B>
	         /           |          \
	      That       <B>       fun
	                     |
	                     is
	 */
		@Test
		public void test1() {
			HTMLTreeMatch tester=new HTMLTreeMatch();
			TreeNode n11=tester.new TreeNode("<!html>");TreeNode n12=tester.new TreeNode("<I>");
			TreeNode n13=tester.new TreeNode("</I>");TreeNode n14=tester.new TreeNode("</B>");
			TreeNode n15=tester.new TreeNode("This");TreeNode n16=tester.new TreeNode("<B>");
			TreeNode n17=tester.new TreeNode("fun");TreeNode n18=tester.new TreeNode("is");
			n11.child.add(n12);n11.child.add(n13);n11.child.add(n14);n12.child.add(n15);
			n13.child.add(n16);n14.child.add(n17);n16.child.add(n18);
			
			TreeNode n21=tester.new TreeNode("<!html>");TreeNode n22=tester.new TreeNode("<I>");
			TreeNode n23=tester.new TreeNode("</I>");TreeNode n24=tester.new TreeNode("</B>");
			TreeNode n25=tester.new TreeNode("That");TreeNode n26=tester.new TreeNode("<B>");
			TreeNode n27=tester.new TreeNode("fun");TreeNode n28=tester.new TreeNode("is");
			n21.child.add(n22);n21.child.add(n23);n21.child.add(n24);n22.child.add(n25);
			n23.child.add(n26);n24.child.add(n27);n26.child.add(n28);
			
			assertTrue(!tester.isMatchedTree(n11, n21));
			
		}
	@Test
	public void test2() {
		HTMLTreeMatch tester=new HTMLTreeMatch();
		TreeNode n11=tester.new TreeNode("<!html>");TreeNode n12=tester.new TreeNode("<I>");
		TreeNode n13=tester.new TreeNode("</I>");TreeNode n14=tester.new TreeNode("</B>");
		TreeNode n15=tester.new TreeNode("This");TreeNode n16=tester.new TreeNode("<B>");
		TreeNode n17=tester.new TreeNode("fun");TreeNode n18=tester.new TreeNode("is");
		n11.child.add(n12);n11.child.add(n13);n11.child.add(n14);n12.child.add(n15);
		n13.child.add(n16);n14.child.add(n17);n16.child.add(n18);
		
		TreeNode n21=tester.new TreeNode("<!html>");TreeNode n22=tester.new TreeNode("<I>");
		TreeNode n23=tester.new TreeNode("</I>");TreeNode n24=tester.new TreeNode("</B>");
		TreeNode n25=tester.new TreeNode("Thi");TreeNode n26=tester.new TreeNode("<B>");
		TreeNode n27=tester.new TreeNode("fun");TreeNode n28=tester.new TreeNode("sis");
		n21.child.add(n22);n21.child.add(n23);n21.child.add(n24);n22.child.add(n25);
		n23.child.add(n26);n24.child.add(n27);n26.child.add(n28);
		
		assertTrue(tester.isMatchedTree(n11, n21));
	}

}
