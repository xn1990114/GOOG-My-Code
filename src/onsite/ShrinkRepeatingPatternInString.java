package onsite;

import java.util.*;
/*
 * 压缩字符串：给你比如abcabeabfabc，连续的两个字母是一对，把ab—》X，那么可以写成XcXeXfXc，接下来最多的对是Xc，那么Xc--》Y，
 * 那么就成了YXeXfY，接下来没有重复的对了，就结束。要求实现这种变化，同时要记录变化过程，以后还可以变回去。
follow up是，怎么优化，尽量减少重复处理的地方。

面试结果他告诉我，把ab替换成X的时候，把X放在a的位置上，b就换成特殊字符，同时，每个pair分别用list记录自己的起始位置，
替换一个pair的时候同时更新它左右的pair的情况
 */

public class ShrinkRepeatingPatternInString {
	// result will be the last shrinked string + all conversion pattern;
	public List<String> encode(String s) {
		if (s == null) {
			return new ArrayList<String>();
		}
		boolean canShrink = true;
		List<String> res = new ArrayList<String>();
		char currFactor = 'A';
		while (canShrink) {
			canShrink = false;
			Map<String, Integer> patternCount = new HashMap<String, Integer>();
			for (int i = 0; i < s.length() - 1; i++) {
				String pattern = s.substring(i, i + 2);
				if (!patternCount.containsKey(pattern)) {
					patternCount.put(pattern, 0);
				}
				patternCount.put(pattern, patternCount.get(pattern) + 1);
			}
			String maxPattern = null;
			int maxCount = 0;
			for (String p : patternCount.keySet()) {
				int count = patternCount.get(p);
				if (count > maxCount) {
					maxCount = count;
					maxPattern = p;
				}
			}
			if (maxCount >= 2) {
				canShrink = true;
				StringBuilder sb = new StringBuilder();
				res.add(currFactor + "-" + maxPattern);
				for (int i = 0; i < s.length(); i++) {
					String pattern = s.substring(i, Math.min(s.length(), i + 2));
					if (pattern.equals(maxPattern)) {
						sb.append(currFactor);
						i++;
					} else {
						sb.append(s.charAt(i));
					}
				}
				currFactor++;
				s = sb.toString();
			}
		}
		res.add(s);
		Collections.reverse(res);
		return res;
	}

	// follow up
	public List<String> encodeOptimized(String s) {
		if (s == null) {
			return new ArrayList<String>();
		}
		List<String> res=new ArrayList<String>();
		int maxCount=0;
		String maxPattern=null;
		Map<String,List<String>> countMap=new HashMap<String,List<String>>();
		for(int i=0;i<s.length()-1;i++){
			String pattern=s.substring(i,i+2);
			if(!countMap.containsKey(pattern)){
				countMap.put(pattern, new ArrayList<String>());
			}
			countMap.get(pattern).add(i+","+(i+1));
			int size=countMap.get(pattern).size();
			if(size>maxCount&&size>=2){
				maxCount=size;
				maxPattern=pattern;
			}
		}
		char[] chars=s.toCharArray();
		char currFactor='A';
		while(maxPattern!=null){
			List<String> maxPatternLocation=countMap.get(maxPattern);
			countMap.remove(maxPattern);
			res.add(currFactor+"-"+maxPattern);
			for(int i=0;i<maxPatternLocation.size();i++){
				String[] currPos=maxPatternLocation.get(i).split(",");
				int pos1=Integer.parseInt(currPos[0]);
				int pos2=Integer.parseInt(currPos[1]);
				String update1=getNextPattern(pos2,chars);
				String update2=getPrePattern(pos1,chars);
				if(update1!=null){
					String[] update=update1.split("#");
					countMap.get(update[0]).remove(update[1]);
				}
				if(update2!=null){
					String[] update=update2.split("#");
					countMap.get(update[0]).remove(update[1]);
				}
				chars[pos1]=currFactor;
				chars[pos2]=' ';
			}
			
			for(int i=0;i<maxPatternLocation.size();i++){
				String[] currPos=maxPatternLocation.get(i).split(",");
				int pos1=Integer.parseInt(currPos[0]);
				String update1=getNextPattern(pos1,chars);
				String update2=getPrePattern(pos1,chars);
				if(update1!=null){
					String[] update=update1.split("#");
					if(!countMap.containsKey(update[0])){
						countMap.put(update[0], new ArrayList<String>());
					}
					countMap.get(update[0]).add(update[1]);
				}
				if(update2!=null){
					String[] update=update2.split("#");
					if(!countMap.containsKey(update[0])){
						countMap.put(update[0], new ArrayList<String>());
					}
					countMap.get(update[0]).add(update[1]);
				}
			}
			maxPattern=null;
			maxCount=0;
			for(String key:countMap.keySet()){
				int size=countMap.get(key).size();
				if(size>maxCount&&size>=2){
					maxCount=size;
					maxPattern=key;
				}
			}
			currFactor++;
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<chars.length;i++){
			if(chars[i]!=' '){
				sb.append(chars[i]);
			}
		}
		res.add(sb.toString());
		Collections.reverse(res);
		return res;
	}

	public String getNextPattern(int start, char[] chars) {
		if (chars[start] == ' ')
			return null;
		StringBuilder sb = new StringBuilder();
		int location1=-1;
		int location2=-1;
		while (start < chars.length && sb.length() < 2) {
			 if (chars[start] != ' ') {
				sb.append(chars[start]);
				if(location1==-1){
					location1=start;
				}
				else{
					location2=start;
				}
			}
			start++;
		}
		if (sb.length() < 2) {
			return null;
		}
		return sb.toString()+"#"+location1+","+location2;
	}

	public String getPrePattern(int end, char[] chars) {
		if (chars[end] == ' ')
			return null;
		StringBuilder sb = new StringBuilder();
		int location1=-1;
		int location2=-1;
		while (end >= 0 && sb.length() < 2) {
			
			if (chars[end] != ' ') {
				sb.append(chars[end]);
				if(location1==-1){
					location1=end;
				}
				else{
					location2=end;
				}
			}
			end--;
		}
		if (sb.length() < 2) {
			return null;
		}
		return sb.reverse().toString()+"#"+location2+","+location1;
	}

	public String decode(List<String> pattern) {
		String s = pattern.get(0);
		for (int i = 1; i < pattern.size(); i++) {
			String[] str = pattern.get(i).split("-");
			s = s.replace(str[0], str[1]);
		}
		return s;
	}
}
