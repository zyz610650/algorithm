package zyz.algorithm.array.easy;

/**
 * @author zyz
 * @title: 删除有序数组中的重复项
 * @seq: 26
 * @address: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @idea:
 *   吉大小绿书思路
 */
public class RemoveDuplicatesfromSortedArray_38 {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int k=0;
        for(int i=1;i<n;i++)
        {
            if(nums[i]==nums[i-1]) k++;
            else nums[i-k]=nums[i];
        }
        return n-k;
    }

    //双指针也可
    public int removeDuplicates1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }


}
