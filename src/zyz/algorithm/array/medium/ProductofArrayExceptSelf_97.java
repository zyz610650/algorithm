package zyz.algorithm.array.medium;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 除自身以外数组的乘积
 * @seq: 238
 * @address: https://leetcode-cn.com/problems/product-of-array-except-self/
 * @idea:
 *
 *  1          1*2        1*2*3  1*2*3
 *        4*3*2*1     4*3*2      4*3    4
 *
 *                    1        1*2     1*2*3
 *        4*3*2    4*3         4
 */
public class ProductofArrayExceptSelf_97 {

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        int[] arr=productExceptSelf(nums);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] output=new int[n];
        int tmp=1;
        for(int i=0;i<n;i++)
        {
            output[i]=tmp;
            tmp=tmp*nums[i];
        }
        tmp=1;
        for(int i=n-1;i>=0;i--)
        {
            output[i]= output[i]*tmp;
            tmp=tmp*nums[i];
        }

        return output;
    }
}
