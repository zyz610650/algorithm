package zyz.algorithm.type.array.medium;

import java.util.*;

/**
 * @author zyz
 * @title: 存在重复元素 III
 * @seq: 220
 * @address: https://leetcode-cn.com/problems/contains-duplicate-iii/
 * @idea:
 */
public class ContainsDuplicate3_93 {
    public static void main(String[] args) {

    Long k=2147483647*1L+1;
        System.out.println(k);
       int[] nums={2147483647,-1,2147483647};
        System.out.println(containsNearbyAlmostDuplicate3(nums,1,2147483647));
    }

    // 使用Integer不行 错误写法
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n=nums.length;

        TreeSet<Integer> set=new TreeSet<>();
        Integer lb,ub;

        // [-2147483648,2147483647] 使用int遇到这样的数超出范围
        int aaa;
        for(int i=0;i<n;i++)
        {
            lb=set.floor(nums[i]);
            ub=set.ceiling(nums[i]);
            if((lb!=null&&nums[i]-lb<=t)||(ub!=null&&ub-nums[i]<=t)) return true;
            set.add(nums[i]);
            if(i>=k+1) // 不用set.size(); 是因为 j-i=k j->i之间有k+1个数
            {

                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    // 也可以使用long类型强转
    public static boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int n=nums.length;

        TreeSet<Long> set=new TreeSet<>();
        Long lb,ub;

        for(int i=0;i<n;i++)
        {
            Long u=nums[i]*1L;
            lb=set.floor(u);
            ub=set.ceiling(u);
            if((lb!=null&&u-lb<=t*1L)||(ub!=null&&ub-u<=t*1L)) return true;
            set.add(nums[i]*1L);
            if(i>=k) // 不用set.size(); 是因为 j-i=k j->i之间有k+1个数
            {

                set.remove(nums[i-k]*1L);
            }
        }
        return false;
    }

    //  为什么桶号要用Long来存 比如 int[] nums={2147483647,-1,2147483647}; 计算的桶号就为 2147483647
    // int类型 Intger.MAX_VALUE+1=-1 loNG   Long k=2147483647*1L+1;=2147483648

    //int的话就会超出界限 Long是 Long int 不是float
//    public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
//        int n=nums.length;
//        Long bn;
//        Long size=t*1L+1;
//        Map<Long,Long> map=new HashMap<>();
//        Long lb,ub;
//        for(int i=0;i<n;i++)
//        {
//            bn=getIds(nums[i]*1L,size);
//            if(map.containsKey(bn)) return true;
//            lb=bn-1;ub=bn+1;
//            if(map.containsKey(lb)&&nums[i]-map.get(lb)<=t) return true;
//            if(map.containsKey(ub)&&map.get(ub)-nums[i]<=t) return true;
//            map.put(bn,nums[i]*1l);
//            if(i>=k)
//                map.remove(getIds(nums[i-k]*1L,size));
//        }
//        return false;
//    }

    static Long getIds1(Long u,Long size)
    {
        // n/size 保证每size个数，n/size得到的是一个值 相当于把size个数放到一个桶里 这样分桶的原因

        return (u >= 0 ? u / size : ((u + 1) / size) - 1);


        // 这样写是为了处理（-4-->-1）时的情况
        //比如size=4时
        // 0放在正数里面算了 和1 2 3一个桶
        // 如果处理就-3 -2 -1 0 1 2 3这全在一个桶了 ，桶之间的数就不连贯了
        // 比如 [2147483647,-1,2147483647] -1 [2147483647,-1,2147483647]
        // k=1
        //t= 2147483647
        // return u/size; 这样写 -1和2147483647一个桶
        //因为桶之间存的数据要保证是连续的,负数的桶号必须都减1  要么不连贯了 正数0-3和负数桶之间的连贯性就没法判断
    }

    public static boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        int n=nums.length;
        int bn;
        int size=t+1;
        Map<Integer,Integer> map=new HashMap<>();
        int lb,ub;
        for(int i=0;i<n;i++)
        {
            bn=getIds(nums[i]*1L,size);
            if(map.containsKey(bn)) return true;
            lb=bn-1;ub=bn+1;
            if(map.containsKey(lb)&&nums[i]-map.get(lb)<=t) return true;
            if(map.containsKey(ub)&&map.get(ub)-nums[i]<=t) return true;
            map.put(bn,nums[i]);
            if(i>=k)
                map.remove(getIds(nums[i-k]*1L,size));
        }
        return false;
    }

    static int getIds(Long u,int size)
    {
        return (int)(u >= 0 ? u / size : ((u + 1) / size) - 1);
    }
}
