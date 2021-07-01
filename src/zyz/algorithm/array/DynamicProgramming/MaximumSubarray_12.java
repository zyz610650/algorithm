package zyz.algorithm.array.DynamicProgramming;

/**
 * @author zyz
 * @title: 最大子序和
 * @seq: 12
 * @address: https://leetcode-cn.com/problems/maximum-subarray/$
 * @idea:
 *  动态规划
 */
public class MaximumSubarray_12 {
    public int maxSubArray(int[] nums) {

        int[] m=new int[nums.length];
        m[0]=nums[0];
        int max=m[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]+m[i-1]>nums[i]) m[i]=nums[i]+m[i-1];
            else m[i]=nums[i];
            if(max<m[i]) max=m[i];
        }
        return max;
    }

}
