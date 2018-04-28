package onsite;
import java.util.*;
/*
 * meeting room经典问题。给定一堆的meeting 包含开始时间和结束时间， 
 * 要求返回所有房间的meeting序列
 */
public class MeetingRoomSchedule {
	// meeting: 0 meeting id, 1 start time, 2 end time
	public List<List<Integer>> sechduleMeeting(int[][] meetings){
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		Queue<Integer> freeMeetingRoom=new LinkedList<Integer>();
		Arrays.sort(meetings,new Comparator<int[]>(){
			public int compare(int[] i1,int[] i2){
				return i1[1]-i2[1];
			}
		});
		//meeting: 0 meeting id, 1 start time, 2 end time, 3 room id
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
			public int compare(int[] i1,int[] i2){
				return i1[2]-i2[2];
			}
		});
		for(int i=0;i<meetings.length;i++){
			int[] m=meetings[i];
			while(!pq.isEmpty()&&pq.peek()[2]<=m[1]){
				freeMeetingRoom.offer(pq.poll()[3]);
			}
			if(freeMeetingRoom.isEmpty()){
				res.add(new ArrayList<Integer>());
				freeMeetingRoom.offer(res.size()-1);
			}
			int[] toadd={m[0],m[1],m[2],freeMeetingRoom.poll()};
			res.get(toadd[3]).add(toadd[0]);
			pq.offer(toadd);
		}
		return res;
	}
	public void displayRes(List<List<Integer>> res){
		for(int i=0;i<res.size();i++){
			List<Integer> curr=res.get(i);
			for(int j=0;j<curr.size();j++){
				System.out.print(curr.get(j)+"->");
			}
			System.out.println();
		}
	}
}
