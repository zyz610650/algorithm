package zyz.algorithm.array.easy;

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
}
