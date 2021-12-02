package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.Utils;

/**
 * @author zyz
 * @title: 剑指 Offer 19. 正则表达式匹配
 * @seq: 19
 * @address: https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 * @idea:
 * https://leetcode-cn.com/problems/regular-expression-matching/solution/shou-hui-tu-jie-wo-tai-nan-liao-by-hyj8/
 * a3-例子: s="aabb"（或s="aabbb"都行）,p="aab*"。不难看出，p末尾的*使得b重复了2次（或3次），符合情况a3。这种情况，已知s(i-1)=p(j-2)，*使得p(j-2)这个字符重复1次匹配了s(i-1)，*能不能使得p(j-2)再与s(i-2)字符继续匹配，那就把s串的末尾字符去掉，查看p(0,j-1)能否继续与s(0,i-2)匹配了。此时，推导公式为：dp(i)(j) = dp(i-1)(j)
 */
public class T19_242 {

	public static void main (String[] args) {

		String s="aa",p="a*";

		System.out.println (isMatch (s,p));
	}
	public static boolean isMatch(String s, String p) {
		int pl=p.length(),sl=s.length();
		boolean[][] dp=new boolean[sl+1][pl+1];
		dp[0][0]=true;
		for(int i=2;i<=pl;i++)
		{
			dp[0][i]=dp[0][i-2]&&p.charAt (i-1)=='*';
		}
		for(int i=1;i<=sl;i++)
		{
			char ch=s.charAt(i-1);
			for(int j=1;j<=pl;j++)
			{
				char ch_p=p.charAt(j-1);
				if(ch==ch_p||ch_p=='.')
				{
					dp[i][j]=dp[i-1][j-1];

				}
				else if(ch_p=='*')
				{
					dp[i][j]=dp[i][j-2];
					dp[i][j]|=s.charAt (i-1)==p.charAt (j-2)?dp[i-1][j]:false;
					dp[i][j]|='.'==p.charAt (j-2)?dp[i-1][j]:false;
				}
			}
		}
		Utils.print2Arr (dp);
		return dp[sl][pl];
	}
}
