package zyz.algorithm.CharacterString.SlidingWindow;

import java.util.*;

/**
 * @author zyz
 * @title: 最小覆盖子串
 * @seq: 76
 * @address:  https://leetcode-cn.com/problems/minimum-window-substring/
 * @idea:
 */
public class MinimumWindowSubstring_104 {

    public static void main(String[] args) {
        System.out.println((int)'a');
        System.out.println((char)95);
//     for(int i=0;i<26;i++)
//         System.out.println((char)('A'+i));
        String s = "ADOBECODEBANC", t = "ABC";

        System.out.println(minWindow(s,t));

    }
    // 单词重复问题没有解决 比如"aa" "aa"
    public static String minWindow1(String s, String t) {

        if(s.length()<t.length()) return "";

        Map<Character, Integer> map=new HashMap<>();
        Map<Character, Integer> countMap=new HashMap<>();
        for(char ch:t.toCharArray())
        {
            map.put(ch,0);
            countMap.put(ch,countMap.getOrDefault(ch,0)+1);
        }

        int times=t.length();
        char[] chs=s.toCharArray();
        int ans=s.length(),ansMin=s.length(),ansMax=-1;
        int min,max;
        int tmp=0;
        for(int i=0;i<chs.length;i++)
        {
            if(map.containsKey(chs[i]))
            {
                tmp=map.get(chs[i]);
                map.put(chs[i],i);
                times--;
                if(times<=0)
                {
                    min=s.length();
                    max=-1;
                    for(char ch:t.toCharArray())
                    {
                        tmp=map.get(ch);
                        min=Math.min(tmp,min);
                        max=Math.max(tmp,max);
                    }
//                    if(min==max) continue;
                    if(max-min<ans)
                    {
                        ans=max-min;
                        ansMin=min;
                        ansMax=max;
                    }
                }
            }
        }
        if (ansMin==s.length()) return "";
        return s.substring(ansMin,ansMax+1);
    }


//
    public static String minWindow3(String s, String t)
    {
        Map<Character,Integer> hs=new HashMap<>();
        Map<Character,Integer> ht=new HashMap<>();
        for (Character ch:t.toCharArray())
        {
            ht.put(ch,ht.getOrDefault(ch,0)+1);
        }

        String ans="";
        int len=s.length()+1,cnt=0;
        char ch;
        for (int i=0,j=0;i<s.length();i++)
        {
            ch=s.charAt(i);
            hs.put(ch,hs.getOrDefault(ch,0)+1);
            if (ht.containsKey(ch)&&hs.get(ch)<=ht.get(ch)) cnt++;
            ch=s.charAt(j);
            //cnt不重置 并且对于ADOBECODEBANC 第一次找到ADOBEC后j一直在0处，直到i到了下标为10这个A的地方，j才开始移动，
            // j收缩的时候
            while(j<i&&(!ht.containsKey(ch)||hs.get(ch)>ht.get(ch)))
            {
                // ht里不含的字符，hs减不减1都行，这里是为了方便就都减了，要么还得写个if else;
                hs.put(ch,hs.get(ch)-1);
                j++;
                ch=s.charAt(j);
            }
            if (cnt==t.length()&&len>i-j+1)
            {
                len=i-j+1;
                ans=s.substring(j,i+1);
            }
        }
        return ans;
    }

    public static String minWindow(String s, String t)
    {
        int[] hash=new int[128];
        for (char ch:t.toCharArray())
        {
            hash[ch]--;
        }
        String res=""; int cnt=0;
        int len=s.length()+1;
        char ch;
        for (int i=0,j=0;i<s.length();i++)
        {
             ch=s.charAt(i);
            hash[ch]++;
            if (hash[ch]<=0) cnt++;

            while (j<i&&hash[s.charAt(j)]>0) hash[s.charAt(j++)]--;
            if (cnt==t.length()&&len>i-j+1)
            {
                len=i-j+1;
                res=s.substring(j,i+1);
            }

        }
        return res;
    }


}
