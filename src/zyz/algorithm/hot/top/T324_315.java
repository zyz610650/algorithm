package zyz.algorithm.hot.top;

import java.util.Arrays;

public class T324_315 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,6,3};


        T324_315 t=new T324_315();
//        t.wiggleSort(nums);

        t.quickSelect(nums,0,nums.length-1);

        System.out.println(Arrays.toString(nums));
    }
    // 不用会虚地址 会O(n)时间复杂度即可
    public void wiggleSort(int[] nums) {
        // 快速算则排序 可以找到第k大的数
        int mid=quickSelect(nums,0,nums.length-1);
        int l=0,h=nums.length-1,t=0;

        //三分法 给定一个key 分为3个部分
        while(l<h)
        {
            if(nums[l]<mid)
            {
                swap(nums,l,t);
                l++;
                t++;
            }else if(nums[l]>mid)
            {
                swap(nums,l,h);
                h--;
            }else l++;
        }
//三分法
//        nth_element方法排列后元素顺序可能是3 2 3 4，而我们希望两个3都放在数组的中间，所以要再进行一次三分法，处理成2 3 3 4
//        {3,2,3,1,6,3}; -> 1 2 3 3 6 3
//        这里的主要思想就是在一遍扫描中，通过交换不同位置的数字，使得数组最终可以维持一定的顺序，
//        和前面快排中用到的 partition 思想一致。区别在于快排按照 pivot 将数组分为两部分，左右部分中+的值都可能等于 pivot，而 three-way-partition 将数组分为 <, =, >的三部分。

        int[] res=new int[nums.length];
        int ids=0;
        int offest=nums.length/2;
        for(int i=(nums.length-1)/2;i>=0;i--)
        {
            res[ids++]=nums[i];
            if(ids<nums.length)
                res[ids++]=nums[i+offest];
        }
        System.arraycopy(res, 0, nums, 0, nums.length);

    }
    void swap(int[] nums,int l,int h)
    {
        int tmp=nums[l];
        nums[l]=nums[h];
        nums[h]=tmp;
    }

    int quickSelect(int[] nums,int l,int h)
    {
        int left=l, right=h,key=nums[l];
        while(left<right)
        {

            while(right>left&&nums[right]>key) right--;
            if(left<right) nums[left++]=nums[right];
            while(left<right&&nums[left]<=key) left++;
            if(left<right) nums[right--]=nums[left];
        }
        nums[left]=key;
        if(left>nums.length/2) return quickSelect(nums,l,left-1);
        else if(left<nums.length/2) return quickSelect(nums,left+1,h);
        return nums[left];
    }
}
