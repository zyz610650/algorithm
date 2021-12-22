package zyz.algorithm.hot.jzoffer;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 剑指 Offer 60. n个骰子的点数
 * @seq: 60
 * @address: https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 * @idea:
 *
 */
public class T60_290 {
	public double[] dicesProbability(int n) {
		double[] dp=new double[6];
		Arrays.fill(dp,1.0/6.0);
		for(int i=2;i<=n;i++)
		{
			double[] tmp=new double[5*i+1];
			for(int j=0;j<dp.length;j++)
			{
				for(int k=0;k<6;k++)
				{
					tmp[j+k]+=dp[j]/6.0;
				}
			}
			dp=tmp;
		}

		return dp;
	}
}
