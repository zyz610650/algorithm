package zyz.algorithm.type.sort;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 快速排序
 * @seq:
 * @address:
 * @idea:
 *
 * 交换排序的一种,从冒泡改进而来
 * 时间复杂度：
 * 最好：O(nlog2n)
 * 最坏： O(n^2)
 * 平均：O(nlog2n)
 * 空间复杂度 O(nlog2n)
 *
 * 稳定性：不稳定

 */
public class quickSort {

    public static void main(String[] args) {
        int array[] = {41,2,432,2,5435,12,2,3};
        sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

    }
    static void sort(int[] nums,int low,int high)
    {
        if (low>=high) return;
        int start=low,end=high;
        int key=nums[low];
        while (low<high)
        {
            while(nums[high]>=key&&high>low) high--;
            nums[low]=nums[high];
            while(nums[low]<=key&&high>low) low++;
            nums[high]=nums[low];
        }

        nums[low]=key;
        System.out.println(Arrays.toString(nums));
        sort(nums,start,low-1);
        sort(nums,low+1,end);
    }
}
