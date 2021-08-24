package zyz.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zyz
 * @title: 桶排序
 * @seq:
 * @address:
 * @idea:
 */
public class bucketSort {

    public static void main(String[] args) {
        int[] data = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
        sort(data);
        for(int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
    }
    static void sort(int[] nums)
    {
        int n=nums.length;

        int max= Arrays.stream(nums).max().getAsInt();
        int min=Arrays.stream(nums).min().getAsInt();
        // 桶的数量 可以随便设置 我觉得这样设置不好 设置为排序数组的长度会比较好，
        // int bucketNum=(max-min+1)/n+1;这样得到的桶每个桶里面固定放nums.length个数
        // 造成桶的数量就会比较大
        int bucketNum=(max-min+1)/n+1;

        List<List<Integer>> bucket=new ArrayList<>();
        for(int i = 0; i < bucketNum; i++){
            bucket.add(new ArrayList<Integer>());
        }
        int num=0;
        for (int i=0;i<n;i++)
        {
             num=(nums[i]-min)/n;
            bucket.get(num).add(nums[i]);
        }
        for(int i=0;i<bucketNum;i++)
        {
            Collections.sort(bucket.get(i));
        }
        int index=0;
        for(int i=0;i<bucketNum;i++)
        {
            for (int j=0;j<bucket.get(i).size();j++)
            nums[index++]=bucket.get(i).get(j);
        }
    }
}
