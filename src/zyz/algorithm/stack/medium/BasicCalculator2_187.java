package zyz.algorithm.stack.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 基本计算器 II
 * @seq: 227
 * @address: https://leetcode-cn.com/problems/basic-calculator-ii/
 * @idea:
 */
public class BasicCalculator2_187 {
	public static void main (String[] args) {
		String s = " 3+5 / 2 ";
		System.out.println (calculate (s));
	}
	public static int calculate(String s) {
		Deque <Integer> stack=new LinkedList <> ();
		int ans=0;
		// 1 + -1  /
		int i=0;
		while(i<s.length()){
			ans=0;
			if (i<s.length ()&&s.charAt (i)==' ')
			{
				i++;
				continue;
			}
			//处理数字
			if(i<s.length ()&&Character.isDigit(s.charAt(i)))
			{

				while(i<s.length ()&&Character.isDigit(s.charAt(i)))
				{
					ans=ans*10+(s.charAt(i)-'0');
					i++;
				}
				stack.push(ans);
			}

			if(i==s.length()) break;
			char ch= s.charAt(i);

			if(ch=='+')
			{
				stack.push(1);
			}else if(ch=='-')
			{
				stack.push(-1);
			}
			else if(ch=='*'||ch=='/')
			{
				int n=stack.poll();
				i++;
				while (s.charAt (i)==' ') i++;
				int next=(s.charAt(i)-'0');
				n=ch=='*'?n*next:n/next;
				stack.push(n);
			}
			i++;

		}
		int res=0;
		res=stack.poll();
		while(!stack.isEmpty())
		{
			res=stack.poll()==1?res+stack.poll():res-stack.poll();
		}
		return res;
	}
}
