package zyz.algorithm.hot.hot100;

/**
 * @author zyz
 * @title: 戳气球
 * @seq: 312
 * @address: https://leetcode-cn.com/problems/burst-balloons/
 * @idea:
 *  这个题特别好 尤其是降低时间复杂度的思想
 *  https://www.cnblogs.com/niuyourou/p/11964842.html
 */
public class BurstBalloons_206 {
	public static void main (String[] args) {
		int[] nums = {3,1,5,8};
//		System.out.println (maxCoins (nums));
	}
	// 分治
	public  int maxCoins(int[] nums) {
		if(nums==null) return 0;
		int n=nums.length;
		int[][] cache=new int[n+2][n+2];
		int[] arr=new int[n+2];
		System.arraycopy(nums,0,arr,1,n);
		n=n+2;
		arr[0]=1;
		arr[n-1]=1;
		return dfs(arr,0,n-1,cache);

	}
	public  int dfs(int[] nums,int begin,int end,int[][] cache)
	{
		if(begin==end-1) return 0;
		if(cache[begin][end]!=0) return cache[begin][end];
		int max=0,tmp;
		for(int i=begin+1;i<end;i++)
		{
			tmp=dfs(nums,begin,i,cache)+dfs(nums,i,end,cache)+nums[begin]*nums[i]*nums[end];
			max=Math.max(max,tmp);
		}
		cache[begin][end]=max;
		return max;
	}

	//dp
	public int maxCoins1(int[] nums) {
		int n=nums.length;
		int[] arr=new int[n+2];
		System.arraycopy(nums,0,arr,1,n);
		n=n+2;
		arr[0]=1;
		arr[n-1]=1;
		int[][] dp=new int[n][n];
		for(int i=n-3;i>=0;i--)
		{
			for(int j=i+2;j<n;j++)
			{
				for(int k=i+1;k<j;k++)
				{
					dp[i][j]=Math.max(dp[i][k]+dp[k][j]+arr[i]*arr[k]*arr[j],dp[i][j]);
				}
			}
		}
		return dp[0][n-1];
	}
}
