package phone;
import java.util.*;
/*
 * 给一个list of words，当且仅当word2可以由word1通过插入一个字母达到的时候，可以将word2放在word1之后，比如.
 *a-ab-acb-tabc-tabqc- tabpqc.
 *每个这样的结构必须从长度为1的单词开始，求返回list中word可以组成的长度最长的结构的最后一个单词，如果上面的例子就是tabpqc。
 */
public class MaxConinuousLengthString {
	public Set<String> findLastStringWithSequenceChange(String[] strs){
		Map<Integer,Set<String>> map=new HashMap<Integer,Set<String>>();
		Map<String,Set<String>> keyMap=new HashMap<String,Set<String>>();
		for(String s:strs){
			int len=s.length();
			if(!map.containsKey(len)){
				map.put(len, new HashSet<String>());
			}
			String key=serilize(s);
			map.get(len).add(key);
			if(!keyMap.containsKey(key)){
				keyMap.put(key, new HashSet<String>());
			}
			keyMap.get(key).add(s);
		}
		Set<String> last=map.get(1);
		if(last==null){
			return new HashSet<String>();
		}
		int round=2;
		while(map.containsKey(round)){
			Set<String> target=map.get(round);
			Set<String> curr=new HashSet<String>();
			for(String s:target){
				String[] temp=s.split(",");
				int[] tempInt=new int[temp.length];
				for(int i=0;i<temp.length;i++){
					tempInt[i]=Integer.parseInt(temp[i]);
				}
				for(int i=0;i<tempInt.length;i++){
					if(tempInt[i]>0){
						tempInt[i]--;
						String tobeFound=reCombine(tempInt);
						if(last.contains(tobeFound)){
							curr.add(s);
							break;
						}
						tempInt[i]++;
					}
				}
			}
			if(curr.isEmpty()){
				break;
			}
			last=curr;
			round++;
		}
		Set<String> res=new HashSet<String>();
		for(String key:last){
			res.addAll(keyMap.get(key));
		}
		return res;
	}
	public Set<String> findLastStringNoSequenceChange(String[] strs){
		Map<Integer,Set<String>> map=new HashMap<Integer,Set<String>>();
		for(String s:strs){
			int len=s.length();
			if(!map.containsKey(len)){
				map.put(len, new HashSet<String>());
			}
			map.get(len).add(s);
		}
		Set<String> last=map.get(1);
		if(last==null){
			return new HashSet<String>();
		}
		int round=2;
		while(map.containsKey(round)){
			Set<String> target=map.get(round);
			Set<String> curr=new HashSet<String>();
			for(String s:target){
				for(int i=0;i<s.length();i++){
					String newStr=s.substring(0, i)+s.substring(i+1);
					if(last.contains(newStr)){
						curr.add(s);
						break;
					}
				}
			}
			if(curr.isEmpty()){
				break;
			}
			last=curr;
			round++;
		}
		return last;
	}
	public String serilize(String s){
		int[] count=new int[256];
		for(int i=0;i<s.length();i++){
			count[s.charAt(i)]++;
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<256;i++){
			sb.append(count[i]);
			if(i<255){
				sb.append(',');
			}
		}
		return sb.toString();
	}
	public String reCombine(int[] nums){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<256;i++){
			sb.append(nums[i]);
			if(i<255){
				sb.append(',');
			}
		}
		return sb.toString();
	}
	public void display(Set<String> set){
		for(String s:set){
			System.out.print(s+".");
		}
		System.out.println();
	}
}
