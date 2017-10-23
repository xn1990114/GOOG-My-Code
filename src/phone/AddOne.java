package phone;
/*Given a number (positive or negative), e.g., 95, as an array ['9','5'], increment it: change it to ['9','6']. . 1point 3acres 璁哄潧
The input array can be arbitrarily large.
examples:
input: 
char[] [‘9’, ‘5’]
output:
char[] [‘9’, ‘6’]

input: 
char[] [‘-’, ‘9’, ‘5’]
output:
char[] [‘-’, ‘9’, ‘4’]
 */
public class AddOne {
	public String calResult(char[] num){
		if(num.length==0){
			return "";
		}
		boolean negative=false;
		int add=1;
		int start=0;
		int end=num.length-1;
		if(num[0]=='-'){
			start++;
			negative=true;
			add=-1;
		}
		if(num[0]=='+'){
			start++;
		}
		char[] tempRes=new char[num.length+1];
		int index=tempRes.length-1;
		while(end>=start){
			if(add==1&&num[end]=='9'){
				tempRes[index]='0';
				add=1;
			}
			else if(add==-1&&num[end]=='0'){
				tempRes[index]='9';
				add=-1;
			}
			else{
				tempRes[index]=(char)(num[end]+add);
				add=0;
			}
			index--;
			end--;
		}
		if(add!=0){
			tempRes[index]='1';
			index--;
		}
		StringBuilder sb=new StringBuilder();
		if(negative){
			sb.append('-');
		}
		boolean started=false;
		for(int i=index+1;i<tempRes.length;i++){
			if(tempRes[i]=='0'&&!started){
				
			}
			else{
				started=true;
				sb.append(tempRes[i]);
			}
		}
		if(!started){
			return "0";
		}
		return sb.toString();
	}
}
