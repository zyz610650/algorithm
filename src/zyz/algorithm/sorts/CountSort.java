package zyz.algorithm.sorts;

import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        int[] arr={123214,95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        System.out.println(Arrays.toString(countSort(arr)));
    }
    static int[] countSort(int[] nums)
    {
        int sums=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int n:nums)
        {
            max=Math.max(max,n);
            min=Math.min(min,n);
        }
        System.out.println(max);
        System.out.println(min);
        int[] cntArr=new int[max-min+1];
        for (int n:nums)
        {
            cntArr[n-min]++;
        }

       for(int i=0;i<cntArr.length;i++)
        {
              sums+=cntArr[i];
              cntArr[i]=sums;
        }
        int[] sortArr=new int[nums.length];

        for(int n:nums)
        {
            sortArr[cntArr[n-min]-1]=n;
            cntArr[n-min]--;
        }
        return sortArr;
    }
}
