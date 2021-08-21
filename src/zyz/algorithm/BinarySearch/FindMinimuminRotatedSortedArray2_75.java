package zyz.algorithm.BinarySearch;

/**
 * @author zyz
 * @title: 寻找旋转排序数组中的最小值 II
 * @seq: 154
 * @address: https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * @idea:
 */
public class FindMinimuminRotatedSortedArray2_75 {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        int mid=0;
        while(low<high)
        {
            mid=low+(high-low)/2;
            if(nums[mid]>nums[high])
            {
                low=mid+1;
            }else if(nums[mid]<nums[high]){
                high=mid;
            }else{
                high--;
            }
        }
        return nums[low];
    }
}
