package onsite;
//给一个二维矩阵，随机一个出发点，盘旋向外输出，当第一次碰到边界时停止，某code上有原题
public class RotationMovement {
	public void firstEdgeLocation(int[][] matrix,int r,int c){
		int up=r;
		int down=r;
		int left=c;
		int right=c;
		int dir=0; // 0up,1right,2down,3left
		matrix[r][c]=1;
		while(r!=0&&c!=0&&r!=matrix.length-1&&c!=matrix[0].length-1){
			if(dir==0){
				r--;
				if(r<up){
					up=r;
					dir++;
				}
			}
			else if(dir==1){
				c++;
				if(c>right){
					right=c;
					dir++;
				}
			}
			else if(dir==2){
				r++;
				if(r>down){
					down=r;
					dir++;
				}
			}
			else{
				c--;
				if(c<left){
					left=c;
					dir=0;
				}
			}
			matrix[r][c]=1;
		}
	}
	public boolean sameMatrix(int[][] m1, int[][] m2){
		if(m1.length!=m2.length||m1[0].length!=m2[0].length){
			return false;
		}
		for(int r=0;r<m1.length;r++){
			for(int c=0;c<m1[0].length;c++){
				if(m1[r][c]!=m2[r][c]){
					return false;
				}
			}
		}
		return true;
	}
}
