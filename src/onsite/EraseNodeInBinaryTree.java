package onsite;
import java.util.*;
/*
 * 给你一个树，一个函数shouldBeEreased，你可以测试树中的每个节点是否需要被删除，
 * 返回一个list，保存这个树被删完一些结点后生成的子树。
例子：
                            a
                 b                      c
            d       e              f        g
比如这个树删掉了b和f，返回的list应该为[a, d, e]
 */
public class EraseNodeInBinaryTree {
	public class TreeNode{
		public char val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(char ch){
			this.val=ch;
		}
	}
	public List<TreeNode> getRemainingNode(TreeNode root,Set<TreeNode> toremove){
		List<TreeNode> res=new ArrayList<TreeNode>();
		searchNode(root,res,toremove,null);
		return res;
	}
	public void searchNode(TreeNode curr,List<TreeNode> res,Set<TreeNode> toremove,TreeNode parent){
		if(curr==null){
			return;
		}
		if(toremove.contains(curr)){
			if(parent!=null) {
				if(parent.left==curr) {
					parent.left=null;
				}
				else {
					parent.right=null;
				}
			}
			searchNode(curr.left,res,toremove,null);
			searchNode(curr.right,res,toremove,null);
		}
		else{
			if(parent==null){
				res.add(curr);
			}
			searchNode(curr.left,res,toremove,curr);
			searchNode(curr.right,res,toremove,curr);
		}
	}
}
