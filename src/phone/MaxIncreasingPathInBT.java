package phone;
import java.util.*;
//题目是 一棵树里 从上到下找最长的 increasing path
public class MaxIncreasingPathInBT {
	public class TreeNode{
		public TreeNode left;
		public TreeNode right;
		public int val;
		public TreeNode(int val){
			this.val=val;
		}
	}
	public int findMaxIncreasingPath(TreeNode root){
		if(root==null){
			return 0;
		}
		Queue<TreeNode> nodes=new LinkedList<TreeNode>();
		Queue<Integer> lens=new LinkedList<Integer>();
		nodes.offer(root);
		lens.offer(1);
		int max=0;
		while(!nodes.isEmpty()){
			int size=nodes.size();
			for(int i=0;i<size;i++){
				TreeNode curr=nodes.poll();
				int currLen=lens.poll();
				max=Math.max(max, currLen);
				if(curr.left!=null){
					if(curr.left.val>=curr.val){
						lens.offer(currLen+1);
					}
					else{
						lens.offer(1);
					}
					nodes.offer(curr.left);
				}
				if(curr.right!=null){
					if(curr.right.val>=curr.val){
						lens.offer(currLen+1);
					}
					else{
						lens.offer(1);
					}
					nodes.offer(curr.right);
				}
			}
		}
		return max;
	}
}
