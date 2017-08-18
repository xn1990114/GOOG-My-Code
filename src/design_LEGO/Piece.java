package design_LEGO;

public class Piece {
	int[][] content;
	public Piece(int[][] content){
		this.content=content;
	}
	public boolean isSame(Piece target){
		for(int i=0;i<3;i++){
			if(checker(this.content,target.content)){
				return true;
			}
			target.rotate();
		}
		
		return false;
	}
	public void rotate(){
		int[][] newContent=new int[this.content[0].length][this.content.length];
		for(int i=0;i<content.length;i++){
			for(int j=0;j<content[0].length;j++){
				newContent[j][newContent[0].length-1-i]=content[i][j];
			}
		}
		this.content=newContent;
	}
	
	public boolean checker(int[][] c1,int[][] c2){
		if(c1.length!=c2.length||c1[0].length!=c2[0].length){
			return false;
		}
		for(int i=0;i<c1.length;i++){
			for(int j=0;j<c2[0].length;j++){
				if(c1[i][j]!=c2[i][j]){
					return false;
				}
			}
		}
		return true;
	}
	
}
