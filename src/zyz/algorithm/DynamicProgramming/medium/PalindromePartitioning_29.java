package zyz.algorithm.DynamicProgramming.medium;

import zyz.algorithm.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 分割回文串
 * @seq: 29
 * @address: https://leetcode-cn.com/problems/palindrome-partitioning/
 * @idea:
 *   该题不用DP做试试，不用DP的方法也挺好的
 *   该题用dfs来分割字串想到了但是写的有点问题 注意回溯的题对于取最后的结果有两种方式:
 *   1. 在递归结束时 i==n 加入list
 *   2. 每层迭代都把该层的结果返回给上一层
 */
public class PalindromePartitioning_29 {
    public static void main(String[] args) {
        String s = "a";

        System.out.println(partition(s));
    }
    static List<String> list = new ArrayList<>();
    static List<List<String>> alllist=new ArrayList<>();
    public static List<List<String>> partition(String s) {
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        for(int i=0;i<len;i++)
        {
            dp[i][i]=true;
        }
        //子串长度
        for(int i=2;i<=len;i++)
        {
            for(int j=0;j<len;j++)
            {
                if(j+i>len) break;
                if(i==2)
                {
                    dp[j][j+i-1]=s.charAt(j)==s.charAt(j+i-1);
                }
                else dp[j][j+i-1]=s.charAt(j)==s.charAt(j+i-1)?dp[j+1][j+i-2]:false;
            }
        }
        Utils.print2Arr(dp);
        dfs(dp,0,len,s);
        return alllist;
    }

        public static void dfs(boolean[][] dp,int start ,int n,String s)
        {
            if (start==n)
            {
                alllist.add(new ArrayList<>(list));
                return ;
            }

            for(int i=start;i<n;i++)
            {
                if (dp[start][i])
                {
                    list.add(s.substring(start,i+1));
                    dfs(dp,i+1,n,s);
                    list.remove(list.size()-1);
                }
            }
        }
}
