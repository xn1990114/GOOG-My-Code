package onsite;

/*
 * 有一个string表示地址，比如1667 Plymouth St, Mountain View, CA 94043. 然后因为某些application的限制，字符串不能任意长，所以现在要将它变成长度为n的字符串。有下面两个规则：
Rule1: digits > letters（数字比其他字母的优先级高）
Rule2: 前面出现的比后面出现的优先级高
因为有两个rule，所以还有一个是 Rule1 > Rule2，就是rule1比rule2优先级高
题目也做了简化，输入是一个string，只有字母和数字，按照给的rule变成长度为n的字符串。
 */
public class ShrinkAddress {
	public String Solution(String s,int n){
		if(s.length()<=n){
			return s;
		}
		int countDigit=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
				countDigit++;
				if(countDigit==n){
					break;
				}
			}
		}
		int countChar=n-countDigit;
		StringBuilder sb=new StringBuilder();
		int i=0;
		while(sb.length()<n){
			if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
				sb.append(s.charAt(i));
			}
			else{
				if(countChar>0){
					sb.append(s.charAt(i));
					countChar--;
				}
			}
			i++;
		}
		return sb.toString();
	}
}
