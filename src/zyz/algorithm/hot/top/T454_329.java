package zyz.algorithm.hot.top;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyz
 * @title: 454. 四数相加 II
 * @seq: 454
 * @address: https://leetcode-cn.com/problems/4sum-ii/
 * @idea:
 */
public class T454_329 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map1=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                map1.put(nums1[i]+nums2[j],map1.getOrDefault(nums1[i]+nums2[j],0)+1);
            }
        }
        for(int i=0;i<nums3.length;i++)
        {
            for(int j=0;j<nums4.length;j++)
            {
                map2.put(nums3[i]+nums4[j],map2.getOrDefault(nums3[i]+nums4[j],0)+1);
            }
        }
        int res=0;
        for(Integer key:map1.keySet())
        {
            res+=(map1.get(key)*map2.getOrDefault(-1*key,0));
        }
        return res;
    }
}
