package onsite;
import java.util.*;
/*
 * Given a string s and a word w, determine whether w is a subsequence of s.
这个题一开始以为是连续的substring，后来告诉不是就O(n)过了，简单
主要是follow up是高能
Given a string s and a dict of words, find the longest word in D that  is a subsequence of s 
这个其实也简单，就是暴力解遍历一下两遍就搞定
再follow up，更简便的方法
就这卡住了，一开始想错了用trie tree，但讨论了得有10分钟吧，发现根本解不了，因为不是substring的，就傻了。
后来提示下，逐渐想到用hashmap，但key value又想错了，最后姐姐提示用hashmap character int[]，我就知道了，到这就下面全答出来了，把每个char的index存一下，然后维持maxlen,curlen啥的。
 */
public class StringSubSequence {
	public String findLogestSubSequence(String m,String[] array){
		Map<Character,List<Integer>> dic=new HashMap<Character,List<Integer>>();
		for(int i=0;i<m.length();i++){
			char ch=m.charAt(i);
			if(!dic.keySet().contains(ch)){
				dic.put(ch, new ArrayList<Integer>());
			}
			dic.get(ch).add(i);
		}
		int maxIndex=-1;
		for(int i=0;i<array.length;i++){
			if(array[i].length()>m.length()){
				continue;
			}
			else if(maxIndex==-1||array[i].length()>array[maxIndex].length()){
				if(isSubSequence(dic,array[i])){
					maxIndex=i;
				}
			}
		}
		return maxIndex==-1?null:array[maxIndex];
	}
	public boolean isSubSequence(Map<Character,List<Integer>> dic,String s){
		int last=-1;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			List<Integer> list=dic.get(ch);
			if(list==null){
				return false;
			}
			int start=0;
			int end=0;
			while(start<=end){
				int mid=start+(end-start)/2;
				if(list.get(mid)>last&&(mid==0||list.get(mid-1)<=last)){
					last=mid;
					break;
				}
				else if(list.get(mid)>last){
					end=mid-1;
				}
				else{
					start=mid+1;
				}
			}
			if(start>end){
				return false;
			}
		}
		return true;
	}
}
