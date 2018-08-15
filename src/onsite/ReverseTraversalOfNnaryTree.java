package onsite;
import java.util.*;
/*
 * n-ary tree， 要求遍历的时候child必须排在parent前面。
 * 输出结果存在一个array里面，要求child 存parent 在array里面的index。 要求两种方法做 
 */
public class ReverseTraversalOfNnaryTree {
	public class TreeNode{
		public List<TreeNode> child;
		public int parentIndex;
		public int val;
		public TreeNode(int val){
			this.val=val;
			this.parentIndex=-1;
			this.child=new ArrayList<TreeNode>();
		}
	}
	public TreeNode[] convertToArrayWithInOrderTraversal(TreeNode root){
		if(root==null){
			return new TreeNode[0];
		}
		List<TreeNode> nodeList=new ArrayList<TreeNode>();
		Queue<TreeNode> qu=new LinkedList<TreeNode>();
		qu.offer(root);
		while(!qu.isEmpty()){
			TreeNode top=qu.poll();
			nodeList.add(top);
			int parentIndex=nodeList.size()-1;
			List<TreeNode> child=top.child;
			for(int i=0;i<child.size();i++){
				TreeNode c=child.get(i);
				c.parentIndex=parentIndex;
				qu.offer(c);
			}
		}
		TreeNode[] res=new TreeNode[nodeList.size()];
		for(int i=0;i<res.length;i++){
			res[i]=nodeList.get(nodeList.size()-1-i);
			if(res[i].parentIndex!=-1){
				res[i].parentIndex=res.length-1-res[i].parentIndex;
			}
		}
		return res;
	}
	
	public TreeNode[] convertToArrayWithPostOrderTraversal(TreeNode root){
		if(root==null){
			return new TreeNode[0];
		}
		List<TreeNode> nodeList=new ArrayList<TreeNode>();
		buildNodeListWithPostOrder(root,nodeList);
		TreeNode[] res=new TreeNode[nodeList.size()];
		for(int i=0;i<res.length;i++){
			res[i]=nodeList.get(i);
		}
		return res;
	}

	private void buildNodeListWithPostOrder(TreeNode currNode, List<TreeNode> nodeList) {
		if(currNode==null){
			return;
		}
		List<TreeNode> child=currNode.child;
		if(child==null){
			nodeList.add(currNode);
			return;
		}
		for(int i=0;i<child.size();i++){
			buildNodeListWithPostOrder(child.get(i),nodeList);
		}
		int index=nodeList.size();
		nodeList.add(currNode);
		for(int i=0;i<child.size();i++){
			child.get(i).parentIndex=index;
		}
	}
}
