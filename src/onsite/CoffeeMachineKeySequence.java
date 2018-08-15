package onsite;

/*
 * 一个咖啡机有三个button(S,M, L), 按每个按钮后， 咖啡机会相应流出一个区间的咖啡[s1,s2], [m1, m2], [l1, l2]， 
 * 但是流出的咖啡量是随机的。 有一个杯子总容量是c2,杯子上有个刻度线c1,如果咖啡量在[c1，c2], 则视为盛满
 * 问在进行一系列按button操作后，能不能使咖啡在[c1,c2], 盛满但不溢出,
 */
public class CoffeeMachineKeySequence {
	public String getKeySequence(int[] small, int[] medium, int[] large, int targetLow, int targetHigh) {
		if (small == null || medium == null || large == null || targetLow > targetHigh || targetLow < 0 || small[0] < 0
				|| medium[0] < 0 || large[0] == 0) {
			return "";
		}
		int maxSmall = targetHigh / small[0] + 1;
		int maxMedium = targetHigh / medium[0] + 1;
		int maxLarge = targetHigh / large[0] + 1;
		for (int s = 0; s <= maxSmall; s++) {
			int smallMin = small[0] * s;
			int smallMax = small[1] * s;
			for (int m = 0; m < maxMedium; m++) {
				int mediumMin = smallMin + medium[0] * m;
				int mediumMax = smallMax + medium[1] * m;
				for (int l = 0; l < maxLarge; l++) {
					int largeMin = mediumMin + large[0] * l;
					int largeMax = mediumMax + large[1] * l;
					if (largeMin >= targetLow && largeMax <= targetHigh) {
						return buildResult(s, m, l);
					}
				}
			}
		}
		return "";
	}

	public String buildResult(int s, int m, int l) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s; i++) {
			sb.append('S');
		}
		for (int i = 0; i < m; i++) {
			sb.append('M');
		}
		for (int i = 0; i < l; i++) {
			sb.append('L');
		}
		return sb.toString();
	}
}
