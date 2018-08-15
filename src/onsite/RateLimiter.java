package onsite;

import java.util.Arrays;

/*
 * Rate Limiter，跟leetcode的那题不同，这题如果一秒内超过query per second限制需要wait一下。
给个class
class RateLimiter {
     void setLimit(int query_per_second);
     void wait();
};
wait()是要有block的semantics。
其实这一题打得很不好，在他的提示下找到了要wait多久（有个formula)，最后用了queue给了个O(n)解法。
他接着问O(1)解法。
block的semantics是指在限定的时间内如果qps超过就不能再query。
 */
// linear is LC 362

// need to ask what's the minimum unit of time. below example assuming its 10ms
public class RateLimiter {
	int limit;
	int[] counter;
	int end;
	int total;
	int lastTime;
	public RateLimiter(){
		this.counter=new int[100];
		this.end=0;
		this.total=0;
		this.lastTime=0;
		this.limit=0;
	}
	public void setLimitConstant(int query_per_second){
		this.limit=query_per_second;
	}
    public void waitOnQuery(int timestamp) {
    	System.out.println("Waiting on "+timestamp);
	}
    public void hit(int timestamp){
    	cleanUp(timestamp);
    	if(total>=limit){
    		waitOnQuery(timestamp);
    	}
    	else{
    		counter[end]++;
    		total++;
    		System.out.println("insert at time: " +timestamp+" to total of "+total);
    	}
    }
    public void cleanUp(int timestamp){
    	if(timestamp-lastTime>=100){
    		this.end=0;
    		this.total=0;
    		Arrays.fill(this.counter,0);
    	}
    	else{
    		int diff=timestamp-lastTime;
    		for(int i=0;i<diff;i++){
    			end=(end+1)%100;
    			total=total-counter[end];
    			counter[end]=0;
    		}
    	}
    	this.lastTime=timestamp;
    }
}
