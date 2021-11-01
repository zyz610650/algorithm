package zyz.algorithm.stack.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 基本计算器
 * @seq: 224
 * @address: https://leetcode-cn.com/problems/basic-calculator/
 * @idea:
 * 因为是加减，下面这题的思路是把所有的括号去掉处理
 */
public class BasicCalculator_185 {

	public int calculate(String s) {
		Deque <Integer> stack=new LinkedList <> ();
		int i=0;
		stack.push(1);
		int res=0;
		int ops=1;
		while(i<s.length())
		{
			if(s.charAt(i)==' ')
			{
			}
			else if(s.charAt(i)=='+')
			{
				ops=stack.peek();
			}
			else if(s.charAt(i)=='-')
			{
				ops=-stack.peek();
			}
			else if(s.charAt(i)=='(')
			{
				stack.push(ops);
			}else if(s.charAt(i)==')')
			{
				stack.poll();
			}else{
				int ans=0;
				while(i<s.length()&&Character.isDigit(s.charAt(i)))
				{
					ans=ans*10+(s.charAt(i)-'0');
					i++;
				}
				res+=ans*ops;
				continue;
			}
			i++;
		}
		return res;
	}
}
