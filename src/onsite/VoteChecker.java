package onsite;

import java.util.*;

public class VoteChecker {
	class Node {
		int count;
		Set<Integer> photos;
		Node previous;
		Node next;

		public Node(int count) {
			this.count = count;
			this.photos = new HashSet<Integer>();
		}
	}

	public void findTopK(int k, List<Integer> times, List<int[]> votes) {
		Map<Integer, Node> map = new HashMap<Integer, Node>();
		Node head = new Node(0);
		Node tail = new Node(Integer.MAX_VALUE);
		head.next = tail;
		tail.previous = head;
		int last = 0;
		int index=0;
		for (int i = 0; i < times.size(); i++) {
			while (votes.get(index)[0]<=times.get(i)) {
				if (votes.get(i)[0] - votes.get(last)[0] >= 24) {
					int toCut = votes.get(last)[1];
					Node curr = map.get(toCut);
					curr.photos.remove(toCut);
					if (curr.previous!=head) {
						Node p = curr.previous;
						if (p.count == curr.count - 1) {
							p.photos.add(toCut);
						} else {
							p = new Node(curr.count - 1);
							p.photos.add(toCut);
							p.previous = curr.previous;
							curr.previous.next = p;
							p.next = curr;
							curr.previous = p;
						}
						map.put(toCut, p);
					}
					if (curr.photos.isEmpty()) {
						curr.next.previous = curr.previous;
						curr.previous.next = curr.next;
					}
					last++;
				} else {
					int toadd = votes.get(index)[1];
					if (!map.keySet().contains(toadd)) {
						if (head.next.count == 1) {
							head.next.photos.add(toadd);
							map.put(toadd, head.next);
						} else {
							Node p = new Node(1);
							map.put(toadd, p);
							p.photos.add(toadd);
							p.next = head.next;
							head.next.previous = p;
							p.previous = head;
							head.next = p;
						}
					} else {
						Node curr = map.get(toadd);
						curr.photos.remove(toadd);
						if (curr.next.count == curr.count + 1) {
							map.put(toadd, curr.next);
							curr.next.photos.add(toadd);
						} else {
							Node p = new Node(curr.count + 1);
							p.photos.add(toadd);
							map.put(toadd, p);
							p.next = curr.next;
							curr.next.previous = p;
							p.previous = curr;
							curr.next = p;
						}
						if (curr.photos.isEmpty()) {
							curr.next.previous = curr.previous;
							curr.previous.next = curr.next;
						}
					}
					index++;
				}
			}
			display(k,tail.previous,head);
		}
	}
	public void display(int k,Node curr,Node end){
		List<Integer> result=new ArrayList<Integer>();
		while(curr!=end&&result.size()<k){
			for(int id:curr.photos){
				result.add(id);
				if(result.size()==k){
					break;
				}
			}
			curr=curr.previous;
		}
		for(int id:result){
			System.out.print(id+"\t");
		}
		System.out.println();
	}
}
