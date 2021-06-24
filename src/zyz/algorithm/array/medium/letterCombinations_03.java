package zyz.algorithm.array.medium;

import java.util.*;

/**
 * @author zyz
 * @date $
 * @title: 电话号码的字母组合$
 * @seq: 3$
 * @address: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/$
 * @idea:
 *   StringBuilder>StringBuffer(线程安全)>String** 速度
 *   能用 StringBuilder 尽量不用String  StringBuilder的实现要比String快6ms
 */

public class letterCombinations_03 {

    static List<String>  list=new ArrayList<>();

    public static void main(String[] args) {

        letterCombinations("");
        System.out.println(list.toString());

    }
    public static List<String> letterCombinations(String digits) {
            list.clear();
            if(digits.equals("")) return list;
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] chars=digits.toCharArray();
        int [] nums=new int[chars.length];
        int len=chars.length;
        for (int i=0;i<len;i++) {
            nums[i]=chars[i]-'0';
        }

     f(0,nums,len,numString);
        return list;
    }
    static StringBuilder sb=new StringBuilder();
    public static void f(int i,int nums[],int len,String[] numString)
    {

        if (i==len)
        {
            list.add(sb.toString());
            return;
        }
        int index=nums[i];
        for (char ch:numString[index].toCharArray()) {
            sb.append(ch);
             f(i+1, nums, len, numString);
             sb.deleteCharAt(i);
        }
    }

// 这个使用String 比使用StringBuilder 慢6ms
    public static List<String> letterCombinations1(String digits) {
        list.clear();
        if(digits.equals("")) return list;
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] chars=digits.toCharArray();
        int [] nums=new int[chars.length];
        int len=chars.length;
        for (int i=0;i<len;i++) {
            nums[i]=chars[i]-'0';
        }

        f1(0,nums,len,"",numString);
        return list;
    }
    public static void f1(int i,int nums[],int len,String str,String[] numString)
    {

        if (i==len)
        {
            list.add(str);
            return;
        }
        int index=nums[i];
        for (char ch:numString[index].toCharArray()) {
            f1(i+1, nums, len,str+ch, numString);
        }
    }

}
