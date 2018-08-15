package onsite;
/*
 *  A, B两个人从左到右拿卡， 每个卡上有分数， 每个人能拿1 - 3张， 问A最多能拿到的分数。分数可以是负数。
 *  说了下计算所有情况会很慢，所以尝试dp。
 */
public class CardMaxScore {
	public int findMaxScore(int[] cards){
		if(cards.length==0){
			return 0;
		}
		int[] maxScores=new int[cards.length];
		int[] total=new int[cards.length];
		for(int i=cards.length-1;i>=0;i--){
			total[i]=(i==cards.length-1?0:total[i+1])+cards[i];
			int localMax=Integer.MIN_VALUE;
			int cardTaken=0;
			for(int j=i;j<Math.min(cards.length,i+3);j++){
				cardTaken=cardTaken+cards[j];
				localMax=Math.max(cardTaken+(j==cards.length-1?0:(total[j+1]-maxScores[j+1])), localMax);
			}
			maxScores[i]=localMax;
		}
		return maxScores[0];
	}
}
