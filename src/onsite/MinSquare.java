package onsite;

import java.util.*;

/*
 * 给若干个点，找到他们能组成的最小正方形，只需要考虑由水平竖直线组成的，
 * 不需要考虑 (1,0),(2,1),(1,2),(0,1)这种
 */
public class MinSquare {
	public int Solution(int[][] points){
		int min=Integer.MAX_VALUE;
		HashMap<Integer,Set<Integer>> map=new HashMap<Integer,Set<Integer>>();
		for(int i=0;i<points.length;i++){
			if(!map.keySet().contains(points[i][0])){
				map.put(points[i][0], new HashSet<Integer>());
			}
			map.get(points[i][0]).add(points[i][1]);
		}
		for(int i=0;i<points.length;i++){
			int[] a=points[i];
			for(int j=i+1;j<points.length;j++){
				int[] b=points[j];
				if(a[0]==b[0]||a[1]==b[1]){
					continue;
				}
				if(map.get(b[0]).contains(a[1])&&map.get(a[0]).contains(b[1])){
					if(Math.abs(a[0]-b[0])==Math.abs(a[1]-b[1])){
						min=Math.min(min, Math.abs(a[0]-b[0]));
					}
				}
			}
		}
		return min*min;
	}
}
