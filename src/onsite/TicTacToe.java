package onsite;

import java.util.*;

/*
 * tic-tac-toe变种，给n*n的格子，每次有1进来都从左上角进来，剩下的元素都往右移一位，右下角那个直接删除，
 * 其他行末尾变成下一行第一个，没想出来，暴力解的。
 */
public class TicTacToe {
	List<Queue<Integer>> cells;
	List<Integer> rows;
	Queue<Integer> cols;
	Queue<Integer> leftTopToRightDown;
	public Queue<Integer> rightTopToLeftDown;
	int n;
	public TicTacToe(int n){
		this.n=n;
		this.cells=new ArrayList<Queue<Integer>>();
		this.rows=new ArrayList<Integer>();
		this.cols=new LinkedList<Integer>();
		this.leftTopToRightDown=new LinkedList<Integer>();
		this.rightTopToLeftDown=new LinkedList<Integer>();
		for(int i=0;i<n;i++){
			Queue<Integer> toadd=new LinkedList<Integer>();
			for(int j=0;j<n;j++){
				toadd.offer(0);
			}
			rows.add(0);
			leftTopToRightDown.add(0);
			rightTopToLeftDown.add(0);
			cells.add(toadd);
			cols.add(0);
		}
	}
	public boolean insertNewPiece(int newVal){
		List<Integer> newHead=new ArrayList<Integer>();
		List<Integer> lastTail=new ArrayList<Integer>();
		int last=newVal;
		for(int i=0;i<cells.size();i++){
			newHead.add(last);
			lastTail.add(cells.get(i).poll());
			cells.get(i).offer(last);
			last=lastTail.get(i);
		}
		// update col
		int newCol=cols.poll();
		newCol=newCol-last+newVal;
		if(newCol==n){
			return true;
		}
		cols.offer(newCol);
		// update row
		for(int i=0;i<rows.size();i++){
			rows.set(i, rows.get(i)+newHead.get(i)-lastTail.get(i));
			if(rows.get(i)==n){
				return true;
			}
		}
		// update left top to bottom right
		leftTopToRightDown.poll();
		for(int i=0;i<n;i++){
			int nextVal=i==n-1?0:leftTopToRightDown.poll();
			nextVal=nextVal+newHead.get(i);
			if(nextVal==n){
				return true;
			}
			leftTopToRightDown.offer(nextVal);
		}
		// update top right to left buttom
		rightTopToLeftDown.poll();
		for(int i=n-1;i>=0;i--){
			int nextVal=i==0?0:rightTopToLeftDown.poll();
			nextVal=nextVal+newHead.get(i);
			if(nextVal==n){
				return true;
			}
			rightTopToLeftDown.offer(nextVal);
		}
		return false;
	}
	public void displayMatrix(){
		for(int i=0;i<n;i++){
			Queue<Integer> qu=cells.get(i);
			List<Integer> list=new ArrayList<Integer>();
			list.addAll(qu);
			Collections.reverse(list);
			for(Integer v:list){
				System.out.print(v+",");
			}
			System.out.println();
		}
	}
}
