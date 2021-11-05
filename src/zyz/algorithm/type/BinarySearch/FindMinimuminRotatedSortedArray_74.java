package zyz.algorithm.type.BinarySearch;

/**
 * @author zyz
 * @title: 寻找旋转排序数组中的最小值
 * @seq: 153
 * @address: https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @idea:
 */
public class FindMinimuminRotatedSortedArray_74 {



    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        int mid=0;
        while(low<high)
        {
            mid=low+(high-low)/2;
            if(nums[mid]>nums[high])
            {
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return nums[low];
    }
}
