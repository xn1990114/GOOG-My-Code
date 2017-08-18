package onsite;

import java.util.*;

/*
 * 对N个小灯泡，实现两个method：1.isOn(int i)：
 * 判断第i个灯泡ON/OFF， 2.toggle(int start, int end)：turn on/off 从第start开始到end结束的灯泡
 */
public class LightBulb {
	TreeMap<Integer, Integer> onBlubs;
	int size;

	public LightBulb(int N) {
		this.onBlubs = new TreeMap<Integer, Integer>();
		this.size = N;
	}

	public boolean isOn(int i) {
		return containsBlub(i, this.onBlubs);
	}

	public void toggle(int start, int end) {
		start = Math.max(1, start);
		end = Math.min(this.size, end);
		Integer floor=this.onBlubs.floorKey(start);
		if(floor==null){
			floor=this.onBlubs.ceilingKey(start);
		}
		
		while(floor!=null&&start<=end){
			if(floor<=start){
				int highEnd=this.onBlubs.get(floor);
				if(highEnd>=start){
					this.onBlubs.remove(floor);
					if(floor<start){
						this.onBlubs.put(floor, start-1);
					}
					if(highEnd>end){
						this.onBlubs.put(end+1, highEnd);
					}
					start=highEnd+1;
				}
			}
			else if(floor<=end){
				if(start<floor){
					this.onBlubs.put(start, floor-1);
				}
				start=floor;
				continue;
			}
			else{
				this.onBlubs.put(start, end);
				mergePossible(start,this.onBlubs);
				start=end+1;
			}
			floor=this.onBlubs.ceilingKey(floor+1);
		}
		if(floor==null&&start<=end){
			this.onBlubs.put(start, end);
			mergePossible(start,this.onBlubs);
			return;
		}
	}

	public void mergePossible(int key, TreeMap<Integer, Integer> tm) {
		Integer ceiling = tm.ceilingKey(key + 1);
		if (ceiling!=null&&tm.get(key) == ceiling - 1) {
			int temp = tm.get(ceiling);
			tm.remove(ceiling);
			tm.put(key, temp);
		}
		Integer floor = tm.floorKey(key - 1);
		if(floor!=null&&tm.get(floor)==key-1){
			int temp = tm.get(key);
			tm.remove(key);
			tm.put(floor, temp);
		}
	}

	public boolean containsBlub(int i, TreeMap<Integer, Integer> tm) {
		Integer index = tm.floorKey(i);
		if (index == null) {
			return false;
		}
		if (tm.get(index) >= i) {
			return true;
		}
		return false;
	}
	public void displayResult(){
		for(int key:this.onBlubs.keySet()){
			System.out.print(key+"-"+this.onBlubs.get(key)+"   ");
		}
		System.out.println();
	}
}
