package onsite;
/*
 * 已知screen的高和宽，给你最小和最大的fontSize，要求给定一个string，
 * 将string用竟可能大的fontSize显示在screen里。
 * 已知两个API getHeight(intfontSize), getWidth(char c, int fontSize)，
 * 可以得到每个character在不同fontSize下的高和宽。
 */
public class StringScreenFit {
	public int findMaxFontSizeToFit(int screen_height,int screen_width,String s){
		int res=0;
		int low=1;
		int high=10000;
		while(low<=high){
			int mid=low+(high-low)/2;
			if(canFit(screen_height,screen_width,s,mid)){
				res=mid;
				low=mid+1;
			}
			else{
				high=mid-1;
			}
		}
		return res;
	}
	public boolean canFit(int screen_height,int screen_width,String s,int fontSize){
		int heightNeeded=0;
		int currWidth=screen_width;
		for(int i=0;i<s.length()&&heightNeeded<=screen_height;i++){
			int charWidth=getWidth(s.charAt(i),fontSize);
			if(charWidth>screen_width){
				return false;
			}
			if(charWidth+currWidth>screen_width){
				currWidth=charWidth;
				heightNeeded=heightNeeded+getHeight(fontSize);
			}
			else{
				currWidth=charWidth+currWidth;
			}
		}
		return heightNeeded<=screen_height;
	}
	// assuming all fontSize are even numbers
	public int getHeight(int fontSize){
		return fontSize;
	}
	public int getWidth(char c,int fontSize){
		if(c<='k'||c==' '){
			return fontSize;
		}
		else{
			return fontSize+1;
		}
	}
}
