package zyz.algorithm.type.DynamicProgramming.StockCollections;

import zyz.algorithm.utils.Utils;

/**
 *
 *
 * @author zyz
 * @title: 买卖股票的最佳时机
 * @seq: 309
 * @address: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @idea:
 *
 */
public class BestTimetoBuyAndSellStock5_82 {
    public static void main(String[] args) {
        int [] princes={1,2,3,0,2};


        System.out.println(maxProfit4(princes));
    }



    public static int maxProfit4(int[] prices)
    {
        int n=prices.length;
        int[][] dp=new int[n][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[1][1]=Math.max(dp[0][1],-prices[1]);
        for (int i=1;i<n;i++)
        {

            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            if (i!=1)
                dp[i][1]=Math.max(dp[i-2][0]-prices[i],dp[i-1][1]);
        }
        Utils.print2Arr(dp);
        return dp[n-1][0];
    }

    // 滚动数组优化

}
