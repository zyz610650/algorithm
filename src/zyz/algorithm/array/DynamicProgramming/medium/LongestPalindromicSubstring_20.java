package zyz.algorithm.array.DynamicProgramming.medium;

import zyz.algorithm.utils.Utils;

/**
 * @author zyz
 * @title: 最长回文子串
 * @seq: 20
 * @address: https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @idea:
 *    1.dp[i][j]:i->j 是否是回文字串
 *    2.dp[i-1][j+1]=s[i]==s[j]?dp[i][j]:false;
 *    3. 初始:dp[0] dp[s.length-1] dp[i][s.lentgh-1]
 */
public class LongestPalindromicSubstring_20 {
    public static void main(String[] args) {
        String s="babad";

        System.out.println(longestPalindrome(s));

    }
    public static String longestPalindrome(String s) {
        int len=s.length();
        boolean [][] dp=new boolean[len][len];
        int max=1;
        int dx=0,dy=0;
        //初始化 l:代表字串长度
        for(int i=0;i<len;i++)
        {
            dp[i][i]=true;
        }

        //最外层循环是字串长度
        for(int l=1;l<len;l++)
        {
            for(int i=0;i<len;i++)
            {
                if (i+l>=len) break;
                if(l==1&&s.charAt(i)==s.charAt(i+l))
                {
                    dp[i][i+l]=true;
                }
                else if(s.charAt(i)==s.charAt(i+l))
                {
                    dp[i][i+l]=dp[i+1][i+l-1];
                }
                if(dp[i][i+l]&&max<l+1)
                {
                    max=l+1;
                    dx=i;
                    dy=i+l;
                }

            }
        }
//        System.out.println(dx+" "+dy);
//        Utils.print2Arr(dp);
        return s.substring(dx,dy+1);
    }
}
