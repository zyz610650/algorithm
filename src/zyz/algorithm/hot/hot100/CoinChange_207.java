package zyz.algorithm.hot.hot100;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 零钱兑换
 * @seq: 322
 * @address: https://leetcode-cn.com/problems/coin-change/
 * @idea:
 */
public class CoinChange_207 {

	public int coinChange(int[] coins, int amount) {
		int[] dp=new int[amount+1];
		Arrays.fill(dp,amount+1);
		dp[0]=0;
		for(int i=1;i<=amount;i++)
		{
			for(int j=0;j<coins.length;j++)
			{
				if(coins[j]>i) continue;
				dp[i]=Math.min(dp[i-coins[j]]+1,dp[i]);
			}
		}
		return dp[amount]==amount+1?-1:dp[amount];
	}
}
