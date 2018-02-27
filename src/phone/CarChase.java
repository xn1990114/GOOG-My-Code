package phone;
import java.util.*;
/*
 * 
Imagine a scenario where there are N cars on an infinitely long single-lane road. 
Each car has a unique, permanent integer speed ranging between 1 and N, inclusive (units are irrelevant). 
The cars can be placed in any order along the road and then told to start driving indefinitely. 
Let's assume that the cars are traveling from right-to-left. 
So the leftmost car is at the front. Given an ordering of N cars, 
construct an algorithm to return an array of cluster sizes.

N=4

[2, 4, 1, 3]   -> [2, 2] 4可以追上2， 3可以追上1，就成了两个cluster。

[2, 5, 4, 3, 1] -> [4, 1]

followup：
New car speed = N+1.  Given an ordering of N cars, 
construct an algorithm to return an array of arrays of cluster sizes that will arise when the N+1 car is inserted. 
The ith row in the outer array corresponds to the cluster sizes that exist when the N+1 car is inserted into the ith index.

new car speed = 5
[2, 4, 1, 3]  -> [[1, 2, 2], [3, 2], [3, 2], [2, 3], [2, 3]]
 */
public class CarChase {
	// here we are assuming speed can be any
	public List<Integer> calCluster(int[] nums){
		List<Integer> res=new ArrayList<Integer>();
		if(nums.length==0){
			return res;
		}
		int min=nums[0];
		int start=0;
		int index=1;
		while(index<nums.length){
			if(nums[index]<=min){
				res.add(index-start);
				min=nums[index];
				start=index;
				index++;
			}
			else{
				index++;
			}
		}
		res.add(index-start);
		return res;
	}
	public List<List<Integer>> insertNewSpeed(int[] nums){
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		List<Integer> before=calCluster(nums);
		List<Integer> toadd=new ArrayList<Integer>();
		toadd.add(1);
		toadd.addAll(before);
		res.add(toadd);
		for(int i=0;i<before.size();i++){
			int times=before.get(i);
			toadd=new ArrayList<Integer>();
			for(int k=0;k<before.size();k++){
				if(k==i){
					toadd.add(before.get(k)+1);
				}
				else{
					toadd.add(before.get(k));
				}
			}
			for(int j=0;j<times;j++){
				res.add(new ArrayList<Integer>(toadd));
			}
		}
		return res;
	}
}
