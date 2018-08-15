package onsite;
import java.util.*;
/*
 * 利口武凌伞，follow up是如果data是streaming data, 要怎么改代码和设计输出。

tested on leetcode 503
 */
public class NextGreaterElementInStream {
	public List<Integer> nextGreaterElements(int[] nums) {
        List<Integer> res=new ArrayList<Integer>();
        TreeSet<Integer> addedNum=new TreeSet<Integer>();
        //  0 value 1 index
        PriorityQueue<int[]> fallBacks=new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] i1,int[] i2){
                return i1[0]-i2[0];
            }
        });
        for(int i=0;i<nums.length;i++){
            int currVal=nums[i];
            Integer ceil=addedNum.ceiling(currVal+1);
            if(ceil!=null){
                res.add(ceil);
            }
            else{
                res.add(-1);
            }
            if(addedNum.isEmpty()||addedNum.last()<currVal){
                addedNum.add(currVal);
            }
            
            while(!fallBacks.isEmpty()&&fallBacks.peek()[0]<currVal){
                int[] top=fallBacks.poll();
                res.set(top[1],currVal);
            }
            fallBacks.offer(new int[]{currVal,i});
        }
        return res;
    }
}
