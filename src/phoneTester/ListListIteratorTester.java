package phoneTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import phone.ListListIterator;

public class ListListIteratorTester {

	@Test
	public void test() {
		List<Integer>  list=new ArrayList<Integer>();
		List<List<Integer>> big=new ArrayList<List<Integer>>();
		big.add(new ArrayList<Integer>());
		list.add(1);
		list.add(2);
		big.add(new ArrayList<Integer>(list));
		big.add(new ArrayList<Integer>());
		list.clear();
		list.add(3);
		list.add(4);
		big.add(new ArrayList<Integer>(list));
		ListListIterator lli=new ListListIterator(big);
		int expected=1;
		int round=1;
		while(lli.hasNext()){
			System.out.println(round);
			assertTrue(lli.next()==expected);
			expected++;
			round++;
		}
	}

}
