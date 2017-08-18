package onsite;
import java.util.*;
/*
 * 第二问是有N个机器，每个机器i生产1个产品的时间是T，问生产M个产品用多长时间
 * followup : what if machine has cool down
 */
public class ProductMachine {
	// machines array contains time for each machine to complete 1 part
	public int calTime(int M,int[] machines,int[] cooldowns){
		int time=0;
		//int[] structure, 0-> curr time for this machine(complete time from last one) 
		//1->machine No. (index)
		//2-> projected complete time (plus cooldown) for next part
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
			public int compare(int[] i1,int[] i2){
				return i1[2]-i2[2];
			}
		});
		for(int i=0;i<machines.length;i++){
			int[] toadd={0,i,machines[i]};
			pq.offer(toadd);
		}
		for(int i=0;i<M;i++){
			int[] curr=pq.poll();
			curr[0]=curr[2];
			curr[2]=curr[2]+cooldowns[curr[1]]+machines[curr[1]];
			time=Math.max(time, curr[0]);
			pq.offer(curr);
		}
		return time;
	}
}
