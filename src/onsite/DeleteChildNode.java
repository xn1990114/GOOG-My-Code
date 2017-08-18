package onsite;
/*
 * 这个题绕，之前好像地里见过。一个树， 子节点 有一个 attribute parentIndex  指向他的父节点。 
 * 然后这个树是一个array去表示的。
这个parentIndex呢，其实就是parent node 在这个array里的位置。
题目要求是 给你一组index， 你要删除掉这些index以及它们的子树节点。 最后返回删除之后的新的表示树的list
node的值是1 - n的，然后 就是小的数不可能是大的数的孩子。 4,5 可以是 1的 children 但是 1绝对不可能是4 的children。 好像是这样。
 要求扫一遍，空间就是n
 */
import java.util.*;

public class DeleteChildNode {
	public List<Integer> deleteNode(int[] array,int target){
		List<Integer>  result=new ArrayList<Integer>();
		TreeSet<Integer> ts=new TreeSet<Integer>();
		ts.add(target);
		for(int i=0;i<array.length;i++){
			if(target==i){
				continue;
			}
			else if(ts.contains(array[i])){
				ts.add(i);
			}
			else{
				result.add(array[i]-ts.subSet(0, array[i]).size());
			}
		}
		return result;
	}
}
