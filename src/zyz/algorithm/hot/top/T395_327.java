package zyz.algorithm.hot.top;

import java.util.HashMap;
import java.util.Map;


/**
 * @author zyz
 * @title: 395. 至少有 K 个重复字符的最长子串
 * @seq: 395
 * @address: https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * @idea:
 */
public class T395_327 {
    public int longestSubstring(String s, int k) {

        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for(Character ch: map.keySet())
        {
            if(map.get(ch)<k)
            {
                int res=0;
                for(String str:s.split(String.valueOf(ch)))
                {
                    res=Math.max(res,longestSubstring(str,k));
                }
                return res;
            }
        }
        return s.length();

    }

}
