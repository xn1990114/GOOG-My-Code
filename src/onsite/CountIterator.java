package onsite;

import java.util.Iterator;

//写出给定arraylist的iterator，[3, 1, 0, 9, 2, 4] --> [1, 1, 1, 4, 4] 三个1，零个9，两个4
public class CountIterator implements Iterator<Integer>{
	int[] nums;
	int index;
	int countLeft;
	public CountIterator(int[] nums){
		this.index=1;
		this.nums=nums;
		this.countLeft=(nums==null||nums.length==0)?0:nums[0];
		moveToNextLocation();
	}
	@Override
	public boolean hasNext(){
		return this.index<nums.length;
	}
	@Override
	public Integer next(){
		Integer res=nums[index];
		countLeft--;
		moveToNextLocation();
		return res;
	}
	public void moveToNextLocation(){
		while(index<nums.length&&countLeft==0){
			index=index+2;
			if(index>nums.length){
				break;
			}
			countLeft=nums[index-1];
		}
	}
}
