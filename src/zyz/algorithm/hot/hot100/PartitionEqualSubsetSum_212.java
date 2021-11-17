package zyz.algorithm.hot.hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zyz
 * @title: 分割等和子集
 * @seq: 416
 * @address: https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * @idea:
 */
public class PartitionEqualSubsetSum_212 {

	public static void main (String[] args) {

		int[] nums={3,3,3,4,5};
		System.out.println (canPartition(nums));
	}
	public static boolean canPartition(int[] nums) {
		int sum=0;
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++)
		{
			sum+=nums[i];
		}
		if(sum%2!=0) return false;
		sum/=2;
		boolean[] dp=new boolean[sum+1];
		Set <Integer> set=new HashSet <> ();
		dp[0]=true;
		for(int i=1;i<=sum;i++)
		{
			for(int j=0;j<nums.length;j++)
			{
				if(i<nums[j]) break;
				if(set.contains(j)) continue;
				dp[i]=dp[i-nums[j]];
				if(dp[i])
				{
					set.add(j);
					break;
				}
			}
		}
		System.out.println (Arrays.toString (dp));
		System.out.println (set);
		return dp[sum];
	}
}
