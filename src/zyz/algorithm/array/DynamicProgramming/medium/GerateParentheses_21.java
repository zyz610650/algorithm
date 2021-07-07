package zyz.algorithm.array.DynamicProgramming.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zyz
 * @title: 括号生成
 * @seq: 21
 * @address: https://leetcode-cn.com/problems/generate-parentheses/
 * @idea:
 *  思路1:DFS+回溯
 */
public class GerateParentheses_21 {
    static List<String> list=new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(generateParenthesis1(3).toString());
    }

//dfs
    public static  List<String> generateParenthesis(int n) {
        StringBuilder sb=new StringBuilder();
        f(0,0,sb,n);
        return list;
    }
    public static void f(int left,int right,StringBuilder sb,int n)
    {
        if(right>left) return;
        if(left==n&&right==n)
        {
            list.add(sb.toString());
            return;
        }

        if(left<n)
        {
            f(left+1,right,sb.append("("),n);
            sb.deleteCharAt(sb.length()-1);
        }
         f(left,right+1,sb.append(")"),n);
         sb.deleteCharAt(sb.length()-1);

    }

    //dp
    public static List<String> generateParenthesis1(int n) {
        LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
        if (n == 0)
            return result.get(0);
        LinkedList<String> list0 = new LinkedList<String>();
        list0.add("");
        result.add(list0);
        LinkedList<String> list1 = new LinkedList<String>();
        list1.add("()");
        result.add(list1);
        for (int i = 2; i <= n; i++) {
            LinkedList<String> temp = new LinkedList<String>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" + s2;
                        temp.add(el);
                        System.out.println("第"+i+" s1:"+s1+"          s2:  "+s2+"         "+el.toString());
                    }
                    System.out.println();
                }

            }
            result.add(temp);
        }
        return result.get(n);
    }

}
