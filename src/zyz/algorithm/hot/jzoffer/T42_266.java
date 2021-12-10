package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 39. 数组中出现次数超过一半的数字
 * @seq: 39
 * @address: https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * @idea:
 *
 */
public class T42_266 {

	public int maxSubArray(int[] nums) {
		int n=nums.length;
		int[] dp=new int[n+1];
		int max=Integer.MIN_VALUE;
		for(int i=1;i<=n;i++)
		{
			dp[i]=Math.max(nums[i-1],nums[i-1]+dp[i-1]);
			max=Math.max(dp[i],max);
		}
		return max;

	}
}
