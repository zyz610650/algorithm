package zyz.algorithm.type.CharacterString.SlidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zyz
 * @title: 无重复字符的最长子串
 * @seq: 3
 * @address: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @idea:
 */
public class LongestSubstringWithoutRepeatingCharacters_101 {
    public static void main(String[] args) {
        String str="pwwkew";
        System.out.println(str.contains("ww"));

        System.out.println( lengthOfLongestSubstring(str));
    }
    public static int lengthOfLongestSubstring1(String s) {

        int len=s.length();
        if (len==0) return 0;
        int[] dp=new int[len];
        String str=null;
        Arrays.fill(dp,1);
        int ans=1;
        for(int l=2;l<=len;l++)
        {
            for(int i=0;i<len;i++)
            {
                if(dp[i]==(l-1)&&(i+l-1)<len)
                {

//                    System.out.println(str);
//                    System.out.println(s.charAt(i+l-1));
                    if(!s.substring(i,i+l-1).contains(String.valueOf(s.charAt(i+l-1))))
                    {
                        dp[i]=l;
                       ans=l;
                    }
                }

            }
            System.out.println(Arrays.toString(dp));
        }
        return ans;
    }


    public static int lengthOfLongestSubstring2(String s) {

        int len=s.length();
        if (len==0) return 0;
        int ans=1;
        int  start=0;
        String str=null;
        int i=1;
        while(i<len)
        {
            str=s.substring(start,i);
            if(!str.contains(String.valueOf(s.charAt(i))))
            {
                ans=Math.max(ans,str.length()+1);
                i++;
            }
            else start++;
        }
        return ans;
    }

    // 换成Set 效率就上去了 所以最好不要直接堆String操作
    public static int lengthOfLongestSubstring(String s) {

        int len=s.length();
        if (len==0) return 0;
        int ans=1;
        int  start=0;
        Set<Character> set=new HashSet<>();
        int i=0;
        while(i<len)
        {
            char ch=s.charAt(i);
            if(!set.contains(ch))
            {
                ans=Math.max(ans,set.size()+1);
                set.add(ch);
                i++;
            }
            else
            {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return ans;
    }
}
