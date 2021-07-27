package zyz.algorithm.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 组合总和 II
 * @seq: 43
 * @address: https://leetcode-cn.com/problems/combination-sum-ii/
 * @idea:
 */
public class CombinationSumII_43 {
    static List<List<Integer>> lists=new ArrayList<>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        lists.clear();
        Arrays.sort(candidates);
        List<Integer> list=new ArrayList<>();
        f(candidates,target,list,0);

        return lists;
    }
    public  static  void f(int[] candidates, int target,List<Integer> list,int k)
    {
        if (target==0) {
            List<Integer> res=new ArrayList<>();
            for(int t:list)
            {
                res.add(candidates[t]);
            }
            lists.add(res);
            return;
        }

        for (int i=k;i<candidates.length;i++)
        {
            if(i!=k&&candidates[i]==candidates[i-1]) continue;
            if (target<candidates[i]) break;
            list.add(i);
            f(candidates,target-candidates[i],list,i+1);
            list.remove(list.size()-1);

        }
    }

}
