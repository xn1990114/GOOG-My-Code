package onsite;
/*
 * 一棵树，所有节点的value都是正整数，问只能增加某些节点值的情况下，
 * 如何调整使得从root到所有leaf的path上经过的节点值之和相等，返回增加的值的和，使这个和最小
 */
public class TreeWithEqualPathSum {
	public class TreeNode{
		int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val){
			this.val=val;
		}
	}
	public int findMinAddition(TreeNode root){
		int[] res={0};
		calSum(root,res);
		return res[0];
	}
	public int calSum(TreeNode curr,int[] res){
		if(curr==null){
			return 0;
		}
		int l=calSum(curr.left, res);
		int r=calSum(curr.right,res);
		if(curr.left!=null&&curr.right!=null){
			int diff=Math.abs(l-r);
			res[0]=res[0]+diff;
		}
		return curr.val+Math.max(l, r);
	}
}
