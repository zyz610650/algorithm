package zyz.algorithm.stack.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 逆波兰表达式求值
 * @seq: 150
 * @address: https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @idea:
 */
public class EvaluateReversePolishNotation_183 {

	public int evalRPN(String[] tokens) {
		Deque<Integer> stack=new LinkedList<>();
		String ch;
		for(int i=0;i<tokens.length;i++)
		{
			ch=tokens[i];
			if(ch.equals("+"))
			{
				int ch1=stack.poll();
				int ch2=stack.poll();
				stack.push(ch2+ch1);
				continue;
			}
			if(ch.equals("-"))
			{
				int ch1=stack.poll();
				int ch2=stack.poll();
				stack.push(ch2-ch1);
				continue;
			}
			if(ch.equals("*"))
			{
				int ch1=stack.poll();
				int ch2=stack.poll();
				stack.push(ch2*ch1);
				continue;
			}
			if(ch.equals("/"))
			{
				int ch1=stack.poll();
				int ch2=stack.poll();
				stack.push(ch2/ch1);
				continue;
			}
			stack.push(Integer.valueOf(ch));
		}
		return stack.poll();

	}
}
