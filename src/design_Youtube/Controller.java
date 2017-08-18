package design_Youtube;

import java.util.*;

public class Controller {
	HashMap<Integer,Video> videos;
	HashMap<Integer,User> users;
	public Controller(){
		this.videos=new HashMap<Integer,Video>();
		this.users=new HashMap<Integer,User>();
	}
	public boolean postVideo(int uID,int vID){
		if(!videos.keySet().contains(vID)||!users.keySet().contains(uID)){
			return false;
		}
		return users.get(uID).postVideo(vID);
	}
	public boolean removeVideo(int uID,int vID){
		if(!videos.keySet().contains(vID)||!users.keySet().contains(uID)){
			return false;
		}
		User u=users.get(uID);
		if(!u.myPost.contains(vID)){
			return false;
		}
		return u.removeVideo(vID);
	}
	public boolean follow(int p,int target){
		if(!users.keySet().contains(p)||!users.keySet().contains(target)){
			return false;
		}
		return users.get(p).follow(target);
	}
}
