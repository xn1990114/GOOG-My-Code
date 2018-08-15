package onsite;

import java.util.*;

/*
 * Rebuild array: given a list of subsequences of an original array, 
 * rebuild a shortest unique original array by using the list of subsequence.
e.g., given [[1, 9, 7], [1, 4], [4, 9]], the shortest unique original array is [1, 4, 9, 7]

Follow up: the original array may contain duplicates, return shortest smallest lexicographical order array 
if multiple arrays can be reconstructed.
e.g.,given [[2, 3], [3, 3, 3]], return [2, 3, 3, 3], 虽然[3, 2, 3, 3], [3, 3, 2, 3]也可以build, 但不是最小。
 */
// below code is for follow up
public class ReconstructArray {
	class Element implements Comparable<Element> {
		int num;

		public Element(int num) {
			this.num = num;
		}

		@Override
		public int compareTo(Element o) {
			return this.num - o.num;
		}
		public String toString(){
			return this.num+"Ele";
		}
	}

	public List<Integer> reconstructArrayWithDuplicate(int[][] sequence) {
		if (sequence == null || sequence.length == 0) {
			return new ArrayList<Integer>();
		}
		Map<Integer, List<Element>> numMap = new HashMap<Integer, List<Element>>();
		Map<Element, List<Element>> depMap = new HashMap<Element, List<Element>>();
		populateNumMap(sequence, numMap, depMap);
		List<Integer> res = new ArrayList<Integer>();
		dfsDependencyMap(0, 0, sequence, new HashSet<Element>(), null, res, numMap, depMap);
		return res;
	}

	public void dfsDependencyMap(int r, int c, int[][] sequence, Set<Element> used, Element last, List<Integer> res,
			Map<Integer, List<Element>> numMap, Map<Element, List<Element>> depMap) {
		if (c == sequence[r].length) {
			r++;
			c = 0;
			last = null;
			used = new HashSet<Element>();
		}
		if (r == sequence.length) {
			for(Element e:depMap.keySet()){
				List<Element> pre=depMap.get(e);
				for(Element p:pre){
					if(hasLoop(e,p,depMap)){
						return;
					}
				}
				
			}
			List<Integer> tempRes = new ArrayList<Integer>();
			recoverSeq(tempRes, depMap);
			if (lower(tempRes, res)) {
				res.clear();
				res.addAll(tempRes);
			}
			return;
		}
		int currVal = sequence[r][c];
		List<Element> candidates = numMap.get(currVal);
		for (int i = 0; i < candidates.size(); i++) {
			Element currElement = candidates.get(i);
			if (!used.contains(currElement)) {
				used.add(currElement);
				if (last != null) {
					depMap.get(currElement).add(last);
				}
				dfsDependencyMap(r, c + 1, sequence, used, currElement, res, numMap, depMap);
				used.remove(currElement);
				if (last != null) {
					depMap.get(currElement).remove(depMap.get(currElement).size() - 1);
				}
			}
		}
	}

	public void recoverSeq(List<Integer> tempRes, Map<Element, List<Element>> depMap) {
		Map<Element, Set<Element>> currDepMap = new HashMap<Element, Set<Element>>();
		PriorityQueue<Element> pq = new PriorityQueue<Element>();
		for (Element key : depMap.keySet()) {
			currDepMap.put(key, new HashSet<Element>(depMap.get(key)));
			if (currDepMap.get(key).isEmpty()) {
				pq.offer(key);
				currDepMap.remove(key);
			}
		}
		while (!pq.isEmpty()) {
			Element top = pq.poll();
			tempRes.add(top.num);
			Set<Element> toremove = new HashSet<Element>();
			for (Element key : currDepMap.keySet()) {
				Set<Element> dependency = currDepMap.get(key);
				dependency.remove(top);
				if (dependency.isEmpty()) {
					toremove.add(key);
				}
			}
			for (Element r : toremove) {
				pq.offer(r);
				currDepMap.remove(r);
			}
		}
	}

	public void populateNumMap(int[][] sequence, Map<Integer, List<Element>> numMap,
			Map<Element, List<Element>> depMap) {
		for (int i = 0; i < sequence.length; i++) {
			Element l = null;
			for (int j = 0; j < sequence[i].length; j++) {
				int curr = sequence[i][j];
				if (!numMap.containsKey(curr)) {
					numMap.put(curr, new ArrayList<Element>());
					Element toadd = new Element(curr);
					numMap.get(curr).add(toadd);
					depMap.put(toadd, new ArrayList<Element>());
				}

				if (j > 0) {
					int last = sequence[i][j - 1];
					boolean allLoop = true;
					for (Element c : numMap.get(curr)) {
						if (c != l && !hasLoop(c, l, depMap)) {
							depMap.get(c).add(l);
							l = c;
							allLoop = false;
							break;
						}
					}
					if (allLoop) {
						Element toadd = new Element(curr);
						numMap.get(curr).add(toadd);
						depMap.put(toadd, new ArrayList<Element>());
						depMap.get(toadd).add(numMap.get(last).get(0));
						l = toadd;
					}
				} else {
					l = numMap.get(curr).get(0);
				}
			}
		}
		depMap.clear();
		for (int key : numMap.keySet()) {
			List<Element> list = numMap.get(key);
			for (Element e : list) {
				depMap.put(e, new ArrayList<Element>());
			}
		}
	}

	public boolean hasLoop(Element curr, Element last, Map<Element, List<Element>> depMap) {
		Queue<Element> qu = new LinkedList<Element>();
		qu.offer(last);
		Set<Element> visited = new HashSet<Element>();
		visited.add(last);
		while (!qu.isEmpty()) {
			Element top = qu.poll();
			if (top == curr) {
				return true;
			}
			List<Element> dep = depMap.get(top);
			for (int i = 0; i < dep.size(); i++) {
				Element e = dep.get(i);
				if (!visited.contains(e)) {
					visited.add(e);
					qu.offer(e);
				}
			}
		}
		return false;
	}

	public boolean lower(List<Integer> list, List<Integer> res) {
		if (list.isEmpty()) {
			return false;
		}
		if (res.isEmpty()) {
			return true;
		}
		for (int i = 0; i < res.size(); i++) {
			int n1 = list.get(i);
			int n2 = res.get(i);
			if (n1 < n2) {
				return true;
			} else if (n1 > n2) {
				return false;
			}
		}
		return false;
	}
}
