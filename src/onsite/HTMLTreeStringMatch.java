package onsite;
import java.util.*;
/*
 * 给了一个由html构成的树的结构，好多面经都出现过，由这个树找叶子节点，看存不存在相应的单词：
例如：<!html><I>This</I><B>is</B>fun 类似这样的吧，反正内部节点无所谓，这个html可以变成一棵树，其中的一颗可以是
               <!html>
            /        |        \
        <I>    </I>    </B>
         /           |          \
      This       <B>       fun
                     |
                     is
    然后给一个string：比如his，或者isis，让你判断这个树的节点存不存在这个string，
    并返回组成这个string的所有叶子节点。如果我把this这个单词算是叶子节点1，is是2，fun是3，
    那么his的答案是1，isis是1和2。返回一个List<Node>就好
 */
public class HTMLTreeStringMatch {
	public class TreeNode{
		public String val;
		public List<TreeNode> child;
		public TreeNode(String val){
			this.val=val;
			this.child=new ArrayList<TreeNode>();
		}
	}
	public List<TreeNode> findMatchedNodes(TreeNode root,String target){
		List<TreeNode> allNodes=new ArrayList<TreeNode>();
		List<TreeNode> res=new ArrayList<TreeNode>();
		getAllNodes(root,allNodes);
		for(int i=0;i<allNodes.size();i++){
			String curr=allNodes.get(i).val;
			for(int j=0;j<curr.length();j++){
				int[] matchedIndex=isMatched(allNodes,target,i,j);
				if(matchedIndex[1]!=-1){
					for(int k=matchedIndex[0];k<=matchedIndex[1];k++){
						res.add(allNodes.get(k));
					}
					return res;
				}
			}
		}
		return res;
	}
	public int[] isMatched(List<TreeNode> nodes,String target,int startStringIndex,int startCharIndex){
		int targetIndex=0;
		int endStringIndex=startStringIndex;
		int[] res={startStringIndex,-1};
		TreeNode currNode=nodes.get(startStringIndex);
		while(targetIndex<target.length()){
			if(startCharIndex==currNode.val.length()){
				endStringIndex++;
				if(endStringIndex==nodes.size()){
					return res;
				}
				currNode=nodes.get(endStringIndex);
				startCharIndex=0;
			}
			if(currNode.val.charAt(startCharIndex)!=target.charAt(targetIndex)){
				return res;
			}
			targetIndex++;
			startCharIndex++;
		}
		res[1]=endStringIndex;
		return res;
	}
	public void getAllNodes(TreeNode curr,List<TreeNode> allNodes){
		if(curr==null){
			return;
		}
		if(curr.val.charAt(0)!='<'){
			allNodes.add(curr);
		}
		for(TreeNode c:curr.child){
			getAllNodes(c,allNodes);
		}
	}
}
