package zyz.algorithm.sort;

import zyz.algorithm.utils.Utils;

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
                int iaa=nums[j];
                bucket[tmp][order[tmp]]=nums[j];
                order[tmp]++;
            }
//            Utils.print2Arr(bucket);
            //从桶中取出
            int t=0;
            for(int j=0;j<10;j++)
            {
                if (order[j]!=0)
                {
                    for(int k = 0; k < order[j]; k++)
                    {
                        nums[t++] = bucket[j][k];
                    }
                }
                order[j]=0;
            }
            dev*=10;
//            System.out.println(Arrays.toString(nums));
//            System.out.println();
//            System.out.println();

        }
    }
    /**
     * 高位优先法
     *   用了一种思想 降低了空间复杂度
     * @param arr 待排序列，必须为自然数
     */
    private static void sort1(int[] arr) {
        //待排序列最大值
        int max = arr[0];
        int exp;//指数

        //计算最大值
        for (int anArr : arr) {
            if (anArr > max) {
                max = anArr;
            }
        }

        //从个位开始，对数组进行排序
        for (exp = 1; max / exp > 0; exp *= 10) {
            //存储待排元素的临时数组
            int[] temp = new int[arr.length];
            //分桶个数
            int[] buckets = new int[10];

            //将数据出现的次数存储在buckets中
            for (int value : arr) {
                //(value / exp) % 10 :value的最底位(个位)
                buckets[(value / exp) % 10]++;
            }

            //更改buckets[i]，
            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            //将数据存储到临时数组temp中
            // 这里的意思是  (arr[i] / exp) % 10==3 这时候标号为3的桶的最后一个位置应该是
            // //buckets[(arr[i] / exp) % 10] - 1
            //用Order这样将空间负责度降到了0(N) 时间复杂度为O(n)、有稳定性
//            0 = 1
//            1 = 2
//            2 = 3
//            3 = 7
//            4 = 8
//            5 = 10
//            6 = 10
//            7 = 10
//            8 = 11
//            9 = 12
            for (int i = arr.length - 1; i >= 0; i--) {
                temp[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
                buckets[(arr[i] / exp) % 10]--;
            }

            //将有序元素temp赋给arr
            System.arraycopy(temp, 0, arr, 0, arr.length);
        }

    }
    public static void main(String[] args) {
        int[] data = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
         sort1(data);
        for(int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
    }


}
