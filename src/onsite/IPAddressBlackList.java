package onsite;
import java.util.*;
/*
 * IP address blacklist matching
给一个black list，里面都是ip address，ip address里可能包含wildcard字符 "*", 问如果现在有一 个ip address，
它是否在black list里。和面试官交流后，确认ip address都是合法的，而wildcard 只会出现每个地址的最后，直接用trie做了。
 */
public class IPAddressBlackList {
	public class TrieNode{
		Map<Character,TrieNode> child;
		boolean isLeaf;
		public TrieNode(){
			this.child=new HashMap<Character,TrieNode>();
			this.isLeaf=false;
		}
	}
	public void buildTrie(TrieNode root,String s){
		TrieNode curr=root;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(!curr.child.containsKey(ch)){
				curr.child.put(ch, new TrieNode());
			}
			curr=curr.child.get(ch);
		}
		curr.isLeaf=true;
	}
	
	public boolean searchWithEndAsterisk(TrieNode root,String s){
		TrieNode curr=root;
		if(curr.child.containsKey('*')){
			return true;
		}
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(!curr.child.containsKey(ch)){
				return false;
			}
			curr=curr.child.get(ch);
			if(curr.child.containsKey('*')){
				return true;
			}
		}
		return curr.isLeaf;
	}
	public boolean searchWithMiddleAsterisk(TrieNode curr,String s,int index){
		if(curr==null){
			return false;
		}
		if(index==s.length()){
			return curr.isLeaf;
		}
		if(curr.child.containsKey('*')){
			for(int newIndex=index;newIndex<=s.length();newIndex++){
				if(searchWithMiddleAsterisk(curr.child.get('*'),s,newIndex)){
					return true;
				}
			}
		}
		char ch=s.charAt(index);
		if(!curr.child.containsKey(ch)){
			return false;
		}
		return searchWithMiddleAsterisk(curr.child.get(ch),s,index+1);
	}
	
	public TrieNode initDic(String[] blackList){
		TrieNode root=new TrieNode();
		for(int i=0;i<blackList.length;i++){
			buildTrie(root,blackList[i]);
		}
		return root;
	}
}
