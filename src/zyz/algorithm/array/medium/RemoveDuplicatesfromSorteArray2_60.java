package zyz.algorithm.array.medium;

/**
 * @author zyz
 * @title: 删除有序数组中的重复项 II
 * @seq: 80
 * @address: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * @idea:  小绿书思路
 */
public class RemoveDuplicatesfromSorteArray2_60 {

    public int removeDuplicates(int[] nums) {
        int t=0;
        for(int i=2;i<nums.length;i++)
        {
            if(nums[i-2-t]==nums[i]) t++;
            else nums[i-t]=nums[i];
        }
        return nums.length-t;
    }
}
