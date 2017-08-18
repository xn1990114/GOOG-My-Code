package onsite;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * input是两个string： string1 和string2， 要求是把string1 convert成string2。 
 * 有两个method， 一个是 void pre(char ch), 意思是把String1里的的ch replace成字母序列里前一位的character.
 *  比如 pre(‘b’), 就是把所有string1 里的 'b' convert 成 ‘a’. 
 *  另一个method 是 void next(char ch),  意思是把String1里的的ch replace成 字母序列里后一位的character.
 *  比如 pre(‘b’), 就是把所有string1 里的 'b' convert 成 ‘c’.   
 *  另外 ‘a’ 的pre还是 ‘a’, 'z' 的  next 还是‘z’.  
 *  需要的output是想要完成 string1 到string2 的conversion所需要call 这两个method 的次数之和。  
 *  如果不能conversion， 返回 -1.
 *  
 *  Unsovled, below answer can be wrong
 *  http://www.1point3acres.com/bbs/thread-230637-1-1.html
 */
public class StringConversion {
	public int countSteps(String s1,String s2){
		if(s1.length()!=s2.length()){
			return -1;
		}
		int[] tracker=new int[26];
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
			public int compare(int[] i1,int[] i2){
				int result=Math.abs(i1[0]-i1[1])-Math.abs(i2[0]-i2[1]);
				return result;
			}
		});
		Arrays.fill(tracker, -1);
		for(int i=0;i<s1.length();i++){
			int c1=s1.charAt(i)-'a';
			int c2=s2.charAt(i)-'a';
			if(tracker[c1]==c2){
				continue;
			}
			else if(tracker[c1]==-1){
				tracker[c1]=c2;
			}
			else{
				return -1;
			}
			int[] toadd={c1,c2};
			pq.offer(toadd);
		}
		int count=0;
		Arrays.fill(tracker, -1);
		while(!pq.isEmpty()){
			int[] top=pq.poll();
			int ori=top[0];
			int target=top[1];
			int extra=Math.abs(target-ori);
			if(tracker[ori]==target){
				continue;
			}
			if(target>ori){
				for(int i=0;i<=target;i++){
					if(i<ori){
						if(tracker[i]>target){
							return -1;
						}
						if(tracker[i]==target){
							extra=0;
							break;
						}
						else if(tracker[i]>ori){
							extra=target-ori;
						}
					}
					else{
						if(tracker[i]==target){
							extra=i-ori;
							break;
						}
						else if(tracker[i]!=-1&&tracker[i]<i){
							return -1;
						}
						else if(tracker[i]>ori){
							extra=target-ori;
						}
					}
				}
			}
			else if(target<ori){
				for(int i=25;i>=target;i--){
					if(tracker[i]!=-1&&tracker[i]<target){
						return -1;
					}
					if(i>=ori){
						if(tracker[i]==target){
							extra=0;
							break;
						}
						else if(tracker[i]<ori){
							extra=ori-target;
						}
					}
					else{
						if(tracker[i]==target){
							extra=ori-i;
							break;
						}
						else if(tracker[i]>i){
							return -1;
						}
						else if(tracker[i]<ori){
							extra=ori-target;
						}
					}
				}
			}
			count=count+extra;
			tracker[ori]=target;
		}
		return count;
	}
}
