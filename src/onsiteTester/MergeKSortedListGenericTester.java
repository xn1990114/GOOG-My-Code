package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.MergeKSortedListGeneric;

public class MergeKSortedListGenericTester {

	@Test
	public void test() {
		List<String> l1=new ArrayList<String>();
		List<String> l2=new ArrayList<String>();
		List<String> l3=new ArrayList<String>();
		List<List<String>> lists=new ArrayList<List<String>>();
		l1.add("nan");l1.add("xiao");l1.add("zero");
		l2.add("allen");l2.add("boss");l2.add("fung");
		l3.add("wang");l3.add("yang");
		lists.add(l1);lists.add(l2);lists.add(l3);
		@SuppressWarnings("rawtypes")
		MergeKSortedListGeneric tester=new MergeKSortedListGeneric();
		List<String> res=tester.mergeList(lists);
		for(String s:res){
			System.out.println(s+"\t");
		}
	}

}
