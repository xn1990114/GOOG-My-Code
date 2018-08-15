package onsite;

import java.util.LinkedList;
import java.util.Queue;
//给一个sorted array，里面是Integer. return 出一个complete BST。
public class ConvertArrayToCompleteBST {
	public class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val){
			this.val=val;
		}
	}
	public TreeNode convertArrayToCompleteBST(int[] nums){
		if(nums==null||nums.length==0){
			return null;
		}
		return constructTree(nums,0,nums.length-1);
	}
	public TreeNode constructTree(int[] nums,int start,int end){
		if(start>end){
			return null;
		}
		int totalCount=end-start+1;
		int height=calHeight(totalCount);
		int extra=totalCount-((1<<height)-1);
		int leftCount=(1<<(height-1))-1+Math.min(extra, (1<<(height-1)));
		int midIndex=start+leftCount;
		TreeNode res=new TreeNode(nums[midIndex]);
		res.left=constructTree(nums,start,midIndex-1);
		res.right=constructTree(nums,midIndex+1,end);
		return res;
		
	}
	public int calHeight(int nodeCount){
		if(nodeCount==0){
			return 0;
		}
		int height=1;
		while(height<31){
			int curr=(int)Math.pow(2,height)-1;
			int next=(int)Math.pow(2,height+1)-1;
			if(curr<=nodeCount&&next>nodeCount){
				return height;
			}
			height++;
		}
		return -1;
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
