package zyz.algorithm.hot.hot100;

/**
 * @author zyz
 * @title: 目标和
 * @seq: 494
 * @address: https://leetcode-cn.com/problems/target-sum/
 * @idea:
 *   https://zhuanlan.zhihu.com/p/93857890
 */


public class TargetSum_217 {

	public static void main (String[] args) {
		int[] nums = {1,1,1,1,1};
	    int target = 3;
		System.out.println (findTargetSumWays (nums,target));
//[1, 0, 0, 0]
//[1, 1, 0, 0]
//[1, 3, 1, 0]
//[1, 9, 5, 1]
//[1, 30, 20, 6]

	}

	public static int findTargetSumWays(int[] nums, int target) {
		int n=nums.length;
		int sum=0;
		for(int num:nums) sum+=num;
		if(((target+sum)&1)==1) return 0;
		if(sum<Math.abs(target)) return 0;
		int s=(target+sum)>>1;

		int[] dp=new int[s+1];
		dp[0]=1;
		for(int i=0;i<n;i++)
		{
			// 注意这得是 j>=nums[i] 否则对于
			for(int j=s;j>=nums[i];j--)
			{
				//   if(j-nums[i]>=0) dp[j]+=dp[j-nums[i]];
				dp[j]+=dp[j-nums[i]];

			}

		}

		return dp[s];
	}
	/**
	 * 回溯
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int findTargetSumWays1(int[] nums, int target) {
		int n=nums.length;
		int[] sufix =new int[n];
		sufix[n-1]=0;
		for(int i=n-2;i>=0;i--)
		{
			sufix[i]=nums[i+1]+sufix[i+1];
		}

		return dfs(nums,sufix,target,0,n);
	}

	public static int dfs(int[] nums, int[] sufix ,int target,int index,int n)
	{
		if(index==n&&target==0) return 1;
		if(index==n&& target!=0) return 0;
		int res=0;

		if(Math.abs(target+nums[index])<=sufix[index])
			res+=dfs(nums,sufix,target+nums[index],index+1,n);

		if(Math.abs(target-nums[index])<=sufix[index])
			res+=dfs(nums,sufix,target-nums[index],index+1,n);
		return res;
	}

}
