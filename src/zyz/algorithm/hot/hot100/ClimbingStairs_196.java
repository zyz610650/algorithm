package zyz.algorithm.hot.hot100;

/**
 * @author zyz
 * @title: 爬楼梯
 * @seq: 70
 * @address: https://leetcode-cn.com/problems/climbing-stairs/
 * @idea:
 * 递归会超时 但可以用记忆化递归来优化
 */
public class ClimbingStairs_196 {
	public int climbStairs(int n) {
		int[] dp=new int[n+1];
		dp[1]=1;
		dp[0]=1;
		for(int i=2;i<=n;i++)
		{
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
}
