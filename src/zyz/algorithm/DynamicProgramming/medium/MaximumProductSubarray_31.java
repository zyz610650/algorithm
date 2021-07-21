package zyz.algorithm.DynamicProgramming.medium;

/**
 * @author zyz
 * @title: 乘积最大子数组
 * @seq: 152
 * @address: https://leetcode-cn.com/problems/maximum-product-subarray/
 * @idea:
 *  min存储到目前为止连续子序列乘积最小值
 *  max 激励到目前位置连续子序列成绩最大值，
 *  这样当遇到一个负数时，min*nums[i] 就表示当目前为止连续子序列成绩最大值
 *  max*nums[i] 就表示当目前为止连续子序列成绩最小值
 *  但这时候可能会存在之前部分的子序列的值比现在的还大，所以用imax存储中间子序列的最大值，因为后面可能会×负数，就比
 *  现在这小了，也有可能*负数再×负数就又比它大了，所以弄个Imax不段存储目前为止子序列最大值
 */
public class MaximumProductSubarray_31 {
    public static void main(String[] args) {

        int[] nums={-2,0,-1};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {

        int max=1,min=1,imax=Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++)
        {
            if (nums[i]<0)
            {
                int tmp=max;
                max=min;
                min=tmp;
            }
           min=Math.min(min*nums[i],nums[i]);
           max=Math.max(max*nums[i],nums[i]);
            imax=Math.max(max,imax);
        }
       return imax;
    }
}
