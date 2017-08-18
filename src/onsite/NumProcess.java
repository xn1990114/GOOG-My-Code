package onsite;
import java.util.*;
/*
 * 大意是给一个n 让你返回一个由n到1的长度，长度起始是1
如果n是odd 就继续n * 3 + 1
如果n是even  就执行n/2
但是没执行一次 长度+ 1
然后直到n为1 然后返回length

第二个小问题：
就是求出第一问的所有loop过的数的最大数。
两个loop 两个函数一起是n方复杂度
1然后让优化，提示让我用memorization 
然后我说用hashmap
2 算结束 继续一个followup 说是over的
就是给出一个length，然后让返回所有这个length的数值，其实就是一个inverse的function. 
我没答出来，面试官说的。。。其实想到了dfs 没敢说，不知道对不对。。

 */
// find int[] -- maxLength,maxNum
public class NumProcess {
	public int[] findLenMax(int n){
		int[] result=new int[2];
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		map.put(1, 0);
		for(int i=2;i<=n;i++){
			if(!map.keySet().contains(i)){
				update(result,map,i);
			}
		}
		return result;
	}
	public void update(int[] result,Map<Integer,Integer> map,int curr){
		int res=cal(curr);
		if(!map.keySet().contains(res)){
			update(result,map,res);
		}
		map.put(curr,1+map.get(res));
		result[0]=Math.max(result[0],map.get(curr));
		result[1]=Math.max(result[1],res);
	}
	public int cal(int num){
		if(num%2==0){
			return num/2;
		}
		return num*3+1;
	}
	
	// q2; given len find all Num
	public Set<Integer> reverse(int len){
		Set<Integer> result=new HashSet<Integer>();
		reverseUpdate(0,len,result,1);
		return result;
	}
	public void reverseUpdate(int currLen,int targetLen, Set<Integer> result,int curr){
		if(curr<1){
			return ;
		}
		if(currLen==targetLen){
			result.add(curr);
			return;
		}
		if((curr-1)/3>1&&((curr-1)/3)%2==1){
			reverseUpdate(currLen+1,targetLen,result,(curr-1)/3);
		}
		reverseUpdate(currLen+1,targetLen,result,curr*2);
	}
}
