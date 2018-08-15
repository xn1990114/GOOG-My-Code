package onsite;
/*
 * N个很大的file 里面都是数, 和无限多个machine. 有一个函数 : int computeSum(fileID, machineID) 
 * 可以让一个机器计算一个file里面数的和。 最后求所有N个file的总和。
我说可以循环来call 这个函数， 然后累计结果。 但是很慢， 最好能用Thread. 然后大哥说好，然后给了thread的结构。
然后写code, 两个循环，一个建立thread, 一个循环加结果。 大哥说ok。
follow up: machine会有硬件原因卡住无法出结果， 然后computeSum 会return 多一个status, 来 告诉你是不是有故障。 
问code如何改进来避免卡住超时。 我就比较懵，没有实际thread的工作经验。。。不知道怎么能catch住哪个status, 说了几个想法大 哥都摇头。 
然后给hint说可以写一个wrapper函数传到thread里，然后让写哪个wrapper函数。 实在时间不够就写了几行， 
然后大概意思是如果有问题就用 k*N+i 的 machine再跑一遍，如果还 错就k+1, 直到得到status是正常。 没时间写完整代码了，就意思了一下。
follow up2: computeSum 这个函数有p 的概率计算结果是错的， 如果改进让总结果错误率小于p. 本来大哥说只剩一分钟了没时间不问了， 
我说你说说我就听听，然后其实也不知道怎么弄，算概 率还算错了(很傻)。大哥就上来指点了下就说算了
我的理解是wrapper()函数里面循环地call 那个computeSum(fileID, machineID), 如果状态对就退 出循环并且return. 
如果状态不对就在machine id 上加N， 继续运行computeSum(), 直到状态对。 类似写一个while(true) 这样的循环吧。
. 1point3acres
然后这个wrapper是在thread的结构器里的。
 */
public class MultiThreadFileSum {
	class Worker extends Thread{
		int[] targetArray;
		int[] statusCode;
		int targetIndex;
		int fileID;
		int machineID;
		public Worker(int[] targetArray,int targetIndex,int fileID,int machineID,int[] statusCode){
			this.targetArray=targetArray;
			this.targetIndex=targetIndex;
			this.fileID=fileID;
			this.machineID=machineID;
			this.statusCode=statusCode;
		}
		@Override
		public void run(){
			try{
			targetArray[targetIndex]=computeSum(fileID,machineID);
			statusCode[targetIndex]=1;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		// dummy code
		private int computeSum(int fileID2, int machineID2) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	// status code 0 not started 1 completed 2 error;
	public int calCalculateAllFiles(String[] files){
		int[] targetArray=new int[files.length];
		Worker[] workers=new Worker[files.length];
		int[] statusCode=new int[files.length];
		boolean needContinue=true;
		while(needContinue){
			for(int i=0;i<files.length;i++){
				if(statusCode[i]!=1){
					workers[i].stop();
					Worker w=new Worker(targetArray,i,i,getNextAvailableMachine(),statusCode);
					w.start();
					workers[i]=w;
				}
			}
			needContinue=false;
			for(int i=0;i<workers.length;i++){
				try {
					workers[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(statusCode[i]!=1){
					needContinue=true;
				}
			}
		}
		int res=0;
		for(int i=0;i<targetArray.length;i++){
			res=res+targetArray[i];
		}
		return res;
	}
	// dummy code
	public int getNextAvailableMachine(){
		return 0;
	}
}
