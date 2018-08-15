package onsite;
import java.util.*;
/*
 * 给你一个字符串和一个集合，集合里面是字符串里所有distinct字符。比如说，String: "abcbbbbba", Set: "a, b, c". 
 * 找到所有valid substring, 怎么定义valid： substring 如果不完全包含set里面的字符，就算是valid。 
 * "abc" 是invalid， "cb"， "a"是valid。substring 是连续的字符，in order。
 */
public class NonInclusiveSubString {
	public List<String> getValidSubstring(String s,Set<Character> dic){
		List<String> res=new ArrayList<String>();
		if(s==null||s.length()==0){
			return res;
		}
		int end=0;
		int needed=dic.size();
		int found=0;
		int[] count=new int[256];
		for(int start=0;start<s.length();start++){
			// expand end pointer to include all chars or reach end
			while(end<s.length()&&found<needed){
				char ch=s.charAt(end);
				if(count[ch]==0&&dic.contains(ch)){
					found++;
				}
				count[ch]++;
				end++;
			}
			// add all substring in between to result
			for(int i=start+1;i<=end;i++){
				res.add(s.substring(start,i));
			}
			//update start pointer char
			char chStart=s.charAt(start);
			count[chStart]--;
			if(count[chStart]==0&&dic.contains(chStart)){
				found--;
			}
		}
		return res;
	}
	public boolean checkResult(List<String> res,String[] target){
		if(res.size()!=target.length){
			return false;
		}
		for(int i=0;i<res.size();i++){
			if(!res.get(i).equals(target[i])){
				return false;
			}
		}
		return true;
	}
}
