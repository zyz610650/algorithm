package zyz.algorithm.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 子集
 * @seq: 78
 * @address: https://leetcode-cn.com/problems/subsets/
 * @idea:
 */
public class Subsets_58 {
    static List<List<Integer>> lists=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<Integer> list;
        lists.clear();
        for(int i=0;i<=n;i++)
        {
            list=new ArrayList<>();
            dfs(n,i,-1,0,list,nums);
        }
        return lists;
    }
    public static void dfs(int n,int k,int index,int t,List<Integer> list,int[] nums)
    {

        if(k==t)
        {
            lists.add(new ArrayList<>(list));

            return;
        }

        for(int i=index+1;i<n;i++)
        {
            list.add(nums[i]);
            dfs(n,k,i,t+1,list,nums);
            list.remove(t);
        }
    }
}
