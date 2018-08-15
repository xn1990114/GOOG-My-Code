package onsite;

import java.util.Arrays;

/*
 * 一片森林，正中间一个摄像头，拍的角度是一定的。 树木分布在四个象限里。问至少拍多少张照片能把整个森林拍完
 */
public class ForestCamera {
	public int minScanNeeded(double[][] trees,double scope){
		if(trees.length==0){
			return 0;
		}
		double[] angles=new double[trees.length];
		for(int i=0;i<trees.length;i++){
			double angle=Math.atan2(trees[i][1], trees[i][0])/Math.PI*180;
			if(angle<0){
				angle=angle+360;
			}
			angles[i]=angle;
		}
		Arrays.sort(angles);
		int minCount=Integer.MAX_VALUE;
		for(int start=0;start<angles.length;start++){
			int count=1;
			double base=angles[start];
			int index=(start+1)%angles.length;
			while(index!=start){
				double curr=angles[index];
				if(curr<base){
					curr=curr+360;
				}
				if(curr>base+scope){
					count++;
					base=angles[index];
				}
				index=(index+1)%angles.length;
			}
			minCount=Math.min(minCount, count);
		}
		
		return minCount;
	}
}
