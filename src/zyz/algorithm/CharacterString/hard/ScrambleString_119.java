package zyz.algorithm.CharacterString.hard;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.Random;

/**
 * @author zyz
 * @title: 扰乱字符串
 * @seq: 87
 * @address: https://leetcode-cn.com/problems/scramble-string/
 * @idea:
 */

public class ScrambleString_119 {
    static Random rn=new Random();
    public static void main(String[] args) {
        String s1="great",s2="rgeat";
        System.out.println(isScramble(s1,s2));
// for(int i=0;i<20;i++)        System.out.println(rn.nextInt(20));
    }


    //暴力 超时
    public static boolean isScramble1(String s1, String s2) {
        int len=s1.length(),len1=s2.length();
        if(len!=len1) return false;
        return dfs1(len,s1,s2);

    }

    static boolean dfs1(int l,String s1,String s2)
    {
        if(l==0) return true;
        if(s1.equals(s2)) return true;
        for(int t=1;t<l;t++)
        {
            //t为左边长度
            String str1_left=s1.substring(0,t);
            String str2_left=s2.substring(0,t);

            String str1_right=s1.substring(t,l);
            String str2_right=s2.substring(t,l);
            int len1=str1_left.length();
            int len2=str1_right.length();
            boolean f1=false,f2=false;

            // 不交换
            f1=dfs1(len1,str1_left,str2_left);
            if(f1) f2=dfs1(len2,str1_right,str2_right);
            if(f1&&f2) return true;
            //交换
            // str1_left=s1.substring(0,t);
            // str1_right=s1.substring(t,l);

            str2_left=s2.substring(l-t,l);
            str2_right=s2.substring(0,l-t);
            len1=str1_left.length();
            len2=str1_right.length();
            f1=dfs1(len1,str1_left,str2_left);
            if(f1) f2=dfs1(len2,str1_right,str2_right);
            if (f1&&f2) return true;

        }
        return false;
    }


    // 直接在原字符上判等 还超时
    public static boolean isScramble2(String s1, String s2) {
        int len=s1.length(),len1=s2.length();
        if(len!=len1) return false;
        return dfs2(0,0,len,s1,s2);
    }
    static boolean dfs2(int i,int j,int l,String s1,String s2)
    {
        if(l==0) return true;
        String str1=s1.substring(i,i+l);
        String str2=s2.substring(j,j+l);

        if(str1.equals(str2)) return true;
        for(int t=1;t<l;t++)
        {
            // 不交换
            if(dfs2(i,j,t,s1,s2)&&dfs2(i+t,j+t,l-t,s1,s2)) return true;
            //交换
            if(dfs2(i,j+l-t,t,s1,s2)&&dfs2(i+t,j,l-t,s1,s2)) return true;
        }
        return false;
    }

    // 改进 1>只用一个int数组做缓存还是超时 最后两个用例过不了 不行
    // 下面两种方案可以
    //  2> 把int数组改为byte数组 可以
    // 2> int 数组加上下面的check额外检查 也可以通过
    static byte[][][] dp;
    static String s1,s2;
    public static boolean isScramble3(String s_1, String s_2) {
        s1=s_1;s2=s_2;
        int len=s1.length(),len1=s2.length();
        if(len!=len1) return false;
        dp=new byte[len][len][len];

        int f= dfs3(0,0,len);
        if (f==1) return true;
        return false;
    }

    static int dfs3(int i,int j,int l)
    {

        if(l==0)
        {
            dp[i][j][l-1]=1;
            return 1;
        }
        if (dp[i][j][l-1]!=0) return dp[i][j][l-1];

        String str1=s1.substring(i,i+l);
        String str2=s2.substring(j,j+l);
        if (!check(str1,str2))
        {
            dp[i][j][l-1]=-1;
            return -1;
        }
        if(str1.equals(str2)) return 1;
        for(int t=1;t<l;t++)
        {

            // 不交换
            if(dfs3(i,j,t)==1&&dfs3(i+t,j+t,l-t)==1) return 1;
            //交换
            if(dfs3(i,j+l-t,t)==1&&dfs3(i+t,j,l-t)==1) return 1;

        }
        dp[i][j][l-1]=-1;
        return -1;
    }
    static boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        int[] cnt1 = new int[26], cnt2 = new int[26];
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        for (int i = 0; i < n; i++) {
            cnt1[cs1[i] - 'a']++;
            cnt2[cs2[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }


    public static boolean isScramble(String s_1, String s_2)
    {
        if (s_1.equals(s_2)) return true;
        int len=s_1.length(),len1=s_2.length();
        if(len!=len1) return false;
        boolean[][][] dp=new boolean[len][len][len+1];

        char[] cs1 = s_1.toCharArray(), cs2 = s_2.toCharArray();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {

                // 字符串比较是否相等得用 equals 一直检查不出来的原因是这个 忘记了！！！
    //            System.out.println(s_1.substring(i,i+1) == s_2.substring(j,j+1));
     //           System.out.println(cs1[i] == cs2[j]);
                dp[i][j][1] =( cs1[i] ==  cs2[j]);
            }
        }

        boolean f1=false,f2=false;
        for(int l=2;l<=len;l++)
        {
            for(int i=0;i<=len-l;i++)
            {
                for(int j=0;j<=len-l;j++)
                {
                    for (int t=1;t<l;t++)
                    {

                        f1=(dp[i][j][t]&&dp[i+t][j+t][l-t]);
                        f2=(dp[i][j+l-t][t]&&dp[i+t][j][l-t]);
                        if ( f1||f2)
                        {
                            dp[i][j][l] = true;
                        }

                    }

                }
            }
        }
        return dp[0][0][len];
    }

}
