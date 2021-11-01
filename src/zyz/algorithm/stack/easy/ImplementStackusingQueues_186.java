package zyz.algorithm.stack.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 用队列实现栈
 * @seq: 225
 * @address: https://leetcode-cn.com/problems/implement-stack-using-queues/
 * @idea:
 *  1.用两个队列
 *  2.用一个队列
 */
public class ImplementStackusingQueues_186 {

	class MyStack {
		Deque <Integer> q1=new LinkedList <> ();
		Deque<Integer> q2=new LinkedList<>();
		public MyStack() {

		}

		public void push(int x) {
			q2.offer(x);
			while(!q1.isEmpty())
			{
				q2.offer(q1.poll());
			}
			Deque<Integer> tmp=q1;
			q1=q2;
			q2=tmp;
		}

		public int pop() {
			return q1.poll();
		}

		public int top() {
			return q1.peek();
		}

		public boolean empty() {
			return q1.isEmpty();
		}
	}
}
