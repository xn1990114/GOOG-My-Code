package onsite;
/*
 * 一个缓存，存最近k个数的middle 90%的平均数，也就是去掉最高5%，去掉最低5%，剩下90%的平均数
 */

import java.util.ArrayList;
import java.util.List;

public class MiddlePortionAverage {
	class TreeNode {
		TreeNode left;
		TreeNode right;
		int leftSum;
		int val;
		int leftCount;
		int currCount;
		public TreeNode(int val,int currCount) {
			this.val=val;
			this.currCount=currCount;
		}
	}
	// assuming round is not concern in the calculation for percentile part
	public List<Double> cal90PercentileAverage(int[] nums,int k) {
		List<Double> res=new ArrayList<Double>();
		TreeNode root=null;
		int left=(int)(k*0.05);
		int right=(int)(k*0.95);
		double middleCount=right-left;
		for(int i=0;i<nums.length;i++) {
			root=insertVal(root,nums[i]);
			if(i>=k-1) {
				double total=calSum(root,right)-calSum(root,left);
				res.add(total/middleCount);
				remove(root,nums[i-k+1]);
			}
		}
		return res;
	}
	public TreeNode insertVal(TreeNode root,int val) {
		if(root==null) {
			return new TreeNode(val,1);
		}
		TreeNode curr=root;
		TreeNode last=null;
		while(curr!=null) {
			last=curr;
			if(curr.val==val) {
				curr.currCount++;
				return root;
			}
			else if(curr.val>val) {
				curr.leftCount++;
				curr.leftSum+=val;
				curr=curr.left;
			}
			else {
				curr=curr.right;
			}
		}
		TreeNode toadd=new TreeNode(val,1);
		if(last.val<val) {
			last.right=toadd;
		}
		else {
			last.left=toadd;
		}
		return root;
	}
	public void remove(TreeNode root,int val) {
		TreeNode curr=root;
		while(curr!=null) {
			if(curr.val==val) {
				curr.currCount--;
				return ;
			}
			else if(curr.val>val) {
				curr.leftCount--;
				curr.leftSum-=val;
				curr=curr.left;
			}
			else {
				curr=curr.right;
			}
		}
	}
	public int calSum(TreeNode root,int count) {
		int res=0;
		TreeNode curr=root;
		int currCount=0;
		while(curr!=null) {
			if(currCount+curr.leftCount<=count&&currCount+curr.leftCount+curr.currCount>=count) {
				return res+curr.leftSum+(count-currCount-curr.leftCount)*curr.val;
			}
			else if(currCount+curr.leftCount>count){
				curr=curr.left;
			}
			else {
				res=res+curr.leftCount+curr.currCount*curr.val;
				currCount+=curr.leftCount+curr.currCount;
				curr=curr.right;
			}
		}
		return res;
	}
}
