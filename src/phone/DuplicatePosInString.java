package phone;
import java.util.*;
/*
 * 给字符串s,返回重复次数超过两次的连续字符的起始位置（重复1次两次都算合法，大于两次算不合法）
e.g. hellloooo 返回[[2,4][5,8]]
 */
public class DuplicatePosInString {
	public List<int[]> findDuplicatePos(String s){
		List<int[]> res=new ArrayList<int[]>();
		if(s==null||s.length()==0){
			return res;
		}
		char lastChar=' ';
		int count=0;
		for(int i=0;i<=s.length();i++){
			if(i==s.length()||s.charAt(i)!=lastChar){
				if(count>2){
					res.add(new int[]{i-count,i-1});
				}
				if(i<s.length()){
					count=1;
					lastChar=s.charAt(i);
				}
			}
			else{
				count++;
			}
		}
		return res;
	}
	public boolean compareRes(List<int[]> r1,int[][] r2){
		if(r1.size()!=r2.length){
			return false;
		}
		for(int i=0;i<r1.size();i++){
			int[] a1=r1.get(i);
			int[] a2=r2[i];
			if(a1[0]!=a2[0]||a1[1]!=a2[1]){
				return false;
			}
		}
		return true;
	}
}
