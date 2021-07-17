package zyz.algorithm.array.DynamicProgramming.medium;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 打家劫舍
 * @seq: 198
 * @address: https://leetcode-cn.com/problems/house-robber/
 * @idea:
 */
public class HouseRobber_32 {

    public static void main(String[] args) {
        int[] nums={2,1,3,9};
        System.out.println(rob1(nums));
    }
    //我这个dp[i] 的含义是 偷窃第i间房的同时，之前能偷窃的所有的房子的最大值
    //rob1的dp是第i间房能够偷窃到的最高金额 dp[i]除了包含之前能偷窃的所有的房子的最大值 还可能存储自己不能包含的值
    // 还可滚动数组
    //该题dfs+剪枝也可以
    public static int rob(int[] nums) {
        int n=nums.length;
        if(nums.length==1) return nums[0];
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=nums[1];
        int max=Math.max(dp[0],dp[1]);
        for(int i=2;i<n;i++)
        {
            for (int j=2;j<=i;j++)
            {
                dp[i]=Math.max(dp[i],dp[i-j]+nums[i]);
            }
            max=Math.max(dp[i],max);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    public static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[length - 1];
    }

}
