package zyz.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 基数排序
 * @seq:
 * @address:
 * @idea:
 */
public class radixsort {

    //获取数组中最大数为多少位
    static int getMax(int[] nums)
    {
        int max= Arrays.stream(nums).max().getAsInt();
        return String.valueOf(max).length();//代替下面一堆
//        int n=0;
//        while (max>0)
//        {
//            n++;
//            max=max/10;
//        }
//        return n;
    }

    static void sort(int[] nums)
    {

        int n=nums.length;
        int[][] bucket=new int[10][n];
        int[] order=new int[10];

        int maxN=getMax(nums);
        int mod=10,dev=1;
        for(int i=0;i<maxN;i++)
        {

            //放进桶
            for(int j=0;j<n;j++)
            {
                int tmp=(nums[j]/dev)%10;
                bucket[tmp][order[tmp]++]=nums[j];
            }
            //从桶中取出
            int t=0;
            for(int j=0;j<10;j++)
            {
                if (order[j]!=0)
                    for(int k = 0; k < order[i]; k++)
                    {
                        nums[t++] = bucket[i][j];
                    }
                order[j]=0;
                }
            dev*=10;

        }
    }

    public static void main(String[] args) {
        int[] data = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
        sort(data);
        for(int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
    }


}
