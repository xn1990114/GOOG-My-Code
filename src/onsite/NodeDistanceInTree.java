package onsite;
import java.util.*;
/*
 * design 一个function such that return the total distance from this node to any other nodes 
 * 给的树 是 多枝树 n-ary tree 每个edge distance 为1.
如      A         Asssume function name as D:   then D(A) = 1+1+1+1+2+2. D(B) = 1+2+2+2+3+3 = 13
      ／ |  |  \
  B      C  D  E
          |         \
          F          G
 */
public class NodeDistanceInTree {
	public class TreeNode {
		public char id;
		public List<TreeNode> child;
		public List<int[]> childDis;
		public int parentTotal;
		public TreeNode(char id){
			this.child=new ArrayList<TreeNode>();
			this.childDis=new ArrayList<int[]>();
			this.id=id;
			this.parentTotal=0;
		}
		public int getTotalChildCount(){
			int res=0;
			for(int i=0;i<this.childDis.size();i++){
				res=res+childDis.get(i)[0];
			}
			return res;
		}
		public int getTotalChildDis(){
			int res=0;
			for(int i=0;i<this.childDis.size();i++){
				res=res+childDis.get(i)[1];
			}
			return res;
		}
		public int getTotalDis(){
			return this.getTotalChildDis()+this.parentTotal;
		}
	}
	public void calTotalDistance(TreeNode root){
		updateChildTotal(root);
		updateParentTotal(root,0,0);
	}
	public int[] updateChildTotal(TreeNode root){
		if(root==null){
			return new int[]{-1,-1};
		}
		//0 node count 1 dis count
		int[] res=new int[2];
		for(int i=0;i<root.child.size();i++){
			int[] c=updateChildTotal(root.child.get(i));
			if(c[0]!=-1){
				c[1]=c[1]+c[0];
				res[0]=res[0]+c[0];
				res[1]=res[1]+c[1];
				root.childDis.add(c);
			}
		}
		res[0]++;
		return res;
	}
	public void updateParentTotal(TreeNode root,int parentCount,int parentTotalDis){
		if(root==null){
			return;
		}
		root.parentTotal=parentTotalDis;
		int totalChild=root.getTotalChildCount();
		int totalChildDis=root.getTotalChildDis();
		for(int i=0;i<root.child.size();i++){
			int[] cArray=root.childDis.get(i);
			int parentCountToPass=1+parentCount+totalChild-cArray[0];
			int parentDisToPass=1+parentCount+parentTotalDis+totalChildDis-cArray[1]+totalChild-cArray[0];
			updateParentTotal(root.child.get(i),parentCountToPass,parentDisToPass);
		}
	}
}
