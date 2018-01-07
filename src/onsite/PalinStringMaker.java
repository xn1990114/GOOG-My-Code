package onsite;

import java.util.Arrays;

/*
 * 给一个string，可以在任意部分插任意个char， 使得其为回文，求最短的回文
 */
public class PalinStringMaker {
	public String findMinPalin(String s){
		if(s.length()==0){
			return s;
		}
		String[][] res=new String[s.length()+1][s.length()];
		for(int i=0;i<s.length();i++){
			res[0][i]="";
			res[1][i]=""+s.charAt(i);
		}
		for(int len=2;len<=s.length();len++){
			for(int start=0;start+len-1<s.length();start++){
				if(s.charAt(start)==s.charAt(start+len-1)){
					res[len][start]=s.charAt(start)+res[len-2][start+1]+s.charAt(start);
				}
				else{
					res[len][start]=s.charAt(start)+""+s.charAt(start+len-1)+res[len-2][start+1]+s.charAt(start+len-1)+""+s.charAt(start);
				}
				String temp1=s.charAt(start)+res[len-1][start+1]+s.charAt(start);
				String temp2=s.charAt(start+len-1)+res[len-1][start]+s.charAt(start+len-1);
				if(temp1.length()>temp2.length()){
					temp1=temp2;
				}
				if(temp1.length()<res[len][start].length()){
					res[len][start]=temp1;
				}
			}
		}
		return res[s.length()][0];
	}
}
