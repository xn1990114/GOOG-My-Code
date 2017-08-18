package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.ReversePrintN_naryTree;
import onsite.ReversePrintN_naryTree.Node;
/*
 * 							11
 *            21 		null       22                      23
 *        31  32 33         34     35    36   37         38       39      
 *        41					  42 43 			   44 45 46
 *        						51								52 53 
 *        					    61
 *        
 */
public class ReversePrintN_aryTreeTester {

	@Test
	public void test() {
		ReversePrintN_naryTree printer=new ReversePrintN_naryTree();
		Node n11=printer.new Node(11,4);
		Node n21=printer.new Node(21,3);Node n22=printer.new Node(22,4);
		Node n23=printer.new Node(23,3);
		Node n31=printer.new Node(31,1);Node n32=printer.new Node(32,0);
		Node n33=printer.new Node(33,4);Node n34=printer.new Node(34,1);
		Node n35=printer.new Node(35,2);Node n36=printer.new Node(36,1);
		Node n37=printer.new Node(37,1);Node n38=printer.new Node(38,4);
		Node n39=printer.new Node(39,1);
		Node n41=printer.new Node(41,4);Node n42=printer.new Node(42,1);
		Node n43=printer.new Node(43,1);Node n44=printer.new Node(44,0);
		Node n45=printer.new Node(45,1);Node n46=printer.new Node(46,3);
		Node n51=printer.new Node(51,4);Node n52=printer.new Node(52,0);
		Node n53=printer.new Node(53,1);Node n61=printer.new Node(61,1);
		n11.child[0]=n21;n11.child[2]=n22;n11.child[3]=n23;
		n21.child[0]=n31;n21.child[1]=n32;n21.child[2]=n33;
		n22.child[0]=n34;n22.child[1]=n35;n22.child[2]=n36;n22.child[3]=n37;
		n23.child[0]=n38;n23.child[1]=n39;
		n31.child[0]=n41;n35.child[0]=n42;n35.child[1]=n43;
		n38.child[0]=n44;n38.child[1]=n45;n38.child[2]=n46;
		n42.child[0]=n51;n46.child[0]=n52;n46.child[1]=n53;
		n51.child[0]=n61;
		printer.reversePrint(n11);
	}

}
