package onsite;
import java.util.*;
/*
 * 给一个二位坐标平面和一个起始点，从这点开始垂直下跳，下面有若干水平挡板，
 * 位置长度会在input里给出，当跳到挡板上时，可以选择走到挡板的左端或者右端，
 * 然后继续垂直下跳，直到落地位置，求从开始到落地需要走过的路程最短是多少。
 */
public class MinDistanceJumpDown {
	// for bars 0-left,1-right,2 height
	public int findMinDis(int[] startPoint,int[][] bars){
		Map<int[],int[]> disMap=new HashMap<int[],int[]>();
		return calMinDis(startPoint,bars,disMap);
	}
	public int calMinDis(int[] pos,int[][] bars,Map<int[],int[]> disMap){
		if(pos[1]==0){
			return 0;
		}
		int[] next=findNextBar(pos,bars);
		if(next==null){
			return 0;
		}
		if(!disMap.containsKey(next)){
			int l=calMinDis(new int[]{next[0],next[2]},bars,disMap);
			int r=calMinDis(new int[]{next[1],next[2]},bars,disMap);
			disMap.put(next, new int[]{l,r});
		}
		int[] dis=disMap.get(next);
		return Math.min(dis[0]+pos[0]-next[0], dis[1]+next[1]-pos[0]);
	}
	public int[] findNextBar(int[] pos,int[][] bars){
		int[] res=null;
		for(int i=0;i<bars.length;i++){
			int[] curr=bars[i];
			if(curr[2]>=pos[1]){
				continue;
			}
			if(pos[0]>curr[0]&&pos[0]<curr[1]){
				if(res==null||res[2]<curr[2]){
					res=curr;
				}
			}
		}
		return res;
	}
}
