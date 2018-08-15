package onsite;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
	public class TreeNode{
		public TreeNode left;
		public TreeNode right;
		public int val;
		public TreeNode(int val){
			this.val=val;
		}
	}
	public boolean isCompleteTree(TreeNode root){
		if(root==null){
			return true;
		}
		Queue<TreeNode> qu=new LinkedList<TreeNode>();
		qu.offer(root);
		boolean seenNull=false;
		int level=0;
		while(!qu.isEmpty()&&!seenNull){
			int size=qu.size();
			if(size!=(1<<level)){
				return false;
			}
			for(int round=0;round<size;round++){
				TreeNode top=qu.poll();
				if(top==null){
					seenNull=true;
				}
				else{
					if(seenNull){
						return false;
					}
					qu.offer(top.left);
					qu.offer(top.right);
				}
			}
			level++;
		}
		while(!qu.isEmpty()){
			if(qu.poll()!=null){
				return false;
			}
		}
		return true;
	}
}
