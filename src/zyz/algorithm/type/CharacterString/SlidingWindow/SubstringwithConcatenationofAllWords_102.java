package zyz.algorithm.type.CharacterString.SlidingWindow;

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
        String s ="lingmindraboofooowingdingbarrwingmonkeypoundcake";
                //"barfoofoobarthefoobarman";


                //"wordgoodgoodgoodbestword";
        String[] words = {"fooo","barr","wing","ding","wing"};
                //{"word","good","best","word"};
        System.out.println(findSubstring2(s,words));
    }
    //
    public static List<Integer> findSubstring1(String s, String[] words) {
        int len=0;
        Map<String,Integer> map=new HashMap<>();
        int wordLen=words[0].length();

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

        StringBuilder sb;
        List<Integer> list=new ArrayList<>();
        String word;
        for(int i=0;i<=s.length()-len;i++)
        {

            Map<String,Integer> map1=new HashMap<>(map);
            sb=new StringBuilder();
            word=s.substring(i,i+len);
            boolean flag=true;
            for(int j=0;j<word.length();j+=wordLen)
            {
                sb.append(word.substring(j,j+wordLen));
                if (map1.containsKey(sb.toString()))
                {
                    map1.put(sb.toString(),map1.get(sb.toString())-1);
                    sb=new StringBuilder();
                }else
                {
                    flag=false;
                    break;
                }
            }
         if (!flag) continue;
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

    //优化了 判重少了一次for循环 提升了20%的效率
    public static List<Integer> findSubstring(String s, String[] words) {
        int len=0;
        Map<String,Integer> map=new HashMap<>();
        int wordLen=words[0].length();
        len=wordLen*words.length;
        for(int i=0;i<words.length;i++)
        {
            map.put(words[i],map.getOrDefault(words[i],0)+1);

        }

        List<Integer> list=new ArrayList<>();
        String word;
        String str;
        for(int i=0;i<=s.length()-len;)
        {

            Map<String,Integer> map1=new HashMap<>(map);
            word=s.substring(i,i+len);
            boolean flag=true;
            for(int j=0;j<word.length();j+=wordLen)
            {
                str=word.substring(j,j+wordLen);
                if (map1.containsKey(str))
                {
                    int value=map1.get(str)-1;
                    if (value<0)
                    {
                        // 第一种情况
                        i+=wordLen;;
                        flag=false;
                        break;
                    }
                    map1.put(str,value);
                }else
                {
                    // 第二种情况
                    i=i+j+wordLen;
                    flag=false;
                    break;
                }
            }

            if (flag)
            {
                list.add(i);
                // 第一种情况
                i+=wordLen;
            }
        }
        return list;
    }

    // 有点kmp的思想 没看懂
    public static List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();
        HashMap<String, Integer> allWords = new HashMap<String, Integer>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        //将所有移动分成 wordLen 类情况
        for (int j = 0; j < wordLen; j++) {
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0; //记录当前 HashMap2（这里的 hasWords 变量）中有多少个单词
            //每次移动一个单词长度
            for (int i = j; i < s.length() - wordNum * wordLen + 1; i = i + wordLen) {
                boolean hasRemoved = false; //防止情况三移除后，情况一继续移除
                while (num < wordNum) {
                    String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                    if (allWords.containsKey(word)) {
                        int value = hasWords.getOrDefault(word, 0);
                        hasWords.put(word, value + 1);
                        //出现情况三，遇到了符合的单词，但是次数超了
                        if (hasWords.get(word) > allWords.get(word)) {
                            // hasWords.put(word, value);
                            hasRemoved = true;
                            int removeNum = 0;
                            //一直移除单词，直到次数符合了
                            while (hasWords.get(word) > allWords.get(word)) {
                                String firstWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                int v = hasWords.get(firstWord);
                                hasWords.put(firstWord, v - 1);
                                removeNum++;
                            }
                            num = num - removeNum + 1; //加 1 是因为我们把当前单词加入到了 HashMap 2 中
                            i = i + (removeNum - 1) * wordLen; //这里依旧是考虑到了最外层的 for 循环，看情况二的解释
                            break;
                        }
                        //出现情况二，遇到了不匹配的单词，直接将 i 移动到该单词的后边（但其实这里
                        //只是移动到了出现问题单词的地方，因为最外层有 for 循环， i 还会移动一个单词
                        //然后刚好就移动到了单词后边）
                    } else {
                        hasWords.clear();
                        i = i + num * wordLen;
                        num = 0;
                        break;
                    }
                    num++;
                }
                if (num == wordNum) {
                    res.add(i);

                }
                //出现情况一，子串完全匹配，我们将上一个子串的第一个单词从 HashMap2 中移除
                if (num > 0 && !hasRemoved) {
                    String firstWord = s.substring(i, i + wordLen);
                    int v = hasWords.get(firstWord);
                    hasWords.put(firstWord, v - 1);
                    num = num - 1;
                }

            }

        }
        return res;
    }



}
