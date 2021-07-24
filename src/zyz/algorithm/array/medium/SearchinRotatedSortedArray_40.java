package zyz.algorithm.array.medium;

import jdk.nashorn.internal.ir.Block;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 搜索旋转排序数组
 * @seq: 33
 * @address: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @idea:
 */
public class SearchinRotatedSortedArray_40 {

    public static void main(String[] args) {
       int[] nums = {4,5,6,7,0,1,2};
        int target =3;
        System.out.println( search(nums,target));
    }
    public static int search(int[] nums, int target) {

        int low=0,high=nums.length-1;
        int mid=0;
        while(low<=high)
        {
            mid=(low+high)/2;
            if(nums[mid]==target) return mid;
            if(nums[0]<nums[mid])
            {
                if(target<nums[mid]&&target>=nums[low])
                {
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(target>=nums[mid+1]&&target<nums[high])
                {
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;


    }



}
