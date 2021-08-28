package zyz.algorithm.DynamicProgramming.StockCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 买卖股票的最佳时机 III
 * @seq: 188
 * @address: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * @idea:
 *  注意这里 K>N/2时 该题就成了可以买卖无数次的题型了
 */
public class BestTimetoBuyandSellStock4_81 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};

        System.out.println(maxProfit2(2,prices));
    }

//dp
    public static int maxProfit1(int k,int[] prices)
    {
        int n=prices.length;
        if (n==0) return  0;
        int[][][] dp=new int[n][k+1][2];
        dp[0][0][0]=0;
        dp[0][0][1]=-prices[0];
        for (int i=1;i<=k;i++)
        {
            dp[0][i][0]=Integer.MIN_VALUE/2;
            dp[0][i][1]=Integer.MIN_VALUE/2;
        }
        int ans=0;
        for (int i=1;i<n;i++)
        {
            for (int j=0;j<=k;j++)
            {
                if (j==0)
                {
                    dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j][0]-prices[i]);
                    dp[i][j][0]=dp[i-1][j][0];
                    continue;
                }
                dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j][0]-prices[i]);
                dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j-1][1]+prices[i]);
                ans=Math.max(ans,dp[i][j][0]);
            }

        }


        return ans;
    }
    // 滚动数组优化
    public static int maxProfit2(int k,int[] prices)
    {
        int n=prices.length;
        if (n==0) return  0;
        int[][][] dp=new int[n][k+1][2];
        int[] buy=new int[k+1]; //未持有
        int[] sell=new int[k+1];//持有
        buy[0]=0;
        sell[0]=-prices[0];
        for (int i=1;i<=k;i++)
        {
            buy[i]=Integer.MIN_VALUE/2;
            sell[i]=Integer.MIN_VALUE/2;
        }
        int ans=0;
        for (int i=1;i<n;i++)
        {
            for (int j=0;j<=k;j++)
            {
                if (j==0)
                {
                    sell[j]=Math.max(sell[j],buy[j]-prices[i]);
                    continue;
                }
                sell[j]=Math.max(sell[j],buy[j]-prices[i]);
                buy[j]=Math.max(buy[j],sell[j-1]+prices[i]);
                ans=Math.max(ans,buy[j]);
            }

        }


        return ans;
    }
}

