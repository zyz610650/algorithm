package zyz.algorithm.sort;

/**
 * @author zyz
 * @title: 数组中的第K个最大元素
 * @seq: 215
 * @address: https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @idea:
 */
public class KthLargestElementinanArray_89 {

    public int findKthLargest(int[] nums, int k) {

        //sort(nums);
        return nums[nums.length-k];

    }

    public static void swap(int[] nums,int i,int j)
    {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }






    public static void adjustHap1(int[] nums,int len)
    {
        int cnt=(len-2)/2;
        int left,right,tmp;
        while(cnt!=-1)
        {
            left=cnt*2+1;
            right=cnt*2+2;
            if (left>=len)
            {
                cnt--; continue;
            }
            if(right>=len)
            {
                if (nums[left]>nums[cnt]) swap(nums,left,cnt);
                cnt--;
                continue;
            }
            if (nums[left]>nums[right]) tmp=left;
            else tmp=right;
            if (nums[cnt]<nums[tmp]) swap(nums,cnt,tmp);
            cnt--;
        }
    }

    static void sort1(int[] nums)
    {
        adjustHap1(nums,nums.length);
        // 构建大顶堆
        for(int i=nums.length;i>0;i--)
        {
            adjustHap1(nums,i);
            swap(nums,0,i-1);
        }

    }



}
