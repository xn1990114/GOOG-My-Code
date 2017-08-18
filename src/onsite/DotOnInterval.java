package onsite;

import java.util.*;

public class DotOnInterval {
	public int CountDot(int[][] array){
		int count=0;
		Arrays.sort(array,new Comparator<int[]>(){
			public int compare(int[] i1,int[] i2){
				if(i1[1]==i2[1]){
					return i1[0]-i2[0];
				}
				return i1[1]-i2[1];
			}
		});
		long last=(long)array[0][0]-1L;
		for(int i=0;i<array.length;i++){
			if(last<(long)array[i][0]){
				count++;
				last=(long)array[i][1];
			}
		}
		return count;
	}
}
