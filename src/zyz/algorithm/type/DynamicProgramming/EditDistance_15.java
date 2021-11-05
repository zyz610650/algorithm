package zyz.algorithm.type.DynamicProgramming;

/**
 * @author zyz
 * @title: 编辑距离
 * @seq: 15
 * @address: https://leetcode-cn.com/problems/edit-distance/
 * @idea:
 *  1.判断是否是DP
 *    1>根据1: 你可以对一个单词进行如下三种操作： 插入一个字符 删除一个字符 替换一个字符 表示从某一状态 有三种路径可以到达另一状态
 *    2>根据2: 假设状态q : word1: wor 到 word2: like 经过的最少操作数已经知道
 *      想知道状态p : word1: word 到 word2: like 经过的最少步数 只需要在状态q的基础上多一步即可
 *      据此判断 可用DP
 *  2.DP[i][j] 表示单词1的前i个单词变换成单词2的前j个单词所用的最少操作
 *  3.DP[i][j]=min{dp[i][j-1]+1,dp[i-1][j]+1,dp[i-1][j-1]+1} 分别对应增删改
 *  4.边界： i=0: 单词1每匹配单词2的一个字母都需要做一次加操作
 *          j=0; 同上，这里做见减操作
 * https://blog.csdn.net/hollis_chuang/article/details/103045322?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522162485974616780264033425%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=162485974616780264033425&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-103045322.first_rank_v2_pc_rank_v29&utm_term=%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92&spm=1018.2226.3001.4187
 *
 * 动态规划专题：https://leetcode-cn.com/tag/dynamic-programming/
 *
 * 动态规划专题 简单的 想下思路  看经典的动态规划算法题  做中等的前200道
 * */
public class EditDistance_15 {

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        minDistance(word1,word2);


    }
    public static int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            dp[i][0]=i;
        }
        for(int i=0;i<=n;i++)
        {
            dp[0][i]=i;
        }

        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else{
                    dp[i][j]=Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
                }
            }
//        Utils.print2Arr(dp);
        return dp[m][n];
    }
}
