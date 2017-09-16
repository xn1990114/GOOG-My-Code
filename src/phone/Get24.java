package phone;
import java.util.*;
/*
 * 一道题，  输入为一个大小为4的整型数组，每个整数范围1-9。判断能不能通过+，-，*， /, () 五种操作使的操作完结果是二十四。
 * 只需判断可不可行 true/false比如，输入是 4，1，8，7 ， 返回真，因为  (8-4)*(7-1) 等于二十四。 
 * 这里数组里元素的顺序可以随意变换。又比如，输入是1，1，1，1 返回假，因为不能生成二十四。
 * follow up 返回具体怎样操作得到二十四
 */
public class Get24 {
	public Set<String> findWayTo24(int[] nums){
		Arrays.sort(nums);
		Set<String> res=new HashSet<String>();
		do{
			@SuppressWarnings("unchecked")
			Map<Integer,Set<String>>[][] map=new HashMap[4][4];
			countPossible(nums,0,3,map);
			if(map[0][3].containsKey(24)){
				res.addAll(map[0][3].get(24));
			}
		}
		while(findNextPermutation(nums));
		return res;
	}
	public void countPossible(int[] nums,int start,int end,Map<Integer,Set<String>>[][] map){
		if(start>end){
			return ;
		}
		Map<Integer,Set<String>> currMap=new HashMap<Integer,Set<String>>();
		if(start==end){
			map[start][end]=currMap;
			currMap.put(nums[start], new HashSet<String>());
			currMap.get(nums[start]).add(""+nums[start]);
			return;
		}
		for(int i=start;i<end;i++){
			if(map[start][i]==null){
				countPossible(nums,start,i,map);
			}
			if(map[i+1][end]==null){
				countPossible(nums,i+1,end,map);
			}
			Map<Integer,Set<String>> left=map[start][i];
			Map<Integer,Set<String>> right=map[i+1][end];
			for(int l:left.keySet()){
				for(int r:right.keySet()){
					int temp=l+r;
					if(!currMap.containsKey(temp)){
						currMap.put(temp, new HashSet<String>());
					}
					for(String ls:left.get(l)){
						for(String rs:right.get(r)){
							currMap.get(temp).add("("+ls+"+"+rs+")");
						}
					}
					temp=l-r;
					if(!currMap.containsKey(temp)){
						currMap.put(temp, new HashSet<String>());
					}
					for(String ls:left.get(l)){
						for(String rs:right.get(r)){
							currMap.get(temp).add("("+ls+"-"+rs+")");
						}
					}
					temp=l*r;
					if(!currMap.containsKey(temp)){
						currMap.put(temp, new HashSet<String>());
					}
					for(String ls:left.get(l)){
						for(String rs:right.get(r)){
							currMap.get(temp).add("("+ls+"*"+rs+")");
						}
					}
					if(r==0){
						continue;
					}
					temp=l/r;
					if(!currMap.containsKey(temp)){
						currMap.put(temp, new HashSet<String>());
					}
					for(String ls:left.get(l)){
						for(String rs:right.get(r)){
							currMap.get(temp).add("("+ls+"/"+rs+")");
						}
					}
				}
			}
		}
		map[start][end]=currMap;
	}
	public boolean findNextPermutation(int[] nums){
		int cutPoint=nums.length-1;
		while(cutPoint>0&&nums[cutPoint]<=nums[cutPoint-1]){
			cutPoint--;
		}
		if(cutPoint==0){
			return false;
		}
		int last=cutPoint-1;
		for(int i=3;i>=cutPoint;i--){
			if(nums[i]>nums[last]){
				int temp=nums[last];
				nums[last]=nums[i];
				nums[i]=temp;
				break;
			}
		}
		int end=3;
		while(cutPoint<end){
			int temp=nums[cutPoint];
			nums[cutPoint]=nums[end];
			nums[end]=temp;
			cutPoint++;
			end--;
		}
		return true;
	}
	public void display(Set<String> set){
		if(set==null){
			System.out.println("no matching");
			return;
		}
		for(String s:set){
			System.out.print(s+"\t");
		}
		System.out.println();
	}
}
