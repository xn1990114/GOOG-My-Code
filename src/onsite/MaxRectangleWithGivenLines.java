package onsite;
import java.util.*;
// given some horizontal and vertical lines. Whats the area of max rectangle is can form
public class MaxRectangleWithGivenLines {
	public class Line{
		int x1;
		int x2;
		int y1;
		int y2;
		public Line(int x1,int x2,int y1,int y2){
			this.x1=Math.min(x1, x2);
			this.x2=Math.max(x1, x2);
			this.y1=Math.min(y1, y2);
			this.y2=Math.max(y1, y2);
		}
		public boolean isVertical(){
			return this.x1==this.x2;
		}
	}
	public int calMaxArea(List<Line> lines){
		if(lines==null||lines.size()<4){
			return 0;
		}
		List<Line> vlines=new ArrayList<Line>();
		List<Line> hlines=new ArrayList<Line>();
		for(int i=0;i<lines.size();i++){
			Line l=lines.get(i);
			if(l.isVertical()){
				vlines.add(l);
			}
			else{
				hlines.add(l);
			}
		}
		int maxArea=0;
		for(int i=0;i<hlines.size();i++){
			for(int j=i+1;j<hlines.size();j++){
				Line hline1=hlines.get(i);
				Line hline2=hlines.get(j);
				int minX=Integer.MAX_VALUE;
				int maxX=Integer.MIN_VALUE;
				for(int k=0;k<vlines.size();k++){
					Line vline=vlines.get(k);
					int[] intersection1=getIntersection(vline,hline1);
					int[] intersection2=getIntersection(vline,hline2);
					if(intersection1!=null&&intersection2!=null){
						minX=Math.min(minX, vline.x1);
						maxX=Math.max(maxX, vline.x1);
					}
				}
				if(minX<maxX){
					maxArea=Math.max(maxArea, (maxX-minX)*Math.abs(hline2.y1-hline1.y1));
				}
			}
		}
		
		return maxArea;
	}
	
	
	public int[] getIntersection(Line vline,Line hline){
		if(vline.x1!=vline.x2||hline.y1!=hline.y2){
			return null;
		}
		if(vline.x1<hline.x1||vline.x1>hline.x2||hline.y1<vline.y1||hline.y1>vline.y2){
			return null;
		}
		return new int[]{vline.x1,hline.y1};
	}
}
