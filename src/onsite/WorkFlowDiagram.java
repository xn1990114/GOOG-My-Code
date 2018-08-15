package onsite;
import java.util.*;
/*
 * 给workflow（给的格式是ide上代码的那种格式），有task，有condition，例子如下
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
然后题目是说，user有一个api，叫做run_one_task()，作用是可以正确的执行下一个该被执行的任务，其中condition是在user使用的时候才判断，
所以不能提前preprocess。让我设计一个data strcutre，并且实现这个api。
一开始第一题脑子懵的，扯了半天没想到把整个flow变成directed graph。然后面试官估计看不下去了给我画了个图，恍然大悟。
后来谈到设计方面，我一开始说enum 定义图的node，里面有两个type task和condition。面试官说可以不用enum，用多态就好了。
我就吭哧吭哧写了个abstract class，然后task和condition extend一下就好了。然后就是正常的判断，执行就好了
 */
public class WorkFlowDiagram {
	public abstract class FlowNode{
		public boolean isTask(){
			return this instanceof Task;
		}
		public boolean isCondition(){
			return this instanceof Condition;
		}
	}
	public class Task extends FlowNode{
		int taskID;
		public FlowNode next;
		public Task(int id){
			this.taskID=id;
		}
		public void execute(){
			System.out.println("Task: "+this.taskID+" is executed");
		}
	}
	public class Condition extends FlowNode{
		public FlowNode trueNext;
		public FlowNode falseNext;
		String requiredCondition;
		public Condition(String requiredCond){
			this.requiredCondition=requiredCond;
		}
	}
	public Set<String> activeCondition;
	public FlowNode currNode;
	public WorkFlowDiagram(FlowNode head,Set<String> cond){
		this.activeCondition=cond;
		this.currNode=head;
	}
	public void run_one_task(){
		while(currNode!=null&&!currNode.isTask()){
			Condition currCond=(Condition)currNode;
			if(this.activeCondition.contains(currCond.requiredCondition)){
				currNode=currCond.trueNext;
			}
			else{
				currNode=currCond.falseNext;
			}
		}
		if(currNode!=null){
			((Task)currNode).execute();
			currNode=((Task)currNode).next;
		}
		else{
			System.out.println("All task completed");
		}
	}
}
