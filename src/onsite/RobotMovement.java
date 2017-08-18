package onsite;
import java.util.*;
/*
 * 2D平面，给你一个robot的坐标, 和一个string表示robot movement. 
 * 返回robot 最终的位置。这个movement string里，
 * F表示前进1步，R表示转90度。起始位置（0，0），起始方向是向上的。
 * 例子：FF2R3F表示前进两步，转180（此时面朝下了），再前进3步。结果应该是（0， -1）
 */
public class RobotMovement {
	// direction 0-up,1-right,2-down,3-left
	public int[] move(String steps){
		int[] curr=new int[2];
		int dir=0;
		int count=1;
		for(int i=0;i<steps.length();i++){
			char ch=steps.charAt(i);
			if(ch=='R'){
				dir=(dir+count)%4;
				count=1;
			}
			else if(ch=='F'){
				calNextStep(curr,dir,count);
				count=1;
			}
			else{
				int start=i;
				while(i+1<steps.length()&&steps.charAt(i+1)>='0'&&steps.charAt(i+1)<='9'){
					i++;
				}
				count=Integer.parseInt(steps.substring(start,i+1));
			}
		}
		return curr;
	}
	public void calNextStep(int[] curr,int dir,int count){
		if(dir==0){
			curr[1]=curr[1]+count;
		}
		if(dir==1){
			curr[0]=curr[0]+count;
		}
		if(dir==2){
			curr[1]=curr[1]-count;
		}
		if(dir==3){
			curr[0]=curr[0]-count;
		}
	}
}
