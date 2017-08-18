package onsite;

import java.util.*;

public class SudokuInitializer {
	public int[][] createSudoku() {
		int[][] result = new int[9][9];
		List<Set<Integer>> rowList = new ArrayList<Set<Integer>>();
		List<Set<Integer>> colList = new ArrayList<Set<Integer>>();
		List<Set<Integer>> cellList = new ArrayList<Set<Integer>>();
		List<Integer> toadd = new ArrayList<Integer>();
		for (int i = 1; i <= 9; i++) {
			toadd.add(i);
		}
		for (int i = 0; i < 9; i++) {
			rowList.add(new HashSet<Integer>());
			colList.add(new HashSet<Integer>());
			cellList.add(new HashSet<Integer>());
		}
		PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>(new Comparator<List<Integer>>(){
			public int compare(List<Integer> l1,List<Integer> l2){
				return l1.size()-l2.size();
			}
		});
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				List<Integer> curr = new ArrayList<Integer>();
				curr.add(i);
				curr.add(j);
				shuffle(toadd);
				curr.addAll(toadd);
				pq.offer(curr);
			}
		}
		buildSudoku(pq, rowList, colList, cellList, result);
		return result;
	}

	public boolean buildSudoku(PriorityQueue<List<Integer>> pq, List<Set<Integer>> rowList, List<Set<Integer>> colList,
			List<Set<Integer>> cellList, int[][] result) {
		if(pq.size()==0){
			return true;
		}
		List<Integer> curr=pq.poll();
		int r=curr.get(0);
		int c=curr.get(1);
		for(int i=2;i<curr.size();i++){
			int currNum=curr.get(i);
			if(rowList.get(r).contains(currNum)||colList.get(c).contains(currNum)||cellList.get(r/3*3+c/3).contains(currNum)){
				continue;
			}
			rowList.get(r).add(currNum);
			colList.get(c).add(currNum);
			cellList.get(r/3*3+c/3).add(currNum);
			if(buildSudoku(pq, rowList, colList, cellList, result)){
				result[r][c]=currNum;
				return true;
			}
			rowList.get(r).remove(currNum);
			colList.get(c).remove(currNum);
			cellList.get(r/3*3+c/3).remove(currNum);
		}
		pq.offer(curr);
		return false;
	}

	public void shuffle(List<Integer> list) {
		int index = list.size() - 1;
		while (index > 0) {
			int currIndex = (int) (Math.random() * (index + 1));
			int temp = list.get(currIndex);
			list.set(currIndex, list.get(index));
			list.set(index, temp);
			index--;
		}
	}

	public void display(int[][] matrix) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
