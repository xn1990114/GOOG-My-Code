package phone;
/*
 * repeat string match. 给两个String A, B, 问A至少重复多少遍, 使得B是重复后字符串的子字符串
 * 例如"abcd", "cdabcdab" -> 3, 因为A串重复3遍变成"abcdabcdabcd", 然后B是其substring
 */
public class RepeatStringMatch {
	public int countRepeat(String s,String target){
		if(s.length()>target.length()){
			if(s.indexOf(target)>=0){
				return 1;
			}
			return 2;
		}
		int count=0;
		int len=0;
		for(int i=s.length();i>0;i--){
			if(s.indexOf(target.substring(0,i))>=0){
				len=i;
				count++;
				break;
			}
		}
		if(len==0){
            return -1;
        }
        int start=len;
        while(start<target.length()){
            String tempB=target.substring(start,Math.min(start+s.length(),target.length()));
            String tempA=s.substring(0,Math.min(s.length(),target.length()-start));
            if(!tempA.equals(tempB)){
                return -1;
            }
            start=start+s.length();
            count++;
        }
		return count;
	}
}
