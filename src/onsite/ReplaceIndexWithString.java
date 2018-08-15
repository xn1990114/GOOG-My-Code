package onsite;
/*
 * Input: "I am {0} {2}." 和 {“ very”，“apple”, "happy"}, Ouput: "I am very happy"   
 * 要自己分析各种corner case。 
 */
public class ReplaceIndexWithString {
	public String buildNewString(String s,String[] replacement){
		if(s==null||s.length()==0){
			return "";
		}
		int index=0;
		StringBuilder sb=new StringBuilder();
		while(index<s.length()){
			char ch=s.charAt(index);
			if(ch=='{'){
				int nextIndex=isValid(s,index+1,replacement);
				if(nextIndex==-1){
					sb.append(ch);
					index++;
				}
				else{
					sb.append(replacement[Integer.parseInt(s.substring(index+1,nextIndex))]);
					index=nextIndex+1;
				}
			}
			else{
				sb.append(ch);
				index++;
			}
		}
		return sb.toString();
	}
	public int isValid(String s,int index,String[] replacement){
		StringBuilder sb=new StringBuilder();
		while(index<s.length()){
			char ch=s.charAt(index);
			if(ch=='}'){
				String temp=sb.toString();
				if(isValidNumber(temp)&&Integer.parseInt(sb.toString())<replacement.length){
					return index;
				}
				return -1;
			}
			else if(!Character.isDigit(ch)){
				return -1;
			}
			else{
				sb.append(ch);
			}
			index++;
		}
		return -1;
	}
	public boolean isValidNumber(String s){
		if(s.length()==0){
			return false;
		}
		StringBuilder sb=new StringBuilder();
		boolean started=false;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(ch=='0'&&!started){
				continue;
			}
			started=true;
			sb.append(ch);
		}
		if(sb.length()==0){
			return true;
		}
		return sb.length()<=10&&Long.parseLong(sb.toString())<=Integer.MAX_VALUE;
	}
}
