package onsite;

import java.util.*;

public class SameMeaningWord {
	// node for union find tree
	class Node{
		int height; 
		// keep track of height to better merge trees, 
		//gives log n time for both union and find in worst case
		String val;
		Node parent;
		public Node(String val){
			this.val=val;
			this.height=0;
			this.parent=this;
		}
	}
	public boolean Solution(String[][] words, String word1, String word2) {
		// build lib
		Map<String, Node> dic = new HashMap<String, Node>();
		for (int i = 0; i < words.length; i++) {
			if(!dic.keySet().contains(words[i][0])){
				dic.put(words[i][0], new Node(words[i][0]));
			}
			if(!dic.keySet().contains(words[i][1])){
				dic.put(words[i][1], new Node(words[i][1]));
			}
			mapWords(dic.get(words[i][0]),dic.get(words[i][1]));
		}
		if(!dic.keySet().contains(word1)||!dic.keySet().contains(word2)){
			return false;
		}
		return findRoot(dic.get(word1))==findRoot(dic.get(word2));

	}
	public void mapWords(Node n1,Node n2){
		n1=findRoot(n1);
		n2=findRoot(n2);
		if(n1==n2){
			return ;
		}
		else if(n1.height>n2.height){
			n2.parent=n1;
		}
		else if(n1.height<n2.height){
			n1.parent=n2;
		}
		else{
			n2.parent=n1;
			n1.height++;
		}
	}
	public Node findRoot(Node n){
		while(n.parent!=n){
			n=n.parent;
		}
		return n;
	}
}
