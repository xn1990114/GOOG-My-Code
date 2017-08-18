package onsite;
import java.util.*;
/*
 * 写一个data structure 要求包括实现以下函数 
 * size(), push(key, value), findByKey(key), findByIdx(index), removeByKey(key), 
 * removeByIdx(index) ,其中push的时候如果已经有key存在，就更新其对应value，其它的比较好理解。
 */
public class IndexKeyMap {
	static int currIndex=0;
	// map index to key
	Map<Integer,String> indexMap;
	// map key to index
	Map<String,Integer> keyMap;
	// map key to value
	Map<String,String> valueMap;
	public IndexKeyMap(){
		this.indexMap=new HashMap<Integer,String>();
		this.keyMap=new HashMap<String,Integer>();
		this.valueMap=new HashMap<String,String>();
	}
	public int size(){
		return this.valueMap.size();
	}
	public void push(String key,String value){
		if(valueMap.keySet().contains(key)){
			valueMap.put(key, value);
			return;
		}
		indexMap.put(currIndex,key);
		keyMap.put(key, currIndex);
		valueMap.put(key, value);
		currIndex++;
	}
	public String findByKey(String key){
		return this.valueMap.get(key);
	}
	
	public String findByIndex(int index){
		return this.valueMap.get(this.indexMap.get(index));
	}
	
	public void removeByKey(String key){
		if(!this.keyMap.keySet().contains(key)){
			return;
		}
		int index=this.keyMap.get(key);
		this.indexMap.remove(index);
		this.keyMap.remove(key);
		this.valueMap.remove(key);
	}
	
public void removeByIndex(int index){
	if(!this.indexMap.keySet().contains(index)){
		return;
	}
		String key=this.indexMap.get(index);
		this.indexMap.remove(index);
		this.keyMap.remove(key);
		this.valueMap.remove(key);
	}
	
	public void display(){
		for(int i:indexMap.keySet()){
			System.out.print(i+":"+indexMap.get(i)+"\t");
		}
		System.out.println();
		for(String i:keyMap.keySet()){
			System.out.print(i+":"+keyMap.get(i)+"\t");
		}
		System.out.println();
		for(String i:valueMap.keySet()){
			System.out.print(i+":"+valueMap.get(i)+"\t");
		}
	}
}
