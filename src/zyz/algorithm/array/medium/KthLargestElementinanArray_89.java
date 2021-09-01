package zyz.algorithm.array.medium;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 数组中的第K个最大元素
 * @seq: 215
 * @address: https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @idea:
 */
public class KthLargestElementinanArray_89 {

    public static void main(String[] args) {
        int[] nums={3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums,k));
    }
    public static int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        int t=1;
        return nums[nums.length-k];
//        for(int i=nums.length-2;i>=0;i--)
//        {
//            if(nums[i]!=nums[i+1]) t++;
//            if(t==k) return nums[i];
//        }
//        return -1;
    }
}
