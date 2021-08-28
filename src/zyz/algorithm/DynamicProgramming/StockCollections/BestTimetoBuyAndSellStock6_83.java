package zyz.algorithm.DynamicProgramming.StockCollections;

import zyz.algorithm.utils.Utils;

/**
 *
 *
 * @author zyz
 * @title: 买卖股票的最佳时机
 * @seq: 309
 * @address: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @idea:
 *
 */
public class BestTimetoBuyAndSellStock6_83 {
    public static void main(String[] args) {
        int [] princes={1,2,3,0,2};


        System.out.println(maxProfit4(princes,2));
    }



    public static int maxProfit4(int[] prices,int fee)
    {
        int n=prices.length;
        int[][] dp=new int[n][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i=1;i<n;i++)
        {

            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1]=Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
//        Utils.print2Arr(dp);
        return dp[n-1][0];
    }

    // 滚动数组优化

}
