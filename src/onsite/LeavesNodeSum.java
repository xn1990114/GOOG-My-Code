package onsite;
//给一个二叉树，每个node有一个指向其父节点的指针，不可以修改树，求该树所有叶子节点的和，要求o1空间
public class LeavesNodeSum {
	public class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode parent;
		public TreeNode(int val){
			this.val=val;
		}
	}
	public int findSum(TreeNode root){
		if(root==null){
			return 0;
		}
		TreeNode curr=root;
		while(curr.left!=null){
			curr=curr.left;
		}
		int res=0;
		while(curr!=null){
			if(curr.left==null&&curr.right==null){
				res=res+curr.val;
			}
			curr=findNext(curr);
		}
		return res;
	}
	public TreeNode findNext(TreeNode curr){
		if(curr==null){
			return null;
		}
		TreeNode next=curr.right;
		if(next==null){
			TreeNode last=curr;
			next=curr.parent;
			while(next!=null&&next.right==last){
				last=next;
				next=next.parent;
			}
		}
		else{
			while(next.left!=null){
				next=next.left;
			}
		}
		return next;
	}
}
