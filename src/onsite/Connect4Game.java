package onsite;
import java.util.*;
/*
 * connected 4 game 。给你一个play (k,n,i) 返回嬴或者输。 自己定义 数据结构，类。问题抽象成一个数组， 
 * k是连续的石子，N是数组长度，i是每次你放石子的位置。当你放一个石子到数组里，使连续的石子长度大于等于K 就返回true 否则返回false。
 */
// below answer is optimized for lookup result after placing a piece
public class Connect4Game {
	int[][] board;
	TreeMap<Integer,Integer>[] rows;
	TreeMap<Integer,Integer>[] cols;
	int k;
	public Connect4Game(int n,int k){
		this.board=new int[n][n];
		this.rows=new TreeMap[n];
		this.cols=new TreeMap[n];
		this.k=k;
		for(int i=0;i<n;i++){
			rows[i]=new TreeMap<Integer,Integer>();
			cols[i]=new TreeMap<Integer,Integer>();
		}
	}
	// player 1 put 1 player 2 put -1;
	public int placePiece(int r,int c,int player){
		if(board[r][c]!=0){
			return 0;
		}
		int piece=player==1?1:-1;
		board[r][c]=piece;
		int lowC=c;
		int highC=c;
		TreeMap<Integer,Integer> row=rows[r];
		Integer floorC=row.floorKey(c);
		Integer ceilC=row.ceilingKey(c);
		if(floorC!=null&&row.get(floorC)==c-1&&board[r][floorC]==piece){
			lowC=floorC;
			row.remove(floorC);
		}
		if(ceilC!=null&&ceilC==c+1&&board[r][ceilC]==piece){
			highC=row.get(ceilC);
			row.remove(ceilC);
		}
		row.put(lowC, highC);
		
		int lowR=r;
		int highR=r;
		TreeMap<Integer,Integer> col=cols[c];
		Integer floorR=col.floorKey(r);
		Integer ceilR=col.ceilingKey(r);
		if(floorR!=null&&col.get(floorR)==r-1&&board[floorR][c]==piece){
			lowR=floorR;
			col.remove(floorR);
		}
		if(ceilR!=null&&ceilR==r+1&&board[ceilR][c]==piece){
			highR=col.get(ceilR);
			col.remove(ceilR);
		}
		col.put(lowR, highR);
		if(highR-lowR+1>=k||highC-lowC+1>=k){
			return player;
		}
		return 0;
	}
}
