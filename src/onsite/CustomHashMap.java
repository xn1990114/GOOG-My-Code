package onsite;
import java.util.*;

public class CustomHashMap<K,V> {
	class Pair{
		K key;
		V value;
		public Pair(K key,V value){
			this.key=key;
			this.value=value;
		}
	}
	List<Pair>[] buckets;
	public CustomHashMap(){
		this.buckets=new List[100];
		for(int i=0;i<100;i++){
			this.buckets[i]=new ArrayList<Pair>();
		}
	}
	public boolean containsKey(K key){
		int hashCode=key.hashCode()%100;
		List<Pair> targetList=buckets[hashCode];
		for(int i=0;i<targetList.size();i++){
			Pair p=targetList.get(i);
			if(p.key.equals(key)){
				return true;
			}
		}
		return false;
	}
	public V get(K key){
		int hashCode=key.hashCode()%100;
		List<Pair> targetList=buckets[hashCode];
		for(int i=0;i<targetList.size();i++){
			Pair p=targetList.get(i);
			if(p.key.equals(key)){
				return p.value;
			}
		}
		return null;
	}
	public void put(K key,V value){
		int hashCode=key.hashCode()%100;
		List<Pair> targetList=buckets[hashCode];
		for(int i=0;i<targetList.size();i++){
			Pair p=targetList.get(i);
			if(p.key.equals(key)){
				p.value=value;
				return;
			}
		}
		targetList.add(new Pair(key,value));
	}
	public void remove(K key){
		int hashCode=key.hashCode()%100;
		List<Pair> targetList=buckets[hashCode];
		for(int i=0;i<targetList.size();i++){
			Pair p=targetList.get(i);
			if(p.key.equals(key)){
				targetList.remove(p);
				return;
			}
		}
	}
	public int size(){
		int res=0;
		for(int i=0;i<100;i++){
			res=res+buckets[i].size();
		}
		return res;
	}
}
