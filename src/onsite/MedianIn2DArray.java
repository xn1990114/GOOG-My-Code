package onsite;
//二维矩阵找median，sorted in row
public class MedianIn2DArray {
	public double findMedian(int[][] nums){
		int size=0;
		for(int i=0;i<nums.length;i++){
			size=size+nums[i].length;
		}
		if(size%2==1){
			return findKth(nums,size/2+1);
		}
		double low=findKth(nums,size/2);
		double high=findKth(nums,size/2+1);
		return (low+high)/2.0;
	}
	public double findKth(int[][] nums,int k){
		int[][] index=new int[nums.length][2];
		for(int i=0;i<index.length;i++){
			index[i][1]=nums[i].length-1;
		}
		while(true){
			int count=0;
			int l=Integer.MAX_VALUE;
			int lrow=-1;
			int hrow=-1;
			int countHasValue=0;
			int h=Integer.MIN_VALUE;
			for(int i=0;i<index.length;i++){
				if(index[i][0]<=index[i][1]){
					countHasValue++;
					int m=index[i][0]+(index[i][1]-index[i][0])/2;
					count=count+m-index[i][0]+1;
					if(nums[i][m]<l){
						lrow=i;
						l=nums[i][m];
					}
					if(nums[i][m]>=h){
						hrow=i;
						h=nums[i][m];
					}
				}
			}
			if(lrow==hrow){
				if(k<=count&&k>count-countHasValue){
					return h;
				}
				else if(count<k){
					for(int i=0;i<index.length;i++){
						if(index[i][0]<=index[i][1]){
							int m=index[i][0]+(index[i][1]-index[i][0])/2;
							k=k-(m-index[i][0]+1);
							index[i][0]=m+1;
						}
					}
				}
				else{
					for(int i=0;i<index.length;i++){
						if(index[i][0]<=index[i][1]){
							int m=index[i][0]+(index[i][1]-index[i][0])/2;
							index[i][1]=m-1;
						}
					}
				}
			}
			else{
				if(lrow==hrow){
					return nums[lrow][index[lrow][0]+k-1];
				}
				// remove lowest
				else if(count<=k){
					int m=index[lrow][0]+(index[lrow][1]-index[lrow][0])/2;
					k=k-(m-index[lrow][0]+1);
					index[lrow][0]=m+1;
				}
				//remove highest
				else{
					int m=index[hrow][0]+(index[hrow][1]-index[hrow][0])/2;
					index[hrow][1]=m-1;
				}
			}
		}
	}
}
