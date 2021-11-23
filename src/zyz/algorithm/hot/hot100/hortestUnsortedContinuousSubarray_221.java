package zyz.algorithm.hot.hot100;

/**
 * @author zyz
 * @title: 课程表
 * @seq: 581
 * @address: https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * @idea:
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/si-lu-qing-xi-ming-liao-kan-bu-dong-bu-cun-zai-de-/
 */
public class hortestUnsortedContinuousSubarray_221 {

	//  right 下标右边的元素是有序全大于nums[right]
	// left 下标左边的元素是有序全小于nums[left]
	public int findUnsortedSubarray(int[] nums) {
		int n=nums.length;
		int min=nums[n-1];
		int max=nums[0];
		int left=0,right=-1;
		for(int i=0;i<n;i++)
		{
			if(nums[i]>=max)
			{
				max=nums[i];
			}else{
				right=i;
			}

			if(nums[n-i-1]<=min)
			{
				min=nums[n-i-1];
			}else{
				left=n-i-1;
			}
		}
		return right-left+1;
	}
}
