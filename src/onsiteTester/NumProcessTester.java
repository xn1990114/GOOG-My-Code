package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.NumProcess;

public class NumProcessTester {
//3 - 10- 5-16-8-4-2-1
	@Test
	public void test() {
		NumProcess np=new NumProcess();
		int[] res=np.findLenMax(4);
		System.out.println(res[0]+" "+res[1]);
		Set<Integer> r=np.reverse(7);
		for(int i:r){
			System.out.print(i+"\t");
		}
	}

}
