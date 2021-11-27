package zyz.algorithm.hot.jzoffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 剑指 Offer 09. 用两个栈实现队列
 * @seq: 9
 * @address: https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @idea:
 */
public class T9_231 {
	class CQueue {
		Deque <Integer> stack1=new LinkedList<>();
		Deque<Integer> stack2=new LinkedList <> ();
		public CQueue() {

		}

		public void appendTail(int value) {
			stack1.push(value);
		}

		public int deleteHead() {


			if(!stack2.isEmpty()) return stack2.pop();
			if(!stack1.isEmpty())
			{
				while(!stack1.isEmpty())
				{
					stack2.push(stack1.pop());
				}
				return stack2.pop();
			}
			return -1;
		}
	}
}
