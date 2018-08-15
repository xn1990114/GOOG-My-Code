package onsite;

/*
 * 公交车站里面有若干公共汽车， 类似这样 terminal:{bus1, bus2, bus3, ...}， 
 * bus是一个类， 有int id, String company name 和一个出发时间 int time. 
 * 然后让实现几个函数 ： add(bus) 向一个车站里加入一辆车，getnext() 得到下一辆出发的车， 
 * dispatch() 让下一辆车从车站出发, removeAll(company) 除掉车站中某一个公司的所有车。 
 * 每个函数的时间复杂度。 follow up, 自己实现priority queue 来实现上面的每个问题。 
 */
// below answer is using PQ as interviewer requested so
public class BusScheduler {
	public class Bus implements Comparable<Bus> {
		int id;
		String companyName;
		int departTime;

		public Bus(int id, String companyName, int departTime) {
			this.id = id;
			this.companyName = companyName;
			this.departTime = departTime;
		}

		@Override
		public int compareTo(Bus b2) {
			return this.departTime - b2.departTime;
		}

		@Override
		public String toString() {
			return "id: " + this.id + " company: " + this.companyName + " depart time: " + this.departTime;
		}
	}

	Bus[] buses;
	int len;

	public BusScheduler(int size) {
		this.len = 0;
		this.buses = new Bus[size+1];
	}

	public void addBus(Bus bus) {
		len++;
		this.buses[len] = bus;
		int index=len;
		while(index/2>0){
			int parentIndex=index/2;
			if(bus.compareTo(buses[parentIndex])<0){
				Bus temp=buses[parentIndex];
				buses[parentIndex]=buses[index];
				buses[index]=temp;
			}
			index=index/2;
		}
	}

	public Bus getNext() {
		if (this.len == 0) {
			return null;
		}
		return this.buses[1];
	}

	public void dispatch() {
		if (this.len == 0) {
			return;
		}
		remove(1);
	}

	public void removeAll(String companyName) {
		for (int i = len; i > 0; i--) {
			if (buses[i].companyName.equals(companyName)) {
				remove(i);
			}
		}
	}

	private void remove(int index) {
		buses[index] = buses[len];
		len--;
		while (index * 2 <= len) {
			if (index * 2 + 1 <= len) {
				Bus curr = buses[index];
				Bus left = buses[index * 2];
				Bus right = buses[index * 2 + 1];
				if (curr.compareTo(left) > 0 || curr.compareTo(right) > 0) {
					if (left.compareTo(right) < 0) {
						buses[index] = left;
						buses[index * 2] = curr;
						index = index * 2;
					} else {
						buses[index] = right;
						buses[index * 2 + 1] = curr;
						index = index * 2 + 1;
					}
				} else {
					return;
				}
			} else {
				Bus curr = buses[index];
				Bus left = buses[index * 2];
				if (curr.compareTo(left) > 0) {
					buses[index] = left;
					buses[index * 2] = curr;
					index = index * 2;
				} else {
					return;
				}
			}
		}
	}
	public void displayAllBus(){
		for(int i=1;i<=len;i++){
			System.out.println(buses[i]);
		}
		System.out.println();
	}
}
