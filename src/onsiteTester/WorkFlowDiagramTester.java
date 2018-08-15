package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.WorkFlowDiagram;
import onsite.WorkFlowDiagram.Condition;
import onsite.WorkFlowDiagram.FlowNode;
import onsite.WorkFlowDiagram.Task;
/*
task1
task2
if (condition1) {
  task 3
}
while (condition 2) {
  task 4
  if (condition 3) {
    task 5.
  }
}
 */
public class WorkFlowDiagramTester {

	@Test
	public void test1() {
		Set<String> dic=new HashSet<String>();
		WorkFlowDiagram tester=new WorkFlowDiagram(null,dic);
		dic.add("Cond1");dic.add("Cond2");dic.add("Cond3");
		Task t1=tester.new Task(1);Task t2=tester.new Task(2);Task t3=tester.new Task(3);
		Task t4=tester.new Task(4);Task t5=tester.new Task(5);
		Condition c1=tester.new Condition("Cond1");Condition c2=tester.new Condition("Cond2");
		Condition c3=tester.new Condition("Cond3");
		t1.next=t2;t2.next=c1;c1.trueNext=t3;c1.falseNext=c2;t3.next=c2;c2.trueNext=t4;t4.next=c3;
		c3.trueNext=t5;c3.falseNext=c2;t5.next=c2;
		tester.currNode=t1;
		for(int i=0;i<10;i++){
			tester.run_one_task();
		}
		System.out.println();
		dic.remove("Cond3");
		tester.run_one_task();
		tester.run_one_task();
		dic.remove("Cond2");
		tester.run_one_task();
		tester.run_one_task();
		System.out.println();
	}
	@Test
	public void test2() {
		Set<String> dic=new HashSet<String>();
		WorkFlowDiagram tester=new WorkFlowDiagram(null,dic);
		dic.add("Cond2");dic.add("Cond3");
		Task t1=tester.new Task(1);Task t2=tester.new Task(2);Task t3=tester.new Task(3);
		Task t4=tester.new Task(4);Task t5=tester.new Task(5);
		Condition c1=tester.new Condition("Cond1");Condition c2=tester.new Condition("Cond2");
		Condition c3=tester.new Condition("Cond3");
		t1.next=t2;t2.next=c1;c1.trueNext=t3;c1.falseNext=c2;t3.next=c2;c2.trueNext=t4;t4.next=c3;
		c3.trueNext=t5;c3.falseNext=c2;t5.next=c2;
		tester.currNode=t1;
		for(int i=0;i<5;i++){
			tester.run_one_task();
		}
		dic.remove("Cond2");
		tester.run_one_task();
		tester.run_one_task();
	}

}
