package zyz.algorithm.type.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 子集 II
 * @seq: 90
 * @address: https://leetcode-cn.com/problems/subsets-ii/
 * @idea:
 */
public class Subsets2_65 {
    static  List<List<Integer>> lists=new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        Arrays.sort(nums);
        Arrays.asList(nums);
        System.out.println(subsetsWithDup(nums));
    }


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        int n=nums.length;

        for(int i=0;i<=n;i++)
        {
            List<Integer> list=new ArrayList<>();
            dfs(i,0,0,n,nums,list);
        }
        return lists;
    }
    public static void dfs(int n,int t,int index,int len,int[] nums,List<Integer> list)
    {
        if(t==n){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<len;i++)
        {
            if(i==index||nums[i]!=nums[i-1])
            {
                list.add(nums[i]);
                dfs(n,t+1,i+1,len,nums,list);
                list.remove(list.size()-1);
            }
        }
    }
}
