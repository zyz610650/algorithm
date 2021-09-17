package zyz.algorithm.CharacterString.hard;

import java.util.concurrent.Phaser;

/**
 * @author zyz
 * @title: 正则表达式匹配
 * @seq: 10
 * @address: https://leetcode-cn.com/problems/regular-expression-matching/
 * @idea:
 */
public class RegularExpressionMatching_106 {
    public static void main(String[] args) {
       String s = "aaa",p =  "ab*a*c*a";
        System.out.println(isMatch(s,p));


    }

    public static boolean isMatch(String s, String p) {

        char[] chs=s.toCharArray();
        char[] chp=p.toCharArray();

        int index=0;
        char preCh='\0';
        int i=0;
        for(;i<chp.length;)
        {
            if (index==chs.length) break;
            if(chp[i]>='a'&&chp[i]<='z'&&chp[i]==chs[index]) {
                preCh=chs[index++];
                i++;
                continue;
            }
            if(chp[i]=='.') {
                preCh=chp[i];
                index++;
                i++;
                continue;
            }
            if(chp[i]=='*')
            {
                i++;
                if (preCh=='.')
                {

                    if (i==chp.length)
                    {
                        index=s.length();
                        break;
                    }
                    while(index<s.length()&&chs[index]!=chp[i])
                    {
                        index++;
                    }

                }
                else
                {
                    while(index<s.length()&&chs[index]==preCh) index++;

                    if (index==s.length())
                    {
                        String str=p.substring(i,p.length());
                        String ss=s.substring(s.length()-str.length(),s.length());
                        if (ss.equals(str)) return true;

                        boolean flag=false;
                        for (char ch:str.toCharArray())
                        {
                            flag=!flag;
                            if (flag&&ch>='a'&&ch<='z') continue;
                            if (!flag&&ch=='*') continue;
                            break;
                        }
                        return true;

                    }
                }
                continue;
            }
            if(i+1<p.length()&&chp[i+1]=='*')
                preCh=chp[i++];
            else break;
        }
        if (index==s.length()&&i==chp.length)
            return true;
        else return false;
    }
}
