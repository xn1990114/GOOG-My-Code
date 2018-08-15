package onsite;
import java.util.*;
//给一个String “a{1,2}b{3,4}d”输出 “a1b3d”,"a2b3d","a2b3d","a2b4d" 我说可以把string 抽象成树的结构 用dfs 或者bfs解决。 
public class LetterNumberCombinationString {
	class Data{
		String s;
		List<Integer> nums;
		public Data(){
			this.nums=new ArrayList<Integer>();
		}
	}
	public List<String> getCombination(String s){
		List<String> res=new ArrayList<String>();
		List<Data> dataList=parseString(s);
		dfs("",res,dataList,0);
		return res;
	}
	private void dfs(String curr,List<String> res,List<Data> dataList,int index){
		if(index==dataList.size()){
			res.add(curr);
			return;
		}
		Data d=dataList.get(index);
		if(d.s!=null){
			dfs(curr+d.s,res,dataList,index+1);
		}
		else{
			List<Integer> nums=d.nums;
			for(int i=0;i<nums.size();i++){
				dfs(curr+nums.get(i),res,dataList,index+1);
			}
		}
	}
	
	private List<Data> parseString(String s){
		int index=0;
		List<Data> res=new ArrayList<Data>();
		while(index<s.length()){
			char ch=s.charAt(index);
			if(ch=='{'){
				int start=index+1;
				index++;
				while(index<s.length()&&s.charAt(index)!='}'){
					index++;
				}
				String[] str=s.substring(start,index).split(",");
				Data d=new Data();
				for(int i=0;i<str.length;i++){
					d.nums.add(Integer.parseInt(str[i]));
				}
				res.add(d);
				index++;
			}
			else{
				int start=index;
				while(index<s.length()&&Character.isLetter(s.charAt(index))){
					index++;
				}
				Data d=new Data();
				d.s=s.substring(start,index);
				res.add(d);
			}
		}
		return res;
	}
}
