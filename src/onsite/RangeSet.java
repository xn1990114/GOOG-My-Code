package onsite;

/*
 * 1.  range set, 有一个list， 里面的元素是一个一个range （比如 （start, end））如何表示range 自己定义。 
 * 实现俩方法 1. add new range to the list 2. find if a integer in the list 
 */
public class RangeSet {
	public class Range {
		int start;
		int end;
		Range previous;
		Range next;

		public Range(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}

	public Range head;

	public RangeSet() {
		this.head = new Range(0, 0);
	}

	public void addRange(int start, int end) {
		Range parent = head;
		Range curr = head.next;
		while (curr != null) {
			if ((curr.start <= start && curr.end >= start) || (curr.start >= start && curr.start <= end)) {
				start = Math.min(curr.start, start);
				parent = curr.previous;
				end = Math.max(end, curr.end);
				break;
			}
			curr = curr.next;
			parent=parent.next;
		}
		while (curr != null && end >= curr.start) {
			end = Math.max(end, curr.end);
			curr = curr.next;
		}
		Range newR = new Range(start, end);
		parent.next = newR;
		newR.previous = parent;
		newR.next = curr;
		if (curr != null) {
			curr.previous = newR;
		}
	}

	public boolean find(int num) {
		Range curr = head.next;
		while (curr != null) {
			if (curr.end >= num) {
				if (curr.start <= num) {
					return true;
				}
				return false;
			}
			curr=curr.next;
		}
		return false;
	}

	public String toString() {
		Range curr = head.next;
		StringBuilder sb = new StringBuilder();
		while (curr != null) {
			sb.append("{ " + curr.start + " - " + curr.end + " }" + " ");
			curr = curr.next;
		}
		return sb.toString();
	}
}
