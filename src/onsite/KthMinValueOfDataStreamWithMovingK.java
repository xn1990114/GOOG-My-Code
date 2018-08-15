package onsite;
/*
 * 实现找k-th 最小的数api/数据结构，数据是在不断增加的, k也是在变的。 
 * brute force就是来一个 新数，就插入到一个数组中，O(n); 然后提出了用binary search tree + 存左树的结点数量，这样 能做到 log(n) 插入和查找。
 */
public class KthMinValueOfDataStreamWithMovingK {
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		int currCount;
		int leftCount;
		public TreeNode(int val){
			this.val=val;
			this.currCount=1;
			this.leftCount=0;
		}
	}
	TreeNode root;
	public KthMinValueOfDataStreamWithMovingK(){
		this.root=null;
	}
	public void insertValue(int val){
		if(this.root==null){
			this.root=new TreeNode(val);
			return;
		}
		TreeNode curr=root;
		while(curr.val!=val){
			if(curr.val>val){
				curr.leftCount++;
				if(curr.left==null){
					curr.left=new TreeNode(val);
					return;
				}
				curr=curr.left;
			}
			else if(curr.val<val){
				if(curr.right==null){
					curr.right=new TreeNode(val);
					return;
				}
				curr=curr.right;
			}
		}
		curr.currCount++;
	}
	public Integer getKthMinVal(int k){
		if(k<=0){
			return null;
		}
		TreeNode curr=root;
		while(curr!=null){
			if(k<=curr.leftCount){
				curr=curr.left;
			}
			else if(k<=curr.leftCount+curr.currCount){
				return curr.val;
			}
			else{
				k=k-curr.leftCount-curr.currCount;
				curr=curr.right;
			}
		}
		return null;
	}
}
