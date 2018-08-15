package onsite;
import java.util.*;
/*
 * Implement一个Set class
要求4个O(1)时间的API: add, contains, remove, getRandom. 挺简单的OOD，
因为 getRandom也要常熟时间，所以每次删除就把最后一个元素和被删除的swap就可以. HashSet + array + random swap
 */
public class RandomSet<K> {
	List<K> elementList;
	Map<K,Integer> indexMap;
	public RandomSet(){
		this.elementList=new ArrayList<K>();
		this.indexMap=new HashMap<K,Integer>();
	}
	
	public void add(K valueToAdd){
		if(indexMap.containsKey(valueToAdd)){
			return;
		}
		elementList.add(valueToAdd);
		indexMap.put(valueToAdd, elementList.size()-1);
	}
	
	public boolean contains(K value){
		return this.indexMap.containsKey(value);
	}
	
	public void remove(K value){
		if(!indexMap.containsKey(value)){
			return;
		}
		int index=indexMap.get(value);
		indexMap.remove(value);
		if(index==elementList.size()-1){
			elementList.remove(index);
		}
		else{
			K lastElement=elementList.get(elementList.size()-1);
			indexMap.put(lastElement, index);
			elementList.set(index, lastElement);
			elementList.remove(elementList.size()-1);
		}
	}
	public K getRandom(){
		if(this.elementList.isEmpty()){
			return null;
		}
		int index=(int)(Math.random()*elementList.size());
		return elementList.get(index);
	}
}
