package onsite;

import java.util.ArrayList;
import java.util.List;

/*
 * 第三轮。word cross游戏。给定输入`String[] hints, int[] lenOfWords`, 以及一个word cross board:

   2
   _       3 
 1 _ _ _ _ _
   _       _
   _       _
   _       _ 
           _
           _
该board中包含的每一个单词的placeholder：_，以及每一个单词对应哪一行或那一列。例如本例子中第一个单词为图中第一个横行，
第二个单词为图中第一个竖列，第三个单词为图中第二个竖列。每个单词的长度应当和placeholder的数目相同。
同时`hints`及`lenOfWords`包含第`i`个单词的hint和长度。
给定一个方法`String[] getPotentialWord(String hint, int len)`能够返回给定hint和长度的单词的可能的单词列表，
要求完成`boolean isSolvable(String[] hints, int[] lenOfWords)
方法返回给定board，hints以及lenOfWord的情况下当前board能否被合适的单词填满。
同时还要求设计合适的数据结构存储给定问题的board以及结题需要的信息。board中两个单词相交的情况下，相交位置必须为同一个字母

 */
/*
 * 好机智，用adjacency list的话 比如你的例子里
1:[2,-1,-1,-1,3] 表示第0个位置和word2相交，第4个位置里和word3相交
2:[-1,1,-1,-1,-1]
3:[1,-1,-1,-1,-1]
 */

//assuming each hint can be used only 1 time;
public class FillWordBoard {
	// missingWordLocation 0->r,1->c,2->(0 horizontal 1 vertical), 3->len
	public String[] dic;

	public boolean isSolvable(char[][] board, int[][] missingWordLocation, String[] hints, int[] lenOfWords) {
		return dfs(board, missingWordLocation, 0, hints, lenOfWords, new boolean[hints.length]);
	}

	public boolean dfs(char[][] board, int[][] missingWordLocation, int locationIndex, String[] hints, int[] lenOfWords,
			boolean[] visitedHints) {
		if (locationIndex == missingWordLocation.length) {
			return true;
		}
		for (int i = 0; i < visitedHints.length; i++) {
			if (!visitedHints[i] && lenOfWords[i] == missingWordLocation[locationIndex][3]) {
				visitedHints[i] = true;
				String[] dic = getPotentialWord(hints[i], lenOfWords[i]);
				for (String word : dic) {
					if (canFill(board, missingWordLocation[locationIndex], word)) {
						List<int[]> filledCells=fill(board, missingWordLocation[locationIndex], word);
						if (dfs(board, missingWordLocation, locationIndex + 1, hints, lenOfWords, visitedHints)) {
							return true;
						}
						resetBoard(board,filledCells);
					}
				}
				visitedHints[i] = false;
			}
		}
		return false;
	}

	public void resetBoard(char[][] board, List<int[]> filledCells) {
		for(int i=0;i<filledCells.size();i++){
			int[] curr=filledCells.get(i);
			board[curr[0]][curr[1]]='_';
		}
	}

	public boolean canFill(char[][] board, int[] missingLocation, String word) {
		if (missingLocation[3] != word.length()) {
			return false;
		}
		int[] move = missingLocation[2] == 0 ? new int[] { 0, 1 } : new int[] { 1, 0 };
		int r = missingLocation[0];
		int c = missingLocation[1];
		for (int i = 0; i < word.length(); i++) {
			if (board[r][c] != '_' && board[r][c] != word.charAt(i)) {
				return false;
			}
			r = r + move[0];
			c = c + move[1];
		}
		return true;
	}

	public List<int[]> fill(char[][] board, int[] missingLocation, String word) {
		List<int[]> res=new ArrayList<int[]>();
		if (!canFill(board, missingLocation, word)) {
			return res;
		}
		int[] move = missingLocation[2] == 0 ? new int[] { 0, 1 } : new int[] { 1, 0 };
		int r = missingLocation[0];
		int c = missingLocation[1];
		for (int i = 0; i < word.length(); i++) {
			if(board[r][c]=='_'){
				res.add(new int[]{r,c});
				board[r][c] = word.charAt(i);
			}
			r = r + move[0];
			c = c + move[1];
		}
		return res;
	}

	public String[] getPotentialWord(String hint, int len) {
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < dic.length; i++) {
			String curr = dic[i];
			if (curr.startsWith(hint) && curr.length() == len) {
				res.add(curr);
			}
		}
		String[] arrayRes=new String[res.size()];
		for(int i=0;i<arrayRes.length;i++){
			arrayRes[i]=res.get(i);
		}
		return arrayRes;
	}

	public void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println();
	}
}
