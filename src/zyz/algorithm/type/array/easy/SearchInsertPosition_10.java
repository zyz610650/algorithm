package zyz.algorithm.type.array.easy;

/**
 * @author zyz
 * @title: 搜索插入位置
 * @seq: 10
 * @address: https://leetcode-cn.com/problems/search-insert-position/
 * @idea:
 *  二分需要考虑  high=mid-1; low=mid+1; / high=mid; low=mid;
 *   while(low<=high)
 *   return right /right+1问题
 *   直接记
 *   while (left <= right)
 *   high=mid-1; low=mid+1;
 *   return right + 1;//得到的就是元素不存在时的插入位置 时间复杂度为0（log2n）
 *
 */
public class SearchInsertPosition_10 {

    public int searchInsert(int[] nums, int target) {
        int low=0,high=nums.length-1;
        int mid=0;
        while(low<high)
        {
            // 为了防止 left + right 整形溢出，写成这样
            mid = low + (high - low) / 2;


            if (nums[mid]<target) low=mid+1;
            else if (nums[mid]>target) high=mid-1;
            else return mid;
        }
        return target<=nums[low]?low:low+1;
    }
}
