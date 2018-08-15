package onsite;

import java.util.Iterator;

public class BinaryTreeWithParentLeafSum {
	public class TreeNode{
		public TreeNode parent;
		public TreeNode left;
		public TreeNode right;
		int val;
		public TreeNode(int val){
			this.val=val;
		}
	}
	public int calLeafSum(TreeNode root){
		if(root==null){
			return 0;
		}
		TreeNode curr=root;
		while(curr.left!=null){
			curr=curr.left;
		}
		TreeNodeIterator it=new TreeNodeIterator(curr);
		int totalSum=0;
		while(it.hasNext()){
			curr=it.next();
			if(curr.left==null&&curr.right==null){
				totalSum=totalSum+curr.val;
			}
		}
		return totalSum;
	}
	class TreeNodeIterator implements Iterator<TreeNode>{
		TreeNode currNode;
		public TreeNodeIterator(TreeNode firstNode){
			this.currNode=firstNode;
		}
		public boolean hasNext(){
			return this.currNode!=null;
		}
		public TreeNode next(){
			TreeNode res=currNode;
			if(currNode.right!=null){
				currNode=currNode.right;
				while(currNode.left!=null){
					currNode=currNode.left;
				}
			}
			else{
				TreeNode parent=currNode.parent;
				while(parent!=null&&parent.right==currNode){
					currNode=parent;
					parent=currNode.parent;
				}
				currNode=parent;
			}
			return res;
		}
	}
}
