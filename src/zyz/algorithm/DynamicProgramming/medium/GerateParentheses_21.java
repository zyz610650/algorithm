package zyz.algorithm.DynamicProgramming.medium;

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
 *  思路2:DP
 *    1.dp[i] 表示前i组括号的所有情况
 *    2.dp[i]=左括号和右括号 放到 dp[i-1]中已经确定过的组合中任意一个能放的位置，因为存放的位置很多，所有引入p和q 如果不理解可以
 *    想象一下第i组括号怎么往第已经确定了的前i-1组括号确定的组合里添加
 *    这里引进p和q 分别表示第p和第q组括号
 *    比如 dp[i-1]=[()()(), ()(()), (())(), (()()), ((()))];=dp[p]+dp[q]  p + q = i-1，且 p q 均为非负整数。
 *    比如: 前i-1组括号的一种情况是 ()(())
 *    则第i组括号可以放的位置 i(i)i(i(i)i)i i-1个括号（拿出了括号E）仅可能分布于括号E内和括号E外，分为两种子情况讨论！
 *    这里的意思是 固定q 然后 "(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
 *    把第i组括号添加到【i=p时所有括号的排列组合】上,p从0开始遍历，q=i-1-p
 *    dp[n]="(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
 *     p + q = i-1 就是 p从0开始遍历 q=i-1-p p和q的组合组成了i-1组括号的所有情况

 *
 *
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
