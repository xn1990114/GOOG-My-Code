package onsite;

import java.util.*;
//实现一个从给你的iterator中筛选偶数的iterator，写test case，generic，多线程。


public class EvenIterator<T extends Evenable> implements Iterator<T>{
	Iterator<T> it;
	T nextVal;
	public EvenIterator(Iterator<T> it){
		this.it=it;
		this.nextVal=null;
		moveToNextVal();
	}
	public void moveToNextVal(){
		while(this.it.hasNext()){
			this.nextVal=it.next();
			if(this.nextVal.isEven()){
				return;
			}
		}
		this.nextVal=null;
	}
	@Override
	public boolean hasNext(){
		return this.nextVal!=null;
	}
	@Override
	public T next(){
		T res=this.nextVal;
		moveToNextVal();
		return res;
	}
	public static class Data implements Evenable{
		int num;
		String s;
		public Data(int num,String s){
			this.num=num;
			this.s=s;
		}
		public String toString(){
			return this.s;
		}
		@Override
		public boolean isEven(){
			return this.num%2==0;
		}
	}
}

