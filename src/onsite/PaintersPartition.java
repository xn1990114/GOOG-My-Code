package onsite;
/*
 * We have to paint n boards of length {A1, A2…An}. 
 * There are k painters available and each takes 1 unit time to paint 1 unit of board. 
 * The problem is to find the minimum time to get this job done under the constraints that 
 * any painter will only paint continuous sections of boards, 
 * say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
 */
public class PaintersPartition {
	public int calMinTimeDP(int[] walls,int k){
		if(walls==null||walls.length==0){
			return 0;
		}
		if(k<=0){
			return -1;
		}
		k=Math.min(walls.length, k);
		int[] total=new int[walls.length];
		for(int i=0;i<walls.length;i++){
			total[i]=walls[i]+(i>0?total[i-1]:0);
		}
		int[] lastMin=total.clone();
		int globalMinTime=lastMin[lastMin.length-1];
		for(int i=1;i<k;i++){
			int[] currMin=lastMin.clone();
			for(int end=0;end<walls.length;end++){
				int currRangeMin=Integer.MAX_VALUE;
				for(int mid=0;mid<end;mid++){
					currRangeMin=Math.min(currRangeMin, Math.max(total[end]-total[mid], lastMin[mid]));
				}
				currMin[end]=currRangeMin;
			}
			globalMinTime=Math.min(globalMinTime, currMin[currMin.length-1]);
			lastMin=currMin;
		}
		return globalMinTime;
	}
	public int calMinTimeBinarySearch(int[] walls,int k){
		if(walls==null||walls.length==0){
			return 0;
		}
		if(k<=0){
			return -1;
		}
		int low=0;
		int high=0;
		for(int i=0;i<walls.length;i++){
			high=high+walls[i];
		}
		int globalMinTime=high;
		while(low<=high){
			int mid=low+(high-low)/2;
			if(canMeet(walls,k,mid)){
				globalMinTime=Math.min(globalMinTime, mid);
				high=mid-1;
			}
			else{
				low=mid+1;
			}
		}
		return globalMinTime;
	}
	private boolean canMeet(int[] walls,int k,int currMax){
		int currTotal=0;
		k--;
		for(int i=0;i<walls.length;i++){
			if(walls[i]>currMax){
				return false;
			}
			if(currTotal+walls[i]>currMax){
				currTotal=walls[i];
				k--;
			}
			else{
				currTotal=currTotal+walls[i];
			}
		}
		return k>=0;
	}
}
