package zyz.algorithm.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 组合总和 III
 * @seq: 216
 * @address: https://leetcode-cn.com/problems/combination-sum-iii/
 * @idea:
 */
public class CombinationSum3_90 {

    static List<List<Integer>> lists=new ArrayList<>();
    public static void main(String[] args) {
        int k = 3, n = 7;

        System.out.println(combinationSum3(k,n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        lists.clear();
        List<Integer> list=new ArrayList<>();
        dfs(k,n,1,list);

        return lists;
    }

    static void dfs(int k, int n,int cnt,List<Integer> list)
    {
        if(n==0&&k==0)
        {
            lists.add(new ArrayList<>(list));
            return;
        }
        if(k==0) return;

        for(int i=cnt;i<10;i++)
        {
            if(n>=i)
            {
                list.add(i);
                dfs(k-1,n-i,i+1,list);
                list.remove(list.size()-1);
            }
        }



    }
}
