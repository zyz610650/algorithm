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

    public static boolean isScramble(String s1, String s2) {

        if(dfs(s1).equals(s2)) return true;
        return false;
    }

    static String dfs(String str)
    {
        if (str.length()==0) return "";
        if (str.length()==1) return str;
        int len=str.length();
        int span=rn.nextInt(len);
        String s1;
        String s2;
        //交换
        if(rn.nextInt(2)==0)
        {
            s2=str.substring(0,span);
            s1=str.substring(span,len);
        }else{
            s1=str.substring(0,span);
            s2=str.substring(span,len);
        }

        s1=dfs(s1);
        s2=dfs(s2);
        return s1+s2;
    }
}
