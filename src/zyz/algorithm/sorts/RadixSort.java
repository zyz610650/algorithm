package zyz.algorithm.sorts;

import java.util.Arrays;

public class RadixSort {


    public static void main(String[] args) {
        int[] arr={123214,95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        System.out.println(Arrays.toString(radixSort(arr)));
    }
    public static int[] radixSort(int[] nums)
    {

        int exp;
        int max=nums[0];
        for(int n:nums) max=Math.max(max,n);
        for(exp=1;max>0;exp*=10,max/=10)
        {
            int[] buckets=new int[10];
            int[] tmp=new int[nums.length];
            for(int n:nums) buckets[n/exp%10]++;
            int sum=0;
            for (int i=0;i<10;i++)
            {
                sum+=buckets[i];
                buckets[i]=sum;
            }
            System.out.println(Arrays.toString(buckets));
            for(int i=nums.length-1;i>=0;i--)
            {
                tmp[buckets[nums[i]/exp%10]-1]=nums[i];
                buckets[nums[i]/exp%10]--;
            }
            System.arraycopy(tmp,0,nums,0,nums.length);
        }
        return nums;
    }
}
