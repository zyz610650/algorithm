package zyz.algorithm.DynamicProgramming.StockCollections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

/**
 *
 *
 * @author zyz
 * @title: 买卖股票的最佳时机
 * @seq: 121
 * @address: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @idea:
 *
 *   炒股合集专题: https://leetcode-cn.com/circle/article/qiAgHn/
 *
 *
 *   考虑最大子序和的思路来做
 *   0.判断是否是DP：
 *      1>根据1: i-1天可以通过 下一天持有或不持有两种操作到达第i天的状态
 *      2>根据2: 第i-1天想要盈利则则i-1天卖出的利润一定是>=0的,否则第
 *      i-1天没有或的利润,这时候 这时候利润为dp[i-1]=0,第i-1天再买进就行,如果i-1天之前买进，
 *      到了第i-1天处于亏损状态了，这时候第i-1天买进 即吵了低，又躲避了大跌
 *      那么第i天可以根据前一天的利润得到最长多少天能得到的正向利润
 *      如果dp[i-1]+prices[i]-prices[i-1]< 0 说明第i天的股价比前i-1天 任何时候都低，可以抄底！！！
 *
 *   1、dp[i] 连续i天所能获得的正利润 若设dp[i]为第i天所能获得的最大利润是不对的
 *   2.dp[i]=max{dp[i-1]+prices[i]-prices[i-1],0}
 *   3.初始值
 *
 *   看了力扣的题解觉得我这才是DP思路
 */
public class BestTimetoBuyAndSellStock1_16 {
    public static void main(String[] args) {
        int [] princes={7,1,5,3,6,4};


        System.out.println(maxProfit3(princes));
    }
    //自己的DP
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
    //这个方法好
    public static int maxProfit3(int[] prices)
    {
       int n=prices.length;
       int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
       int ans=0;

        for (int i=0;i<n;i++)
        {
            if (prices[i]<min)
            {
                min=prices[i];
            }else {
                ans=Math.max(ans,prices[i]-min);
            }
        }
        return ans;
    }
    //单调栈
    public static int maxProfit1(int[] prices) {
        Deque<Integer> stack=new ArrayDeque<>();
        int n=prices.length;
       if (n==1) return 0;
        int[] arr=new int[n+1];
        System.arraycopy(prices,0,arr,0,n);
        int ans=0;
        System.out.println(Arrays.toString(arr));
       for (int i=0;i<n+1;i++)
       {
           while (!stack.isEmpty()&&arr[stack.peekLast()]>arr[i])
           {

               int t=stack.pollLast();
               if (stack.isEmpty()) break;
               int min=stack.getFirst();
               ans=Math.max(ans,arr[t]-arr[min]);
           }
           stack.addLast(i);
       }
//       if (!stack.isEmpty())
//       {
//           System.out.println(stack.getLast()+" "+stack.getFirst());
//           ans=Math.min(ans,prices[stack.getLast()]-prices[stack.getFirst()]);
//       }
           return ans;


    }

    //官方的DP
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    public int maxProfit4(int[] prices)
    {
        int n=prices.length;
        int[][] dp=new int[n][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i=1;i<n;i++)
        {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(-prices[i],dp[i-1][1]);
        }
        return dp[n-1][0];
    }

    // 滚动数组优化
    public int maxProfit5(int[] prices)
    {
        int n=prices.length;

        int profit0 =0,profit1 =-prices[0];
        for (int i=1;i<n;i++)
        {
            profit0=Math.max(profit0,profit1+prices[i]);
            profit0=Math.max(-prices[i],profit1);
        }
        return profit0;
    }
}
