package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.ConvertGraphToBinaryTree;
import onsite.ConvertGraphToBinaryTree.GraphNode;

public class ConvertGraphToBinaryTreeTester {
/*
 * 					
 *   		9-	1  -2 - 3 - 4
 *   		  / |    \    \
 *   		 5  6     7	    8
 *   
 *   
 *   
 *   
 */
	@Test
	public void test1() {
		ConvertGraphToBinaryTree tester=new ConvertGraphToBinaryTree();
		GraphNode n1=tester.new GraphNode(1);GraphNode n2=tester.new GraphNode(2);
		GraphNode n3=tester.new GraphNode(3);GraphNode n4=tester.new GraphNode(4);
		GraphNode n5=tester.new GraphNode(5);GraphNode n6=tester.new GraphNode(6);
		GraphNode n7=tester.new GraphNode(7);GraphNode n8=tester.new GraphNode(8);
		GraphNode n9=tester.new GraphNode(9);
		n1.neighbor.add(n2);n1.neighbor.add(n5);n1.neighbor.add(n6);n1.neighbor.add(n9);
		n2.neighbor.add(n1);n2.neighbor.add(n3);n2.neighbor.add(n7);
		n3.neighbor.add(n2);n3.neighbor.add(n4);n3.neighbor.add(n8);
		n4.neighbor.add(n3);n5.neighbor.add(n1);n6.neighbor.add(n1);
		n7.neighbor.add(n2);n8.neighbor.add(n3);n9.neighbor.add(n1);
		assertTrue(!tester.isBinaryTree(n1));
		GraphNode root=tester.convertToBinaryTree(n1);
		GraphNode last=null;
		GraphNode curr=root;
		while(curr!=null){
			System.out.print(curr.val+"->");
			if(curr.neighbor.size()<=1&&root!=curr){
				break;
			}
			for(int i=0;i<curr.neighbor.size();i++){
				GraphNode next=curr.neighbor.get(i);
				if(next!=last){
					last=curr;
					curr=next;
					break;
				}
			}
			
		}
		System.out.println();
	}
	/*
	 * 					
	 *   		9-	1  -2 - 3 - 4
	 *   		  / |    \    \
	 *   		 5  6   - 7-    8
	 *   
	 *   
	 *   
	 *   
	 */
		@Test
		public void test2() {
			ConvertGraphToBinaryTree tester=new ConvertGraphToBinaryTree();
			GraphNode n1=tester.new GraphNode(1);GraphNode n2=tester.new GraphNode(2);
			GraphNode n3=tester.new GraphNode(3);GraphNode n4=tester.new GraphNode(4);
			GraphNode n5=tester.new GraphNode(5);GraphNode n6=tester.new GraphNode(6);
			GraphNode n7=tester.new GraphNode(7);GraphNode n8=tester.new GraphNode(8);
			GraphNode n9=tester.new GraphNode(9);
			n1.neighbor.add(n2);n1.neighbor.add(n5);n1.neighbor.add(n6);n1.neighbor.add(n9);
			n2.neighbor.add(n1);n2.neighbor.add(n3);n2.neighbor.add(n7);
			n3.neighbor.add(n2);n3.neighbor.add(n4);n3.neighbor.add(n8);
			n4.neighbor.add(n3);n5.neighbor.add(n1);n6.neighbor.add(n1);
			n7.neighbor.add(n2);n8.neighbor.add(n3);n9.neighbor.add(n1);
			n7.neighbor.add(n6);n6.neighbor.add(n7);n7.neighbor.add(n8);
			n8.neighbor.add(n7);
			assertTrue(!tester.isBinaryTree(n1));
			GraphNode root=tester.convertToBinaryTree(n1);
			GraphNode last=null;
			GraphNode curr=root;
			while(curr!=null){
				System.out.print(curr.val+"->");
				if(curr.neighbor.size()<=1&&root!=curr){
					break;
				}
				for(int i=0;i<curr.neighbor.size();i++){
					GraphNode next=curr.neighbor.get(i);
					if(next!=last){
						last=curr;
						curr=next;
						break;
					}
				}
				
			}
			System.out.println();
		}
		/*
		 * 					
		 *   		9-	1  -2 - 3 - 4
		 *   		  / |    \    \
		 *   		 5  6 -    7	    8
		 *   
		 *   
		 *   
		 *   
		 */
			@Test
			public void test3() {
				ConvertGraphToBinaryTree tester=new ConvertGraphToBinaryTree();
				GraphNode n1=tester.new GraphNode(1);GraphNode n2=tester.new GraphNode(2);
				GraphNode n3=tester.new GraphNode(3);GraphNode n4=tester.new GraphNode(4);
				GraphNode n5=tester.new GraphNode(5);GraphNode n6=tester.new GraphNode(6);
				GraphNode n7=tester.new GraphNode(7);GraphNode n8=tester.new GraphNode(8);
				GraphNode n9=tester.new GraphNode(9);
				n1.neighbor.add(n2);n1.neighbor.add(n6);
				n2.neighbor.add(n1);n2.neighbor.add(n3);n2.neighbor.add(n7);
				n3.neighbor.add(n2);n3.neighbor.add(n4);n3.neighbor.add(n8);
				n4.neighbor.add(n3);n6.neighbor.add(n1);
				n6.neighbor.add(n7);n7.neighbor.add(n6);
				n7.neighbor.add(n2);n8.neighbor.add(n3);
				assertTrue(!tester.isBinaryTree(n1));
				GraphNode root=tester.convertToBinaryTree(n1);
				GraphNode last=null;
				GraphNode curr=root;
				while(curr!=null){
					System.out.print(curr.val+"->");
					if(curr.neighbor.size()<=1&&root!=curr){
						break;
					}
					for(int i=0;i<curr.neighbor.size();i++){
						GraphNode next=curr.neighbor.get(i);
						if(next!=last){
							last=curr;
							curr=next;
							break;
						}
					}
					
				}
				System.out.println();
			}
			/*
			 * 					
			 *   		9-	1  -2 - 3 - 4
			 *   		  / |    \    \
			 *   		 5  6     7	    8
			 *   
			 *   
			 *   
			 *   
			 */
				@Test
				public void test4() {
					ConvertGraphToBinaryTree tester=new ConvertGraphToBinaryTree();
					GraphNode n1=tester.new GraphNode(1);GraphNode n2=tester.new GraphNode(2);
					GraphNode n3=tester.new GraphNode(3);GraphNode n4=tester.new GraphNode(4);
					GraphNode n5=tester.new GraphNode(5);GraphNode n6=tester.new GraphNode(6);
					GraphNode n7=tester.new GraphNode(7);GraphNode n8=tester.new GraphNode(8);
					GraphNode n9=tester.new GraphNode(9);
					n1.neighbor.add(n2);n1.neighbor.add(n6);
					n2.neighbor.add(n1);n2.neighbor.add(n3);n2.neighbor.add(n7);
					n3.neighbor.add(n2);n3.neighbor.add(n4);n3.neighbor.add(n8);
					n4.neighbor.add(n3);n6.neighbor.add(n1);
					n7.neighbor.add(n2);n8.neighbor.add(n3);
					assertTrue(tester.isBinaryTree(n1));
					GraphNode root=tester.convertToBinaryTree(n1);
					GraphNode last=null;
					GraphNode curr=root;
					while(curr!=null){
						System.out.print(curr.val+"->");
						if(curr.neighbor.size()<=1&&root!=curr){
							break;
						}
						for(int i=0;i<curr.neighbor.size();i++){
							GraphNode next=curr.neighbor.get(i);
							if(next!=last){
								last=curr;
								curr=next;
								break;
							}
						}
						
					}
					System.out.println();
				}
}
