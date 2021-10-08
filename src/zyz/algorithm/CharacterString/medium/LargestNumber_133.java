package zyz.algorithm.CharacterString.medium;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 最大数
 * @seq: 179
 * @address: https://leetcode-cn.com/problems/largest-number/
 * @idea:
 */
public class LargestNumber_133 {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
    public  static String largestNumber(int[] nums) {
        int n=nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = "" + nums[i];

        Arrays.sort(ss,(x, y)->{

            return (y+x).compareTo(x+y);
        });

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ss.length;i++)
            sb.append(ss[i]);
        return sb.toString();
    }
}
