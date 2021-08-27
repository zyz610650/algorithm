package zyz.algorithm.DynamicProgramming.StockCollections;

/**
 * @author zyz
 * @title: 买卖股票的最佳时机 II
 * @seq: 122
 * @address: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @idea:
 */
public class BestTimetoBuyandSellStock2_67 {
    public int maxProfit(int[] prices) {
        int ans=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>prices[i-1]) ans+=prices[i]-prices[i-1];
        }
        return ans;
    }


    public int maxProfit1(int[] prices)
    {
        int n=prices.length;
        int[][] dp=new int[n][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i=1;i<n;i++)
        {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
        return dp[n-1][0];
    }

    // 滚动数组优化
    public int maxProfit2(int[] prices)
    {
        int n=prices.length;

        int profit0 =0,profit1 =-prices[0];
        for (int i=1;i<n;i++)
        {
            profit0=Math.max(profit0,profit1+prices[i]);
            profit1=Math.max(profit0-prices[i],profit1);
        }
        return profit0;
    }
}
