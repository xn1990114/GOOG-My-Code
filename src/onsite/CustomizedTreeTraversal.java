package onsite;

public class CustomizedTreeTraversal {
	class Node {
		int val;
		Node getParent();
		Node getNextSibling();
		Node getFirstChild();
	}

	void print(Node root) {
		Node cur = root;
		while (cur != null) {
			System.out.println(cur);
			cur = nextNode(cur);
		}
	}

	Node nextNode(Node curr) {
		// 让实现这个function，然后调用print时候能打印所有的node
		if(curr.getFirstChild()!=null){
			return curr.getFirstChild();
		}
		if(curr.getNextSibling().getParent()==curr.getParent()){
			return curr.getNextSibling();
		}
		while(curr!=null&&curr.getNextSibling().getParent()!=curr.getParent()){
			curr=curr.getParent();
		}
		if(curr==null){
			return null;
		}
		return curr.getNextSibling();
	}
}
