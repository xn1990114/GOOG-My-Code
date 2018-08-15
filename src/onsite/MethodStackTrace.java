package onsite;
/*
 * 输入 像methodstack trace： “main, start”, “foo, start”, foo, end”, “bar, start”, “barend”, “main, end”, “main2, start”, “main2, end”
输出String, 例如以下格式，来表明method 被call的顺序和hierarchy
main
    foo
    bar
main2
 */
public class MethodStackTrace {
	public void printTrace(String[] str){
		int countSpace=0;
		for(int i=0;i<str.length;i++){
			String[] curr=str[i].split(",");
			if(curr[1].equals("start")){
				for(int j=0;j<countSpace;j++){
					System.out.print("\t");
				}
				System.out.print(curr[0]);
				System.out.println();
				countSpace++;
			}
			else{
				countSpace--;
			}
		}
	}
}
