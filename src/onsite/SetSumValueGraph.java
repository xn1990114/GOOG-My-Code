package onsite;
import java.util.*;
/*
 * 题目背景是Hypergraph, 给一个hypergraph H = (X,E), 每个node X有个weight value，假设存在一个method， 
 * 输入是一个edge的两个顶点的w1，w2，输出可以是任意两个weights, w3, w4, 并且满足w3 + w4 = w1 + w2。
 * 请设计一个算法，只使用上述method，使得所有顶点的weight值相等，调用method的次数越少越好
 */
public class SetSumValueGraph {
	public class Node{
		double val;
		public Set<Node> neighbor;
		public Node(double val){
			this.val=val;
			this.neighbor=new HashSet<Node>();
		}
	}
	public void setSumValue(Node n){
		setToSum(n);
		distributeValue(n);
	}
	public void setToSum(Node n){
		List<Set<Node>> layers=new ArrayList<Set<Node>>();
		Set<Node> visited=new HashSet<Node>();
		visited.add(n);
		Queue<Node> qu=new LinkedList<Node>();
		qu.offer(n);
		while(!qu.isEmpty()){
			Set<Node> curr=new HashSet<Node>();
			int size=qu.size();
			for(int i=0;i<size;i++){
				Node top=qu.poll();
				curr.add(top);
				for(Node ne:top.neighbor){
					if(!visited.contains(ne)){
						visited.add(ne);
						qu.offer(ne);
					}
				}
			}
			layers.add(curr);
		}
		for(int i=layers.size()-2;i>=0;i--){
			for(Node parent:layers.get(i)){
				for(Node child:layers.get(i+1)){
					if(parent.neighbor.contains(child)&&visited.contains(child)){
						visited.remove(child);
						set2Sum(parent,child);
					}
				}
			}
		}
	}
	public void distributeValue(Node n){
		Map<Node,Node> parents=new HashMap<Node,Node>();
		Map<Node, Integer> childCount=new HashMap<Node,Integer>();
		Set<Node> visited=new HashSet<Node>();
		visited.add(n);
		Queue<Node> qu=new LinkedList<Node>();
		qu.offer(n);
		parents.put(n, n);
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int i=0;i<size;i++){
				Node top=qu.poll();
				for(Node ne:top.neighbor){
					if(!visited.contains(ne)){
						parents.put(ne, top);
						visited.add(ne);
						qu.offer(ne);
					}
				}
			}
		}
		for(Node c:parents.keySet()){
			if(!childCount.containsKey(c)){
				childCount.put(c, 1);
			}
			while(c!=n){
				Node p=parents.get(c);
				if(!childCount.containsKey(p)){
					childCount.put(p, 1);
				}
				childCount.put(p, childCount.get(p)+1);
				c=p;
			}
		}
		double target=n.val/visited.size();
		visited=new HashSet<Node>();
		visited.add(n);
		qu=new LinkedList<Node>();
		qu.offer(n);
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int i=0;i<size;i++){
				Node top=qu.poll();
				for(Node ne:top.neighbor){
					if(!visited.contains(ne)){
						visited.add(ne);
						qu.offer(ne);
						setPortionVal(top,ne,childCount.get(ne),target);
					}
				}
			}
		}
	}
	public void set2Sum(Node n1,Node n2){
		double sum=n1.val+n2.val;
		n1.val=sum;
		n2.val=0;
	}
	public void setPortionVal(Node n1,Node n2,int count,double target){
		n2.val=target*count;
		n1.val=n1.val-n2.val;
	}
	public boolean checkResult(Node n,double target){
		Queue<Node> qu=new LinkedList<Node>();
		qu.offer(n);
		Set<Node> visited=new HashSet<Node>();
		visited.add(n);
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int i=0;i<size;i++){
				Node top=qu.poll();
				if(top.val<target-0.01||top.val>target+0.01){
					return false;
				}
				for(Node ne:top.neighbor){
					if(!visited.contains(ne)){
						visited.add(ne);
						qu.offer(ne);
					}
				}
			}
		}
		return true;
	}
}
