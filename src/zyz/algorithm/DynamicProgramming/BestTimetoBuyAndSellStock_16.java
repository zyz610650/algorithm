package zyz.algorithm.DynamicProgramming;

/**
 * @author zyz
 * @title: 买卖股票的最佳时机
 * @seq: 16
 * @address: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @idea:
 *   考虑最大子序和的思路来做
 *   0.判断是否是DP：
 *      1>根据1: i-1天可以通过 下一天持有或不持有两种操作到达第i天的状态
 *      2>根据2: 第i-1天的利润一定是>=0的，那么第i天可以根据前一天的利润得到最长多少天能得到的正向利润
 *      如果dp[i-1]+prices[i]-prices[i-1]< 0 说明第i天的股价比前i-1天 任何时候都低，可以抄底！！！
 *
 *   1、dp[i] 连续i天所能获得的正利润 若设dp[i]为第i天所能获得的最大利润是不对的
 *   2.dp[i]=max{dp[i-1]+prices[i]-prices[i-1],0}
 *   3.初始值
 *
 *   看了力扣的题解觉得我这才是DP思路
 */
public class BestTimetoBuyAndSellStock_16 {
    public static void main(String[] args) {
        int [] princes=new int[3];
       int k= princes.length;
    }

    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] dp=new int[n];
        int max=0;
        for(int i=1;i<n;i++)
        {
            dp[i]=Math.max(dp[i-1]+prices[i]-prices[i-1],0);
            max=Math.max(dp[i],max);
        }
        return max;
    }
}
