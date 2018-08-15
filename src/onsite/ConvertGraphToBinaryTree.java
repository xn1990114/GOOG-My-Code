package onsite;
import java.util.*;
/*
 * 解释 Graph 和 binary tree 的区别  比如 cycle 多个children 之类的.
Code:  写一个function  input 是一个 root  让我return true 或者false
Follow up: 如果发现是 graph 怎么把graph变成 binary tree

如果是directed graph, 感觉先break cycle, 再分别处理入度大于1和出度大于2的node, 比较方便处理一些
如果是undirected graph, 也是先break cycle, 再处理edge数量大于3的node, 然后规定下左右孩子和parent
 */
//
//assumption: graph is non-directed
public class ConvertGraphToBinaryTree {
	public class GraphNode{
		public int val;
		public List<GraphNode> neighbor;
		public GraphNode(int val){
			this.val=val;
			this.neighbor=new ArrayList<GraphNode>();
		}
	}
	public boolean isBinaryTree(GraphNode root){
		if(root==null){
			return true;
		}
		Queue<GraphNode[]> qu=new LinkedList<GraphNode[]>();
		Set<GraphNode> visited=new HashSet<GraphNode>();
		visited.add(root);
		qu.offer(new GraphNode[]{root,null});
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int round=0;round<size;round++){
				GraphNode[] top=qu.poll();
				GraphNode lastNode=top[0];
				GraphNode lastParent=top[1];
				if((lastNode==root&&lastNode.neighbor.size()>=3)||(lastNode!=root&&lastNode.neighbor.size()>3)){
					return false;
				}
				for(int i=0;i<lastNode.neighbor.size();i++){
					GraphNode nextNode=lastNode.neighbor.get(i);
					if(nextNode!=lastParent){
						if(visited.contains(nextNode)){
							return false;
						}
						visited.add(nextNode);
						qu.offer(new GraphNode[]{nextNode,lastNode});
					}
				}
			}
		}
		return true;
	}
	public GraphNode convertToBinaryTree(GraphNode root){
		if(root==null){
			return root;
		}
		Queue<GraphNode> qu=new LinkedList<GraphNode>();
		Set<GraphNode> visited=new HashSet<GraphNode>();
		visited.add(root);
		qu.offer(root);
		GraphNode parent=root;
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int round=0;round<size;round++){
				GraphNode top=qu.poll();
				for(int i=0;i<top.neighbor.size();i++){
					GraphNode neg=top.neighbor.get(i);
					if(!visited.contains(neg)){
						visited.add(neg);
						qu.offer(neg);
					}
				}
				top.neighbor.clear();
				if(top!=root){
					parent.neighbor.add(top);
					top.neighbor.add(parent);
					parent=top;
				}
			}
		}
		return root;
	}
}
