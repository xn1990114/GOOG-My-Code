package onsite;

import java.util.*;

//2D grid，人，自行车。讨论了一堆，要求找全局最优配对。
// 1 people 2 bicycle
public class BicyclePair {
	public class Pair {
		public int[] people;
		public int[] bicycle;

		public Pair(int[] people, int[] bicycle) {
			this.people = people;
			this.bicycle = bicycle;
		}
	}

	public List<Pair> pairBiCycle(int[][] board) {
		List<Pair> res = new ArrayList<Pair>();
		if (board == null || board.length == 0 || board[0].length == 0) {
			return res;
		}
		List<int[]> people = new ArrayList<int[]>();
		List<int[]> bicycle = new ArrayList<int[]>();
		List<Pair> currCombination = new ArrayList<Pair>();
		double[] minDis = { -1.0 };
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1) {
					people.add(new int[] { i, j });
				} else if (board[i][j] == 2) {
					bicycle.add(new int[] { i, j });
				}
			}
		}
		if (people.size() == 0) {
			return res;
		}
		boolean[] usedBicycle = new boolean[bicycle.size()];
		searchForCombination(res, currCombination, people, bicycle, 0, usedBicycle, 0, minDis);
		return res;
	}

	public void searchForCombination(List<Pair> res, List<Pair> currCombination, List<int[]> people,
			List<int[]> bicycle, int peopleIndex, boolean[] usedBicycle, double totalDis, double[] minDis) {
		if (people.size() == peopleIndex) {
			if (minDis[0] < 0 || minDis[0] > totalDis) {
				minDis[0] = totalDis;
				res.clear();
				res.addAll(currCombination);
			}
			return;
		}
		int[] currPeople = people.get(peopleIndex);
		for (int i = 0; i < bicycle.size(); i++) {
			if (!usedBicycle[i]) {
				usedBicycle[i] = true;
				int[] currBicycle = bicycle.get(i);
				currCombination.add(new Pair(currPeople, currBicycle));
				searchForCombination(res, currCombination, people, bicycle, peopleIndex + 1, usedBicycle,
						totalDis + calDis(currPeople, currBicycle), minDis);
				usedBicycle[i] = false;
				currCombination.remove(currCombination.size() - 1);
			}
		}
	}

	public double calDis(int[] p, int[] b) {
		return Math.sqrt((p[0] - b[0]) * (p[0] - b[0]) + (p[1] - b[1]) * (p[1] - b[1]));
	}
}
