package onsite;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 找到一条线将坐标系中的点分成两等份
题目是在一个坐标系里给很多离散的点，找到一条线将所有点分成两个数量相等的集合，不用考虑基偶性或者多个点在一条线上的特殊情况。 
这题似乎和人工智能的分类器之类的有点关系，可惜楼主基础不牢一开始基本完全懵逼。提出了 个O(n^3)的算法，然后只能想到用heuristic来优化。
面试官只说了句可以更快，然后就等我自由发挥，在楼主卡壳五分钟尝试了各种天花乱坠的解法 后，问了我一个问题:总共有多少条符合条件的线? 
在这个提示下楼主提出了一假设:过任意一点，一定能找到另一个点将坐标系中其余的点分成两 个数量相等的组(不知道怎么证也来不及证，但是直觉告诉我是对)，
基于这个假设之前那个算 法的实际复杂度是O(n^2)，结合heuristic实际情况会更快直接比较就好了把，点(x', y') 如果满足 ax' + b < y'，
那就在线下面了 比较 tricky 的地方就是和 y 轴平行的线
 */
// another approach: https://stackoverflow.com/questions/3106324/dividing-a-plane-of-points-into-two-equal-halves#3106359
// below answer is might be wrong
public class LineToCutPointInHalf {
	//y=ax+b
	// res[0]=a res[1]=b
	public String findCutLine(double[][] points){
		if(points==null||points.length==0){
			return "Empty";
		}
		double minX=Double.MAX_VALUE;
		double minY=Double.MAX_VALUE;
		for(int i=0;i<points.length;i++){
			minX=Math.min(minX, points[i][0]);
			minY=Math.min(minY, points[i][1]);
		}
		minX=minX-0.001;
		minY=minY-0.001;
		int median1Pos=points.length/2;
		int median2Pos=(points.length-1)/2;
		double[] thetas=new double[points.length];
		for(int i=0;i<points.length;i++){
			double currTheta=Math.atan2(points[i][1]-minY,points[i][0]-minX);
			thetas[i]=currTheta;
		}
		Arrays.sort(thetas);
		double finalTheta=(thetas[median1Pos]+thetas[median2Pos])/2.0;
		double finalSlope=Math.sin(finalTheta)/Math.cos(finalTheta);
		return "y="+finalSlope+"*x"+"+"+(minY-minX*finalSlope);
	}
	
	public String findCutLineWithRandomLine(double[][] points){
		if(points==null||points.length==0){
			return "Empty";
		}
		boolean needContinue=true;
		double slope=0;
		double[][] intersections=new double[points.length][2];
		while(needContinue){
			double randomTheta=Math.random()*Math.PI-Math.PI/2.0;
			slope=Math.abs(randomTheta)==Math.PI/2.0?Double.MAX_VALUE:(Math.sin(randomTheta)/Math.cos(randomTheta));
			for(int i=0;i<points.length;i++){
				intersections[i]=calIntersect(slope,points[i]);
			}
			Arrays.sort(intersections,new Comparator<double[]>(){
				public int compare(double[] a1,double[] a2){
					if(a1[0]<a1[0]){
						return -1;
					}
					else if(a1[0]>a1[0]){
						return 1;
					}
					else if(a1[1]<a2[1]){
						return -1;
					}
					else if(a1[1]>a2[1]){
						return 1;
					}
					return 0;
				}
			});
			needContinue=false;
			for(int i=1;i<intersections.length;i++){
				if(intersections[i][0]==intersections[i-1][0]&&intersections[i][1]==intersections[i-1][1]){
					needContinue=true;
				}
			}
		}
		int median1Pos=points.length/2;
		int median2Pos=(points.length-1)/2;
		double medianX=(intersections[median1Pos][0]+intersections[median2Pos][0])/2.0;
		double medianY=(intersections[median1Pos][1]+intersections[median2Pos][1])/2.0;
		return "y="+(-1/slope)+"*x+"+(medianY-medianX*(-1/slope));
	}
	public double[] calIntersect(double slope,double[] point){
		if(slope==0){
			return new double[]{0,point[1]};
		}
		double slope2=-1/slope;
		double b2=point[1]-point[0]*slope2;
		double resX=b2/(slope-slope2);
		double resY=resX*slope;
		//System.out.println(resX+","+resY);
		return new double[]{resX,resY};
	}
}
