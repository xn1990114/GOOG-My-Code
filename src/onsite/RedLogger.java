package onsite;

import java.util.*;

//设计一个RedLogger class, 有start和end函数，用户call start(int id， timestamp starttime)来开始一个request，
//然后call end(int id， timestamp starttime)标志这个request结束，
//然后要一个write函数把所有已完成的request按照start time的排序写入disk。
//需要注意就是可能一个开始很早的函数迟迟不结束。学完了之后又问了一堆multi user同时使用的会造成的multithreading和share memory的问题
public class RedLogger {
	public class Request implements Comparable<Request> {
		int id;
		long startTime;
		long endTime;

		public Request(int id, long startTime) {
			this.id = id;
			this.startTime = startTime;
		}

		@Override
		public int compareTo(Request r2) {
			if (this.startTime < r2.startTime) {
				return -1;
			} else if (this.startTime > r2.startTime) {
				return 1;
			}
			return 0;
		}

		public String toString() {
			return "[" + this.id + "," + this.startTime + "," + this.endTime + "]";
		}
	}

	Map<Integer, Request> activeRequest;
	PriorityQueue<Request> completedRequest;

	public RedLogger() {
		this.activeRequest = new HashMap<Integer, Request>();
		this.completedRequest = new PriorityQueue<Request>();
	}

	public synchronized void start(int id, long startTime) {
		if (this.activeRequest.containsKey(id)) {
			return;
		}
		this.activeRequest.put(id, new Request(id, startTime));
	}

	public void end(int id, long endTime) {
		if (!this.activeRequest.containsKey(id)) {
			return;
		}
		synchronized (this) {
			Request r = this.activeRequest.get(id);
			this.activeRequest.remove(id);
			r.endTime = endTime;
			this.completedRequest.offer(r);
		}
	}

	public synchronized List<String> write() {
		List<String> res = new ArrayList<String>();
		synchronized (this.completedRequest) {
			while (!this.completedRequest.isEmpty()) {
				res.add(this.completedRequest.poll().toString());
			}
		}
		return res;
	}

	public class Worker extends Thread {
		RedLogger logger;
		int[][] tostart;
		int[][] toend;
		List<String> res;

		public Worker(RedLogger logger, int[][] tostart, int[][] toend, List<String> res) {
			this.logger = logger;
			this.tostart = tostart;
			this.toend = toend;
			this.res = res;
		}

		@Override
		public void run() {
			for (int i = 0; i < tostart.length; i++) {
				logger.start(tostart[i][0], tostart[i][1]);
			}
			for (int i = 0; i < toend.length; i++) {
				logger.end(toend[i][0], toend[i][1]);
			}
			res.addAll(logger.write());
		}
	}
}
