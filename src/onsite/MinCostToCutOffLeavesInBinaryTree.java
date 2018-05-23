package onsite;
//有一个二叉树，每个边上有值，怎样选择边cut，能够以最小代价cut 掉所有叶子节点。
public class MinCostToCutOffLeavesInBinaryTree {
	public class TreeNode{
		public int cost;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int cost){
			this.cost=cost;
		}
	}
	public int findMinCost(TreeNode root){
		if(root==null){
			return 0;
		}
		if(root.left==null&&root.right==null){
			return root.cost;
		}
		return Math.min(root.cost, findMinCost(root.left)+findMinCost(root.right));
	}
}
