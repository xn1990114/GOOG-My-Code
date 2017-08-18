package onsite;
import java.util.*;

/*
 * 给一个List<Pair>，每一个Pair的两个词是同义词，再给两句话，让判断这两句话是不是一个意思
    a) 不用考虑同义词的传递性，
    b) 考虑同义词的传递性
 * 
 */
public class SameMeaning {
	public boolean Solution(String s1,String s2, String[][] dic){
		HashMap<String,Set<String>>map=new HashMap<String,Set<String>>();
		for(int i=0;i<dic.length;i++){
			if(!map.keySet().contains(dic[i][0])){
				map.put(dic[i][0], new HashSet<String>());
			}
			if(!map.keySet().contains(dic[i][1])){
				map.put(dic[i][1], new HashSet<String>());
			}
			map.get(dic[i][0]).add(dic[i][1]);
			map.get(dic[i][1]).add(dic[i][0]);
		}
		int i=0;
		int j=0;
		while(i<s1.length()||j<s2.length()){
			while(i<s1.length()&&!((s1.charAt(i)>='a'&&s1.charAt(i)<='z')||(s1.charAt(i)>='A'&&s1.charAt(i)<='Z'))){
				i++;
			}
			int start1=i;
			while(i<s1.length()&&((s1.charAt(i)>='a'&&s1.charAt(i)<='z')||(s1.charAt(i)>='A'&&s1.charAt(i)<='Z'))){
				i++;
			}
			int end1=i;
			while(j<s2.length()&&!((s2.charAt(j)>='a'&&s2.charAt(j)<='z')||(s2.charAt(j)>='A'&&s2.charAt(j)<='Z'))){
				j++;
			}
			int start2=j;
			while(j<s2.length()&&((s2.charAt(j)>='a'&&s2.charAt(j)<='z')||(s2.charAt(j)>='A'&&s2.charAt(j)<='Z'))){
				j++;
			}
			int end2=j;
			String w1=s1.substring(start1,end1);
			String w2=s2.substring(start2,end2);
			HashSet<String> visited=new HashSet<String>();
			visited.add(w1);
			if(!sameMeaning(w1,w2,map,visited)){
				return false;
			}
		}
		return true;
	}
	public boolean sameMeaning(String w1,String w2,HashMap<String,Set<String>>map,HashSet<String> visited ){
		if(w1.equals(w2)){
			return true;
		}
		if(!map.keySet().contains(w1)||!map.keySet().contains(w2)){
			return false;
		}
		if(map.get(w1).contains(w2)){
			return true;
		}
		for(String s:map.get(w1)){
			if(visited.contains(s)){
				continue;
			}
			visited.add(s);
			if(sameMeaning(s,w2,map,visited)){
				return true;
			}
		}
		return false;
	}
	
}
