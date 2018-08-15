package onsite;
//给两个数 n 和 sum，要求输出一个数组，长度为 n，元素的和为 sum
// follow up the max number in one slot is cap
public class GenerateRandomArrayOfSum {
	public int[] randomArrayWithSum(int n,int k){
		int[] res=new int[n];
		for(int i=0;i<k;i++){
			int index=(int)(Math.random()*n);
			res[index]++;
		}
		return res;
	}
	public int[] randomArrayWithSumAndCap(int n,int k,int cap){
		if(cap<0){
			return null;
		}
		int[] res=new int[n];
		for(int i=0;i<k;i++){
			int index=(int)(Math.random()*n);
			res[index]++;
			if(res[index]==cap){
				int temp=res[index];
				res[index]=res[n-1];
				res[n-1]=temp;
				n--;
			}
		}
		shuffle(res);
		return res;
	}
	public void shuffle(int[] res){
		for(int i=res.length-1;i>=0;i--){
			int index=(int)(Math.random()*(i+1));
			int temp=res[index];
			res[index]=res[i];
			res[i]=temp;
		}
	}
}
