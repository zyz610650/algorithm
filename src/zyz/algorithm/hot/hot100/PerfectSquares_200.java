package zyz.algorithm.hot.hot100;

/**
 * @author zyz
 * @title: 完全平方数
 * @seq: 279
 * @address: https://leetcode-cn.com/problems/perfect-squares/
 * @idea:
 *  coin change 问题
 */
public class PerfectSquares_200 {

	public int numSquares(int n) {
		int[] dp=new int[n+1];

		for(int i=1;i<=n;i++)
		{
			dp[i]=i;
			for(int j=1;j*j<=i;j++)
			{
				dp[i]=Math.min(dp[i],dp[i-j*j]+1);
			}
		}

		return dp[n];
	}
}
