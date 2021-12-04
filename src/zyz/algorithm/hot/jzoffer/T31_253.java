package zyz.algorithm.hot.jzoffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 剑指 Offer 31. 栈的压入、弹出序列
 * @seq: 31
 * @address: https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * @idea:
 */
public class T31_253 {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Deque <Integer> stack=new LinkedList <> ();
		int index=0;
		for(int val:pushed)
		{
			stack.push(val);
			while(!stack.isEmpty()&&popped[index]==stack.peek())
			{
				stack.pop();
				index++;
			}
		}
		return stack.isEmpty();
	}
}
