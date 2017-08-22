package onsite;
import java.util.*;

public class MergeKSortedListGeneric {
	class Element<T extends Comparable<T>> implements Comparable<Element<T>>{
		int row;
		int col;
		T val;
		public Element(int row,T val){
			this.val=val;
			this.row=row;
			this.col=0;
		}
		@Override
		public int compareTo(Element<T> o) {
			return  this.val.compareTo(o.val);
		}
	}
	public <T extends Comparable<T>> List<T> mergeList(List<List<T>> lists){
		List<T> res=new ArrayList<T>();
		PriorityQueue<Element<T>> pq=new PriorityQueue<Element<T>>();
		for(int i=0;i<lists.size();i++){
			if(lists.get(i).size()>0){
				Element<T> e=new Element<T>(i,lists.get(i).get(0));
				pq.offer(e);
			}
		}
		while(!pq.isEmpty()){
			Element<T> top=pq.poll();
			res.add(top.val);
			top.col++;
			if(top.col<lists.get(top.row).size()){
				top.val=lists.get(top.row).get(top.col);
				pq.offer(top);
			}
		}
		return res;
	}
}
