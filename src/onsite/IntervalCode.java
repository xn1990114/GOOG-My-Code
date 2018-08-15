package onsite;

import java.util.*;

/*
 * 给了一堆list (start, end, label), start是inclusive的，end是exclusive的，然后让 输出所有连续的不同的region
就是 (2, 8, 'a'), (3, 5, 'c'), (6, 9, 'b')的话， 不考虑没有label的地方， 
输出就是 (2, 3, 'a'), (3, 5, 'ac'), (5， 6， ‘a’), (6, 8, 'ab'), (8,9, 'b') .
 */
public class IntervalCode {
	public class Interval{
		int start;
		int end;
		char label;
		public Interval(int start,int end,char label){
			this.start=start;
			this.end=end;
			this.label=label;
		}
	}
	public String findRegion(Interval[] intervals){
		if(intervals==null||intervals.length==0){
			return "";
		}
		Arrays.sort(intervals,new Comparator<Interval>(){
			public int compare(Interval i1,Interval i2){
				return i1.start-i2.start;
			}
		});
		PriorityQueue<Interval> pq=new PriorityQueue<Interval>(new Comparator<Interval>(){
			public int compare(Interval i1,Interval i2){
				return i1.end-i2.end;
			}
		});
		int last=0;
		int index=0;
		int[] activeChars=new int[26];
		StringBuilder sb=new StringBuilder();
		while(index<intervals.length||!pq.isEmpty()){
			if(pq.isEmpty()){
				Interval curr=intervals[index];
				last=curr.start;
				pq.offer(curr);
				activeChars[curr.label-'a']++;
				index++;
			}
			while(index<intervals.length&&pq.peek().end>intervals[index].start){
				Interval curr=intervals[index];
				if(last<curr.start){
					sb.append("("+last+","+curr.start+","+makeLabel(activeChars)+")");
				}
				last=curr.start;
				activeChars[curr.label-'a']++;
				pq.offer(curr);
				index++;
			}
			Interval top=pq.poll();
			if(last<top.end){
				sb.append("("+last+","+top.end+","+makeLabel(activeChars)+")");
				last=top.end;
			}
			activeChars[top.label-'a']--;
		}
		return sb.toString();
	}
	public String makeLabel(int[] activeChars){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<26;i++){
			if(activeChars[i]>0){
				sb.append((char)('a'+i));
			}
		}
		return sb.toString();
	}
}
