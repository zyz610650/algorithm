package zyz.algorithm.array.medium;

/**
 * @author zyz
 * @title: 搜索旋转排序数组 II
 * @seq: 81
 * @address: https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * @idea:
 */
public class SearchinRotatedSortedArray2_61 {
    public boolean search(int[] nums, int target) {
        int low=0,high=nums.length-1,mid;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(nums[mid]==target) return true;
            if(nums[mid]==nums[low]&&nums[mid]==nums[high])
            {
                low++;
                high--;
            } else if(nums[mid]>=nums[low]){ //左半边有序  有序不一定代表target在这个区间 也有可能在无序期间
                if(target<nums[mid]&&nums[low]<=target)
                {
                    high=mid-1;
                }else {
                    low=mid+1;
                }
            }else{
                if(mid+1<=high&&target>=nums[mid+1]&&nums[high]>=target)
                {
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }

        }
        return false;
    }

}
