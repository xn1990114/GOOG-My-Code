package onsite;

public class CustomizedTreeTraversal {
	class TreeNode {
		int val;
		TreeNode parent;
		TreeNode left;
		TreeNode right;
		
		TreeNode getParent(){
			return this.parent;
		}
		TreeNode getNextSibling(){
			// not implemented
			return null;
		}
		TreeNode getFirstChild(){
			if(this.left!=null){
				return left;
			}
			return right;
		}
	}

	void print(TreeNode root) {
		TreeNode cur = root;
		while (cur != null) {
			System.out.println(cur);
			cur = nextNode(cur);
		}
	}

	TreeNode nextNode(TreeNode curr) {
		// 让实现这个function，然后调用print时候能打印所有的node
		if(curr.getFirstChild()!=null){
			return curr.getFirstChild();
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
