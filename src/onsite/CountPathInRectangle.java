package onsite;

import java.util.HashMap;
import java.util.Map;

/*
 * 给定一个矩形的长宽，用多少种方法可以从左上角走到右上角 (每一步，只能向正右、右上 或 右下走)
Two pass DP即可
follow up:如果给矩形里的三个点，要求解决上述问题的同时，经过这三个点 纵向切割矩形，一个一个地做DP，然后相加
follow up:如何判断这三个点一个是合理的，即存在遍历这三个点的路经 DP时看是否可达就好了呗
follow up:如果给你一个H，要求你的路径必须向下越过H这个界，怎么做 可以再做一次 dp，但是只走 <= H 的路径，再用总数减一下
Follow up:要经过某些特定row怎么走?要先经过一个row再经过另一个row怎么走? 也是矩阵切割的思想，但是要处理先后顺序
 */
public class CountPathInRectangle {
	public int countPath(int row, int col) {
		if (row == 0 || col == 0) {
			return 0;
		}
		int[] last = new int[Math.min(row, (col + 1) / 2)];
		last[0] = 1;
		for (int c = 0; c < col - 1; c++) {
			int[] curr = new int[last.length];
			for (int r = 0; r < curr.length; r++) {
				curr[r] = last[r] + (r - 1 >= 0 ? last[r - 1] : 0) + (r + 1 < last.length ? last[r + 1] : 0);
			}
			last = curr;
		}
		return last[0];
	}

	// follow up:如果给矩形里的三个点，要求解决上述问题的同时，经过这三个点 纵向切割矩形，一个一个地做DP，然后相加
	// follow up:如何判断这三个点一个是合理的，即存在遍历这三个点的路经 DP时看是否可达就好了呗
	public int countPathWith3Points(int row, int col, int[][] requiredPoints) {
		if (row == 0 || col == 0) {
			return 0;
		}
		Map<Integer, Integer> pointMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < requiredPoints.length; i++) {
			int r = requiredPoints[i][0];
			int c = requiredPoints[i][1];
			if (c < 0 || r < 0 || c >= col || r >= row) {
				return 0;
			}
			if (pointMap.containsKey(c) && pointMap.get(c) != r) {
				return 0;
			}
			pointMap.put(c, r);
		}
		if (pointMap.containsKey(0) && pointMap.get(0) != 0) {
			return 0;
		}
		int[] last = new int[Math.min(row, (col + 1) / 2)];
		last[0] = 1;
		for (int c = 1; c < col; c++) {
			int targetR = -1;
			if (pointMap.containsKey(c)) {
				targetR = pointMap.get(c);
			}
			int[] curr = new int[last.length];
			for (int r = 0; r < curr.length; r++) {
				if (targetR == -1 || r == targetR) {
					curr[r] = last[r] + (r - 1 >= 0 ? last[r - 1] : 0) + (r + 1 < last.length ? last[r + 1] : 0);
				}
			}
			last = curr;
		}
		return last[0];
	}

	// follow up:如果给你一个H，要求你的路径必须向下越过H这个界，怎么做 可以再做一次 dp，但是只走 <= H 的路径，再用总数减一下
	public int countPathWithTargetH(int row, int col, int H) {
		if (row == 0 || col == 0 || H >= row) {
			return 0;
		}
		// 0 not reach H yet, 1 has reached H
		int[][] last = new int[Math.min(row, (col + 1) / 2)][2];
		if (H <= 0) {
			last[0][1] = 1;
		} else {
			last[0][0] = 1;
		}
		for (int c = 1; c < col; c++) {
			int[][] curr = new int[last.length][2];
			for (int r = 0; r < last.length; r++) {
				if (r >= H) {
					curr[r][1] = last[r][0] + last[r][1] + (r - 1 >= 0 ? last[r - 1][0] + last[r - 1][1] : 0)
							+ (r + 1 < last.length ? last[r + 1][0] + last[r + 1][1] : 0);
				} else {
					curr[r][0] = last[r][0] + (r - 1 >= 0 ? last[r - 1][0] : 0)
							+ (r + 1 < last.length ? last[r + 1][0] : 0);
					curr[r][1] = last[r][1] + (r - 1 >= 0 ? last[r - 1][1] : 0)
							+ (r + 1 < last.length ? last[r + 1][1] : 0);
				}
			}
			last = curr;
		}
		return last[0][1];
	}

	// Follow up:要经过某些特定row怎么走?要先经过一个row再经过另一个row怎么走? 也是矩阵切割的思想，但是要处理先后顺序
	public int countPathWithRowSequence(int row, int col, int[] rowSeq) {
		if (row <= 0 || col <= 0) {
			return 0;
		}
		int[][] last = new int[row][col];
		last[0][0] = 1;
		populate(last, -1);
		for (int i = 0; i < rowSeq.length; i++) {
			int[][] curr = new int[row][col];
			int r = rowSeq[i];
			curr[r] = last[r];
			populate(curr, r);
			last = curr;
		}
		return last[0][col - 1];
	}

	public void populate(int[][] count, int freezeR) {
		for (int c = 1; c < count[0].length; c++) {
			for (int r = 0; r < count.length; r++) {
				if(r!=freezeR){
					count[r][c]=count[r][c-1]+(r-1>=0?count[r-1][c-1]:0)+(r+1<count.length?count[r+1][c-1]:0);
				}
			}
		}
	}
}
