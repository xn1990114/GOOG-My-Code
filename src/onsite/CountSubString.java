package onsite;
import java.util.*;
/*
 * 给两个字符串，返回有几个非连续的字符串子集
比如：
input:
str = aab, sub = ab
output:
2
解释
str = aab包含两个sub，分别是下标0，2和下标1，2

再比如:
input:
str = aabbab, sub = ab
output:
7
解释：
下标为02,03,05,12,13,15,45
 */
public class CountSubString {
	public int countSubstring(String s,String sub){
		int[][] res=new int[sub.length()+1][s.length()+1];
		for(int i=0;i<sub.length();i++){
			Arrays.fill(res[i], -1);
		}
		Arrays.fill(res[sub.length()], 1);
		count(sub,s,0,0,res);
		return res[0][0];
	}
	public void count(String sub,String s,int i1,int i2,int[][] res){
		if(i2==s.length()){
			res[i1][i2]=0;
		}
		int i=i2;
		int count=0;
		while(i<s.length()){
			if(sub.charAt(i1)==s.charAt(i)){
				if(res[i1+1][i+1]==-1){
					count(sub,s,i1+1,i+1,res);
				}
				count=count+res[i1+1][i+1];
			}
			i++;
		}
		res[i1][i2]=count;
	}
}
