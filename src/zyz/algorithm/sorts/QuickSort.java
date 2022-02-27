package zyz.algorithm.sorts;

public class QuickSort {
    public int[] quickSort(int[] nums)
    {
        return nums;
    }
    public void sort(int[] nums,int l,int h)
    {
        int i=l,j=h;
        while(i<l)
        {
            while(i<j&&nums[j]>=nums[l]) j--;
            while (i<j&&nums[i]<=nums[l]) i++;
            swap(nums,i,j);
        }
        swap(nums,l,i);
        sort(nums,l,i-1);
        sort(nums,i+1,h);
    }
    public void swap(int[] nums,int i,int j)
    {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
