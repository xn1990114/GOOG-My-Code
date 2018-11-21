package onsite;

/*
 * https://www.geeksforgeeks.org/number-turns-reach-one-node-binary-tree/
 * assuming all nodes are having unique value
 */
public class CountTurnsInBinaryTree {
	public class TreeNode {
		int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	class ResultTracker {
		boolean v1Found;
		boolean v2Found;
		int countTurns;

		public ResultTracker(boolean v1Found, boolean v2Found, int countTurns) {
			this.v1Found = v1Found;
			this.v2Found = v2Found;
			this.countTurns = countTurns;
		}

		public boolean nodeNotFound() {
			return !this.v1Found && !this.v2Found;
		}
	}

	public int countTurns(int val1, int val2, TreeNode root) {
		if (root == null) {
			return -1;
		}
		ResultTracker res = calRes(val1, val2, root, 0);
		if (res.nodeNotFound()) {
			return -1;
		}
		return res.countTurns;
	}

	// childPos 0=root, 1 left child 2 right child;
	private ResultTracker calRes(int val1, int val2, TreeNode curr, int childPos) {
		if (curr == null) {
			return new ResultTracker(false, false, -1);
		}
		ResultTracker l = calRes(val1, val2, curr.left, 1);
		ResultTracker r = calRes(val1, val2, curr.right, 2);
		if (l.v1Found && l.v2Found) {
			return l;
		} else if (r.v1Found && r.v2Found) {
			return r;
		}
		if (curr.val == val1 || curr.val == val2) {
			if (l.nodeNotFound() && r.nodeNotFound()) {
				return new ResultTracker(curr.val == val1, curr.val == val2, 0);
			} else {
				int dis = Math.max(0, l.countTurns) + Math.max(0, r.countTurns);
				return new ResultTracker(true, true, dis);
			}
		} else {
			if ((l.v1Found && r.v2Found) || (l.v2Found && r.v1Found)) {
				return new ResultTracker(true, true, l.countTurns + r.countTurns + 1);
			} else if (l.v1Found || r.v1Found) {
				int dis = Math.max(0, l.countTurns) + Math.max(0, r.countTurns);
				int extra = 0;
				if ((l.v1Found && childPos == 2) || (r.v1Found && childPos == 1)) {
					extra++;
				}
				return new ResultTracker(true, false, dis + extra);
			} else if (l.v2Found || r.v2Found) {
				int dis = Math.max(0, l.countTurns) + Math.max(0, r.countTurns);
				int extra = 0;
				if ((l.v2Found && childPos == 2) || (r.v2Found && childPos == 1)) {
					extra++;
				}
				return new ResultTracker(false, true, dis + extra);
			}
			else {
				return new ResultTracker(false, false, -1);
			}
		}
	}
}
