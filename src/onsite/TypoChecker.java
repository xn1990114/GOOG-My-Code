package onsite;
/*
 * 2. one error exact typo match. 给一个字典， 和一个词， 
 * 检查这个词是不是只有一个错误的typo。这里一个错误的定义是  只有一个字母是错的。 
 * 比如 applr  是 apple的 typo 但是不是application的typo 
 */
public class TypoChecker {
	class Node{
		Node[] child;
		boolean isLeaf;
		public Node(){
			this.child=new Node[26];
			this.isLeaf=false;
		}
	}
	public Node root;
	public boolean checkTypo(String[] dic,String target){
		Node root=new Node();
		for(int i=0;i<dic.length;i++){
			buildTrie(root,dic[i]);
		}
		return search(root,target,0,false);
	}
	public void buildTrie(Node root,String s){
		Node curr=root;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(curr.child[ch-'a']==null){
				curr.child[ch-'a']=new Node();
			}
			curr=curr.child[ch-'a'];
		}
		curr.isLeaf=true;
	}
	public boolean search(Node root,String target,int index,boolean misMatched){
		if(index==target.length()){
			if(misMatched){
				return root.isLeaf;
			}
			for(int i=0;i<26;i++){
				if(root.child[i]!=null&&search(root.child[i],target,index,true)){
					return true;
				}
			}
		}
		Node curr=root;
		if(misMatched){
			char ch=target.charAt(index);
			for(int i=index;i<target.length();i++){
				if(curr.child[ch-'a']!=null){
					curr=curr.child[ch-'a'];
				}
				else{
					return false;
				}
			}
			return curr.isLeaf;
		}
		else{
			char ch=target.charAt(index);
			for(int i=0;i<26;i++){
				if(i==ch-'a'){
					curr=root.child[ch-'a'];
					if(curr!=null&&search(curr,target,index+1,false)){
						return true;
					}
				}
				else{
					curr=root.child[ch-'a'];
					if(curr!=null&&search(curr,target,index+1,true)){
						return true;
					}
					else if(curr==null&&index==target.length()-1){
						return true;
					}
				}
			}
		}
		if(!misMatched){
			if(search(root,target,index+1,true)){
				return true;
			}
			for(int i=0;i<26;i++){
				if(root.child[i]!=null&&search(root.child[i],target,index,true)){
					return true;
				}
			}
		}
		return false;
	}
}
