package design_Youtube;
import java.util.*;

public class User {
	static int nextID=1;
	public static int personal=1;
	public static int channel=2;
	public int ID;
	public int type;
	public Set<Integer> following;
	public Set<Integer> follower;
	public LinkedHashSet<Integer> myPost;
	public User(int type){
		this.ID=User.nextID;
		User.nextID++;
		this.type=type;
		this.following=new HashSet<Integer>();
		this.follower=new HashSet<Integer>();
		this.myPost=new LinkedHashSet<Integer>();
	}
	public boolean follow(int targetID){
		if(this.following.contains(targetID)){
			return false;
		}
		this.following.add(targetID);
		return true;
	}
	public boolean followed(int targetID){
		if(this.follower.contains(targetID)){
			return false;
		}
		this.follower.add(targetID);
		return true;
	}
	public boolean postVideo(int vID){
		if(myPost.contains(vID)){
			return false;
		}
		this.myPost.add(vID);
		return true;
	}
	public boolean removeVideo(int vID){
		if(myPost.contains(vID)){
			return false;
		}
		this.myPost.remove(vID);
		return true;
	}
	public void watchTopRecommended(){
		/*
		 * 1, create list for each category, sort by view -- not stable with large user base
		 * 2, create list for each category but not sort -- stable
		 * 3, no separate list, too slow
		 * 4, create a list that contains the top viewed in each category
		 */
	}
}
