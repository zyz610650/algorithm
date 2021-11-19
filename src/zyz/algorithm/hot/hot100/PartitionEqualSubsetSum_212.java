package zyz.algorithm.hot.hot100;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 分割等和子集
 * @seq: 416
 * @address: https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * @idea:
 * 0 1背包
 */
public class PartitionEqualSubsetSum_212 {

	public static void main (String[] args) {

		int[] nums={3,3,3,4,5};


	}
	public boolean canPartition(int[] nums) {
		int sum=0;
		int n=nums.length;
		Arrays.sort(nums);
		for(int i=0;i<n;i++)
		{
			sum+=nums[i];
		}
		if(sum%2!=0) return false;
		sum/=2;
		int[] dp=new int[sum+1];
		for(int i=0;i<n;i++)
		{
			for(int j=sum;j>=0;j--)
			{
				if(j>=nums[i])
					dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
				else break;
			}
		}
		if(dp[sum]==sum) return true;
		return false;

	}
}
