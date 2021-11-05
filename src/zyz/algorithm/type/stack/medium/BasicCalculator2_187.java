package zyz.algorithm.type.stack.medium;

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
	    String s = " 3/2 ";

		System.out.println (calculate (s));


	}
	public static int calculate(String s) {
		s=s.replaceAll (" ","");
		Deque <Integer> stack=new LinkedList <> ();
		int ans=0;
		// 1 + -1  /
		int i=0;
		while(i<s.length ()&&Character.isDigit(s.charAt(i)))
		{
			ans=ans*10+(s.charAt(i)-'0');
			i++;
		}
		stack.push (ans);
		while(i<s.length()){
			ans=0;
			char ch= s.charAt(i++);
			//处理数字
				while(i<s.length ()&&Character.isDigit(s.charAt(i)))
				{
					ans=ans*10+(s.charAt(i)-'0');
					i++;
				}

			if(ch=='+')
			{
				stack.push(ans);
			}else if(ch=='-')
			{
				stack.push(-ans);
			}
			else if(ch=='*')
			{
				stack.push(stack.poll ()*ans);
			}else {
				stack.push (stack.poll ()/ans);
			}

		}
		int res=0;
		while(!stack.isEmpty())
		{

			res+=stack.poll ();
		}
		return res;
	}
}
