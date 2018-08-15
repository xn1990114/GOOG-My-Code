package onsite;

import java.util.*;

/*
 * 题目是你要给自家hallway装传感器来检测小偷，hallway的representation就是两条平行于x轴的直线，假设他们的y轴坐标是y1和y2。
 * 传感器可以探测一个圆形的范围，半径是r，我写成了这种样子面试官表示可以：
class Sensor{
int x;
int y;. 
int r;
}
题目就是给你一个List<Sensor>和y1, y2作为input，问这些Sensor够不够cover住后院使得小偷不能通过hallway。 
我先写了一个判断两个圆是不是有overlap的函数，然后把input list处理成一个图，有overlap的话就加一条边，
然后dfs就行了。因为写的很快面试官加了一点followup，一是说如果这段code现在你要发code review了，
你怎么improve；一个是如果sensor不一定是圆可以有别的形状怎么改。
 */
public class HallwayMonitor {
	class Sensor {
		double x;
		double y;
		double r;

		public Sensor(double x, double y, double r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}

	public boolean canCoverHallway(double y1, double y2, Sensor[] sensors) {
		double higher = Math.max(y1, y2);
		double lower = Math.min(y1, y2);
		Map<Sensor, Set<Sensor>> adjList = new HashMap<Sensor, Set<Sensor>>();
		for (int i = 0; i < sensors.length; i++) {
			for (int j = 0; j < sensors.length; j++) {
				if (i == j) {
					continue;
				}
				Sensor s1 = sensors[i];
				Sensor s2 = sensors[j];
				if (!adjList.containsKey(s1)) {
					adjList.put(s1, new HashSet<Sensor>());
				}
				if (!adjList.containsKey(s2)) {
					adjList.put(s2, new HashSet<Sensor>());
				}
				if (hasOverlap(s1, s2)) {
					adjList.get(s1).add(s2);
					adjList.get(s2).add(s1);
				}
			}
		}
		Set<Sensor> visited = new HashSet<Sensor>();
		for (Sensor sensor : adjList.keySet()) {
			if(canCover(lower,higher,sensor,adjList,visited)){
				return true;
			}
		}
		return false;
	}

	private boolean canCover(double lower, double higher, Sensor startSensor, Map<Sensor, Set<Sensor>> adjList,
			Set<Sensor> visited) {
		if(visited.contains(startSensor)){
			return false;
		}
		Queue<Sensor> qu=new LinkedList<Sensor>();
		qu.offer(startSensor);
		visited.add(startSensor);
		double min=startSensor.y-startSensor.r;
		double max=startSensor.y+startSensor.r;
		while(!qu.isEmpty()){
			Sensor top=qu.poll();
			min=Math.min(min, top.y-top.r);
			max=Math.max(max, top.y+top.r);
			Set<Sensor> overLappedSensor=adjList.get(top);
			for(Sensor next:overLappedSensor){
				if(!visited.contains(next)){
					visited.add(next);
					qu.offer(next);
				}
			}
		}
		return min<=lower&&max>=higher;
	}

	private boolean hasOverlap(Sensor s1, Sensor s2) {
		double dis = Math.sqrt((s2.y - s1.y) * (s2.y - s1.y) + (s2.x - s1.x) * (s2.x - s1.x));
		return dis <= s2.r + s1.r;
	}
}
