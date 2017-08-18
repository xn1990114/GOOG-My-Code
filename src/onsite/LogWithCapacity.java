package onsite;

/*
 * 有一个本地存储log的系统，capacity 为n,现在有m个消息源，
 * 发送消息给系统class log{ String msg, String address}。
 * 寻找一个threshold，当一个消息源消息数目<=bound的时候，接受全部消息，
 * 大于bound时候截取bound个存储，输入是list<Log>要求选择bound最大化利用存储容量
 *举了个例子。[10, 20, 20, 50, 70] 存储容量90.bound就是20...
 *这么简单的题目LZ竟然用binary search做了，被吐槽不是最优，中间还有个小bug, 
 *面试官问举出输入是invalid的test case也没举出来。。。
 *///http://www.1point3acres.com/bbs/thread-222495-4-1.html
// unsolved(might have error)
public class LogWithCapacity {
	public int findBound(int[] input,int max){
		int pre=max/input.length;
		return quickSelect(input,0,input.length-1,max,pre);
	}
	public int quickSelect(int[] nums,int start,int end,int target,int pre){
		if(start>end){
			return pre;
		}
		
		int curr=nums[start];
		if(start==end){
			if(nums.length-1-start==0){
				return curr;
			}
			return target/(nums.length-start);
		}
		int i=start+1;
		int j=end;
		int count=curr;
		int higher=Integer.MAX_VALUE;
		while(i<j){
			while(i<=end&&nums[i]<=curr){
				count=count+nums[i];
				i++;
			}
			if(i<=end&&nums[i]>curr){
				higher=Math.min(higher, nums[i]);
			}
			while(j>start&&nums[j]>curr){
				higher=Math.min(higher, nums[j]);
				j--;
			}
			if(i<j){
				int temp=nums[i];
				nums[i]=nums[j];
				nums[j]=temp;
				i++;
				j--;
			}
		}
		nums[start]=nums[j];
		nums[j]=curr;
		int leftcount=nums.length-1-j;
		if(target-count>curr*leftcount){
			return quickSelect(nums,j+1,end,target-count,Math.max(curr, pre));
		}
		else if(target-count<curr*leftcount){
			return quickSelect(nums,start,j-1,target,pre);
		}
		else {
			return curr;
		}
	}
}
