package zyz.algorithm.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author zyz
 * @title: 计数排序
 * @seq:
 * @address:
 * @idea:
 */
public class countSort {
    public static void main(String[] args) {
        int[] data = {73, 22, 93, 43,73, 22, 93,  55, 14, 28, 65, 39, 55, 14, 28, 65, 39,81, 33, 100};
        sort(data);
        for(int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
    }
    static void  sort(int[] nums)
    {
        int n=nums.length;
        int max= Arrays.stream(nums).max().getAsInt();
        int min=Arrays.stream(nums).min().getAsInt();
        int[] countArray=new int[max-min+1];
        int[] sortedArray=new int[n];
        for (int i=0;i<n;i++)
        {
            countArray[nums[i]-min]++;
        }
        for (int i=1;i<max-min+1;i++)
        {
            countArray[i]+=countArray[i-1];
        }
//        倒序赋值保证算法是稳定的
        for(int i=n-1;i>=0;i--)
        {
//            int index=countArray[nums[i]];
            sortedArray[countArray[nums[i]-min]-1]=nums[i];
            countArray[nums[i]-min]--;
        }
        System.arraycopy(sortedArray,0,nums,0,n);

    }
}
