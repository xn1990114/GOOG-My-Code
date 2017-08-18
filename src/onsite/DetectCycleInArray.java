package onsite;
/*
 * Given an array of integers where each element points to the   
 * index of the next element how would you detect if there is a cycle in this array?
 * {5,1,4,5,1,5,12,2,6}
 */
public class DetectCycleInArray {
	public boolean hasCycle(int[] nums){
		boolean[] visited=new boolean[nums.length];
		for(int i=0;i<nums.length;i++){
			if(!visited[i]){
				visited[i]=true;
				int curr=nums[i];
				while(curr>=0&&curr<nums.length&&!visited[curr]){
					visited[curr]=true;
					curr=nums[curr];
					if(curr==i){
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
