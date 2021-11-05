package zyz.algorithm.type.CharacterString.hard;

import zyz.algorithm.utils.Utils;

/**
 * @author zyz
 * @title: 分割回文串 II
 * @seq: 132
 * @address: https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 * @idea:
 *
 */
public class PalindromePartitioning2_128 {

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));
    }
    public  static int minCut(String s) {
        int len=s.length();
        boolean[][] dp=new boolean[len+1][len+1];
        dp[0][0]=true;
        dp[len][len]=true;
        for(int i=1;i<len;i++)
        {
            dp[i][i]=true;
            if(s.charAt(i)==s.charAt(i-1)) dp[i][i+1]=true;
        }
        for(int i=3;i<=len;i++)
        {
            for(int j=1;j+i-2<len;j++)
            {
                if(s.charAt(j-1)==s.charAt(j+i-2))
                {
                    dp[j][j+i-1]=dp[j+1][j+i-2];

                }
            }
        }

        Utils.print2Arr(dp);
        System.out.println();
        int[] f=new int[len+1];
        for(int i=1;i<=len;i++)
        {
            if(dp[1][i]) f[i]=0;
            else{
                f[i]=i-1;
                for(int j=1;j<=i;j++)
                {
                    if(dp[j][i]) f[i]=Math.min(f[i],f[j-1]+1);
                }
            }
        }
        return f[len];
    }

}
