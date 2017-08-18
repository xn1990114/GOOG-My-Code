package onsite;

import java.util.*;

/*
 * 跑得快，手上一堆整数，能不能全部分成顺子，顺子是3个以上连续数。
 */
public class PaoDeKuai {
	public boolean split(int[] nums) {
		Map<Integer,Integer> map1=new HashMap<Integer,Integer>();
        Map<Integer,Integer> map2=new HashMap<Integer,Integer>();
        Map<Integer,Integer> map3=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            if(map1.containsKey(curr-1)){
                map1.put(curr-1,map1.get(curr-1)-1);
                if(map1.get(curr-1)==0){
                    map1.remove(curr-1);
                }
                if(!map2.containsKey(curr)){
                    map2.put(curr,0);
                }
                map2.put(curr,map2.get(curr)+1);
            }
            else if(map2.containsKey(curr-1)){
                map2.put(curr-1,map2.get(curr-1)-1);
                if(map2.get(curr-1)==0){
                    map2.remove(curr-1);
                }
                if(!map3.containsKey(curr)){
                    map3.put(curr,0);
                }
                map3.put(curr,map3.get(curr)+1);
            }
            else if(map3.containsKey(curr-1)){
                map3.put(curr-1,map3.get(curr-1)-1);
                if(map3.get(curr-1)==0){
                    map3.remove(curr-1);
                }
                if(!map3.containsKey(curr)){
                    map3.put(curr,0);
                }
                map3.put(curr,map3.get(curr)+1);
            }
            else{
                if(!map1.containsKey(curr)){
                    map1.put(curr,0);
                }
                map1.put(curr,map1.get(curr)+1);
            }
        }
        return map1.isEmpty()&&map2.isEmpty();
	}
}
