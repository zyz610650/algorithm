package zyz.algorithm.DynamicProgramming.medium;

import java.util.*;

/**
 * @author zyz
 * @title: 单词拆分
 * @seq: 139
 * @address: https://leetcode-cn.com/problems/word-break/
 * @idea:
 *
 * dp[i]：表示i之前的字符串是否可以被空格拆分为一个或多个在字典中出现的单词。
 *  这三种方法都比较好 
 */
public class WordBreak_30 {
   static String s= "leetcode";
    public static void main(String[] args) {

        String[] wordDict = {"leet", "code"};
        System.out.println(wordBreak2(s, Arrays.asList(wordDict)));

    }

    //1.DP
    public  boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;

        //子串长度
        for(int i=1;i<=s.length();i++)
        {
            // 以j为分割点
            for(int j=0;j<i;j++)
            {
                if(dp[j]&&set.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }

    //DFS
    //注意这里vis表示的是从第i个字符起若进行匹配过 匹配成功为1 失败为-1 没匹配过为0 减少重复计算
    // 如果把vis当作以i为起点计算字符串是否匹配过是不对的
    static int[] vis=new int[s.length()];
    public static boolean wordBreak1(String s, List<String> wordDict){
        return dfs(s, new HashSet<>(wordDict), 0,s.length());
    }

     static boolean dfs(String s,Set<String> set,int start,int end)
    {
        if (start>=end) return true;
        if (vis[start]==1) return true;
        if (vis[start]==-1) return false;
        for(int i=start;i<end;i++)
        {
            if(set.contains(s.substring(start,i+1))&&dfs(s,set,i+1,end))
            {
                vis[start]=1;
                return true;
            }
        }
        vis[end]=-1;
        return false;
    }

    //方法2: bfs
    public static boolean wordBreak2(String s, List<String> wordDict){
        Set<String> set=new HashSet<>(wordDict);
        Queue<Integer> queue=new LinkedList<>();
        int[] vis=new int[s.length()];
        int i=0;
        queue.add(i);
         int t;
        while(!queue.isEmpty())
        {
            t=queue.poll();
            if (vis[t]==1) continue;
            vis[t]=1;
           for (int k=t+1;k<=s.length();k++)
           {
               if (set.contains(s.substring(t,k)))
               {

                   if (k==s.length()) return true;

                   queue.add(k);
               }
           }
        }
        return false;

    }
}
