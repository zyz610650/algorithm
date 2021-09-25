package zyz.algorithm.CharacterString.hard;

import java.util.*;
import java.util.function.Function;

/**
 * @author zyz
 * @title: 最长有效括号
 * @seq: 32
 * @address: https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @idea:
 * 和
 */
public class LongestValidParentheses_110 {
    public static void main(String[] args) {
    String s="()()";
        System.out.println(longestValidParentheses(s));


    }
    //dp
    public static int longestValidParentheses1(String s) {
        int len=s.length();
        int[] dp=new int[len+1];
        char[] chs=s.toCharArray();
        int ans=0;
        for(int i=1;i<=len;i++)
        {
            int pre=i-dp[i-1]-1;
            if(pre>=1&&chs[i-1]==')'&&chs[pre-1]=='('){
                dp[i]=dp[i-1]+2;
                dp[i]+=dp[pre-1];
            }
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }
    // 这个思想是 栈中始终保存一个不能凑成一对括号的字符的下标,用于计算最后满足的一组括号比如 (()())
    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack=new LinkedList<>();
        char[] chs=s.toCharArray();
        stack.push(-1);
        for(int i=0;i<chs.length;i++)
        {
            if (chs[i]=='(') stack.push(i);
            else {
                stack.poll();
                if (stack.isEmpty()) stack.push(i);
                else maxans= Math.max(maxans,i-stack.peek());
            }
        }
        return maxans;
    }


















}
