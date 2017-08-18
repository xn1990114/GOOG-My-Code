package onsiteTester;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;

import onsite.DeleteChildNode;

public class DeleteChildNodeTester {

	@Test
	public void test() {
		DeleteChildNode dcn=new DeleteChildNode();
		int[] a1={0,0,1,2,3,4,5,6,7,8};
		List<Integer> l1=dcn.deleteNode(a1, 0);
		for(int i=0;i<l1.size();i++){
			System.out.print(l1.get(i));
		}
		List<Integer> l2=dcn.deleteNode(a1, 5);
		for(int i=0;i<l2.size();i++){
			System.out.print(l2.get(i));
		}
		int[] a2={ 0, 0, 1, 2,1};
		System.out.println();
		List<Integer> l3=dcn.deleteNode(a2, 2);
		for(int i=0;i<l3.size();i++){
			System.out.print(l3.get(i));
		}
	}

}
