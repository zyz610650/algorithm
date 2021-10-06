package zyz.algorithm.CharacterString.hard;

import java.util.*;

/**
 * @author zyz
 * @title: 单词拆分 II
 * @seq: 140
 * @address: https://leetcode-cn.com/problems/word-break-ii/
 * @idea:
 */
public class WordBreak2_126 {

    static boolean[] vis;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {


        String s = "aaaaaaa";
        String[] ss = {"aaaa","aa","a"};
        String[] s1={"a a a a a a a","aa a a a a a","a aa a a a a","a a aa a a a","aa aa a a a",
                "aaaa a a a","a a a aa a a","aa a aa a a","a aa aa a a","a aaaa a a",
                "a a a a aa a","aa a a aa a","a aa a aa a","a a aa aa a","aa aa aa a",
                "aaaa aa a","a a aaaa a","aa aaaa a","a a a a a aa","aa a a a aa",
                "a aa a a aa","a a aa a aa",
                "aa aa a aa","aaaa a aa","a a a aa aa","aa a aa aa","a aa aa aa","a aaaa aa","a a a aaaa","aa a aaaa","a aa aaaa"};
        System.out.println(wordBreak(s, Arrays.asList(ss)));

        Set<String> set1=new HashSet<>(Arrays.asList(s1));
        Set<String> set2=new HashSet<>(list);

        for (int i=0;i<set2.size();i++)
        {
            if (!set1.contains(list.get(i))) System.out.println(list.get(i));
        }

        System.out.println(set1.size());
        System.out.println(set2.size());
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        vis = new boolean[wordDict.size()];
        Set<String> set = new HashSet<>(wordDict);
        StringBuilder sb = new StringBuilder();
        dfs(s, 0, set, sb);
        return list;
    }

    static void dfs(String s, int index, Set<String> set, StringBuilder sb) {
        if (index == s.length()) {
            sb.deleteCharAt(sb.length() - 1);
            list.add(sb.toString());
            sb.append(" ");
            return;
        }
        StringBuilder str = new StringBuilder();
        for (int i = index; i < s.length(); i++) {
            str.append(s.charAt(i));
            if (set.contains(str.toString())) {

                if (sb.toString().equals("aaa a a"))
                {
                    System.out.println();
                }
                str.append(" ");
                sb.append(str.toString());

                dfs(s, i + 1, set, sb);

                sb.delete(sb.length()-str.length(), sb.length());

                str.deleteCharAt(str.length()-1);

            }
        }
    }

}
