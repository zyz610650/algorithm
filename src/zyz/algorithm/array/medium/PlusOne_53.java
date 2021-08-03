package zyz.algorithm.array.medium;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 加一
 * @seq: 66
 * @address: https://leetcode-cn.com/problems/plus-one/
 * @idea:
 */
public class PlusOne_53 {
    public static void main(String[] args) {
       int[] digits = {9,9,9};
       plusOne(digits);
       System.out.println(Arrays.toString(digits));;
    }
    public static int[] plusOne(int[] digits) {
        int m=digits.length;
        int t=m-1;
        digits[t]++;
        while(digits[t]>9&&t>0)
        {
            digits[t]=digits[t]-10;
            digits[--t]++;
        }
        if(digits[0]<10) return digits;
        digits[0]=1;
        return digits;
    }
}
