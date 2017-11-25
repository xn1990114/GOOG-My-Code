package onsite;
import java.util.*;
/*
 * 里口 贰灵舞 的升级版，给一个s，一堆t，问是不是都匹配。优化方案已在心中，但是怕好高骛远眼高手低，
 * 就先写了一个 贰灵舞，然后说匹配每一个。一起走了几个测试样例，他觉得没问题，于是问能优化么，当然能。于是写了个前缀树。
 */
public class IsomorphicStrings {
	class Node{
		Map<Character,Node> child;
		String s;
		public Node(){
			this.child=new HashMap<Character,Node>();
			this.s=null;
		}
	}
	public void buildTrie(Node root,String s){
		Node curr=root;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(!curr.child.containsKey(ch)){
				curr.child.put(ch, new Node());
			}
			curr=curr.child.get(ch);
		}
		curr.s=s;
	}
	public void findMatch(Node curr,List<String> res,int[] sToT,int[] tToS,String s,int index){
		if(curr==null){
			return ;
		}
		if(index==s.length()){
			if(curr.s!=null){
				res.add(curr.s);
			}
			return;
		}
		char sCh=s.charAt(index);
		for(char tCh:curr.child.keySet()){
			if(tToS[tCh]!=-1&&sToT[sCh]!=-1){
				if(tToS[tCh]==sCh&&sToT[sCh]==tCh){
					findMatch(curr.child.get(tCh),res,sToT,tToS,s,index+1);
				}
			}
			else if(tToS[tCh]==-1&&sToT[sCh]==-1){
				tToS[tCh]=sCh;
				sToT[sCh]=tCh;
				findMatch(curr.child.get(tCh),res,sToT,tToS,s,index+1);
				tToS[tCh]=-1;
				sToT[sCh]=-1;
			}
		}
	}
	public List<String> findAllIsomorphic(String s,String[] t){
		List<String> res=new ArrayList<String>();
		Node root=new Node();
		for(String temp:t){
			buildTrie(root,temp);
		}
		int[] sToT=new int[256];
		int[] tToS=new int[256];
		Arrays.fill(sToT, -1);
		Arrays.fill(tToS, -1);
		findMatch(root,res,sToT,tToS,s,0);
		return res;
	}
}
