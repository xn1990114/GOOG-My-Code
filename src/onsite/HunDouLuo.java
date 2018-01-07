package onsite;
import java.util.*;
/*
 * 题目是魂斗罗的作弊码，上上下下左左右右BBAA，
 * 给一连串输入判断是否调用konami作弊
 */
public class HunDouLuo {
	public boolean checkCheatCode(String keys){
		String s="UUDDLLRRBBAA";
		StringBuilder sb=new StringBuilder();
		Iterator<Character> it=getIterator(keys);
		char last=' ';
		int i=0;
		while(it.hasNext()){
			char ch=it.next();
			sb.append(ch);
			if(s.charAt(i)==ch){
				i++;
			}
			else if(ch=='U'&&last=='U'){
				i=2;
			}
			else if(ch=='U'){
				i=1;
			}
			else{
				i=0;
			}
			if(i==s.length()){
				System.out.println("input: "+s+" got result with: "+sb.toString());
				return true;
			}
			last=ch;
		}
		System.out.println("input: "+s+" doesn't contain cheat code" );
		return false;
	}

	private Iterator<Character> getIterator(String s) {
		char[] str=s.toCharArray();
		List<Character> list=new ArrayList<Character>();
		for(char ch:str){
			list.add(ch);
		}
		return list.iterator();
	}
}
