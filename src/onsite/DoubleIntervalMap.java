package onsite;
import java.util.*;
/*
 * Double map with eplision
设计一个map, map有一个eplison 比如 0.1 key是 double
put ( 2.0, "hello)
get的时候在 如果查询的key在 ( original key - eplison, original key + eplison )的范围内，则返回 original key的value.
比如这个栗子
get(2.05) -> hello get(1.98) -> hello
不考虑overlap collision的情况，面试官提示用bucket做
答案:
如果epsilon 是0.1，代表最小精度是0.1, 1/0.1 = 10, 10就是用来计算bucket的multipler 
如果put(1.2, "hello") ，那就把 (1.2， "hello")这个pair放到 1.2 x 10 = 12 的bucket里面
如果要查找 get( 1.22) , 那么就去bucket 1.22 * 10 = 12的bucket 和他的两边邻居的bucket里面找 ( 11， 13，这个case直接在12就找到了，
那么返回hello)如果查 get(1.12)， 那么就去 bucket 1.12 * 10 = 11的bucket 和他两遍邻居(10, 12)找
因为epsilon是0.1. 如果我们把每个bucket的范围限制在0.1 (方便计算，乘以multipler映射成整 数)，那么我们知道符合结果的key如果存在，
那么一定在他整数映射的bucket或者他两遍的邻居 里面。
 */
//assumptions: no limit in range, gap/interval is can be any value. put option will not override the old values.
public class DoubleIntervalMap {
	double interval;
	Map<Integer,List<Pair>> map;
	public DoubleIntervalMap(double interval){
		this.interval=interval;
		this.map=new HashMap<Integer,List<Pair>>();
	}
	public void put(double key,String val){
		Pair toadd=new Pair(key,val);
		int multiple=(int)Math.floor(key/interval);
		if(!this.map.containsKey(multiple)){
			map.put(multiple, new ArrayList<Pair>());
		}
		map.get(multiple).add(toadd);
	}
	
	public String get(double key){
		int multiple=(int)Math.floor(key/interval);
		List<List<Pair>> candidates=new ArrayList<List<Pair>>();
		candidates.add(map.get(multiple-1));
		candidates.add(map.get(multiple));
		candidates.add(map.get(multiple+1));
		for(int i=0;i<candidates.size();i++){
			List<Pair> currList=candidates.get(i);
			if(currList==null){
				continue;
			}
			for(int j=0;j<currList.size();j++){
				Pair p=currList.get(j);
				if(p.key>=key-interval&&p.key<=key+interval){
					return p.val;
				}
			}
		}
		return null;
	}
	
	
	private class Pair{
		double key;
		String val;
		public Pair(double key,String val){
			this.key=key;
			this.val=val;
		}
	}
}
