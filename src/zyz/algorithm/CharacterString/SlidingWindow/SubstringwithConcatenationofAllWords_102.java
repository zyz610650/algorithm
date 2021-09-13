package zyz.algorithm.CharacterString.SlidingWindow;

import java.util.*;

/**
 * @author zyz
 * @title: 串联所有单词的子串
 * @seq: 30
 * @address: https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * @idea:
 */
public class SubstringwithConcatenationofAllWords_102 {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};
        System.out.println(findSubstring(s,words));
    }
    public static List<Integer> findSubstring1(String s, String[] words) {
        int len=0;
        Map<String,Integer> map=new HashMap<>();

        for(int i=0;i<words.length;i++)
        {
            len+=words[i].length();

            if (!map.containsKey(words[i]))
            {
                map.put(words[i],1);
            }else {
                map.put(words[i],map.get(words[i])+1);
            }
        }


        System.out.println(len);
        Set<String> set=new HashSet<>();
        String str;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<=s.length()-len;i++)
        {
            str=s.substring(i,i+len);
            Map<String,Integer> map1=new HashMap<>(map);
            for(int j=0;j<words.length;j++)
                if(str.contains(words[j]))
                {
                    map1.put(words[j],map1.get(words[j])-1);

                }
            boolean flag=true;
            for (int k=0;k<map1.size() ;k++)
            {
                if (map1.get(words[k])!=0)
                {
                    flag=false;
                    break;
                }

            }
            if (flag)
                list.add(i);
        }
        return list;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        int len=0;
        for(int i=0;i<words.length;i++)
            len+=words[i].length();
        Set<String> set=new HashSet<>();
        String str;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<=s.length()-len;i++)
        {
            str=s.substring(i,i+len);
            boolean flag=true;
            for(int j=0;j<words.length;j++)
                if(!str.contains(words[j]))
                {
                    flag=false;
                    continue;
                }
            if(flag) list.add(i);
        }
        return list;
    }

}
