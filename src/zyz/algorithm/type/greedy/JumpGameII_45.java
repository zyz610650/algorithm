package zyz.algorithm.type.greedy;

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

    //贪心算法 该思路也可以说是动态规划的思想
    public static int jump(int[] nums) {
        int end=0,start=0,n=nums.length,maxStep=0,step=0;
        for(int i=0;i<n-1;i++)
        {

            maxStep=Math.max(maxStep,i+nums[i]);
            if(i==end)
            {
                step++;
                end=maxStep;
            }
        }
        return step;
    }
    //动态规划 O(n^2) 不好
    public static int jump2(int[] nums) {
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
