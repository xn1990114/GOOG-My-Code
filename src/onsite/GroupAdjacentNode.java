package onsite;
import java.util.*;
/*
 * 有一个无限长的double linked list，和一个pointer array，每个pointer指向list中的一个node，
 * 求有多少个不相连的node group。
 * double linked list里的node，只知道前后两个node，而且不能存任何东西，
 * group的定义是group里的nodes通过node前后link相连，group之间，没有node有相连关系。
 * 同时，array中的pointer只指向一个unique的node。
 */
public class GroupAdjacentNode {
	public class Node{
		public Node previous;
		public Node next;
		public Node(){}
	}
	public int countGroup(Node[] pointerArray){
		Map<Node,Node> parent=new HashMap<Node,Node>();
		for(int i=0;i<pointerArray.length;i++){
			Node curr=pointerArray[i];
			Node pre=curr.previous;
			Node next=curr.next;
			if(parent.containsKey(curr)){
				continue;
			}
			parent.put(curr, curr);
			if(parent.containsKey(pre)){
				merge(pre,curr,parent);
			}
			if(parent.containsKey(next)){
				merge(curr,next,parent);
			}
		}
		int count=0;
		for(Node key:parent.keySet()){
			if(parent.get(key)==key){
				count++;
			}
		}
		return count;
	}
	public void merge(Node n1,Node n2,Map<Node,Node> parent){
		int d1=0;
		int d2=0;
		while(n1!=null&&parent.get(n1)!=n1){
			d1++;
			n1=parent.get(n1);
		}
		while(n2!=null&&parent.get(n2)!=n2){
			d2++;
			n2=parent.get(n2);
		}
		if(n1==n2){
			return;
		}
		if(d1<d2){
			parent.put(n1,n2);
		}
		else{
			parent.put(n2,n1);
		}
	}
}
