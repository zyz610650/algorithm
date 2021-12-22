package zyz.algorithm.hot.jzoffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 剑指 Offer 59 - II. 队列的最大值
 * @seq: 59_2
 * @address: https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * @idea:
 *
 */
public class T59_2_289 {

	public static void main (String[] args) {
		Deque<Integer> queue = new LinkedList<Integer>();
		queue.add (2);
		queue.add (3);
		// int ans=queue.pollFirst();
		// if(ans==q.peekFirst())
		// {
		//     q.pollFirst();
		// }
		// return ans;
		if(queue.peekFirst()==2)
		{

		}
		System.out.println (queue.peekFirst ());
		System.out.println (queue.pollFirst ());
	}
	class MaxQueue {
		Deque <Integer> q;
		Deque<Integer> d;

		public MaxQueue() {
			q = new LinkedList<Integer>();
			d = new LinkedList<Integer>();
		}

		public int max_value() {
			if (d.isEmpty()) {
				return -1;
			}
			return d.peekFirst();
		}

		public void push_back(int value) {
			while (!d.isEmpty() && d.peekLast() < value) {
				d.pollLast();
			}
			d.offerLast(value);
			q.offerLast (value);
		}

		public int pop_front() {
			if (q.isEmpty()) {
				return -1;
			}
			int ans = q.pollFirst ();

			if (ans == d.peekFirst()) {
				d.pollFirst();
			}
			return ans;
		}
	}


}
