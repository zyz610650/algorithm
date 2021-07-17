package zyz.algorithm.array.DynamicProgramming.medium;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 打家劫舍 II
 * @seq: 213
 * @address: https://leetcode-cn.com/problems/house-robber-ii/
 * @idea:
 */
public class HouseRobberII_33 {

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        if (nums.length==1)
        {
            return nums[0];
        }
        if (nums.length==2) return Math.max(nums[0],nums[1]);
        return Math.max(robRange(nums,0,nums.length-1),robRange(nums,1,nums.length));
    }

    public static int robRange(int[] nums,int start,int end)
    {

        int f1=nums[start],f2=Math.max(nums[start+1],f1);

        int tmp;
        for (int i=start+2;i<end;i++)
        {
            tmp=f2;
            f2=Math.max(f1+nums[i],f2);
            f1=tmp;
        }
        return f2;
    }
}
