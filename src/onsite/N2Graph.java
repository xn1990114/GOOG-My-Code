package onsite;
//一个N*N的map,里面填上1-N^2，要求行列和两个对角加起来都一样
public class N2Graph {
	public int[][] populateMatrix(int N){
		if(N==0){
			return new int[0][0];
		}
		int target=(1+N*N)*N*N/2;
		if(target%N!=0){
			return new int[0][0];
		}
		target=target/N;
		int[][] res=new int[N][N];
		boolean[] visited=new boolean[N*N+1];
		int[] colSum=new int[N];
		if(canPopulate(res,visited,colSum,target,0,0,0)){
			return res;
		}
		return new int[0][0];
	}
	public boolean canPopulate(int[][] res,boolean[] visited,int[] colSum,int target,int r,int c,int rowSum){
		if(rowSum>target){
			return false;
		}
		if(c==res[0].length){
			if(rowSum!=target){
				return false;
			}
			rowSum=0;
			r++;
			c=0;
		}
		if(r==res.length){
			return meetTarget(res,colSum,target);
		}
		for(int i=1;i<visited.length;i++){
			if(!visited[i]){
				colSum[c]=colSum[c]+i;
				visited[i]=true;
				res[r][c]=i;
				if(colSum[c]<=target){
					if(canPopulate(res,visited,colSum,target,r,c+1,rowSum+i)){
						return true;
					}
				}
				res[r][c]=0;
				visited[i]=false;
				colSum[c]=colSum[c]-i;
			}
		}
		return false;
	}
	public boolean meetTarget(int[][] res,int[] colSum,int target){
		int downSum=0;
		int upSum=0;
		for(int i=0;i<colSum.length;i++){
			if(colSum[i]!=target){
				return false;
			}
			downSum=downSum+res[i][i];
			upSum=upSum+res[res.length-1-i][i];
		}
		return downSum==target&&upSum==target;
	}
	
	public void printMatrix(int[][] res){
		if(res.length==0){
			System.out.println("Empty");
			return;
		}
		for(int i=0;i<res.length;i++){
			for(int j=0;j<res[i].length;j++){
				System.out.print(res[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
