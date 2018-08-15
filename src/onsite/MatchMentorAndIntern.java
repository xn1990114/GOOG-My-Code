package onsite;

import java.util.*;

/*
 * 每个mentor有几个理想的intern的list，每个intern理想的mentor的list，
 * 其中有人没有perfect match而且如果和别人换一下能得到更满意的match。给出mentor的理想list和现在匹配的intern，
 * 和Intern的理想mentor list和现有mentor，求可能的更优match。
参看 https://www.geeksforgeeks.org/maximum-bipartite-matching/  
 */
public class MatchMentorAndIntern {
	public class Mentor {
		int id;
		public Intern currIntern;
		public List<Intern> prefectMatches;
		public Mentor(int id){
			this.id=id;
			this.prefectMatches=new ArrayList<Intern>();
		}
	}

	public class Intern {
		int id;
		public Mentor currMentor;
		public List<Mentor> prefectMatches;
		public Intern(int id){
			this.id=id;
			this.prefectMatches=new ArrayList<Mentor>();
		}
	}
	
	// greedy approach -- assuming qty of mentor and intern are same
	public String rematchWithGreedy(List<Mentor> mentors, List<Intern> interns){
		for(int i=0;i<mentors.size();i++){
			Mentor currMentor=mentors.get(i);
			Intern currIntern=currMentor.currIntern;
			if(currIntern==null||!currMentor.prefectMatches.contains(currIntern)||currIntern.prefectMatches.contains(currMentor)){
				for(Intern perferredIntern:currMentor.prefectMatches){
					if(!isPerfectMatch(perferredIntern)){
						swapAssignment(currMentor,currIntern,perferredIntern);
						break;
					}
				}
			}
		}
		int index1=0;
		int index2=0;
		while(index1<mentors.size()){
			while(index1<mentors.size()){
				if(mentors.get(index1).currIntern==null){
					break;
				}
				index1++;
			}
			while(index2<interns.size()){
				if(interns.get(index2).currMentor==null){
					break;
				}
				index2++;
			}
			if(index1<mentors.size()){
				Mentor m=mentors.get(index1);
				Intern i=interns.get(index2);
				m.currIntern=i;
				i.currMentor=m;
				index1++;
				index2++;
			}
		}
		StringBuilder sb=new StringBuilder();
		for(Mentor m:mentors){
			sb.append("M:"+m.id+"->"+"I:"+m.currIntern.id);
		}
		return sb.toString();
	}
	public boolean isPerfectMatch(Intern i){
		if(i.currMentor==null){
			return false;
		}
		return i.prefectMatches.contains(i.currMentor)&&i.currMentor.prefectMatches.contains(i);
	}
	public void swapAssignment(Mentor m1,Intern currIntern,Intern perferredIntern){
		Mentor m2=perferredIntern.currMentor;
		m1.currIntern=perferredIntern;
		perferredIntern.currMentor=m1;
		if(m2!=null){
			m2.currIntern=currIntern;
		}
		if(currIntern!=null){
			currIntern.currMentor=m2;
		}
	}
	
	
	/// DFS + back tracking
	public String rematchWithBackTracking(List<Mentor> mentors, List<Intern> interns) {
		if (mentors == null || interns == null || mentors.size() == 0 || interns.size() == 0) {
			return "";
		}
		List<String> currMatch = new ArrayList<String>();
		String[] res = new String[1];
		int[] maxMatch = { -1 };
		searchForMatch(mentors, 0, interns, new HashSet<Intern>(),currMatch, res, maxMatch,0);
		return res[0];
	}

	private void searchForMatch(List<Mentor> mentors, int index, List<Intern> interns,Set<Intern> visited, List<String> currMatch,
			String[] res, int[] maxMatch,int happyCount) {
		if(index==mentors.size()){
			if(happyCount>maxMatch[0]){
				maxMatch[0]=happyCount;
				StringBuilder sb=new StringBuilder();
				for(String s:currMatch){
					sb.append(s+",");
				}
				res[0]=sb.toString();
			}
			return;
		}
		Mentor currMentor=mentors.get(index);
		searchForMatch(mentors, index+1, interns,visited, currMatch, res, maxMatch,happyCount);
		List<Intern> matchedInterns=currMentor.prefectMatches;
		for(int i=0;i<matchedInterns.size();i++){
			Intern currIntern=matchedInterns.get(i);
			if(visited.contains(currIntern)){
				continue;
			}
			visited.add(currIntern);
			currMatch.add("M:"+currMentor.id+"->"+"I:"+currIntern.id);
			int extraHappy=1;
			if(currIntern.prefectMatches.contains(currMentor)){
				extraHappy++;
			}
			searchForMatch(mentors, index+1, interns,visited, currMatch, res, maxMatch,extraHappy+happyCount);
			currMatch.remove(currMatch.size()-1);
			visited.remove(currIntern);
		}
	}
}
