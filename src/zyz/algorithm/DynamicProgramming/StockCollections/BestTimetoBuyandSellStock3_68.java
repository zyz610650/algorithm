package zyz.algorithm.DynamicProgramming.StockCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 买卖股票的最佳时机 III
 * @seq: 123
 * @address: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * @idea:
 */
public class BestTimetoBuyandSellStock3_68 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};

        System.out.println(maxProfit2(prices));
    }
    static List<Integer> list=new ArrayList<>();

    //这个是错误思路
    public static int maxProfit(int[] prices) {
        int n=prices.length;
        if(n<1) return 0;
        dfs(0,n-1,prices);
        Integer[] arr=list.toArray(new Integer[0]);
        Arrays.sort(arr);
        if(arr.length<=1) return arr[arr.length-1];
        return arr[arr.length-1]+arr[arr.length-2];
    }
    public static void dfs(int low,int high,int[] prices)
    {
        if(low>=high) return;
        int left=low+1,right=0;
        int min=low;
        int ans=0;
        for(;left<=high;left++)
        {
            if(prices[left]<prices[min])
            {
                min=left;
            }else{
                if(prices[left]-prices[min]>ans)
                {
                    right=left;
                    ans=prices[left]-prices[min];
                }
            }
        }
        if(ans!=0) {
            list.add(ans);
            dfs(low,min,prices);
            dfs(right,high,prices);
        }
    }
//        3,3,5,0,0,4,3,1
//        思路: 记录最大和最小利润的下标,然后这时候可能分成两个区间 递归继续寻找 比如这个
//        3,3,5    0,0,4      3,1
//        找到0,0,4  再分别从 3,3,5  和  3,1找 记录每次分区后找到的最大利润 存到List,然后排序之类去最后两个


//    一天结束时，可能有持股、可能未持股、可能卖出过1次、可能卖出过2次、也可能未卖出过
//
//    所以定义状态转移数组dp[天数][当前是否持股][卖出的次数]
    //这里dp里存的不是每天的净利润，而记录的是只有当进行卖出后才作为利润进行记录
    public static int maxProfit1(int[] prices)
    {
        int[][][] dp=new int[prices.length][2][3];
        int n=prices.length;
        dp[0][0][1] = Integer.MIN_VALUE/2;
        dp[0][0][2] = Integer.MIN_VALUE/2;
        dp[0][1][1]=Integer.MIN_VALUE/2;
        dp[0][1][2]=Integer.MIN_VALUE/2;
        dp[0][1][0]=-prices[0];

        for (int i=1;i<prices.length;i++)
        {

            //未持股 卖1次
            dp[i][0][1]=Math.max(dp[i-1][0][1],dp[i-1][1][0]+prices[i]);
            //为持股 卖2次
            dp[i][0][2]=Math.max(dp[i-1][0][2],dp[i-1][1][1]+prices[i]);

            //持股 卖0次
            dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][0][0]-prices[i]);
            //持股 卖1次
            dp[i][1][1]=Math.max(dp[i-1][1][1],dp[i-1][0][1]-prices[i]);
        }
        int ans=0;
        ans=Math.max(dp[n-1][0][1],dp[n-1][0][2]);
        ans=Math.max(ans,dp[n-1][1][1]);
        ans=Math.max(ans,0);
        return ans;
    }

    // 这个思路其实和上面差不多,上面的数组替换成动态数组来做和这个差不多 但能节省空间
    public static int maxProfit2(int[] prices)
    {
        int n=prices.length;
       int buy1=-prices[0],sell1=0,buy2=-prices[0],sell2=0;

       for (int i=1;i<n;i++)
       {
           buy1=Math.max(buy1,-prices[i]);
           sell1=Math.max(sell1,prices[i]+buy1);
           buy2=Math.max(buy2,sell1-prices[i]);
           sell2=Math.max(sell2,buy2+prices[i]);
       }
       return sell2;
    }

    public int maxProfit3(int[] prices)
    {
        int n=prices.length;
        int[][][] dp=new int[n][3][2];
        dp[0][0][0]=0;
        dp[0][0][1]=-prices[0];
        dp[0][1][0]=Integer.MIN_VALUE/2;
        dp[0][1][1]=Integer.MIN_VALUE/2;
        dp[0][2][0]=Integer.MIN_VALUE/2;
        dp[0][2][1]=Integer.MIN_VALUE/2;
        for (int i=1;i<n;i++)
        {
            dp[i][0][1]=Math.max(dp[i-1][0][1],dp[i-1][0][0]-prices[i]);
            dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][0][1]+prices[i]);
            dp[i][1][1]=Math.max(dp[i-1][1][1],dp[i-1][1][0]-prices[i]);
            dp[i][2][0]=Math.max(dp[i-1][2][0],dp[i-1][1][1]+prices[i]);

        }
        int ans=0;
        ans=Math.max(dp[n-1][1][0],dp[n-1][2][0]);
        ans=Math.max(ans,dp[n-1][1][1]);
        ans=Math.max(ans,0);
        return ans;
    }
}

