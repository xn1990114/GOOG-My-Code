package onsite;
import java.util.*;
/*
 * 实现auto-complete，也就是trie，支持搜索单词和包含wildcard的单词例如ab*cd
 */
public class StringAutoComplete {
	class Node{
		Node[] child;
		String s;
		public Node(){
			this.child=new Node[26];
			this.s=null;
		}
	}
	Node root=new Node();
	public void addDic(String[] dic){
		for(int i=0;i<dic.length;i++){
			buildTrie(dic[i].toLowerCase());
		}
	}
	public void buildTrie(String s){
		Node curr=this.root;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(curr.child[ch-'a']==null){
				curr.child[ch-'a']=new Node();
			}
			curr=curr.child[ch-'a'];
		}
		curr.s=s.toLowerCase();
	}
	public Set<String> searchString(String s){
		Set<String> result=new HashSet<String>();
		search(s,root,result,0);
		return result;
	}
	public void search(String s, Node curr,Set<String> result,int index){
		if(curr==null){
			return;
		}
		if(index==s.length()){
			result.add(curr.s);
		}
		
		for(int i=index;i<s.length()&&curr!=null;i++){
			char ch=s.charAt(i);
			if(ch=='*'){
				for(int j=0;j<26;j++){
					search(s,curr.child[j],result,i);
				}
			}
			else {
				curr=curr.child[ch-'a'];
			}
		}
		findAll(result,curr);
	}
	public void findAll(Set<String> result,Node curr){
		if(curr==null){
			return;
		}
		if(curr.s!=null){
			result.add(curr.s);
		}
		for(int i=0;i<26;i++){
			findAll(result,curr.child[i]);
		}
	}
}
