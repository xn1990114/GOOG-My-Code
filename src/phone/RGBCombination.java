package phone;
import java.util.*;
//给'R', 'G', 'B'三个character和length k, 
//return all possible strings that are made up of the three chars with length k. 
public class RGBCombination {
	public List<String> findAllCombinations(int k){
		List<String> res=new ArrayList<String>();
		if(k<0){
			return res;
		}
		String dic="RGB";
		char[] currCharList=new char[k];
		dfs(res,dic,currCharList,0,k);
		return res;
	}
	public void dfs(List<String> res, String dic,char[] currCharList,int index,int k){
		if(index==k){
			res.add(String.valueOf(currCharList));
			return;
		}
		for(int i=0;i<dic.length();i++){
			currCharList[index]=dic.charAt(i);
			dfs(res,dic,currCharList,index+1,k);
		}
	}
}
