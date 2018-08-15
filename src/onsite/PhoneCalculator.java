package onsite;
/*
 * 简化版的计算器，能够处理输入数字和加减的情况。用户每次能够输入`0-9,+,-,=`这几种可能的字符。
 * 要求用户每输入一个字符就做相应处理并输出结果。输出结果的方式类似于手机上的计算器的输出方式。
 */
/*
 * num+ sign +num + sign/= return result
 */
public class PhoneCalculator {
	public StringBuilder input;
	public int lastRes;
	public char operand;
	public int currNum;
	public PhoneCalculator(){
		this.input=new StringBuilder();
		this.lastRes=0;
		this.operand='+';
		this.currNum=0;
	}
	public void takeInput(char ch){
		if(ch=='c'){
			this.lastRes=0;
			this.operand='+';
			this.currNum=0;
			this.input=new StringBuilder();
		}
		else if(Character.isDigit(ch)){
			this.input.append(ch);
		}
		else if(ch=='='){
			if(this.input.length()==0){
				this.lastRes=calResult(lastRes,operand,currNum);
			}
			else{
				currNum=Integer.parseInt(input.toString());
				this.lastRes=calResult(lastRes,operand,currNum);
				this.input=new StringBuilder();
			}
		}
		else{
			if(this.input.length()==0){
				this.operand=ch;
				this.currNum=this.lastRes;
			}
			else{
				currNum=Integer.parseInt(input.toString());
				this.lastRes=calResult(lastRes,operand,currNum);
				this.operand=ch;
				this.input=new StringBuilder();
			}
		}
	}
	public int calResult(int num1,char operand,int num2){
		if(operand=='+'){
			return num1+num2;
		}
		else{
			return num1-num2;
		}
	}
}
