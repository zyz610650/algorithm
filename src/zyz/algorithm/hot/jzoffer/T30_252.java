package zyz.algorithm.hot.jzoffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 剑指 Offer 30. 包含min函数的栈
 * @seq: 30
 * @address: https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @idea:
 */
public class T30_252 {

	class MinStack {

		/** initialize your data structure here. */
		Deque<Integer> stack=new LinkedList ();
		Deque<Integer> minStack=new LinkedList();
		public MinStack() {

		}

		public void push(int x) {
			if(minStack.peek()<=x) minStack.push(x);
			stack.push(x);

		}

		public void pop() {
			if(minStack.peek()==stack.peek()) minStack.pop();
			stack.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int min() {
			return minStack.peek();
		}
	}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}
