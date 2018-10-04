package onsite;
import java.util.*;
/*
 * 题目是，给一个字符串（如“cadogt”)，判断是否存在两个单词，例子里就是“cat”，“dog”，并且这两个单词合并之后能得到这个串。
 * 合并规则和merge sort一样，这里就是 c<d a<d o>g
 * my understanding is that when doing merge sort we use 2 pointer and compare each pair of chars
 * then push which ever is lower into the result string and move corresponding pointer.
 */
public class ReconstructMergeSortedString {
	public boolean canReconstruct(String target,Set<String> validWords){
		boolean[] res={false};
		searchCombination(new StringBuilder(),new StringBuilder(),target,0,validWords,res);
		return res[0];
	}
	private void searchCombination(StringBuilder sb1, StringBuilder sb2, String target, int index,
			Set<String> validWords,boolean[] res) {
		if(res[0]){
			return;
		}
		if(index==target.length()){
			String w1=sb1.toString();
			String w2=sb2.toString();
			if(validWords.contains(w1)&&validWords.contains(w2)&&mergeWord(w1,w2).equals(target)){
				res[0]=true;
			}
			return;
		}
		sb1.append(target.charAt(index));
		searchCombination(sb1,sb2,target,index+1,validWords,res);
		sb1.deleteCharAt(sb1.length()-1);
		
		sb2.append(target.charAt(index));
		searchCombination(sb1,sb2,target,index+1,validWords,res);
		sb2.deleteCharAt(sb2.length()-1);
	}
	public String mergeWord(String w1,String w2){
		int index1=0;
		int index2=0;
		StringBuilder sb=new StringBuilder();
		while(index1<w1.length()||index2<w2.length()){
			if(index1<w1.length()&&index2<w2.length()){
				char ch1=w1.charAt(index1);
				char ch2=w2.charAt(index2);
				if(ch1<ch2){
					sb.append(ch1);
					index1++;
				}
				else{
					sb.append(ch2);
					index2++;
				}
			}
			else if(index1<w1.length()){
				sb.append(w1.charAt(index1));
				index1++;
			}
			else{
				sb.append(w2.charAt(index2));
				index2++;
			}
		}
		return sb.toString();
	}
}
