package onsite;
import java.util.*;
/*
 * 现在有一大堆机场的代号，每个代号都是三个字母，比如LAX, SEA, LAS这样子。有个用户给自己做了一个旅行计划，
 * 就是一个机场代号的list，比如 SEA->LAX->POR->LAS，就表示用户想从SEA玩到LAX再到POR再到LAS。
 * 然而这个用户特别的傻，他计划的行程里两个机场之间不一定有直飞；更傻的是，这个用户还会打错字，
 * 比如把LAX打成了LAZ，然后LAZ并不是一个合法的机场代号。这两种情况都会造成用户没法按照预定行程去玩。
 * 现在给你一个用户的游玩列表，让你改成一个合法的行程，要求你的修改cost最小。这里cost的定义是每修改一个字母算一个cost，
 * 比如LAZ->LAX算一个cost。 SEA->LAX->POR 改成SEA->PEK->POR算三个cost。你可以随便改这个行程，
 * 甚至可以改出发城市和目的地城市，也不需要保证用户能玩到所有他一开始想玩的城市。
 * 会给两个api：List<String> getConnectedAirportCodes(String code)和List<String> getAllValidCodes(). 
 * 这题乍一看是个edit distance的变种，然而仔细研究了一下并不能用dp因为局部最优不能导致全局最优。
 * 最后写了一个纯暴力搜索。和面试官讨论了一下可以cache一些中间结果，不过并没写完code。给这题跪了。
 */
// assumption: the trip list size is fixed and can't be changed.
public class AirportRouteRearrangement {
	
	class PathTracker{
		PathTracker last;
		String curr;
		int minCost;
		public PathTracker(PathTracker last,String curr,int minCost){
			this.curr=curr;
			this.last=last;
			this.minCost=minCost;
		}
	}
	public List<String> rearrangeRouteWithMinCost(List<String> originalRoute){
		if(originalRoute==null||originalRoute.size()==0){
			return originalRoute;
		}
		List<String> airports=getAllValidCodes();
		Map<String,Integer> airportIndex=new HashMap<String,Integer>();
		for(int i=0;i<airports.size();i++){
			airportIndex.put(airports.get(i), i);
		}
		PathTracker[][] costTracker=new PathTracker[originalRoute.size()][airports.size()];
		for(int routeID=0;routeID<originalRoute.size();routeID++){
			for(int flightID=0;flightID<airports.size();flightID++){
				if(routeID==0){
					int cost=calCost(originalRoute.get(routeID),airports.get(flightID));
					costTracker[routeID][flightID]=new PathTracker(null,airports.get(flightID),cost);
				}
				else{
					PathTracker toadd=new PathTracker(null,airports.get(flightID),Integer.MAX_VALUE);
					List<String> previousStop=getConnectedAirportCodes(airports.get(flightID));
					int currPosCost=calCost(originalRoute.get(routeID),airports.get(flightID));
					for(int k=0;k<previousStop.size();k++){
						PathTracker last=costTracker[routeID-1][airportIndex.get(previousStop.get(k))];
						if(last==null||last.minCost==Integer.MAX_VALUE){
							continue;
						}
						int currTotalCost=currPosCost+last.minCost;
						if(currTotalCost<toadd.minCost){
							toadd.minCost=currTotalCost;
							toadd.last=last;
						}
					}
					costTracker[routeID][flightID]=toadd;
				}
			}
		}
		List<String> newPlan=new ArrayList<String>();
		PathTracker pt=null;
		for(int flightID=0;flightID<costTracker[0].length;flightID++){
			PathTracker newPT=costTracker[costTracker.length-1][flightID];
			if(pt==null||(pt!=null&&newPT!=null&&pt.minCost>newPT.minCost)){
				pt=newPT;
			}
		}
		while(pt!=null){
			newPlan.add(pt.curr);
			pt=pt.last;
		}
		Collections.reverse(newPlan);
		return newPlan;
	}
	
	public int calCost(String ori,String target){
		int cost=0;
		for(int i=0;i<target.length();i++){
			if(ori.charAt(i)!=target.charAt(i)){
				cost++;
			}
		}
		return cost;
	}
	// below are fake API provided
	Map<String,List<String>> connection;
	public AirportRouteRearrangement(){
		this.connection=new HashMap<String,List<String>>();
		List<String> airports=getAllValidCodes();
		for(String a:airports){
			connection.put(a,new ArrayList<String>());
		}
		connection.get("XNA").add("LAX");connection.get("XNA").add("SEA");
		connection.get("SEA").add("LAS");connection.get("LAS").add("POR");
		connection.get("JFK").add("POR");connection.get("DLA").add("SFA");
		connection.get("JFK").add("SJE");connection.get("DLA").add("SFA");
		connection.get("SJE").add("LAX");connection.get("SFA").add("XNA");
		connection.get("SJE").add("LAX");connection.get("DLA").add("POR");
	}
	public List<String> getConnectedAirportCodes(String code){
		return this.connection.get(code);
	}
	public List<String> getAllValidCodes(){
		List<String> res=new ArrayList<String>();
		res.add("XNA");res.add("LAX");res.add("SEA");res.add("LAS");res.add("POR");res.add("JFK");
		res.add("SJE");res.add("SFA");res.add("DLA");
		return res;
	}
}
