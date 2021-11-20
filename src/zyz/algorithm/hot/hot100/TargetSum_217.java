package zyz.algorithm.hot.hot100;

/**
 * @author: @zyz
 */
public class TargetSum_217 {

	public static void main (String[] args) {
		int[] nums = {1,1,1,1,1};
	    int target = 3;
		System.out.println (findTargetSumWays (nums,target));
	}

	/**
	 * 回溯
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int findTargetSumWays(int[] nums, int target) {
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
