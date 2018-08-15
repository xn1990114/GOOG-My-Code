package onsite;

import java.util.*;

/*
 * Rectangle min area
一个2D坐标系上分布很多个点，要求找出4个点可以组成矩形，然后return 最小的矩形面积
 */
public class MinRectangleArea {
	// assuming only horizonal lines and vertical lines.
	public int minAreaWithOnlyHorizonalRectangle(int[][] points) {
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < points.length; i++) {
			int r = points[i][0];
			int c = points[i][1];
			if (!map.containsKey(r)) {
				map.put(r, new HashSet<Integer>());
			}
			map.get(r).add(c);
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < points.length; i++) {
			int[] p1 = points[i];
			for (int j = i + 1; j < points.length; j++) {
				int[] p2 = points[j];
				if (p1[0] == p2[0] || p1[1] == p2[1]) {
					continue;
				}
				int[] p3 = { p1[0], p2[1] };
				int[] p4 = { p2[0], p1[1] };
				if (map.get(p3[0]).contains(p3[1]) && map.get(p4[0]).contains(p4[1])) {
					int h = Math.max(p1[1], p2[1]) - Math.min(p1[1], p2[1]);
					int w = Math.max(p1[0], p2[0]) - Math.min(p1[0], p2[0]);
					res = Math.min(res, h * w);
				}
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	// assuming not only horizonal lines and vertical lines.
	public double minAreaAllRectangle(int[][] points) {
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < points.length; i++) {
			int r = points[i][0];
			int c = points[i][1];
			if (!map.containsKey(r)) {
				map.put(r, new HashSet<Integer>());
			}
			map.get(r).add(c);
		}
		double res = Integer.MAX_VALUE;
		for(int midIndex=0;midIndex<points.length;midIndex++){
			int[] midPoint=points[midIndex];
			for(int index1=0;index1<points.length;index1++){
				int[] p1=points[index1];
				if(p1[0]>midPoint[0]||p1[1]<=midPoint[1]){
					continue;
				}
				for(int index2=0;index2<points.length;index2++){
					int[] p2=points[index2];
					if(p2[0]<=midPoint[0]||p2[1]<midPoint[1]){
						continue;
					}
					if(is90Degree(midPoint,p1,p2)){
						int[] p4={p1[0]+(p2[0]-midPoint[0]),p1[1]+(p2[1]-midPoint[1])};
						if(map.containsKey(p4[0])&&map.get(p4[0]).contains(p4[1])){
							double area=calArea(midPoint,p1,p2);
							res=Math.min(res, area);
						}
					}
				}
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}
	public double calArea(int[] midPoint,int[] p1,int[] p2){
		double h=Math.sqrt((p1[1]-midPoint[1])*(p1[1]-midPoint[1])+(p1[0]-midPoint[0])*(p1[0]-midPoint[0]));
		double w=Math.sqrt((p2[1]-midPoint[1])*(p2[1]-midPoint[1])+(p2[0]-midPoint[0])*(p2[0]-midPoint[0]));
		return h*w;
	}
	public boolean is90Degree(int[] mid,int[] p1,int[] p2){
		return (p2[1]-mid[1])*(p1[1]-mid[1])==-(p2[0]-mid[0])*(p1[0]-mid[0]);
	}
	public boolean isSame(int[] p1,int[] p2){
		return p1[0]==p2[0]&&p1[1]==p2[1];
	}
}
