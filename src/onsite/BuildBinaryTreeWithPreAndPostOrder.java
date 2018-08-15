package onsite;

import java.util.*;

/*
 * 用preorder和postorder建树
这道题出来时我说好像没有inorder是做不出来的，然后举了个例子，
面试管说那就假设总是有left subtree的，然后楼主用recursion写了。完了分析时间复杂度，问怎么优化(hashmap 存一边 postorder里的val 对应的Index)
 */
public class BuildBinaryTreeWithPreAndPostOrder {
	public class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public TreeNode buildTreeOnPreAndPostOrder(int[] preOrder, int[] postOrder) {
		if (preOrder == null || postOrder == null || preOrder.length == 0 || preOrder.length != postOrder.length) {
			return null;
		}
		Map<Integer, Integer> postIndex = new HashMap<Integer, Integer>();
		for (int i = 0; i < postOrder.length; i++) {
			postIndex.put(postOrder[i], i);
		}
		return buildTree(preOrder, postOrder, 0, preOrder.length - 1, 0, postOrder.length - 1, postIndex);
	}

	public TreeNode buildTree(int[] preOrder, int[] postOrder, int preStart, int preEnd, int postStart, int postEnd,
			Map<Integer, Integer> postIndex) {
		if (preStart > preEnd) {
			return null;
		}
		if (preStart == preEnd) {
			return new TreeNode(preOrder[preStart]);
		}
		TreeNode currNode = new TreeNode(preOrder[preStart]);
		int leftVal = preOrder[preStart + 1];
		int leftEnd = postIndex.get(leftVal);
		int leftTreeTotalLen = leftEnd - postStart + 1;
		currNode.left = buildTree(preOrder, postOrder, preStart + 1, preStart + leftTreeTotalLen, postStart, leftEnd,
				postIndex);
		currNode.right = buildTree(preOrder, postOrder, preStart + leftTreeTotalLen + 1, preEnd, leftEnd + 1,
				postEnd - 1, postIndex);
		return currNode;
	}

	public void displayTree(TreeNode root) {
		if (root == null) {
			System.out.println("Empty tree");
			return;
		}
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.offer(root);
		while (!qu.isEmpty()) {
			int size = qu.size();
			for (int round = 0; round < size; round++) {
				TreeNode top = qu.poll();
				if(top==null){
					System.out.print("null\t");
				}
				else{
					System.out.print(top.val+"\t");
					qu.offer(top.left);
					qu.offer(top.right);
				}
			}
			System.out.println();
		}
	}
}
