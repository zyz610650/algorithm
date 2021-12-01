package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.Utils;

/**
 * @author zyz
 * @title: 剑指 Offer 19. 正则表达式匹配
 * @seq: 19
 * @address: https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 * @idea:
 * https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/jian-zhi-offer-19-zheng-ze-biao-da-shi-pi-pei-dong/
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
