package onsite;
import java.util.*;
/*
 * 让玩一个online小游戏，给你一个board，上面随机放着几个小汽车，横着放的可以左右移动，竖着放的可以上下移动，
 * board的右边边界处有一个位置是Exit。车头车尾要是有其他汽车挡着就动不了，要求设法移动其他汽车使得某个指定的小汽车能够移动到Exit的位置。 
 * 玩了两局游戏以后，问你怎么表示这个board以及上面的小汽车，然后让写一个method判断能否移动其中某一个汽车（就是这个汽车周围有没有其他汽车挡着）。
 * 当时说用矩阵表示这个board，每个小汽车可以用它的头尾在矩阵中的位置表示，其他的小汽车可以看作是它的邻居，
 * 判断它的上下或者左右有没有邻居就可以知道能否移动它。面试官觉得reasonable，让实现出来，给你一个指定的汽车，
 * 返回阻碍它移动的所有邻居（可能还要考虑邻居的邻居）
 */
public class CarBlockers {
	public class Car{
		int id;
		int top;
		int down;
		int left;
		int right;
		public Car(int id,int top,int down,int left,int right){
			this.id=id;
			this.top=top;
			this.down=down;
			this.left=left;
			this.right=right;
		}
	}
	public List<Integer> findBlockers(Map<Integer,Car> carMap,int[][] board,Car targetCar){
		List<Integer> res=new ArrayList<Integer>();
		Set<Integer> visited=new HashSet<Integer>();
		visited.add(targetCar.id);
		Queue<Car> qu=new LinkedList<Car>();
		qu.offer(targetCar);
		while(!qu.isEmpty()){
			int size=qu.size();
			for(int round=0;round<size;round++){
				Car top=qu.poll();
				List<Car> neighbor=getNeighbor(carMap,board,top);
				for(int i=0;i<neighbor.size();i++){
					Car next=neighbor.get(i);
					if(!visited.contains(next.id)){
						visited.add(next.id);
						res.add(next.id);
						qu.offer(next);
					}
				}
			}
		}
		
		return res;
	}
	private List<Car> getNeighbor(Map<Integer,Car> carMap,int[][] board,Car currCar){
		List<Car> res=new ArrayList<Car>();
		if(currCar.left==currCar.right){
			if(currCar.top-1>=0&&board[currCar.top-1][currCar.left]!=0){
				res.add(carMap.get(board[currCar.top-1][currCar.left]));
			}
			if(currCar.down+1<board.length&&board[currCar.down+1][currCar.left]!=0){
				res.add(carMap.get(board[currCar.down+1][currCar.left]));
			}
		}
		else{
			if(currCar.left-1>=0&&board[currCar.top][currCar.left-1]!=0){
				res.add(carMap.get(board[currCar.top][currCar.left-1]));
			}
			if(currCar.right+1<board[0].length&&board[currCar.top][currCar.right+1]!=0){
				res.add(carMap.get(board[currCar.top][currCar.right+1]));
			}
		}
		return res;
	}
	public boolean checkResult(List<Integer> res,int[] target){
		if(res.size()!=target.length){
			return false;
		}
		Collections.sort(res);
		for(int i=0;i<res.size();i++){
			if(res.get(i)!=target[i]){
				return false;
			}
		}
		return true;
	}
}
