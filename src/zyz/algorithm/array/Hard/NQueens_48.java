package zyz.algorithm.array.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyz
 * @title: N 皇后
 * @seq: 51
 * @address: https://leetcode-cn.com/problems/n-queens/
 * @idea:
 */
public class NQueens_48 {
    static List<List<String>> lists=new ArrayList<>();
    static Map<Integer,Boolean> col=new HashMap<>();
    static Map<Integer,Boolean> left=new HashMap<>();
    static Map<Integer,Boolean> right=new HashMap<>();

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public static List<List<String>> solveNQueens(int n) {

        List<String> list=new ArrayList<>();
        dfs(0,n,list);
        return lists;
    }

    public static void dfs(int index,int n,List<String> list)
    {
        if(index==n)
        {
            lists.add(new ArrayList<>(list));
            return;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(!col.containsKey(i)&&!left.containsKey(index+i)&&!right.containsKey(i-index))
            {
                col.put(i,true);
                left.put(i+index,true);
                right.put(i-index,true);
                for(int j=0;j<n;j++)
                    if(j!=i) sb.append(".");
                    else sb.append("Q");
                list.add(sb.toString());
                dfs(index+1,n,list);
                col.put(i,false);
                left.put(i+index,false);
                right.put(i-index,false);
                list.remove(index);
            }
        }
    }
}
