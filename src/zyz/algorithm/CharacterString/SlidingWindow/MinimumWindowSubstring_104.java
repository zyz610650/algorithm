package zyz.algorithm.CharacterString.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyz
 * @title: 最小覆盖子串
 * @seq: 76
 * @address:  https://leetcode-cn.com/problems/minimum-window-substring/
 * @idea:
 */
public class MinimumWindowSubstring_104 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        if(s.length()<t.length()) return null;
        if(s.length()==t.length()&&!s.equals(t)) return null;

        Map<Character, List<Integer>> map=new HashMap<>();
        for(char ch:t.toCharArray())
            map.put(ch,new ArrayList<>());
        List<Integer> list=null;
        int times=t.length();
        char[] chs=s.toCharArray();
        int ans=s.length(),ansMin=s.length(),ansMax=-1;
        int min,max;
        for(int i=0;i<chs.length;i++)
        {
            if(map.containsKey(chs[i]))
            {
                list=map.get(chs[i]);
                list.add(i);
                map.put(chs[i],list);
                times--;
                if(times<=0)
                {
                    min=s.length();
                    max=-1;
                    for(char ch:t.toCharArray())
                    {
                        list=map.get(ch);
                        int tmp=list.get(list.size()-1);
                        min=Math.min(tmp,min);
                        max=Math.max(tmp,max);
                    }
                    if(min==max) continue;
                    if(max-min<ans)
                    {
                        ans=max-min;
                        ansMin=min;
                        ansMax=max;
                    }
                }
            }
        }

        if (ansMax==ansMin) return null;
        return s.substring(ansMin,ansMax+1);
    }
}
