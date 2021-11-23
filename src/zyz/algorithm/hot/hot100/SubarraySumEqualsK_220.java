package zyz.algorithm.hot.hot100;

import zyz.algorithm.utils.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyz
 * @title: 和为 K 的子数组
 * @seq: 560
 * @address: https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @idea:
 */
public class SubarraySumEqualsK_220 {

	public static void main (String[] args) {
		int[] nums = {1,2,3};
		int k = 3;
		System.out.println (subarraySum (nums,k));
	}

	public static int subarraySum(int[] nums, int k) {
		int n=nums.length;
		Map <Integer,Integer> map=new HashMap <> ();
		int sum=0;
		int cnt=0;
		map.put(0,1);
		for(int i=0;i<n;i++)
		{
			sum+=nums[i];
			// 换成这两行代码 效率提升
//			if(map.containsKey(sum-k))
//				cnt+=map.get(sum-k);
			cnt+=map.getOrDefault(sum-k,0);
			map.put(sum,map.getOrDefault(sum,0)+1);

		}

		return cnt;


	}

	/**
	 * 超时
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int subarraySum1(int[] nums, int k) {
		int n=nums.length;

		int[][] dp=new int[n+1][n+1];
		int ans=0;
		for(int i=1;i<=n;i++)
		{
			dp[i][i]=nums[i-1];
			for(int j=i+1;j<=n;j++)
			{
				dp[i][j]=dp[i][j-1]+nums[j-1];
				if(dp[i][j]==k) ans++;
			}
		}
		Utils.print2Arr (dp);
		return ans;


	}
}
