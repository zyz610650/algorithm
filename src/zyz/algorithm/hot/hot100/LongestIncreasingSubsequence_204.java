package zyz.algorithm.hot.hot100;

/**
 * @author zyz
 * @title: 课程表
 * @seq: 207
 * @address: https://leetcode-cn.com/problems/course-schedule/
 * @idea:
 */
public class LongestIncreasingSubsequence_204 {
	public static void main (String[] args) {
	int[] nums={3,10,9,101,2,5,7,18};
		System.out.println (lengthOfLIS (nums));
	}

	public static int lengthOfLIS(int[] nums) {
		int[] tails = new int[nums.length];
		int res = 0;
		for(int num : nums) {
			int i = 0, j = res;
			while(i < j) {
				int m = (i + j) / 2;
				if(tails[m] < num) i = m + 1;
				else j = m;
			}
			tails[i] = num;
			if(res == j) res++;
		}
		return res;
	}



	public int lengthOfLIS1(int[] nums) {
		int n=nums.length;
		int[] dp=new int[n+1];
		int max=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(nums[j]<nums[i])
					dp[i]=Math.max(dp[i],dp[j]+1);
			}
			max=Math.max(max,dp[i]);
		}

		return max+1;
	}
}
