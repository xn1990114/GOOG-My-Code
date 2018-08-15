package onsite;

import java.util.*;

/*
 * input是两个string： string1 和string2， 要求是把string1 convert成string2。 
 * 有两个method， 一个是 void pre(char ch), 意思是把String1里的的ch replace成字母序列里前一位的character.
 *  比如 pre(‘b’), 就是把所有string1 里的 'b' convert 成 ‘a’. 
 *  另一个method 是 void next(char ch),  意思是把String1里的的ch replace成 字母序列里后一位的character.
 *  比如 post(‘b’), 就是把所有string1 里的 'b' convert 成 ‘c’.   
 *  另外 ‘a’ 的pre还是 ‘a’, 'z' 的  next 还是‘z’.  
 *  需要的output是想要完成 string1 到string2 的conversion所需要call 这两个method 的次数之和。  
 *  如果不能conversion， 返回 -1.
 *  
 *  http://www.1point3acres.com/bbs/thread-230637-1-1.html
 */
// below solution assumes next(z)='a'. Solution works for above req, just need to change pre() and next() method
public class StringConversion {
	public int countSteps(String s1,String s2){
		if(s1.length()!=s2.length()){
			return -1;
		}
		Set<String> visited=new HashSet<String>();
		Queue<String> qu=new LinkedList<String>();
		qu.offer(s1);
		visited.add(s1);
		int step=0;
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int round=0;round<size;round++){
				String top=qu.poll();
				if(top.equals(s2)){
					return step;
				}
				for(char ch='a';ch<='z';ch++){
					String cand1=pre(top,ch);
					String cand2=next(top,ch);
					if(!visited.contains(cand1)){
						visited.add(cand1);
						qu.offer(cand1);
					}
					if(!visited.contains(cand2)){
						visited.add(cand2);
						qu.offer(cand2);
					}
				}
			}
			step++;
		}
		return -1;
	}
	public String pre(String s,char ch){
		char[] array=s.toCharArray();
		char targetCh=(char)((ch-'a'-1+26)%26+'a');
		for(int i=0;i<array.length;i++){
			if(array[i]==ch){
				array[i]=targetCh;
			}
		}
		return String.valueOf(array);
	}
	public String next(String s,char ch){
		char[] array=s.toCharArray();
		char targetCh=(char)((ch-'a'+1)%26+'a');
		for(int i=0;i<array.length;i++){
			if(array[i]==ch){
				array[i]=targetCh;
			}
		}
		return String.valueOf(array);
	}
}
