package onsite;
import java.util.*;
/*
1. 一辆汽车，初始速度为1。每次加速速度变为两倍，每次调头调转方向并且速度变回1。
给一个字符串表示汽车加速调头的过程（比如加速加速调头加速），求最终汽车的位置。
2. 还是汽车，给出汽车行驶的里程，求字符串。
 */
public class CarTravel {
	// String format "FFTT", f is forward, t is turn
	public int calPos(String s){
		int currPos=0;
		int currSpeed=1;
		boolean forward=true;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='F'){
				currPos=currPos+currSpeed;
				currSpeed=currSpeed*2;
			}
			else{
				currPos=currPos+currSpeed;
				if(forward){
					currSpeed=-1;
				}
				else{
					currSpeed=1;
				}
				forward=!forward;
			}
		}
		currPos=currPos+currSpeed;
		return currPos;
	}
	
	public String calString(int pos){
		StringBuilder sb=new StringBuilder();
		HashMap<String,int[]> map=new HashMap<String,int[]>();
		int[] toadd={0,1};
		map.put("", toadd);
		return bfs(pos,map);
	}
	public String bfs(int pos,HashMap<String,int[]> map){
		HashMap<String,int[]> newMap=new HashMap<String,int[]>();
		for(String key:map.keySet()){
			int[] curr=map.get(key);
			curr[0]=curr[0]+curr[1];
			if(curr[0]==pos){
				return key;
			}
			if(curr[1]>0){
				int[] toadd1={curr[0],curr[1]*2};
				newMap.put(key+"F", toadd1);
				int[] toadd2={curr[0],-1};
				newMap.put(key+"T", toadd2);
			}
			else{
				int[] toadd1={curr[0],curr[1]*2};
				newMap.put(key+"F", toadd1);
				int[] toadd2={curr[0],1};
				newMap.put(key+"T", toadd2);
			}
		}
		return bfs(pos,newMap);
	}
}
