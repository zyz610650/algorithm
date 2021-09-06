package zyz.algorithm.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 汇总区间
 * @seq: 228
 * @address: https://leetcode-cn.com/problems/summary-ranges/
 * @idea:
 */
public class SummaryRanges_95 {

    public static void main(String[] args) {
       int[] nums = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(nums));
    }
    public static List<String> summaryRanges(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<String> list=new ArrayList<>();
        if(n==0) return list;
        StringBuilder sb=new StringBuilder();
        sb.append(nums[0]);
        int tmp=0;
        for(int i=1;i<n;i++)
        {
            if(i!=n-1&&(nums[i]==nums[i-1]+1||nums[i]==nums[i-1])) continue;

            if(i!=n-1&&i!=tmp+1&&sb.length()!=0) sb.append("->");
            if(i!=tmp+1) sb.append(nums[i-1]);
            list.add(sb.toString());
            sb=new StringBuilder();
            sb.append(nums[i]);
            tmp=i;

        }
        list.add(sb.toString());
        return list;
    }
}
