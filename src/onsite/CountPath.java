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
	//followup：设定上下界，所有走出这个上下界的路线数量。(or condition)
	public int findCountWithLimit(int n,int low,int high){
		// very important to find length, odd vs even
		int[] resMet=new int[n+1];
		int[] resNotMet=new int[n+1];
		int start=(n+1)/2;
		if(low>0||high<0){
			resMet[(n+1)/2]=1;
		}
		else{
			resNotMet[(n+1)/2]=1;
		}
		for(int i=0;i<n;i++){
			int[] newResMet=new int[n+1];
			int[] newResNotMet=new int[n+1];
			for(int j=0;j<resMet.length;j++){
				if(j-1>=0){
					newResMet[j-1]=newResMet[j-1]+resMet[j];
					if(start-j-1>high){
						newResMet[j-1]=newResMet[j-1]+resNotMet[j];
					}
					else{
						newResNotMet[j-1]=newResNotMet[j-1]+resNotMet[j];
					}
				}
				newResMet[j]=newResMet[j]+resMet[j];
				newResNotMet[j]=newResNotMet[j]+resNotMet[j];
				if(j+1<resMet.length){
					newResMet[j+1]=newResMet[j+1]+resMet[j];
					if(start-j-1<low){
						newResMet[j+1]=newResMet[j+1]+resNotMet[j];
					}
					else{
						newResNotMet[j+1]=newResNotMet[j+1]+resNotMet[j];
					}
				}
			}
			resMet=newResMet;
			resNotMet=newResNotMet;
		}
		return resMet[(n+1)/2];
	}
}
