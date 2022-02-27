package zyz.algorithm.sorts;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr={123214,95, 94, 91, 4343, 99, 90, 99, 93, 91, 92};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
    public static int[] mergeSort(int[] nums)
    {
        int low=0,high=nums.length;

        f(nums,low,high-1);
        return nums;
    }
    public static void f(int[] nums,int l,int h)
    {
        if(l<h)
        {
            int mid=(l+h)/2;
            f(nums,l,mid);
            f(nums,mid+1,h);
            merge(nums,l,h,mid);
        }
    }
    public static void merge(int[] nums,int l,int h,int mid)
    {
        int l1=l,l2=mid+1,h1=mid,h2=h;
        int[] tmp=new int[h-l+1];
        int index=0;
        while(l1<=h1&&l2<=h2)
        {
            if(nums[l1]<nums[l2])
            {
                tmp[index++]=nums[l1++];
            }else{
                tmp[index++]=nums[l2++];
            }
        }
        while (l1<=h1)  tmp[index++]=nums[l1++];
        while (l2<=h2)  tmp[index++]=nums[l2++];
        index=0;
        for(int i=l;i<=h;i++)
        {
            nums[i]=tmp[index++];
        }
    }
}
