package onsite;

import java.util.*;
/*
 * 2d drawing 有一个画笔和一些线段在一个2d平面上，假设画每条线段需要常数时间，移动笔头需要常数时间，如何安排写的顺序似的总用时最少。
 * 这道题写起来还是挺有难度，我用了贪心利用最多的首尾相接的节点。follow up：如果画线段时间和移动时间跟距离成正比。
 */
// assuming pen is starting at 0,0 at the beginning.

public class DrawingIn2DBoard {
	// below code for original. assuming cost of moving and drawing are both 1.
	public int calMinCostToDrawLine(int[][] lines) {
		Set<int[]> used = new HashSet<int[]>();
		int totalCost = 0;
		boolean has00Start = false;
		Map<String, Set<int[]>> map = new HashMap<String, Set<int[]>>();
		for (int i = 0; i < lines.length; i++) {
			String s1 = lines[i][0] + "," + lines[i][1];
			String s2 = lines[i][2] + "," + lines[i][3];
			if (!map.containsKey(s1)) {
				map.put(s1, new HashSet<int[]>());
			}
			if (!map.containsKey(s2)) {
				map.put(s2, new HashSet<int[]>());
			}
			map.get(s1).add(lines[i]);
			map.get(s2).add(lines[i]);
		}
		for (int i = 0; i < lines.length; i++) {
			int[] curr = lines[i];
			if (!used.contains(curr)) {
				int preSize=used.size();
				used.add(curr);
				int[] groupPos = groupAndFindPoints(curr, map, used);
				if ((groupPos[0] == 0 && groupPos[1] == 0) || (groupPos[2] == 0 && groupPos[3] == 0)) {
					has00Start = true;
				}
				totalCost=totalCost+used.size()-preSize;
				totalCost++;
			}
		}
		if (has00Start) {
			totalCost--;
		}
		return totalCost;
	}

	public int[] groupAndFindPoints(int[] curr, Map<String, Set<int[]>> map, Set<int[]> used) {
		String start = curr[0] + "," + curr[1];
		String end = curr[2] + "," + curr[3];
		map.get(start).remove(curr);
		map.get(end).remove(curr);
		if (map.get(start).isEmpty()) {
			map.remove(start);
		}
		if (map.get(end).isEmpty()) {
			map.remove(end);
		}
		while (map.containsKey(start)) {
			int[] next = map.get(start).iterator().next();
			String n1 = next[0] + "," + next[1];
			String n2 = next[2] + "," + next[3];
			used.add(next);
			map.get(n1).remove(next);
			map.get(n2).remove(next);
			if (map.get(n1).isEmpty()) {
				map.remove(n1);
			}
			if (map.get(n2).isEmpty()) {
				map.remove(n2);
			}
			if (start.equals(n1)) {
				start = n2;
			} else {
				start = n1;
			}
		}
		while (map.containsKey(end)) {
			int[] next = map.get(end).iterator().next();
			used.add(next);
			String n1 = next[0] + "," + next[1];
			String n2 = next[2] + "," + next[3];
			used.add(next);
			map.get(n1).remove(next);
			map.get(n2).remove(next);
			if (map.get(n1).isEmpty()) {
				map.remove(n1);
			}
			if (map.get(n2).isEmpty()) {
				map.remove(n2);
			}
			if (end.equals(n1)) {
				end = n2;
			} else {
				end = n1;
			}
		}
		String[] p1 = start.split(",");
		String[] p2 = end.split(",");
		return new int[] { Integer.parseInt(p1[0]), Integer.parseInt(p1[1]), Integer.parseInt(p2[0]),
				Integer.parseInt(p2[1]) };
	}
	// below code is for follow up.
	// assuming starting at 0,0
	// greedy
	public double minCostToDrawWithDistanceCost(int[][] lines){
		double totalCost=0;
		int[] curr={0,0};
		boolean[] used=new boolean[lines.length];
		int usedCount=0;
		while(usedCount<used.length){
			double minDis=Double.MAX_VALUE;
			int minIndex=-1;
			for(int i=0;i<lines.length;i++){
				if(!used[i]){
					int[] p1={lines[i][0],lines[i][1]};
					int[] p2={lines[i][2],lines[i][3]};
					double d1=calDis(curr,p1);
					double d2=calDis(curr,p2);
					if(d1<minDis||d2<minDis){
						minDis=Math.min(d1,d2);
						minIndex=i;
					}
				}
			}
			used[minIndex]=true;
			int[] p1={lines[minIndex][0],lines[minIndex][1]};
			int[] p2={lines[minIndex][2],lines[minIndex][3]};
			double d1=calDis(curr,p1);
			double d2=calDis(curr,p2);
			totalCost=totalCost+Math.min(d1, d2)+calDis(p1,p2);
			if(d1<d2){
				curr=p1;
			}
			else{
				curr=p2;
			}
			usedCount++;
		}
		return totalCost;
	}
	public double calDis(int[] p1,int[] p2){
		return Math.sqrt((p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]));
	}
}
