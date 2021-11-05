package zyz.algorithm.type.stack.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title:  用栈实现队列
 * @seq: 232
 * @address: https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * @idea:
 */
public class ImplementQueueusingStacks_188 {
	//法1
	class MyQueue1 {

		Deque <Integer> stack1=new LinkedList <> ();
		Deque<Integer> stack2=new LinkedList<>();
		public MyQueue1() {

		}

		public void push(int x) {
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
			stack2.push(x);
			while(!stack2.isEmpty())
			{
				stack1.push(stack2.poll());
			}
		}

		public int pop() {
			return stack1.poll();
		}

		public int peek() {
			return stack1.peek();
		}

		public boolean empty() {
			return stack1.isEmpty();
		}
	}
	// 法2
	class MyQueue {

		Deque<Integer> stack1=new LinkedList<>();
		Deque<Integer> stack2=new LinkedList<>();
		int front;
		public MyQueue() {

		}

		public void push(int x) {
			if(stack1.isEmpty()) front=x;
			stack1.push(x);
		}

		public int pop() {
			if(stack2.isEmpty())
			{
				while(!stack1.isEmpty())
				{
					stack2.push(stack1.poll());
				}
			}
			return stack2.poll();
		}

		public int peek() {
			if(!stack2.isEmpty())
			{
				return stack2.peek();
			}
			return front;
		}

		public boolean empty() {
			return stack2.isEmpty()&&stack1.isEmpty();
		}
	}
}
