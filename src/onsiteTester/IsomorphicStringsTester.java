package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.IsomorphicStrings;

public class IsomorphicStringsTester {

	@Test
	public void test() {
		IsomorphicStrings tester=new IsomorphicStrings();
		String s1="egg";
		String[] t1={"add","addd","edgg","dde","wrg","pll"};
		List<String> r1=tester.findAllIsomorphic(s1, t1);
		for(String s:r1){
			System.out.print(s+"\t");
		}
		System.out.println();
		String s2="automata";
		String[] t2={"butombtb","butomatb","butombta","autombtb","bgadtbab","bgadabtb"};
		List<String> r2=tester.findAllIsomorphic(s2, t2);
		for(String s:r2){
			System.out.print(s+"\t");
		}
	}

}
