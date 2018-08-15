package onsite;
import java.util.*;
/*
 * 假设给你一个字符串的iterator，如何实现一个iterator，通过调用hasNext和next可以返回字符串的统计信息。
例子：. 围观我们@1point 3 acres
逐个string iterator返回的内容为："a", "a", "a", "b", "a".留学论坛-一亩-三分地
你实现的iterator每个next应该返回：<a, 3>, <b, 1>, <a, 1>
 */
public class CharCountIterator implements Iterator<String>{
	Iterator<String> it;
	String lastString;
	int count;
	public CharCountIterator(List<String> list){
		if(list==null||list.size()==0){
			lastString=null;
			count=0;
		}
		else{
			this.it=list.iterator();
			lastString=it.next();
			count=1;
		}
	}
	@Override
	public boolean hasNext(){
		return lastString!=null;
	}
	@Override
	public String next(){
		String res=null;
		while(it.hasNext()){
			String next=it.next();
			if(next.equals(lastString)){
				count++;
			}
			else{
				res=lastString+count;
				lastString=next;
				count=1;
				return res;
			}
		}
		res=lastString+count;
		lastString=null;
		count=0;
		return res;
	}
}
