package zyz.algorithm.type.CharacterString.medium;

import java.util.*;

/**
 * @author zyz
 * @title: 字母异位词分组
 * @seq: 49
 * @address: https://leetcode-cn.com/problems/group-anagrams/
 * @idea:
 */
public class GroupAnagrams_114 {

    public static void main(String[] args) {
       String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {


        Map<String,List<String>> map=new HashMap<>();
        char[] chs;
        for(int i=0;i<strs.length;i++)
        {
            chs=strs[i].toCharArray();
            Arrays.sort(chs);
            String str=String.valueOf(chs);
            map.computeIfAbsent(str,s->{
                ArrayList<String> list = new ArrayList<>();
                return list;
            });
            map.get(str).add(strs[i]);
        }
// computeIfAbsent的逻辑用代替也行

//        List<String> list = map.getOrDefault(key, new ArrayList<String>());
//        list.add(str);
//        map.put(key, list);



        return new ArrayList<List<String>>(map.values());
    }
}
