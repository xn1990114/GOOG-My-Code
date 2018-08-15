package onsite;

import java.util.*;

/*
 * (高频)数组shuffle问题
数组1是排好序的1-n个数字，数组2是根据数组1 shuffle得出，给定数组3，要求根据一样的 shuffle规则变换成数组4，输出数组4。
第一个follow up，如果数组一是无重复数字组成的无序数组，如何做
第二个follow up，数组1有重复。
假如arr1 = {1, 2, 3, 4}, arr2 = {4, 2, 1, 3}
首先需要预处理arr2，得到val2NewIndex map 然后遍历arr1，新建index2NewIndex，
那么index2NewIndex.put(i, val2NewIndex.get(a[i])) 对于arr3，
根据index2NewIndex逐个填写元素到arr4中即可。
Follow-up 1
跟上面做法相同
Follow-up 2
将val2NewIndex map的每个值变成List<Integer>就行了
 */
public class ArrayMirrorConversion {
	public int[] conversionOf1ToN(int[] array1,int[] array2,int[] array3){
		if(array1==null||array2==null||array3==null||array1.length!=array2.length||array2.length!=array3.length){
			return new int[0];
		}
		int[] res=new int[array3.length];
		for(int i=0;i<res.length;i++){
			int targetIndex=array2[i]-1;
			res[i]=array3[targetIndex];
		}
		return res;
	}
	//follow up 1
	public int[] conversionOfAnyNumberWithoutDuplicate(int[] array1,int[] array2,int[] array3){
		if(array1==null||array2==null||array3==null||array1.length!=array2.length||array2.length!=array3.length){
			return new int[0];
		}
		Map<Integer,Integer> indexMap1=new HashMap<Integer,Integer>();
		Map<Integer,Integer> indexMap2=new HashMap<Integer,Integer>();
		for(int i=0;i<array1.length;i++){
			indexMap1.put(array1[i], i);
			indexMap2.put(array2[i], i);
		}
		int[] res=new int[array3.length];
		for(int val:indexMap2.keySet()){
			int index1=indexMap1.get(val);
			int index2=indexMap2.get(val);
			res[index2]=array3[index1];
		}
		return res;
	}
	// follow up 2
	public int[] conversionOfAnyNumberWithDuplicate(int[] array1,int[] array2,int[] array3){
		if(array1==null||array2==null||array3==null||array1.length!=array2.length||array2.length!=array3.length){
			return new int[0];
		}
		Map<Integer,List<Integer>> indexMap1=new HashMap<Integer,List<Integer>>();
		Map<Integer,List<Integer>> indexMap2=new HashMap<Integer,List<Integer>>();
		for(int i=0;i<array1.length;i++){
			if(!indexMap1.containsKey(array1[i])){
				indexMap1.put(array1[i], new ArrayList<Integer>());
			}
			if(!indexMap2.containsKey(array2[i])){
				indexMap2.put(array2[i], new ArrayList<Integer>());
			}
			indexMap1.get(array1[i]).add(i);
			indexMap2.get(array2[i]).add(i);
		}
		int[] res=new int[array3.length];
		for(int val:indexMap2.keySet()){
			List<Integer> l1=indexMap1.get(val);
			List<Integer> l2=indexMap2.get(val);
			for(int i=0;i<l1.size();i++){
				res[l2.get(i)]=array3[l1.get(i)];
			}
		}
		return res;
	}
}
