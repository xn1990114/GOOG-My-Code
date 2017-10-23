package phone;
import java.util.*;
/*
 * 给出一个tree, 每一个node都有一个value, 问tree里面相同value的node连接成最长路径的大小(edge的数量).
 * tree是要自己建的, 输入是两个array, 第一个array表示每个node的value, 第二个array表示所有的边
 * 例如[1,1,1], [1,2,1,3] -> 2, 说明这个tree有3个node, value都是1, 然后node1和node2有边, node1和node3也有边, 
 * 最长的路径是2 -> 1 -> 3或者反过来, 总共两条边, 输出2.
 * doesn't seem to be actually tree structure
 * below code is using graph instead of tree
 */
public class MaxContinuousLengthWithSameValue {
	public class Node{
		int val;
		Set<Node> adj;
		public Node(int val){
			this.val=val;
			this.adj=new HashSet<Node>();
		}
	}
	public int findMaxLength(int[] vals,int[][] links){
		Node[] nodes=new Node[vals.length];
		for(int i=0;i<vals.length;i++){
			nodes[i]=new Node(vals[i]);
		}
		for(int i=0;i<links.length;i++){
			int n1=links[i][0];
			int n2=links[i][1];
			nodes[n1].adj.add(nodes[n2]);
			nodes[n2].adj.add(nodes[n1]);
		}
		Set<Node> visited=new HashSet<Node>();
		int max=0;
		for(int i=0;i<nodes.length;i++){
			if(!visited.contains(nodes[i])){
				visited.add(nodes[i]);
				max=Math.max(max, countLength(nodes[i],visited));
			}
		}
		return max-1;
	}
	public int countLength(Node node,Set<Node> visited){
		Queue<Node> qu=new LinkedList<Node>();
		qu.offer(node);
		int count=1;
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int i=0;i<size;i++){
				Node curr=qu.poll();
				for(Node a:curr.adj){
					if(a.val==node.val&&!visited.contains(a)){
						visited.add(a);
						qu.offer(a);
						count++;
					}
				}
			}
		}
		return count;
	}
}
