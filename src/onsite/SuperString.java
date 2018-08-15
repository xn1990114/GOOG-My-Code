package onsite;
import java.util.*;
/*
 * 给两个string，比如 lee和eel,找到一个最短的string,它的substring包含这两个stirng,比如 leel.
 * (应该是KMP,然而忘了怎么写了，弄了个hashSet存一个string的所有prefix,跟另一个比较，O(n^2))
  follow up: 给一堆string怎么办？（这轮血炸，一开始思路就错了，一直在想greedy的方法，实际上不是greedy的，dfs遍历就好。。
  最后画了个dfs树，没时间写代码了。。）
 */
public class SuperString {
	public String findMinSuperString(String s1,String s2){
		if(s1==null||s2==null){
			return "";
		}
		if(s1.length()==0||s2.length()==0){
			return s1+s2;
		}
		for(int i=0;i<s1.length();i++){
			if(s1.length()-i>s2.length()){
				continue;
			}
			String target=s1.substring(i);
			if(s2.startsWith(target)){
				return s1.substring(0, i)+s2;
			}
		}
		return s1+s2;
	}
	public String makeShortestSuperStringGreedy(String[] strs){
		if(strs==null||strs.length==0){
			return "";
		}
		int startIndex=-1;
		int maxOverlap=-1;
		Map<Integer,List<Tracker>> map=new HashMap<Integer,List<Tracker>>(); 
		for(int i=0;i<strs.length;i++){
			List<Tracker> curr=new ArrayList<Tracker>();
			for(int j=0;j<strs.length;j++){
				if(i==j){
					continue;
				}
				String tempRes=findMinSuperString(strs[i],strs[j]);
				curr.add(new Tracker(j,strs[j],strs[i].length()+strs[j].length()-tempRes.length()));
			}
			Collections.sort(curr);
			map.put(i, curr);
			if(!curr.isEmpty()){
				int currMax=curr.get(curr.size()-1).overlap;
				if(currMax>maxOverlap){
					maxOverlap=currMax;
					startIndex=i;
				}
			}
		}
		startIndex=Math.max(0, startIndex);
		StringBuilder sb=new StringBuilder();
		sb.append(strs[startIndex]);
		int count=1;
		boolean[] visited=new boolean[strs.length];
		visited[startIndex]=true;
		while(count<strs.length){
			List<Tracker> cand=map.get(startIndex);
			for(int i=0;i<cand.size();i++){
				Tracker t=cand.get(i);
				if(!visited[t.index]){
					visited[t.index]=true;
					sb.append(t.targetString.substring(t.overlap));
					startIndex=t.index;
					break;
				}
			}
			count++;
		}
		return sb.toString();
	}
	class Tracker implements Comparable<Tracker>{
		int index;
		String targetString;
		int overlap;
		public Tracker(int index,String s,int overlap){
			this.index=index;
			this.targetString=s;
			this.overlap=overlap;
		}
		public int compareTo(Tracker t2){
			return -(this.overlap-t2.overlap);
		}
	}
	// back track
	public String makeShortestSuperString(String[] strs){
		if(strs==null||strs.length==0){
			return "";
		}
		String[] res=new String[1];
		boolean[] visited=new boolean[strs.length];
		dfsPatterns("",0,visited,strs,res);
		return res[0];
	}
	private void dfsPatterns(String currPattern,int usedCount,boolean[] visited,String[] strs,String[] res){
		if(usedCount==strs.length){
			if(res[0]==null||res[0].length()>currPattern.length()){
				res[0]=currPattern;
			}
			return;
		}
		for(int i=0;i<strs.length;i++){
			if(!visited[i]){
				visited[i]=true;
				String nextPattern=findMinSuperString(currPattern,strs[i]);
				dfsPatterns(nextPattern,usedCount+1,visited,strs,res);
				visited[i]=false;
			}
		}
	}
}
