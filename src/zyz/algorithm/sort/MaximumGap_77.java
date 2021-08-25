package zyz.algorithm.sort;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

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
        int[] nums={15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
        System.out.println(maximumGap(nums));;
    }
    public static int maximumGap(int[] nums) {

        int n=nums.length;
        if(n==1) return 0;
        int max= Arrays.stream(nums).max().getAsInt();
        int min=Arrays.stream(nums).min().getAsInt();
        //桶的数量
        int bucketNum=n;

        int[] bucketMax=new int[bucketNum];
        int[] bucketMin=new int[bucketNum];
        Arrays.fill(bucketMax,Integer.MIN_VALUE);
        Arrays.fill(bucketMin,Integer.MAX_VALUE);
        int num=0;
        for (int i=0;i<n;i++)
        {
            // 注意这里  (nums[i]-min+1)/(max-min+1) int / int 如果得到的结果是0.n 这时候因为是int 类型
            // 就相当于0了 虽然后面也乘了39 相当于0*39
            num=(int)(((nums[i]-min+1)/(double)(max-min+1))*(bucketNum-1));
            bucketMax[num]=Math.max(bucketMax[num],nums[i]);
            bucketMin[num]=Math.min(bucketMin[num],nums[i]);
        }

        // 为什么不用考虑桶内的排序，会不会桶内的间距更大呢?
        // 不会
        // 因为这里桶的数量设置为数组的大小.这样存在两种情况
        // 1.每个桶内只有一个元素 这时候相当于直接两两相见了
        // 2. 如果不存在每个桶内只有一个元素，这时候必然存在空桶，这时候后面桶的最小值-前面桶的最大值一定>=桶内的间距 所以不考虑桶内的间距
        //  因为桶的数量是大于间距的数量 所以必定有一个桶是空的 这样一来 桶间的间距一定大于桶内间距
        int maxGap=0;
        int preMax=min;
        for(int i=0;i<bucketNum;i++)
        {
            if (bucketMax[i]==Integer.MIN_VALUE) continue;
            maxGap=Math.max(maxGap,bucketMin[i]-preMax);
            preMax=bucketMax[i];
        }
        return maxGap;
    }

}

//    桶排序的时间复杂度和空间复杂度都是O(n)，并且桶排序是一种稳定的排序算法。
//        但是桶排序的性能并非是绝对稳定的，因为如果元素分布不均衡，比如说创建了5个桶，大多数元素都集中在了第2个桶，这样桶排序的时间复杂度就会退化为O(nlogn)，而且还浪费了空间。