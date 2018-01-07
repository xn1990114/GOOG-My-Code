package phone;
import java.util.*;
/*
 * 有一个source string，一个target string。二者都只包含"L","R","_" 三种字符，L可以往左移，R可以往右移，
 * 不能jump over。让设计一个函数，判断能否从source走到target，返回boolean;
"_L_R" ,"L__R"---> true
"_L_R_" ,"L___R"---> true
"_R_L_" ,"_R__L"---> false
 */
public class MovingLetters {
	public boolean canConstruct(String source,String target){
		int indexT=0;
		int indexS=0;
		while(indexT<target.length()){
			while(indexT<target.length()&&target.charAt(indexT)=='_'){
				indexT++;
			}
			while(indexS<source.length()&&source.charAt(indexS)=='_'){
				indexS++;
			}
			if(indexT<target.length()){
				if(indexS==source.length()){
					return false;
				}
				if(target.charAt(indexT)!=source.charAt(indexS)){
					return false;
				}
				if(target.charAt(indexT)=='L'&&indexT>indexS){
					return false;
				}
				if(target.charAt(indexT)=='R'&&indexS>indexT){
					return false;
				}
				indexT++;
				indexS++;
			}
		}
		while(indexS<source.length()){
			if(source.charAt(indexS)!='_'){
				return false;
			}
			indexS++;
		}
		return true;
	}
}
