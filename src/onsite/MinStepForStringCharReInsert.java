package onsite;
/*
 * 大概是从一个string 变成另一个string的最短步数（string的字母是一样的）。 
 * 规则是每次从第一个string拿一个字符放到最前面。
 */
public class MinStepForStringCharReInsert {
	public int findMinStep(String s,String target){
		if(s==null||target==null||s.equals(target)){
			return 0;
		}
		int minStep=Integer.MAX_VALUE;
		for(int i=s.length()-1;i>=0;i--){
			if(s.charAt(i)==target.charAt(target.length()-1)){
				int maxSubLen=findMaxSubsequenceLength(s,target,i);
				minStep=Math.min(minStep, target.length()-maxSubLen);
			}
		}
		return minStep;
	}
	public int findMaxSubsequenceLength(String s,String target,int indexS){
		int indexT=target.length()-1;
		int matchedCount=0;
		while(indexS>=0){
			if(target.charAt(indexT)==s.charAt(indexS)){
				matchedCount++;
				indexT--;
				indexS--;
			}
			else{
				indexS--;
			}
		}
		return matchedCount;
	}
}
