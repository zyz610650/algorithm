package zyz.algorithm.stack.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 最小栈
 * @seq: 155
 * @address: https://leetcode-cn.com/problems/min-stack/
 * @idea:
 */
public class MinStack_184 {
	class MinStack {
		Deque<Integer> stack =new LinkedList<>();
		Deque<Integer> mStack=new LinkedList<>();
		public MinStack() {
			mStack.push(Integer.MAX_VALUE);
		}

		public void push(int val) {
			stack.push(val);
			mStack.push(Math.min(mStack.peek(),val));
		}

		public void pop() {
			mStack.poll();
			stack.poll();
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return mStack.peek();
		}
	}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


}
