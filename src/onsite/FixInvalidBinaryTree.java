package onsite;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//对于Binary tree，可能会有一些invalid的情况，比如一个node的left child 或者 right child 指向自己，
//当然也会有其他的情况。求找出第一个这样的invalid并且修复（就是把这个指向null）
public class FixInvalidBinaryTree {
	public class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val){
			this.val=val;
		}
	}
	public void fixTree(TreeNode root){
		if(root==null){
			return;
		}
		Set<TreeNode> visited=new HashSet<TreeNode>();
		visited.add(root);
		Queue<TreeNode> qu=new LinkedList<TreeNode>();
		qu.offer(root);
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int round=0;round<size;round++){
				TreeNode top=qu.poll();
				if(top.left!=null){
					if(visited.contains(top.left)){
						top.left=null;
					}
					else{
						qu.offer(top.left);
						visited.add(top.left);
					}
				}
				if(top.right!=null){
					if(visited.contains(top.right)){
						top.right=null;
					}
					else{
						qu.offer(top.right);
						visited.add(top.right);
					}
				}
			}
		}
	}
	public void printTree(TreeNode root){
		Queue<TreeNode> qu=new LinkedList<TreeNode>();
		qu.offer(root);
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int round=0;round<size;round++){
				TreeNode top=qu.poll();
				if(top==null){
					System.out.print("null");
					System.out.print("\t");
				}
				else{
					System.out.print(top.val);
					System.out.print("\t");
					qu.offer(top.left);
					qu.offer(top.right);
				}
			}
			System.out.println();
		}
	}
}
