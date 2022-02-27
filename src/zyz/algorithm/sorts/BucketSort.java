package zyz.algorithm.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr={123214,95, 94, 91, 32432,98, 99, 43, 99, 93, 91, 92};
        System.out.println(Arrays.toString(buckSort(arr)));
    }
    public static int[] buckSort(int[] nums)
    {
        int max=nums[0];
        int min=nums[0];
        for(int n:nums)
        {
            max=Math.max(max,n);
            min=Math.min(min,n);
        }
        int bucketNums=(max-min)/nums.length+1;
//        int[] buckets=new int[bucketNums];
        List<List<Integer>> buckets=new ArrayList<>(bucketNums);
        for(int i=0;i<bucketNums;i++) buckets.add(new ArrayList<>());
        for(int n:nums)
        {
            buckets.get((n-min)/bucketNums).add(n);
        }
        for (int i=0;i<bucketNums;i++)
            Collections.sort(buckets.get(i));
        int index=0;
        for(int i=0;i<bucketNums;i++)
        {
           for (int j=0;j<buckets.get(i).size();j++)
               nums[index++]=buckets.get(i).get(j);
        }
        return nums;
    }
}
