package design_Youtube;
import java.util.*;
public class Video {
	static int nextID;
	public int ID;
	public int author;
	public int views;
	Set<String> label;
	public Video(int author){
		this.ID=nextID;
		this.views=0;
		nextID++;
		this.label=new HashSet<String>();
	}
	public boolean setLabel(String s){
		if(this.label.contains(s)){
			return false;
		}
		this.label.add(s);
		return true;
	}
}
