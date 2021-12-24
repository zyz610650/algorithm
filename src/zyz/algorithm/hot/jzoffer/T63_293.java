package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 63. 股票的最大利润
 * @seq: 63
 * @address: https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * @idea:
 *
 */
public class T63_293 {

	public int maxProfit(int[] prices) {
		if(prices.length==0) return 0;
		int min=prices[0];
		int max=0;
		for(int i=1;i<prices.length;i++)
		{
			max=Math.max(prices[i]-min,max);
			min=Math.min(min,prices[i]);
		}
		return max;
	}
}
