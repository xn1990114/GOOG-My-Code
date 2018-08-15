package onsiteTester;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import onsite.RedLogger;
import onsite.RedLogger.Worker;

public class RedLoggerTester {

	@Test
	public void test1() {
		RedLogger logger=new RedLogger();
		int[][] tostart1={{1,0},{5,2},{2,5},{7,5},{15,20}};
		int[][] toend1={{1,3},{15,25}};
		List<String> res=new ArrayList<String>();
		Worker w1=logger.new Worker(logger,tostart1,toend1,res);
		w1.run();
		for(String s:res){
			System.out.println(s);
		}
		System.out.println();
	}
	@Test
	public void test2() throws InterruptedException {
		RedLogger logger=new RedLogger();
		int[][] tostart1={{1,0},{5,2},{2,5},{7,5},{15,20}};
		int[][] toend1={{1,3},{7,10}};
		int[][] tostart2={};
		int[][] toend2={{15,25},{5,7}};
		List<String> res1=new ArrayList<String>();
		List<String> res2=new ArrayList<String>();
		Worker w1=logger.new Worker(logger,tostart1,toend1,res1);
		Worker w2=logger.new Worker(logger,tostart2,toend2,res2);
		w1.run();
		w2.run();
		w1.join();
		w2.join();
		for(String s:res1){
			System.out.println(s);
		}
		System.out.println();
		for(String s:res2){
			System.out.println(s);
		}
		System.out.println();
	}
}
