package onsite;
/*
 * 一堆卡片从一头拿，可以拿一二三张，两人轮流拿，求最高得分。小哥直接表示有负数的情况。我刚吃了饭有点懵，
 * 推出了正数的情况但是卡在了含负数的情况。然后小哥说那就先不考虑负数吧。随后还给了点 hint，
 * 然后就写出来了。并且让我在一个例子上过了一遍，问了问用什么 case 来测。
 */
public class MaxScoreFromCardDraw {
	// assume take from right
	public int findMaxScore(int[] cards){
		int[] totalPoints=new int[cards.length+1];
		int[] res=new int[cards.length+1];
		for(int i=1;i<totalPoints.length;i++){
			totalPoints[i]=cards[i-1]+totalPoints[i-1];
		}
		for(int i=1;i<totalPoints.length;i++){
			int currentDraw=0;
			int max=Integer.MIN_VALUE;
			for(int j=1;j<=3&&j<=i;j++){
				currentDraw=currentDraw+cards[i-j];
				max=Math.max(max,currentDraw+totalPoints[i-j]-res[i-j]);
			}
			res[i]=max;
		}
		return res[res.length-1];
	}
}
