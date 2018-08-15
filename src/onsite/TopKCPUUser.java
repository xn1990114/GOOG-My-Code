package onsite;
import java.util.*;
/*
 * 给了一堆log，log里有用户id，resource id以resource在某个起始时间和终止时间的使用量，
 * 比如用户abc在1到5秒钟使用了CPU的数量是2，用户abc在2到3秒使用的CPU数量是4，
 * 也就是一个用户对某个resource的使用在某个时间是可以叠加的，给定一个resource id，
 * 根据用户对这个resource的peak使用量，找到top k的用户。上面的例子中abc的CPU的peak使用量是2+4=6
 */
// assumption: loggin format: userID + start + end+ usage
// e.g userID,1,2,3
public class TopKCPUUser {
	private class UserRecord implements Comparable<UserRecord>{
		private String userID;
		private int usage;
		private UserRecord(String userID,int usage){
			this.userID=userID;
			this.usage=usage;
		}
		public  int compareTo(UserRecord r2){
			if(this.usage<r2.usage){
				return -1;
			}
			else if(this.usage>r2.usage){
				return 1;
			}
			return 0;
		}
	}
	public List<String> topKUsageUser(List<String> logs,int k){
		// organize record by user id
		Map<String,List<int[]>> usage=new HashMap<String,List<int[]>>();
		for(int i=0;i<logs.size();i++){
			String[] log=logs.get(i).split(",");
			String userID=log[0];
			int[] record={Integer.parseInt(log[1]),Integer.parseInt(log[2]),Integer.parseInt(log[3])};
			if(!usage.containsKey(userID)){
				usage.put(userID, new ArrayList<int[]>());
			}
			usage.get(userID).add(record);
		}
		PriorityQueue<UserRecord> topKUser=new PriorityQueue<UserRecord>();
		for(String userID:usage.keySet()){
			int currUserUsage=calUsage(usage.get(userID));
			topKUser.offer(new UserRecord(userID,currUserUsage));
			if(topKUser.size()>k){
				topKUser.poll();
			}
		}
		List<String> res=new ArrayList<String>();
		while(!topKUser.isEmpty()){
			res.add(topKUser.poll().userID);
		}
		return res;
	}
	
	public int calUsage(List<int[]> list){
		Collections.sort(list,new Comparator<int[]>(){
			public int compare(int[] i1,int[] i2){
				return i1[0]-i2[0];
			}
		});
		int maxUsage=0;
		int currUsage=0;
		PriorityQueue<int[]> activeRange=new PriorityQueue<int[]>(new Comparator<int[]>(){
			public int compare(int[] i1,int[] i2){
				return i1[1]-i2[1];
			}
		});
		for(int i=0;i<list.size();i++){
			int[] currRange=list.get(i);
			while(!activeRange.isEmpty()&&activeRange.peek()[2]<=currRange[0]){
				currUsage=currUsage-activeRange.poll()[2];
			}
			activeRange.offer(currRange);
			currUsage=currUsage+currRange[2];
			maxUsage=Math.max(maxUsage, currUsage);
		}
		return maxUsage;
	}
	public boolean validateResult(List<String> res,String[] target){
		if(res.size()!=target.length){
			return false;
		}
		for(int i=0;i<res.size();i++){
			if(!res.get(i).equals(target[i])){
				return false;
			}
		}
		return true;
	}
}
