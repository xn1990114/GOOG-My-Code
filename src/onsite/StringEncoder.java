package onsite;
/*
 * string encode decode。假定已经有decode，只要求实现encode。举个例子，decode 会 把 ”1dd2Xa" 转成 '1ddaa'，’3f3X3‘ 转成 ’3f333‘。 
 * 这道题比较tricky，有很多edge case。 第一问比较简单， 要求直接把输入转换成 count of char  +  'x' + char. 
 * 第二问，要考虑，aa  转成 2Xa 反而变长了， 所以长度短于3的不转。以及如果原string有 ‘2xa' 怎么办。。。。 
 */
// my approach can only encode len between 1-9. 
//use ' ' before 'X' to void ambiguity(can also use 1XX-better approach assuming decode method can't be changed)
public class StringEncoder {
	public String encode(String s){
		if(s==null||s.length()==0){
			return "";
		}
		StringBuilder sb=new StringBuilder();
		char last=s.charAt(0);
		int count=0;
		for(int i=0;i<=s.length();i++){
			if(i==s.length()||last!=s.charAt(i)){
				if(count>3||last=='X'){
					sb.append(count);
					sb.append('X');
					sb.append(last);
				}
				else{
					for(int k=0;k<count;k++){
						sb.append(last);
					}
				}
				if(i<s.length()){
					last=s.charAt(i);
					count=1;
				}
			}
			else{
				count++;
				if(count==10){
					sb.append(9);
					sb.append('X');
					sb.append(last);
					count=1;
				}
			}
		}
		return sb.toString();
	}
	public String decode(String code){
		StringBuilder sb=new StringBuilder();
		int index=0;
		while(index<code.length()){
			char ch=code.charAt(index);
			if(Character.isDigit(ch)&&index<code.length()-1&&code.charAt(index+1)=='X'){
				int count=code.charAt(index)-'0';
				char chToAdd=code.charAt(index+2);
				for(int i=0;i<count;i++){
					sb.append(chToAdd);
				}
				index=index+3;
			}
			else{
				sb.append(ch);
				index++;
			}
		}
		return sb.toString();
	}
}
