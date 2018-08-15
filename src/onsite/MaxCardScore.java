package onsite;
import java.util.*;
/*
 * 有一个2d board, board上有一行字，例如cat
你有一堆字母的卡片，例如a, a, t, r
每一个字母有相应的分数，只要是相同字母分数一样
  有一个List<String>dictionary
  现在你垂直于board上的字母放卡片（也就是说只能利用board上的一个字母）， 问使用你手中已有的卡片， 
  并利用board上的一个字母，能拼出的单词的最大分数的单词是什么，此单词要属于dictionary
 */
// assuming only lower char
public class MaxCardScore {
	public int maxScore(char[][] board,Set<String> dic,char[] cards,int[] scores){
		if(board.length==0||board[0].length==0||dic.isEmpty()){
			return 0;
		}
		Set<Character> startChar=new HashSet<Character>();
		int[] hand=new int[26];
		for(int i=0;i<cards.length;i++){
			hand[cards[i]-'a']++;
		}
		for(int i=0;i<board[0].length;i++){
			startChar.add(board[0][i]);
		}
		int maxScore=0;
		for(String word:dic){
			if(word==null||word.length()==0){
				continue;
			}
			if(word.length()<=board.length&&startChar.contains(word.charAt(0))){
				int score=calScore(word.substring(1),hand,scores);
				if(score>=0){
					score=score+scores[word.charAt(0)-'a'];
					maxScore=Math.max(maxScore, score);
				}
			}
		}
		
		return maxScore;
	}
	private int calScore(String s,int[] hand,int[] scores){
		int[] needed=new int[26];
		for(int i=0;i<s.length();i++){
			needed[s.charAt(i)-'a']++;
		}
		int totalScore=0;
		for(int i=0;i<26;i++){
			if(needed[i]>hand[i]){
				return -1;
			}
			totalScore=totalScore+needed[i]*scores[i];
		}
		return totalScore;
	}
}
