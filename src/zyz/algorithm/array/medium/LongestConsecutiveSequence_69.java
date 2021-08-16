package zyz.algorithm.array.medium;

import java.util.TreeSet;

/**
 * @author zyz
 * @title: 最长连续序列
 * @seq: 128
 * @address: https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @idea:
 */
public class LongestConsecutiveSequence_69 {

    public static void main(String[] args) {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();

        for(int i=0;i<nums.length;i++)
        {
            ts.add(nums[i]);

        }
        int ans=1;
        int pre=ts.first();
        int i=0;
        int max=1;
        for(int value:ts)
        {
            if(i==0) {
                i=1;
                continue;
            }
            if(value-pre==1)
            {
                ans++;
            }else
            {
                max=Math.max(ans,max);
                ans=1;
                i=0;
            }
            pre=value;
        }
        return max=Math.max(ans,max);

    }
}
