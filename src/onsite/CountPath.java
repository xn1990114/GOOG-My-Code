package onsite;
/*
 * 给一个二维grid，只允许右，右上，右下，有几种走法。
 * 起始点(0,0)，目标点(0,n)。dp题，要求O(n)space complexity。
 */
public class CountPath {
	public int findCount(int n){
		if(n==0){
			return 1;
		}
		// very important to find length, odd vs even
		int[] res=new int[n+1];
		res[(n+1)/2]=1;
		for(int i=1;i<=n;i++){
			int[] newRes=new int[n+1];
			for(int j=0;j<res.length;j++){
				newRes[j]=res[j]+(j-1>=0?res[j-1]:0)+(j+1==res.length?0:res[j+1]);
			}
			res=newRes;
		}
		return res[(n+1)/2];
	}
}
