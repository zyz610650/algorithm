package zyz.algorithm.type.array.medium;

/**
 * @author zyz
 * @title: 搜索旋转排序数组
 * @seq: 33
 * @address: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @idea:
 */
public class SearchinRotatedSortedArray_40 {

    public static void main(String[] args) {
       int[] nums = {3,1};
        int target =1;
        System.out.println( search(nums,target));
    }
    public static int search(int[] nums, int target) {

        int low=0,high=nums.length-1;
        int mid=0;
        while(low<=high)
        {
            mid=(low+high)/2;
            if(nums[mid]==target) return mid;
            if(nums[low]<=nums[mid])
            // if(nums[low]<=nums[mid]) 注意这是<=
            {
                if(target<nums[mid]&&target>=nums[low])
                {
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
//                if(mid<high&&target>=nums[mid+1]&&target<=nums[high])
                if(target>nums[mid]&&target<=nums[high])
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
///////////////////////////

