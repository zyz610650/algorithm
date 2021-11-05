package zyz.algorithm.type.array.easy;

import java.util.*;

/**
 * @author zyz
 * @title: 存在重复元素
 * @seq: 217
 * @address: https://leetcode-cn.com/problems/contains-duplicate/
 * @idea:
 */
public class ContainsDuplicate_91 {

    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,2);
        System.out.println(map.put(1,0));
    }
    public boolean containsDuplicate(int[] nums) {


        Set<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            //if(map.containKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
            //else  map.put(nums[i],1);
            if(set.contains(nums[i])) return true;
            else set.add(nums[i]);

        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {

        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1]) return true;
        }
        return false;
    }
}


