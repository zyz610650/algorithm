package zyz.algorithm.CharacterString.hard;

import zyz.algorithm.utils.Utils;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 不同的子序列
 * @seq: 115
 * @address: https://leetcode-cn.com/problems/distinct-subsequences/
 * @idea:
 *
 */
public class DistinctSubsequences_122 {
    public static void main(String[] args) {

       String s = "babgbag", t = "bag";
        System.out.println(numDistinct(s,t));
    }

// DP
    public static int numDistinct2(String s, String t) {
        // dp[i][j] i j
        //if chs[i]==cht[j] dp[i][j]=  dp[0->i-1][j-1]

        char[] chs=s.toCharArray();
        char[] cht=t.toCharArray();
        int lens=chs.length;
        int lent=cht.length;
        int[][] dp=new int[lent+1][lens+1];

        for(int i=1;i<=lent;i++)
        {
            for(int j=1;j<=lens;j++)
            {
                if(chs[j-1]==cht[i-1])
                {
                    if(i==1) dp[i][j]=1;
                    else
                        for(int k=0;k<j;k++)
                        {
                            dp[i][j]+=dp[i-1][k];
                        }
                }
            }
        }
        int n=0;
        for(int i=1;i<=lens;i++)
            n+=dp[lent][i];
        Utils.print2Arr(dp);
        return n;
    }
    // 动态数组 不太行
    public static int numDistinct(String s, String t) {
        // dp[i][j] i j
        //if chs[i]==cht[j] dp[i][j]=  dp[0->i-1][j-1]

        char[] chs=s.toCharArray();
        char[] cht=t.toCharArray();
        int lens=chs.length;
        int lent=cht.length;
        int[] dp=new int[lens+1];

        for(int i=1;i<=lent;i++)
        {
            for(int j=1;j<=lens;j++)
            {
                if(chs[j-1]==cht[i-1])
                {
                    if(i==1) dp[j]=1;
                    else
                    {
                        dp[j]=0;
                        for(int k=0;k<j;k++)
                        {
                            dp[j]+=dp[k];
                        }
                    }
                }else{
                    dp[j]=0;
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        int n=0;
        for(int i=1;i<=lens;i++)
            n+=dp[i];
        return n;
    }
}
//"bag"
//"babgbag"
