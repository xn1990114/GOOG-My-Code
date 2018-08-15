package onsite;
/*
 * 问我给我一个list of int， 然后给我一个query with start and end index， 问我这个区间的最小值是多少。 
 * 典型的线段树题目。但我还是从最naive的做法开始了。 在给的区间里 一个个compare找最小。 O(n) 解法。 
 * 然后小姐姐先让我写code，然后再来优化。那我就把我学线段树的时候的分析思路说了一遍。 说完她就让我写query的code， 
 * 并没有要我写build的code， 就是假设我有了root来做query。这里真的要多谢地里的小伙伴们把线段树挂在嘴边， 不然我连线段树是啥都不知道。
 */
public class RangeMinimum {
	class TreeNode{
		int start;
		int end;
		int min;
		TreeNode left;
		TreeNode right;
		public TreeNode(int start,int end,int min){
			this.start=start;
			this.end=end;
			this.min=min;
		}
	}
	TreeNode root;
	public RangeMinimum(int[] nums){
		this.root=buildTree(nums,0,nums.length-1);
	}
	public void update(int index,int val){
		updateNode(index,val,root);
	}
	
	public int query(int start,int end){
		return findMin(start,end,root);
	}
	
	private int findMin(int start,int end,TreeNode currNode){
		if(currNode==null||start>currNode.end||end<currNode.start){
			return Integer.MAX_VALUE;
		}
		if(start<=currNode.start&&end>=currNode.end){
			return currNode.min;
		}
		return Math.min(findMin(start,end,currNode.left), findMin(start,end,currNode.right));
	}
	
	private void updateNode(int index,int val,TreeNode currNode){
		if(currNode==null){
			return ;
		}
		if(currNode.start==index&&currNode.end==index){
			currNode.min=val;
			return;
		}
		int mid=currNode.start+(currNode.end-currNode.start)/2;
		if(index<=mid){
			updateNode(index,val,currNode.left);
		}
		else{
			updateNode(index,val,currNode.right);
		}
		currNode.min=Math.min(currNode.left.min, currNode.right.min);
	}
	
	private TreeNode buildTree(int[] nums, int start, int end) {
		if(start>end){
			return null;
		}
		if(start==end){
			return new TreeNode(start,end,nums[start]);
		}
		int mid=start+(end-start)/2;
		TreeNode left=buildTree(nums,start,mid);
		TreeNode right=buildTree(nums,mid+1,end);
		TreeNode curr=new TreeNode(start,end,Math.min(left.min, right.min));
		curr.left=left;
		curr.right=right;
		return curr;
	}
}
