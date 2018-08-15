package onsiteTester;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import onsite.EvenIterator;
import onsite.EvenIterator.Data;

public class EvenIteratorTester {

	@Test
	public void test() {
		Data d0=new Data(0,"0");
		Data d1=new Data(1,"1");
		Data d2=new Data(2,"2");
		Data d3=new Data(3,"3");
		Data d4=new Data(4,"4");
		List<Data> list=new ArrayList<Data>();
		list.add(d0);list.add(d1);list.add(d2);list.add(d3);list.add(d4);
		EvenIterator<Data> it=new EvenIterator<Data>(list.iterator());
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
