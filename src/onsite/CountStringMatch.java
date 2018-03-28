package onsite;
import java.util.*;
/*
 * 两个字符串的匹配, 第二个字符串是第一个字符串删掉的结果
输出第二个在第一个里面对应的index， 要求只有唯一配对的时候输出true 如果存在多个配对 则输出 false

  a b c d e f g    a b -> [0,1]
  a b b c , ab c  -> False

 */
public class CountStringMatch {
	public List<Integer> isUniqueSubstring(String s,String t){
		List<Integer> r1=new ArrayList<Integer>();
		List<Integer> r2=new ArrayList<Integer>();
		int i1=0;
		int i2=0;
		while(i1<s.length()&&i2<t.length()){
			if(s.charAt(i1)==t.charAt(i2)){
				r1.add(i1);
				i2++;
			}
			i1++;
		}
		i1=s.length()-1;
		i2=t.length()-1;
		while(i1>=0&&i2>=0){
			if(s.charAt(i1)==t.charAt(i2)){
				r2.add(i1);
				i2--;
			}
			i1--;
		}
		Collections.reverse(r2);
		if(r1.size()<t.length()||!isSameIndex(r1,r2)){
			return new ArrayList<Integer>();
		}
		return r1;
	}
	public boolean isSameIndex(List<Integer> r1,List<Integer> r2){
		if(r1.size()!=r2.size()){
			return false;
		}
		for(int i=0;i<r1.size();i++){
			if(r1.get(i)!=r2.get(i)){
				return false;
			}
		}
		return true;
	}
	public boolean compareResult(List<Integer> r1,int[] r2){
		if(r1.size()!=r2.length){
			return false;
		}
		for(int i=0;i<r1.size();i++){
			if(r1.get(i)!=r2[i]){
				return false;
			}
		}
		return true;
	}
}
