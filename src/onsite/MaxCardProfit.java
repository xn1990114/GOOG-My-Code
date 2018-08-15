package onsite;

import java.util.Arrays;

//给一副扑克牌，如果抽到 红牌，+1钱，黑牌-1钱。问给一副52张牌，如果play optimally, 求得到钱的 Expectation是多少 这是个DP问题
public class MaxCardProfit {
	public double getExpectedProfit(){
		double[][] dp=new double[27][27];
		for(int i=0;i<=26;i++){
			Arrays.fill(dp[i], -5.0);
		}
		dp[0][0]=0;
		dfs(26,26,0,dp);
		return dp[26][26];
	}
	public void dfs(int red,int black,int money,double[][] dp){
		if(dp[red][black]>-2.0){
			return ;
		}
		double pRed=(double)red/(double)(red+black);
		double currRes=0;
		if(red>0){
			int takeRedMoney=money+1;
			if(takeRedMoney==1){
				currRes=currRes+pRed;
			}
			else{
				dfs(red-1,black,takeRedMoney,dp);
				currRes=currRes+pRed*(1+dp[red-1][black]);
			}
		}
		if(black>0){
			dfs(red,black-1,money-1,dp);
			currRes=currRes+(1-pRed)*(dp[red][black-1]-1);
		}
		dp[red][black]=currRes;
	}
}
