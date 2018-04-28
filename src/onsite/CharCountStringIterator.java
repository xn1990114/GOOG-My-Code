package onsite;
/*
 * 假设给你一个字符串的iterator，如何实现一个iterator，通过调用hasNext和next可以返回字符串的统计信息。
例子：
逐个string iterator返回的内容为："a", "a", "a", "b", "a"
你实现的iterator每个next应该返回：<a, 3>, <b, 1>, <a, 1>
 */
public class CharCountStringIterator {
	String s;
	int index;
	public CharCountStringIterator(String s){
		this.s=s;
		this.index=0;
	}
	public boolean hasNext(){
		return index<s.length();
	}
	public String next(){
		char ch=s.charAt(index);
		int count=0;
		while(index<s.length()&&s.charAt(index)==ch){
			index++;
			count++;
		}
		return ch+""+count;
	}
}
