package zyz.algorithm.type.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 组合
 * @seq: 77
 * @address: https://leetcode-cn.com/problems/combinations/
 * @idea:
 */
public class Combinations_57 {
    public static List<List<Integer>> lists=new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list=new ArrayList<>();
        dfs(n,k,0,0,list);
        return lists;
    }

    public static void dfs(int n,int k,int index,int t,List<Integer> list)
    {
        if(k==t)
        {
            lists.add(new ArrayList<>(list));

            return;
        }

        for(int i=index+1;i<=n;i++)
        {
            list.add(i);
            dfs(n,k,i,t+1,list);
            list.remove(t);
        }
    }
}
