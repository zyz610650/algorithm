package zyz.algorithm.type.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 合总和
 * @seq: 11
 * @address: https://leetcode-cn.com/problems/combination-sum/$
 * @idea:
 *    回溯+剪枝 难点是怎么去重 最初想法是 数组映射判断是否重复，后来觉得不太可行，就想到了前面三数之和用到的排序去重
 *    先对数组排序，按照规定的顺序从数组中选取，每次先选小的，就避免了以后的迭代中会重复选择小的数
 */
public class CombinationSum_11 {


    static List<List<Integer>> lists=new ArrayList<>();

//    public static void main(String[] args) {
//        int[] candidates = {2,3,5};
//        int target = 8;
//        combinationSum(candidates,target);
//    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (target<candidates[i]) break;
            list.add(i);
            f(candidates,target-candidates[i],list,i);
            list.remove(list.size()-1);

        }
    }

}
