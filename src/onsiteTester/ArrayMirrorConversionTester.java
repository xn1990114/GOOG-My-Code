package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.ArrayMirrorConversion;

public class ArrayMirrorConversionTester {

	@Test
	public void test1() {
		ArrayMirrorConversion tester=new ArrayMirrorConversion();
		int[] array1={1,2,3,4};
		int[] array2={4,2,1,3};
		int[] array3={2,3,4,5};
		int[] array4={5,3,2,4};
		int[] res=tester.conversionOf1ToN(array1, array2, array3);
		for(int i=0;i<res.length;i++){
			assertTrue(array4[i]==res[i]);
		}
	}
	@Test
	public void test2() {
		ArrayMirrorConversion tester=new ArrayMirrorConversion();
		int[] array1={7,8,15,2};
		int[] array2={8,2,15,7};
		int[] array3={2,3,4,5};
		int[] array4={3,5,4,2};
		int[] res=tester.conversionOfAnyNumberWithoutDuplicate(array1, array2, array3);
		for(int i=0;i<res.length;i++){
			assertTrue(array4[i]==res[i]);
		}
	}
	@Test
	public void test3() {
		ArrayMirrorConversion tester=new ArrayMirrorConversion();
		int[] array1={7,8,15,2,8,8,7};
		int[] array2={8,2,8,15,7,8,7};
		int[] array3={1,2,3,4,5,6,7};
		int[] array4={2,4,5,3,1,6,7};
		int[] res=tester.conversionOfAnyNumberWithDuplicate(array1, array2, array3);
		for(int i=0;i<res.length;i++){
			assertTrue(array4[i]==res[i]);
		}
	}
}
