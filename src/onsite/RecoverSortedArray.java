package onsite;

import java.util.*;

/*
 * 问的题目是一个数组是乱序的， 例如 3 2 1 4。最短经过多少步的swap, 可以变成排序好的状态。 
 * 和做题网站854差不多，唯一的区别是要打印路径，
 */
//assuming no duplicate
public class RecoverSortedArray {
	public List<List<String>> findAllPathToSortArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<List<String>>();
		}
		// used to get expected string pattern
		int[] copyNums = nums.clone();
		Arrays.sort(copyNums);
		String target = serializeArray(copyNums);
		String curr = serializeArray(nums);
		// track patterns happened in previous rounds
		Set<String> visited = new HashSet<String>();
		// map each element and its proper position after sorting. used to swap
		// elements faster.
		Map<Integer, Integer> positionMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < copyNums.length; i++) {
			positionMap.put(copyNums[i], i);
		}
		// init map with 1 list with 1 element (the original array)
		Map<String, List<List<String>>> map = new HashMap<String, List<List<String>>>();
		List<String> oriPath = new ArrayList<String>();
		List<List<String>> oriPathList = new ArrayList<List<String>>();
		oriPath.add(curr);
		oriPathList.add(oriPath);
		map.put(curr, oriPathList);

		while (!map.containsKey(target)) {
			Map<String, List<List<String>>> nextMap = new HashMap<String, List<List<String>>>();
			fixOneDigit(map, nextMap, visited, positionMap);
			visited.addAll(nextMap.keySet());
			map = nextMap;

		}
		return map.get(target);
	}

	public void fixOneDigit(Map<String, List<List<String>>> map, Map<String, List<List<String>>> nextMap,
			Set<String> visited, Map<Integer, Integer> positionMap) {
		for (String key : map.keySet()) {
			int[] nums = unserialize(key);
			for (int i = 0; i < nums.length; i++) {
				int properPos = positionMap.get(nums[i]);
				if (properPos != i) {
					int n1 = nums[i];
					int n2 = nums[properPos];
					// remove duplicate when 1 swap fixes 2 number
					if(positionMap.get(n2)==i&&i>properPos){
						continue;
					}
					nums[i] = n2;
					nums[properPos] = n1;
					String s = serializeArray(nums);
					if (!visited.contains(s)) {
						if (!nextMap.containsKey(s)) {
							nextMap.put(s, new ArrayList<List<String>>());
						}
						List<List<String>> preLists = map.get(key);
						for (List<String> pre : preLists) {
							List<String> toadd = new ArrayList<String>(pre);
							toadd.add(s);
							nextMap.get(s).add(toadd);
						}
					}
					nums[i]=n1;
					nums[properPos]=n2;
				}
			}
		}
	}

	public int[] unserialize(String s) {
		String[] str = s.split(",");
		int[] nums = new int[str.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(str[i]);
		}
		return nums;
	}

	public String serializeArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i]);
			sb.append(',');
		}
		return sb.toString().substring(0, sb.length() - 1);
	}

	public void printAllPath(List<List<String>> res) {
		for (int i = 0; i < res.size(); i++) {
			List<String> curr = res.get(i);
			for (int j = 0; j < curr.size(); j++) {
				System.out.print(curr.get(j) + "=>");
			}
			System.out.println();
		}
		System.out.println();
	}
}
