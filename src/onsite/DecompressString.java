package onsite;
import java.util.*;
//给定一组char，包含({.小括号 Eg. : a(b(c){2}){2}d will be decompressed as abccbccd. 
//{}中间的是前面（）里的内容的重复次数。
public class DecompressString {
	public String recoverString(String s){
		Stack<StringBuilder> sbs=new Stack<StringBuilder>();
		StringBuilder curr=new StringBuilder();
		int index=0;
		while(index<s.length()){
			char ch=s.charAt(index);
			if(ch=='('){
				sbs.push(curr);
				curr=new StringBuilder();
			}
			else if(ch==')'){
				index=index+2;
				int start=index;
				while(index<s.length()&&Character.isDigit(s.charAt(index))){
					index++;
				}
				int count=Integer.parseInt(s.substring(start,index));
				String temp=curr.toString();
				curr=sbs.pop();
				for(int i=0;i<count;i++){
					curr.append(temp);
				}
			}
			else{
				curr.append(ch);
			}
			index++;
		}
		return curr.toString();
	}
}
