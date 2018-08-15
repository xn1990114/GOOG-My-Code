package onsite;
/*
 * 问题是假设一个图被rails和telegraph连接，两个人 A 和 B move in turns, 只能沿着 rails 走，input是rails[][] tele[][], 
 * A 的起始位置，B的起始位置。问题有些绕，判断是否B无论如何怎么走A都能和B传递信息。

A和B要传递信息有两种方式1) A和B在同一个城市，或者2) A和B在被telegraph连接的城市。

我的思路是1) 先让B走，然后把B走过的城市按照 B(city, days) pair保存起来，2) 然后从这些 (city, days) 出发，
看能否找到A。后面经过提醒，发现2)可以改为从A出发，
然后记录走过的 A(city, days) pair，如果 B(city, days) 是 A(city,days) pair的子集，那么函数可以返回true。

经过她的提醒，我们还需要判断环的情况就是说如果B刻意避开A，总有可能A和B无法相遇，应该返回False。
我思考了下，觉得我们还需要判断是否存在一个长度大于4的环。

最后时间不够没有写完，只写了A和 B的 BFS。感觉自己刷题水平还是不够，花了大量时间在想case上。
应该是前面一种情况，这道题我当时也理解了很久。忘记说还有一个条件了，就是input还有一个参数K，代表步数。

K步之内，无论B怎么走，A和B总能传递消息。你可以想象B走过的地方可以保存为map<moment, city>，
然后A走过的地方也保存在map<moment, city>，判断从 0 到 k 时刻的任意一个时刻 i, B 走到的 cities b，和 A在i时刻走到的cities a，
这两个集合 b, a 有至少一个相同的城市。
 */
public class TeleCommPath {
	public boolean canAvoidCommunication(int A,int B,boolean[][] rails, boolean[][] tele,int totalStepAllowed){
		if(rails==null||tele==null||A<0||A>=rails.length||B<0||B>=rails.length){
			return false;
		}
		int[][][] commPattern=new int[rails.length][rails[0].length][totalStepAllowed+1];
		return !canComm(B,A,rails,tele,totalStepAllowed,commPattern);
	}
	// 0 not visited 1 can comm -1 can't comm
	private boolean canComm(int posB,int posA,boolean[][] rails, boolean[][] tele,int stepLeft,int[][][] commPattern){
		if(stepLeft==0){
			return false;
		}
		if(commPattern[posA][posB][stepLeft]!=0){
			return commPattern[posA][posB][stepLeft]==1;
		}
		if(posB==posA||tele[posA][posB]){
			commPattern[posA][posB][stepLeft]=1;
			return true;
		}
		for(int nextB=0;nextB<rails.length;nextB++){
			if(!rails[posB][nextB]){
				continue;
			}
			boolean canCommOnDir=false;
			for(int nextA=0;nextA<rails.length;nextA++){
				if(!rails[posA][nextA]){
					continue;
				}
				if(canComm(nextB,nextA,rails,tele,stepLeft-1,commPattern)){
					canCommOnDir=true;
					break;
				}
			}
			if(!canCommOnDir){
				commPattern[posA][posB][stepLeft]=-1;
				return false;
			}
		}
		commPattern[posA][posB][stepLeft]=1;
		return true;
	}
}
