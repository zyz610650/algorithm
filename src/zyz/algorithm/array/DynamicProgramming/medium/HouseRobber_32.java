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
        int[] nums={4,1,2,7,5,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {

        if(nums.length==1) return nums[0];
        int[] dp=new int[nums.length];
        int max=0;
        System.out.println(nums.length);
        for(int i=0;i<nums.length;i++)
        {
            dp[i]=nums[i];
            max=Math.max(dp[i],max);
        }
        //长度
        for(int i=2;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                if(j-i<0)
                    continue;
                dp[j]=Math.max(dp[j],dp[j-i]+nums[j]);
                max=Math.max(dp[j],max);
//                if(j+i>=nums.length) break;
            }
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
}
