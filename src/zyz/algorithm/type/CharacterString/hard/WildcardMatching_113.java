package zyz.algorithm.type.CharacterString.hard;

import zyz.algorithm.utils.Utils;

/**
 * @author zyz
 * @title: 通配符匹配
 * @seq: 44
 * @address: https://leetcode-cn.com/problems/wildcard-matching/
 * @idea:
 */
public class WildcardMatching_113 {

    public static void main(String[] args) {
        String s="",p="*****";

        System.out.println(isMatch(s,p));
    }

    public static boolean isMatch1(String s, String p) {
        int slen=s.length(),plen=p.length();
        boolean[][] dp=new boolean[slen+1][plen+1];

        dp[0][0]=true;

            for(int i=1;i<=plen;i++)
            {
                if(p.charAt(i-1)=='*') dp[0][i]=dp[0][i-1];
            }

        for(int i=1;i<=slen;i++)
        {
            for(int j=1;j<=plen;j++)
            {
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?') dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j-1)=='*')
                {
                    dp[i][j]=dp[i][j-1]||dp[i-1][j-1]||dp[i-1][j];
                    //1.*='' 2.*=1 3.*>=2
                    //   if(s.charAt(i-1)==p.charAt(j-2)||s.charAt(i-2)==p.charAt(j-2))
                }else dp[i][j]=false;
            }
        }
        Utils.print2Arr(dp);
        return dp[slen][plen];
    }

    // 使用char数组 
    public static boolean isMatch(String s, String p) {
        int slen=s.length(),plen=p.length();
        boolean[][] dp=new boolean[slen+1][plen+1];
        char[] chs=s.toCharArray();
        char[] chp=p.toCharArray();
        dp[0][0]=true;

        for(int i=1;i<=plen;i++)
        {
            if(chp[i-1]=='*') dp[0][i]=dp[0][i-1];
        }

        for(int i=1;i<=slen;i++)
        {
            for(int j=1;j<=plen;j++)
            {
                if(chs[i-1]==chp[j-1]||chp[j-1]=='?') dp[i][j]=dp[i-1][j-1];
                else if(chp[j-1]=='*')
                {
                    dp[i][j]=dp[i][j-1]||dp[i-1][j-1]||dp[i-1][j];
                    //1.*='' 2.*=1 3.*>=2
                    //   if(s.charAt(i-1)==p.charAt(j-2)||s.charAt(i-2)==p.charAt(j-2))
                }else dp[i][j]=false;
            }
        }
        Utils.print2Arr(dp);
        return dp[slen][plen];
    }
}
