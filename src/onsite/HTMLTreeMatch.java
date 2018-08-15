package onsite;
import java.util.*;

/*
 * 给一个网叶 树 结构，自己定node的结构, 数有两种node，一种是tag node 另一种椰子 node，text只存在椰子  node里面，给两个数，
 * 比较两个数中餒容是否相通
比如
<a><b>hello</b><c>world</c></a>和
<a><b>hellow</b><c>orld</c></a>
对应的数的内容都你好四界，所以这两个数的餒容是相通的
Follow up 如果最后生成餒容太大累存放不下怎么办
写一个椰子节点 iterator，iterator 按照钱序遍历的顺序依次返回椰子 node
 */
// assuming N-ary tree
public class HTMLTreeMatch {
	public class TreeNode{
		public String val;
		public List<TreeNode> child;
		public TreeNode(String val){
			this.val=val;
			this.child=new ArrayList<TreeNode>();
		}
		public boolean isLeaf(){
			return this.child.isEmpty();
		}
	}
	public class HTMLTreeIterator implements Iterator<Character>{
		Stack<TreeNode> nodeStack;
		TreeNode currNode;
		int currIndex;
		public HTMLTreeIterator(TreeNode root){
			nodeStack=new Stack<TreeNode>();
			currNode=null;
			currIndex=-1;
			nodeStack.push(root);
			moveToNextChar();
		}
		public void moveToNextChar(){
			if(currNode!=null&&currIndex<currNode.val.length()){
				return;
			}
			while(!nodeStack.isEmpty()){
				currNode=nodeStack.pop();
				for(int i=currNode.child.size()-1;i>=0;i--){
					nodeStack.push(currNode.child.get(i));
				}
				if(currNode.isLeaf()&&currNode.val.length()>0){
					currIndex=0;
					return;
				}
			}
			currNode=null;
		}
		@Override
		public boolean hasNext(){
			return currNode!=null;
		}
		@Override
		public Character next(){
			Character res=currNode.val.charAt(currIndex);
			currIndex++;
			moveToNextChar();
			return res;
		}
	}
	public boolean isMatchedTree(TreeNode n1,TreeNode n2){
		HTMLTreeIterator it1=new HTMLTreeIterator(n1);
		HTMLTreeIterator it2=new HTMLTreeIterator(n2);
		while(it1.hasNext()&&it2.hasNext()){
			char c1=it1.next();
			char c2=it2.next();
			System.out.println(c1);
			if(c1!=c2){
				return false;
			}
		}
		return !it1.hasNext()&&!it2.hasNext();
	}
}
