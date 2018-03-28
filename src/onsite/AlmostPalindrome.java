package onsite;
/*
 * Palindrome:
aba
abba -> abb
Almost palindrome: can insert exactly onecharacter to make it a palindrome:
abb -> abba yes
abca -> abcba yes
cddc
 */
public class AlmostPalindrome {
	public boolean isAlmostPalinEdgeToMiddle(String s){
		if(s.length()<=2){
			return true;
		}
		int l=0;
		int r=s.length()-1;
		while(l<r){
			if(s.charAt(l)!=s.charAt(r)){
				return isPalin2(s,l+1,r)||isPalin2(s,l,r-1);
			}
			l++;
			r--;
		}
		return true;
	}
	public boolean isAlmostPalinMiddleToEdge(String s){
		if(s.length()<=2||isPalin(s,(s.length()-1)/2,s.length()/2)){
			return true;
		}
		// new added is cente r, middle left is center, middle right is center
		if(s.length()%2==0){
			int c1=s.length()/2-1;
			int c2=s.length()/2;
			return checkWithGivenCenter(s,c1,c1)||checkWithGivenCenter(s,c2,c2);
		}
		else{
			int c=s.length()/2;
			return checkWithGivenCenter(s,c-1,c)||checkWithGivenCenter(s,c,c+1);
		}
	}
	public boolean checkWithGivenCenter(String s,int l,int r){
		while(l>=0&&r<s.length()){
			if(s.charAt(l)!=s.charAt(r)){
				if(isPalin(s,l-1,r)||isPalin(s,l,r+1)){
					return true;
				}
				return false;
			}
			l--;
			r++;
		}
		if(l==0||r==s.length()-1){
			return true;
		}
		return false;
	}
	public boolean isPalin(String s,int l,int r){
		while(l>=0&&r<s.length()){
			if(s.charAt(l)!=s.charAt(r)){
				return false;
			}
			l--;
			r++;
		}
		return l==-1&&r==s.length();
	}
	public boolean isPalin2(String s,int l,int r){
		while(l<r){
			if(s.charAt(l)!=s.charAt(r)){
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
