package onsite;
import java.util.*;
/*
 * 有个string table的概念 foobar\foo\ 类似于一个encoded string,
 * 这个string table再加上一堆offsets的话，你就会extract出来一些string出来，
 * extract的方法是从offset开始知道碰到\结束(\算一个字符)。比如 "foobar\foo\" 
 * 如果offsets是{0, 3, 7} 就能得到3个string foobar, bar, foo。
 * 问题就是你不用管offsets怎么生成，given string[] strs, 
 * output the string table that will be able to extract all elements from given array 
 * and also make the length of string table shortest as possible. 
 * 对于刚才的case "foobar\foo\bar\"也是一个满足要求的stringtable但是不是最短。
 */
public class StringTableForExtraction {
	class Node {
		Map<Character,Node> child;
		public Node(){
			this.child=new HashMap<Character,Node>();
		}
	}
	public void buildTrie(Node root,String s){
		Node curr=root;
		for(int i=s.length()-1;i>=0;i--){
			char ch=s.charAt(i);
			if(!curr.child.containsKey(ch)){
				curr.child.put(ch, new Node());
			}
			curr=curr.child.get(ch);
		}
	}
	public void buildAllString(StringBuilder res,Node curr,StringBuilder sb){
		if(curr==null){
			return;
		}
		if(curr.child.isEmpty()){
			sb.reverse();
			res.append(sb.toString());
			res.append('/');
			sb.reverse();
			return;
		}
		else{
			for(char key:curr.child.keySet()){
				sb.append(key);
				buildAllString(res,curr.child.get(key),sb);
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}
	public String createStringTable(String[] strs){
		Node root=new Node();
		for(int i=0;i<strs.length;i++){
			buildTrie(root,strs[i]);
		}
		StringBuilder res=new StringBuilder();
		buildAllString(res,root,new StringBuilder());
		return res.toString();
	}
	
}
