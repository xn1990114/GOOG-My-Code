package onsite;
import java.util.*;
/*
 * 输入是String数组，每个String代表一条message，内含若干单词。现定义Quote，
 * 如果某条message里有超过连续8个词的字段在它后面的message中出现，那么就算作被引用。一个message可以同时引用多个message，
 * 一个message也可以被多次引用。目标是找出每一条message引用了哪些message，分别引用了哪一段。数据结构自定，输入输出类型自定。
 */
// below answer take word of 8 and assume overlapped result are possible
public class StringQuote {
	public class Quote {
		String parentMessage;
		int start;
		int end;

		public Quote(String parentMessage, int start, int end) {
			this.parentMessage = parentMessage;
			this.start = start;
			this.end = end;
		}

		public String toString() {
			return "Quoted from " + parentMessage + " with index between " + start + " and " + end;
		}
	}
	public List<List<Quote>> findQuotes(String[] messages){
		List<List<Quote>> res=new ArrayList<List<Quote>>();
		if(messages==null||messages.length==0){
			return res;
		}
		Map<String,Quote> quoteMap=new HashMap<String,Quote>();
		for(int i=0;i<messages.length;i++){
			List<Quote> currQuote=new ArrayList<Quote>();
			scanString(messages[i],quoteMap,currQuote);
			res.add(currQuote);
		}
		return res;
	}
	public void scanString(String s,Map<String,Quote> quoteMap,List<Quote> currQuote){
		Map<String,Quote> quoteToAdd=new HashMap<String,Quote>();
		Deque<String> words=new LinkedList<String>();
		Deque<Integer> indexes=new LinkedList<Integer>();
		int index=0;
		while(index<s.length()){
			char ch=s.charAt(index);
			if(isWordChar(ch)){
				int start=index;
				while(index<s.length()&&isWordChar(s.charAt(index))){
					index++;
				}
				words.offerLast(s.substring(start,index));
				indexes.offerLast(start);
				if(words.size()==8){
					String key=makeWord(words);
					if(quoteMap.containsKey(key)){
						currQuote.add(quoteMap.get(key));
					}
					else if(!quoteToAdd.containsKey(key)){
						quoteToAdd.put(key, new Quote(s,indexes.peekFirst(),index-1));
					}
					words.pollFirst();
					indexes.pollFirst();
				}
			}
			else{
				index++;
			}
		}
		for(String key:quoteToAdd.keySet()){
			quoteMap.put(key, quoteToAdd.get(key));
		}
	}
	public boolean isWordChar(char ch){
		return Character.isLetter(ch)||Character.isDigit(ch);
	}
	public String makeWord(Deque<String> words){
		StringBuilder sb=new StringBuilder();
		for(String s:words){
			sb.append(s);
			sb.append(' ');
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
}
