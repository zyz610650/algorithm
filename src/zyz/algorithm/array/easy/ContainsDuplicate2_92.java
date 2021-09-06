package zyz.algorithm.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyz
 * @title: 存在重复元素 II
 * @seq: 219
 * @address: https://leetcode-cn.com/problems/contains-duplicate-ii/
 * @idea:
 */
public class ContainsDuplicate2_92 {

    // 暴力
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n&&j<=i+k;j++)
                if(nums[i]==nums[j]) return true;
        }
        return false;
    }
// HashMap 速度快的原因是因为 利用了containsKey方法判重时间复杂度为o(1),降低了查找时间
    public boolean containsNearbyDuplicate1(int[] nums, int k) {

        int n=nums.length;

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(nums[i])&&(i-map.get(nums[i]))<=k) return true;
            map.put(nums[i],i);
        }
        return false;
    }

    // TreeS
}

