package onsite;
import java.util.*;
//输入一系列点的坐标，返回面积最小的长方形的坐标。
public class MinRectangle {
	class Element{
		int x;
		List<Integer> y;
		public Element(int x,Set<Integer> set){
			this.x=x;
			this.y=new ArrayList<Integer>(set);
			Collections.sort(this.y);
		}
	}
	public int[] findCoordinate(int[][] points){
		Map<Integer,Set<Integer>> map=new HashMap<Integer,Set<Integer>>();
		for(int i=0;i<points.length;i++){
			int x=points[i][0];
			int y=points[i][1];
			if(!map.containsKey(x)){
				map.put(x, new HashSet<Integer>());
			}
			map.get(x).add(y);
		}
		List<Element> list=new ArrayList<Element>();
		for(int key:map.keySet()){
			list.add(new Element(key,map.get(key)));
		}
		Collections.sort(list,new Comparator<Element>(){
			public int compare(Element e1,Element e2){
				return e1.x-e2.x;
			}
		});
		int[] res=new int[4];
		int min=Integer.MAX_VALUE;
		for(int r1=0;r1<list.size();r1++){
			Element e1=list.get(r1);
			for(int r2=r1+1;r2<list.size();r2++){
				Element e2=list.get(r2);
				int i1=0;
				int i2=0;
				int lastMatch=-1;
				while(i1<e1.y.size()&&i2<e2.y.size()){
					if(e1.y.get(i1)==e2.y.get(i2)){
						if(lastMatch>-1){
							int curr=(e2.x-e1.x)*(e1.y.get(i1)-e1.y.get(lastMatch));
							if(curr<min){
								res[0]=e1.x;
								res[1]=e1.y.get(lastMatch);
								res[2]=e2.x;
								res[3]=e1.y.get(i1);
								min=curr;
							}
						}
						lastMatch=i1;
						i1++;
						i2++;
					}
					else if(e1.y.get(i1)<e2.y.get(i2)){
						i1++;
					}
					else{
						i2++;
					}
				}
			}
		}
		return min==Integer.MAX_VALUE?new int[0]:res;
	}
}
