package onsite;
import java.util.*;
/*
void birth(String parent, String name) 父亲名字和孩子名字，生个娃
void death(String name) 此人要死
List<String> getOrder() 返回当前的继承顺序，string array/list

讨论得知，每个人的名字是唯一的，继承顺序符合如下规律:
假设王有大皇子二皇子三皇子，大皇子有长子次子三子，那么继承顺序是王->大皇子->大皇子长子->大皇子次子->大皇子三子->二皇子->三皇子
死掉的人不能出现在继承顺序里，但是如果上面例子中大皇子死了，只需把大皇子移除，
原始继承顺序保持不变：王->大皇子长子->大皇子次子->大皇子三子->二皇子->三皇子
 */
// can use map+double linked list to improve getOrder(), if called many times and not many insert
public class KingdomInheritance {
	class Person{
		String name;
		List<Person> children;
		boolean alive;
		public Person(String name){
			this.name=name;
			this.children=new ArrayList<Person>();
			this.alive=true;
		}
	}
	Person king;
	Map<String,Person> map;
	public KingdomInheritance(String kingName){
		this.king=new Person(kingName);
		this.map=new HashMap<String,Person>();
		map.put(kingName, king);
	}
	public void giveBirth(String parent,String child){
		Person ch=new Person(child);
		if(map.containsKey(parent)){
			map.get(parent).children.add(ch);
			map.put(child, ch);
		}
	}
	public void death(String name){
		if(map.containsKey(name)){
			map.get(name).alive=false;
		}
	}
	public List<String> getOrder(){
		List<String> res=new ArrayList<String>();
		if(this.king==null){
			return res;
		}
		Stack<Person> stack=new Stack<Person>();
		stack.push(king);
		while(!stack.isEmpty()){
			Person top=stack.pop();
			if(top.alive){
				res.add(top.name);
			}
			for(int i=top.children.size()-1;i>=0;i--){
				stack.push(top.children.get(i));
			}
		}
		return res;
	}
	public void display(List<String> res){
		for(String s:res){
			System.out.print(s+"->");
		}
		System.out.println();
	}
}
