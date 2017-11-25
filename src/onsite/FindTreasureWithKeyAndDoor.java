package onsite;

import java.util.*;

/*
 * 第一轮是给一个graph，从root进，每个node（房间）能通往一些node，edge上面有门，有些需要钥匙，有些不需要，
 * 需要钥匙的门必须当前持有那个钥匙才能去下一个房间。每个房间里有一个任意房间的key，
 * 而且也有可能有宝藏。我们需要做的就是走整个graph来找到宝藏，找不到就回false。
 */
// 0 means empty place, postive nums are door, negative numbers are corresponding keys
// 1 is wall, -1 is treasure
public class FindTreasureWithKeyAndDoor {
	public boolean findTreasure(int[][] nums, int[] start) {
		Queue<int[]> startPoints = new LinkedList<int[]>();
		startPoints.offer(start);
		Set<Integer> keyChain = new HashSet<Integer>();
		while (!startPoints.isEmpty()) {
			int size = startPoints.size();
			Queue<int[]> nextStart = new LinkedList<int[]>();
			Set<Integer> newKeyChain = new HashSet<Integer>();
			for (int i = 0; i < size; i++) {
				if (updateData(startPoints.poll(), new boolean[nums.length][nums[0].length], keyChain, newKeyChain, nextStart, nums)) {
					return true;
				}
			}
			if(newKeyChain.isEmpty()){
				return false;
			}
			startPoints=nextStart;
			keyChain.addAll(newKeyChain);
		}
		return false;
	}

	private boolean updateData(int[] start, boolean[][] visited, Set<Integer> keyChain, Set<Integer> newKeyChain,
			Queue<int[]> nextStart, int[][] nums) {

		Queue<int[]> qu = new LinkedList<int[]>();
		visited[start[0]][start[1]]=true;
		qu.offer(start);
		while (!qu.isEmpty()) {
			int[] curr = qu.poll();
			// if is target
			if (nums[curr[0]][curr[1]] == -1) {
				return true;
				// if empty or has key already or is a key
			} else if ((nums[curr[0]][curr[1]] > 1 && keyChain.contains(nums[curr[0]][curr[1]]))
					|| nums[curr[0]][curr[1]] == 0||nums[curr[0]][curr[1]]<-1) {
				if(nums[curr[0]][curr[1]]<-1){
					newKeyChain.add(-nums[curr[0]][curr[1]]);
					nums[curr[0]][curr[1]] =0;
				}
				else if(nums[curr[0]][curr[1]] > 1){
					nums[curr[0]][curr[1]] =0;
				}
				int r=curr[0];
				int c=curr[1];
				if(r-1>=0&&nums[r-1][c]!=1&&!visited[r-1][c]){
					visited[r-1][c]=true;
					qu.offer(new int[]{r-1,c});
				}
				if(r+1<nums.length&&nums[r+1][c]!=1&&!visited[r+1][c]){
					visited[r+1][c]=true;
					qu.offer(new int[]{r+1,c});
				}
				if(c-1>=0&&nums[r][c-1]!=1&&!visited[r][c-1]){
					visited[r][c-1]=true;
					qu.offer(new int[]{r,c-1});
				}
				if(c+1<nums[0].length&&nums[r][c+1]!=1&&!visited[r][c+1]){
					visited[r][c+1]=true;
					qu.offer(new int[]{r,c+1});
				}
			}
			// if is a door with no key
			else if(nums[curr[0]][curr[1]] > 1){
				nextStart.offer(curr);
			}
		}
		return false;
	}
}
