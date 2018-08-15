package onsite;
/*
 * 用最少的正方形填满矩形
给你一个矩形，用最少的square填充满，我当时想用dp，后来讨论了一下发现不太行，然后他给了一堆hint让我用greedy，
然后之后又说greedy也不是最优的，我就懵逼了，之后问问题我问他 该咋做，他说这个没有解。。。只能找个optimal solution，类似np
 */
public class MinSqaureToFillRectangle {
	public int calMinNumberOfSquare(int height,int width){
		if(height==0||width==0){
			return 0;
		}
		int[] res={Integer.MAX_VALUE};
		boolean[][] rectangle=new boolean[height][width];
		searchMinCutNumber(rectangle,res,0);
		return res[0];
	}
	public void searchMinCutNumber(boolean[][] rectangle,int[] res,int totalCut){
		int[] start=nextStart(rectangle);
		if(start[0]==-1){
			res[0]=Math.min(res[0],totalCut);
			return;
		}
		for(int len=1;len<=rectangle.length;len++){
			if(canPlaceSquare(start[0],start[1],len,rectangle)){
				markArea(start[0],start[1],len,true,rectangle);
				searchMinCutNumber(rectangle,res,totalCut+1);
				markArea(start[0],start[1],len,false,rectangle);
			}
		}
	}
	
	public boolean canPlaceSquare(int startR,int startC,int len,boolean[][] rectangle){
		if(startR+len-1>=rectangle.length||startC+len-1>=rectangle[0].length){
			return false;
		}
		for(int r=startR;r<startR+len;r++){
			for(int c=startC;c<startC+len;c++){
				if(rectangle[r][c]){
					return false;
				}
			}
		}
		return true;
	}
	public void markArea(int startR,int startC,int len,boolean val,boolean[][] rectangle){
		if(startR+len-1>=rectangle.length||startC+len-1>=rectangle[0].length){
			return;
		}
		for(int r=startR;r<startR+len;r++){
			for(int c=startC;c<startC+len;c++){
				rectangle[r][c]=val;
			}
		}
	}
	public int[] nextStart(boolean[][] rectangle){
		for(int i=0;i<rectangle.length;i++){
			for(int j=0;j<rectangle[0].length;j++){
				if(!rectangle[i][j]){
					return new int[]{i,j};
				}
			}
		}
		return new int[]{-1,-1};
	}
	public int calMinNumberOfSquareGreedy(int height,int width){
		if(height==0||width==0){
			return 0;
		}
		int high=Math.max(height, width);
		int low=Math.min(height, width);
		int countStep=0;
		while(low!=0){
			countStep=countStep+high/low;
			int newHigh=low;
			int newLow=high%low;
			high=newHigh;
			low=newLow;
		}
		return countStep;
		
	}
}
