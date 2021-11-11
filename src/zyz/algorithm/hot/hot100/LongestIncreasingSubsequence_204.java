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

	}

	/***
	 * 得会这个O(nlogn)的算法
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		int n=nums.length;
		int[] dp=new int[n+1];
		int l=0,h=0,res=0;
		int mid=0;
		for(int num:nums)
		{
			l=0;
			h=res;
			while(l<h)
			{
				mid=(l+h)>>1;
				if(dp[mid]<num) l=mid+1;
				else h=mid;
			}
			dp[h]=num;
			if(res==h) res++;
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
