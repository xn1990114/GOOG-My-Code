package onsite;
/*
 * 给了两个问题，都不是很难。第一个问题是这样的，如果一个string只有0，1构成，而且这个string在某个点断开后形成左边全是0，
 * 右边全是1话，我们就说这是一个good string，例如“000011”是good string，但“01001001”不是，注意“0000”，“1111”也是good string，
 * 因为断点可以选在端点处。现在给一个任意的0，1构成的string，
 * 问断点取在哪里的时候，把这个string变成good string所需要的flip次数最少，注意是flip，不是swap。例如00100101：
 * 断点在最左端点处，也就是“| 00100101”需要将右侧的0全部flip成1，总共需要5次flip，cost是5。
 * 如果取在第二个0后面“00|100101”，那只需要把右边的3个0 flip成1就可以了，cost是3。这个位置就比刚才的位置好。
 * 给定input string，返回断点的index，如果有多个最小值，返回任意一个。
 */
public class GoodBinaryString {
	public int findBreakIndex(String s){
		if(s==null||s.length()==0){
			return -1;
		}
		int countLeft1=0;
		int countRight0=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='1'){
				countLeft1++;
			}
		}
		int res=s.length();
		int min=countLeft1;
		for(int i=s.length()-1;i>=0;i--){
			char ch=s.charAt(i);
			if(ch=='0'){
				countRight0++;
			}
			else{
				countLeft1--;
			}
			if(min>countLeft1+countRight0){
				min=countLeft1+countRight0;
				res=i;
			}
		}
		return res;
	}
}
