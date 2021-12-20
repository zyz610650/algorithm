package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 58 - I. 翻转单词顺序
 * @seq: 58_1
 * @address: https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * @idea:
 *
 */
public class T58_1_286 {

	public static void main (String[] args) {
		String str="ab  c    ";
		String[] strs=str.split(" ");
		System.out.println (strs);

	}
	public String reverseWords(String s) {
		s = s.trim();
		String[] strs=s.split(" ");
		StringBuilder sb=new StringBuilder();
		for(int i=strs.length-1;i>=0;i--)
		{
			if(strs[i].equals ("")) continue;
			sb.append(strs[i]);
			if(i!=0) sb.append(" ");
		}
		s=sb.toString();

		return s;
	}
}
