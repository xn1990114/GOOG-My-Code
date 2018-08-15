package onsite;

import java.util.Arrays;

/*
 * 给一个string， 叫order，比如abc，那么规定a在b前面，以此类推
给第二个 string s，判断s是否符合order，返回boolean，
如果aaa就是对
如果cba就不对
如果aaxyc就对，没出现过的字母跳过
 */
public class StringSortedSequence {
	public boolean isCorrectSeq(String s,String order){
		int[] seq=new int[256];
		Arrays.fill(seq, -1);
		for(int i=0;i<order.length();i++){
			seq[order.charAt(i)]=i;
		}
		int indexOrder=-1;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			int currSeq=seq[ch];
			if(currSeq!=-1&&currSeq<indexOrder){
				return false;
			}
			indexOrder=Math.max(indexOrder, currSeq);
		}
		return true;
	}
}
