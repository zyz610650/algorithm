package zyz.algorithm.array.medium;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 跳跃游戏 II
 * @seq: 45
 * @address: https://leetcode-cn.com/problems/jump-game-ii/
 * @idea:
 */
public class JumpGameII_45 {
    public static void main(String[] args) {
       int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];

        for(int i=0;i<n;i++)
        {
            for(int j=1;j<=nums[i];j++)
            {
                int index=j+i;
                if(index<n)
                 dp[index]=dp[index]==0?dp[i]+1:Math.min(dp[index],dp[i]+1);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}
