package phone;

import java.util.*;

/*写一个Iterator的class，创建的时候给定List<List<Integer>>，
 * 实现next()和hasNext()。比如[[1,2,3],[4,5],[6,7,8,9]]，按顺序应该输出1,4,6,2,5,7,3,8,9
*/
public class ListListIterator {
	int listNum;
	int indexNum;
	List<List<Integer>> list;

	public ListListIterator(List<List<Integer>> list) {
		listNum = 0;
		indexNum = -1;
		this.list = list;
		findNextIndex();
	}

	public void findNextIndex() {
		while (listNum < list.size()) {
			if (indexNum + 1 < list.get(listNum).size()) {
				indexNum++;
				break;
			} else {
				listNum++;
				indexNum = -1;
			}
		}
	}

	public boolean hasNext() {
		return listNum < this.list.size();
	}

	public int next() {
		int result = this.list.get(listNum).get(indexNum);
		findNextIndex();
		return result;
	}
}
