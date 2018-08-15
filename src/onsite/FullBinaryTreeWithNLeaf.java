package onsite;
import java.util.*;
//输入一个整数n 输出叶子树量为n的所有full binary tree
public class FullBinaryTreeWithNLeaf {
	public class TreeNode{
		TreeNode left;
		TreeNode right;
		char val;
		public TreeNode(){
			this.val='N';
		}
	}
	public List<TreeNode> buildAllTrees(int n){
		List<TreeNode> res=new ArrayList<TreeNode>();
		if(n<=0){
			res.add(null);
			return res;
		}
		List<String>[] serializedSubTrees=new List[n+1];
		pupulateSubTrees(serializedSubTrees,n);
		List<String> targetSizeTree=serializedSubTrees[n];
		for(int i=0;i<targetSizeTree.size();i++){
			res.add(deserialize(targetSizeTree.get(i)));
		}
		return res;
	}
	private List<String> pupulateSubTrees(List<String>[] serializedSubTrees, int n) {
		if(serializedSubTrees[n]!=null){
			return serializedSubTrees[n];
		}
		if(n==1){
			List<String> toadd=new ArrayList<String>();
			toadd.add("N,null,null");
			serializedSubTrees[n]=toadd;
			return toadd;
		}
		List<String> res=new ArrayList<String>();
		for(int left=1;left<n;left++){
			List<String> l=pupulateSubTrees(serializedSubTrees,left);
			List<String> r=pupulateSubTrees(serializedSubTrees,n-left);
			for(String leftChild:l){
				for(String rightChild:r){
					res.add("N,"+leftChild+","+rightChild);
				}
			}
		}
		serializedSubTrees[n]=res;
		return res;
	}
	public TreeNode deserialize(String s){
		if(s==null||s.length()==0){
			return null;
		}
		String[] data=s.split(",");
		TreeNode root=new TreeNode();
		boolean right=false;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		for(int i=1;i<data.length;i++){
			if(data[i].equals("null")){
				if(!right){
					right=true;
				}
				else{
					stack.pop();
					right=true;
				}
			}
			else{
				TreeNode toadd=new TreeNode();
				if(!right){
					stack.peek().left=toadd;
					right=false;
					stack.push(toadd);
				}
				else{
					stack.peek().right=toadd;
					stack.pop();
					stack.push(toadd);
					right=false;
				}
			}
		}
		return root;
	}
	public void displayTree(TreeNode root){
		if(root==null){
			System.out.println("Empty");
			return;
		}
		Queue<TreeNode> qu=new LinkedList<TreeNode>();
		qu.offer(root);
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int round=0;round<size;round++){
				TreeNode top=qu.poll();
				if(top==null){
					System.out.print("null"+"\t");
				}
				else{
					System.out.print("Node"+"\t");
					qu.offer(top.left);
					qu.offer(top.right);
				}
			}
			System.out.println();
		}
	}
}
