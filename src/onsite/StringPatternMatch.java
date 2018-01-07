package onsite;
/*
 * 给你一个pattern（pattern中digit表示匹配相应个letter，letter表示匹配letter本身），一个string判断是否match：
ex:
abc->'abc'
'1oc3'->'aoczzz', 'bocabc'
 */
public class StringPatternMatch {
	public boolean isMatch(String s,String pattern){
		int indexS=0;
		int indexP=0;
		while(indexP<pattern.length()&&indexS<s.length()){
			if(Character.isDigit(pattern.charAt(indexP))){
				int start=indexP;
				while(indexP<pattern.length()&&Character.isDigit(pattern.charAt(indexP))){
					indexP++;
				}
				indexS=indexS+Integer.parseInt(pattern.substring(start,indexP));
			}
			else{
				if(pattern.charAt(indexP)!=s.charAt(indexS)){
					return false;
				}
				indexP++;
				indexS++;
			}
		}
		return indexS==s.length()&&indexP==pattern.length();
	}
}
