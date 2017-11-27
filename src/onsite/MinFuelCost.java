package onsite;

/*
 * 加油站问题，给你起始点A 终点B 
 * 一个数组代表每一个加油站的油价 坐标代表每一个加油站的位置 一辆车 每英里耗油V 从A出发到B最少耗油量价格
 */
// assuming starting at 0 and there is always a gas station at 0 and end
// car consumes 1 gallon fuel per mile

/*
 * scenarios:
 * at any point scan forward till max dis:
 * 1. if there is any point with cost <= currCost, then jump to that point and only fuel to reach it
 * 2. otherwise, fuel full tank and jump to lowest cost point.
 */
public class MinFuelCost {
	public int calMinCost(int[] gasStations,int[] costs,int end,int maxCapacity){
		// 0 position,1 currCostSum, 2 fuel left, 3 index
		int[] curr={0,0,0,0};
		while(curr[0]!=-1&&curr[0]!=end){
			int startPos=curr[0];
			int minIndex=-1;
			int minCost=Integer.MAX_VALUE;
			for(int i=curr[3]+1;i<costs.length&&gasStations[i]-curr[0]<=maxCapacity&&gasStations[i]<=end;i++){
				if(costs[i]<=costs[curr[3]]){
					curr[1]=curr[1]+(gasStations[i]-curr[0]-curr[2])*costs[curr[3]];
					curr[2]=0;
					curr[3]=i;
					curr[0]=gasStations[i];
					minIndex=-1;
					break;
				}
				else{
					if(costs[i]<=minCost){
						minCost=costs[i];
						minIndex=i;
					}
				}
			}
			if(minIndex!=-1){
				curr[1]=curr[1]+(Math.min(maxCapacity, end-curr[0])-curr[2])*costs[curr[3]];
				curr[2]=Math.min(maxCapacity, end-curr[0])-(gasStations[minIndex]-curr[0]);
				curr[3]=minIndex;
				curr[0]=gasStations[curr[3]];
			}
			if(startPos==curr[0]){
				curr[0]=-1;
			}
		}
		return curr[0]==-1?-1:curr[1];
	}
}
