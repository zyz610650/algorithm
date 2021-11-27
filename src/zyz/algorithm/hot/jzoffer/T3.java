package zyz.algorithm.hot.jzoffer;

/**
 * @author: @zyz
 */
public class T3 {
	public int findRepeatNumber(int[] nums) {
		Arrays.sort(nums);
		int n=nums.length;
		for(int i=1;i<n;i++)
		{
			if(nums[i]==nums[i-1]) return nums[i];
		}
		return -1;
	}
}
