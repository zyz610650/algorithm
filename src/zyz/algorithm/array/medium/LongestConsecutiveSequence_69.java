package zyz.algorithm.array.medium;

import java.util.HashSet;
import java.util.Set;
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
        Set<Integer> set=new HashSet<>();
        for(int value:set)
        {

        }
    }
    //方法1 利用TreeSet的性质
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
            }
            pre=value;
        }
        return max=Math.max(ans,max);

    }

    //方法2  每个变量最多遍历2边 所以时间复杂读也是O(n) 2n的时间复杂度也是O(n)
    public int longestConsecutive1(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++) set.add(nums[i]);
        int n=0;
        int cnt=0;
        for(int value:set)
        {
            if(!set.contains(value-1))
            {
                cnt=1;
                while(set.contains(value+cnt)) cnt++;
                n=Math.max(n,cnt);
            }
        }
        return n;
    }
}
