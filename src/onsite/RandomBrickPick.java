package onsite;
/*
给一个呆子，呆子里有k中砖投，每种砖投的个数是Nk个，现在随机从呆子里拿砖投，拿出来以后不放回，写一个class 实现这个功能
假设 n1 + n2 + … + nk = N
第一种解法是用树组来存所有，那么空间复杂度O(N) 取转投复杂度O(1)
Follow up
对空间复杂度不满意
存每中转头的个数，然后岁机生成一个1到N之间的数来却定是哪种砖投 空间复杂度O(k)
取转头复杂度O(k)
Follow up
对空间复杂度满意 对时间复杂度优化
用二份索引树 + 二份搜索可以达到 (log(n))^2的取转头复杂度
用瓶亨而叉树变形可以实现log(n)的取砖投复杂度
*/
public class RandomBrickPick {
	class TreeNode{
		int brickID;
		int currTotal;
		int leftTotal;
		TreeNode left;
		TreeNode right;
		public TreeNode(int brickID,int currTotal){
			this.brickID=brickID;
			this.currTotal=currTotal;
		}
	}
	class Tracker{
		TreeNode node;
		int totalNodeCount;
		public Tracker(TreeNode node,int totalNodeCount){
			this.node=node;
			this.totalNodeCount=totalNodeCount;
		}
	}
	private Tracker buildTree(int start,int end,int[] bricks){
		if(start>end){
			return new Tracker(null,0);
		}
		int mid=start+(end-start)/2;
		TreeNode curr=new TreeNode(mid,bricks[mid]);
		Tracker l=buildTree(start,mid-1,bricks);
		Tracker r=buildTree(mid+1,end,bricks);
		curr.left=l.node;
		curr.right=r.node;
		curr.leftTotal=l.totalNodeCount;
		return new Tracker(curr,curr.currTotal+l.totalNodeCount+r.totalNodeCount);
	}
	private int lookUpPos(TreeNode currNode,int index){
		if(currNode==null){
			return -1;
		}
		int l=currNode.leftTotal;
		int m=currNode.currTotal;
		if(index<l){
			currNode.leftTotal--;
			return lookUpPos(currNode.left,index);
		}
		else if(index<l+m){
			currNode.currTotal--;
			return currNode.brickID;
		}
		else{
			return lookUpPos(currNode.right,index-l-m);
		}
	}
	
	TreeNode root;
	int total;
	public RandomBrickPick(int[] bricks){
		if(bricks==null){
			return;
		}
		for(int i=0;i<bricks.length;i++){
			total=total+bricks[i];
		}
		this.root=buildTree(0,bricks.length-1,bricks).node;
	}
	
	public int pickBrick(){
		if(this.total<=0){
			return -1;
		}
		int index=(int)(Math.random()*total);
		this.total--;
		return lookUpPos(this.root,index);
	}
}
