package zyz.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zyz
 * @title: 最大间距
 * @seq: 164
 * @address: https://leetcode-cn.com/problems/maximum-gap/
 * @idea:
 */
// 还得看下桶排序 的桶数量怎么设定 

public class MaximumGap_77 {
    public static void main(String[] args) {
        int[] nums={2,99999999};
        System.out.println(maximumGap(nums));;
    }
    public static int maximumGap(int[] nums) {

        int n=nums.length;
        if(n==1) return 0;
        int max= Arrays.stream(nums).max().getAsInt();
        int min=Arrays.stream(nums).min().getAsInt();
        //桶的数量
        int bucketNum=n;
        //每个桶内有多少数
        int buck_num;
        if((max-min)%2==0)
         buck_num=(max-min+1)/bucketNum;
        else    buck_num=(max-min+2)/bucketNum;
        int[] bucketMax=new int[bucketNum];
        int[] bucketMin=new int[bucketNum];
        Arrays.fill(bucketMax,min);
        Arrays.fill(bucketMin,max);
        int num=0;
        for (int i=0;i<n;i++)
        {
            num=(nums[i]-min)/buck_num;
            bucketMax[num]=Math.max(bucketMax[num],nums[i]);
            bucketMin[num]=Math.min(bucketMin[num],nums[i]);
        }

        int maxGap=bucketNum;
        int preMax=bucketMax[0];
        for(int i=1;i<bucketNum;i++)
        {
            maxGap=Math.max(maxGap,bucketMin[i]-preMax);
            preMax=bucketMax[i];
        }
        return maxGap;
    }

}

//    桶排序的时间复杂度和空间复杂度都是O(n)，并且桶排序是一种稳定的排序算法。
//        但是桶排序的性能并非是绝对稳定的，因为如果元素分布不均衡，比如说创建了5个桶，大多数元素都集中在了第2个桶，这样桶排序的时间复杂度就会退化为O(nlogn)，而且还浪费了空间。