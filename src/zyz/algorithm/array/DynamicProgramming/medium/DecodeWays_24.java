package zyz.algorithm.array.DynamicProgramming.medium;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 解码方法
 * @seq: 24
 * @address: https://leetcode-cn.com/problems/decode-ways/
 * @idea:
 */
public class DecodeWays_24 {


    public static void main(String[] args) {
        String s = "226";
        System.out.println( numDecodings(s));
    }
    public static  int numDecodings(String s) {
        int len=s.length();
        int[] dp=new int[len];
        int tmp=0;

        for(int i=0;i<len-1;i++)
        {

            if(s.charAt(i)=='0') continue;
            tmp=s.charAt(i)-'0';
            if(s.charAt(i+1)=='0')
            {
                if(i==0)        dp[0]=1;
                else dp[i]=dp[i-1];
            }else if((tmp*10+(s.charAt(i+1)-'0'))<=26){
                if(i==0)  dp[0]=2;
                else dp[i]=dp[i-1]*2;
            }
        }
    for(int i=0;i<len;i++) System.out.print(dp[i]+" ");
        System.out.println();
        return dp[len-2];
    }
}
