package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.StringAutoComplete;

public class StringAutoCompleteTester {

	@Test
	public void test() {
		String[] dic={"Tester","Test","test","VtTester","TesterVT","notTester"};
		StringAutoComplete sac=new StringAutoComplete();
		sac.addDic(dic);
		String s1="test";
		Set<String> r1=sac.searchString(s1);
		for(String s:r1){
			System.out.print(s+"\t");
		}
		System.out.println();
		String s2="*est";
		Set<String> r2=sac.searchString(s2);
		for(String s:r2){
			System.out.print(s+"\t");
		}
		System.out.println();
		String s3="t*t";
		Set<String> r3=sac.searchString(s3);
		for(String s:r3){
			System.out.print(s+"\t");
		}
		System.out.println();
		String s4="*e*";
		Set<String> r4=sac.searchString(s4);
		for(String s:r4){
			System.out.print(s+"\t");
		}
		System.out.println();
		String s5="*";
		Set<String> r5=sac.searchString(s5);
		for(String s:r5){
			System.out.print(s+"\t");
		}
		System.out.println();
		String s6="t*a";
		Set<String> r6=sac.searchString(s6);
		for(String s:r6){
			System.out.print(s+"\t");
		}
	}

}
