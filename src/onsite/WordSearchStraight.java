package onsite;
//判断一个单词是不是在char[][] array。八个直线方向，上，下，左，右，左上，右上，左下，右下。不能拐弯。比刷题网站需要dfs的那道题简单。
public class WordSearchStraight {
	public boolean searchWord(String word,char[][] matrix){
		if(word==null||matrix==null||matrix.length==0||matrix[0].length==0){
			return false;
		}
		if(word.length()==0){
			return true;
		}
		int[][] movement={{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				for(int k=0;k<movement.length;k++){
					if(canFind(word,matrix,i,j,movement[k])){
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean canFind(String word,char[][] matrix,int r,int c,int[] move){
		int index=0;
		while(r>=0&&c>=0&&r<matrix.length&&c<matrix[0].length&&index<word.length()){
			if(word.charAt(index)!=matrix[r][c]){
				return false;
			}
			index++;
			r=r+move[0];
			c=c+move[1];
		}
		return index==word.length();
	}
}
