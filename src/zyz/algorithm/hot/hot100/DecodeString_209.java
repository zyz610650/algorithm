package zyz.algorithm.hot.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 字符串解码
 * @seq: 394
 * @address: https://leetcode-cn.com/problems/decode-string/
 * @idea:
 * 数字一个栈 字符串一个栈的思路特别好
 */
public class DecodeString_209 {
	public static void main (String[] args) {
		String str="100[leetcode]";
		System.out.println (decodeString(str));
	}
	public static String decodeString(String s) {
		Deque <Character> stack=new LinkedList <> ();
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==']') {
				StringBuilder sb = new StringBuilder ();
				Character ch;
				while (Character.isLetterOrDigit (ch = stack.pop ())) {
				  sb.append (ch);
				}
					StringBuilder str = new StringBuilder ();
					sb=sb.reverse ();
					int n=0;
					StringBuilder strN=new StringBuilder ();
					while (!stack.isEmpty ()&&stack.peek ()<='9'&&stack.peek ()>='0')
					{
						strN.append (stack.pop ());
					}
					n=Integer.parseInt (strN.reverse ().toString ());
					for (int k = 0 ; k < n ; k++) {
						str.append (sb);
					}
					for (int k = 0 ; k < str.length () ; k++) stack.push (str.charAt (k));

					continue;
			}
			stack.push(s.charAt(i));
		}
		StringBuilder sb=new StringBuilder ();
		while (!stack.isEmpty ())
		{
			sb.append (stack.pop ());
		}
		return sb.reverse ().toString ();
	}


}
