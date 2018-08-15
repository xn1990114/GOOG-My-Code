package onsite;

import java.util.*;

/*
 * Given a 2D char board:  [['G', 'O', 'O'],
                            ['G', 'L', 'E'],
                            ['A', 'B', 'C']]
and given a word, find a shortest sequence path that contains all characters of the word, 
the relative order of the word should be maintained. The path can move to any of 8 adjacent cells,
but one cell can be used at most once.
e.g1., given "GCB", return "GLCB"
e.g2., given "ABO", return "ABGO" or "ABLO" or "ABEO"
e.g3., given "LBC", return "LBC"
e.g4., given "LBF", return empty string

第二题: Instead of one word, given a list of words, find a shortest sequence path for each word.
 */
// time complexity seems to be m*n*4^(m*n)
public class WordSearchWithSkip {
	public String findShortestPath(char[][] board, String word) {
		if (word == null || word.length() == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
		String[] res = new String[1];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				searchBoard(i, j, board, word, new boolean[board.length][board[0].length], 0, move, sb, res);
			}
		}
		return res[0];
	}

	public void searchBoard(int r, int c, char[][] board, String word, boolean[][] visited, int index, int[][] move,
			StringBuilder sb, String[] res) {
		if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c]) {
			return;
		}
		sb.append(board[r][c]);
		visited[r][c] = true;
		if (word.charAt(index) == board[r][c]) {
			index++;
		}
		if (index == word.length()) {
			String cand = sb.toString();
			if (res[0] == null || cand.length() < res[0].length()) {
				res[0] = cand;
			}
			sb.deleteCharAt(sb.length() - 1);
			visited[r][c] = false;
			return;
		}
		for (int i = 0; i < move.length; i++) {
			searchBoard(r + move[i][0], c + move[i][1], board, word, visited, index, move, sb, res);
		}
		sb.deleteCharAt(sb.length() - 1);
		visited[r][c] = false;
	}

	class TrieNode {
		Map<Character, TrieNode> child;
		int index;

		public TrieNode() {
			this.child = new HashMap<Character, TrieNode>();
			this.index=-1;
		}
	}

	public String[] findShortestPathOfMultipleWord(char[][] board, String[] words) {
		if (words == null || words.length == 0) {
			return new String[0];
		}
		int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
		TrieNode root = new TrieNode();
		for (int i = 0; i < words.length; i++) {
			buildTrie(root, words[i], i);
		}
		StringBuilder sb = new StringBuilder();
		String[] res = new String[words.length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				searchBoardWithTrie(root, i, j, board, new boolean[board.length][board[0].length], res, sb, move);
			}
		}
		return res;
	}

	public void searchBoardWithTrie(TrieNode curr, int r, int c, char[][] board, boolean[][] visited, String[] res,
			StringBuilder sb, int[][] move) {
		if(curr==null||r<0||c<0||r>=board.length||c>=board[0].length||visited[r][c]){
			return;
		}
		sb.append(board[r][c]);
		visited[r][c]=true;
		if(curr.child.containsKey(board[r][c])){
			TrieNode nextNode=curr.child.get(board[r][c]);
			if(nextNode.index!=-1){
				int index=nextNode.index;
				String cand=sb.toString();
				if(res[index]==null||res[index].length()>cand.length()){
					res[index]=cand;
				}
			}
			for(int i=0;i<move.length;i++){
				searchBoardWithTrie(nextNode,r+move[i][0],c+move[i][1],board,visited,res,sb,move);
			}
		}
		for(int i=0;i<move.length;i++){
			searchBoardWithTrie(curr,r+move[i][0],c+move[i][1],board,visited,res,sb,move);
		}
		visited[r][c]=false;
		sb.deleteCharAt(sb.length()-1);
	}

	public void buildTrie(TrieNode root, String word, int index) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!curr.child.containsKey(ch)) {
				curr.child.put(ch, new TrieNode());
			}
			curr = curr.child.get(ch);
		}
		curr.index = index;
	}
}
