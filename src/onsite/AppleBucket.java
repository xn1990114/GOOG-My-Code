package onsite;
import java.util.*;
/*
 * 给你很多node（他说是Apple）每个Apple之间有关系 friend 或者 enemy， 
 * 你有N个袋子，每个袋子能装无限多个苹果，限制条件是每个袋子装的苹果只能是friend 不能是enemy
 * note: friend and enemy is not transitive in this problem.
 */
//assume can only be friend or enemy
public class AppleBucket {
	public List<String> findAppleBucketCombination(int[][] friendApple,int countBag,int countApple){
		List<String> res=new ArrayList<String>();
		Map<Integer,Set<Integer>> friendMap=new HashMap<Integer,Set<Integer>>();
		List<List<Integer>> buckets=new ArrayList<List<Integer>>();
		for(int i=0;i<countBag;i++){
			buckets.add(new ArrayList<Integer>());
		}
		for(int i=0;i<countApple;i++){
			friendMap.put(i, new HashSet<Integer>());
		}
		for(int i=0;i<friendApple.length;i++){
			int a1=friendApple[i][0];
			int a2=friendApple[i][1];
			friendMap.get(a1).add(a2);
			friendMap.get(a2).add(a1);
		}
		putApples(res,0,countApple,buckets,friendMap);
		return res;
	}
	private void putApples(List<String> res,int currAppleID,int countApple,List<List<Integer>> buckets,Map<Integer,Set<Integer>> friendMap){
		if(currAppleID==countApple){
			res.add(serialize(buckets));
			return;
		}
		for(int i=0;i<buckets.size();i++){
			List<Integer> currBucket=buckets.get(i);
			if(canPut(currBucket,currAppleID,friendMap)){
				currBucket.add(currAppleID);
				putApples(res,currAppleID+1,countApple,buckets,friendMap);
				currBucket.remove(currBucket.size()-1);
			}
		}
	}
	
	private boolean canPut(List<Integer> currBucket,int currAppleID,Map<Integer,Set<Integer>> friendMap){
		Set<Integer> friend=friendMap.get(currAppleID);
		for(int i=0;i<currBucket.size();i++){
			if(!friend.contains(currBucket.get(i))){
				return false;
			}
		}
		return true;
	}
	
	private String serialize(List<List<Integer>> buckets){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<buckets.size();i++){
			List<Integer> currBucket=buckets.get(i);
			for(int j=0;j<currBucket.size();j++){
				if(j>0){
					sb.append(',');
				}
				sb.append(currBucket.get(j));
			}
			sb.append('|');
		}
		return sb.toString();
	}
}
