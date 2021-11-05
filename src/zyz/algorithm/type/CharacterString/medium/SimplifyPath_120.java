package zyz.algorithm.type.CharacterString.medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 简化路径
 * @seq: 71
 * @address: https://leetcode-cn.com/problems/simplify-path/
 * @idea:
 */

public class SimplifyPath_120 {

    public static void main(String[] args) {

        String path="/a//b////c/d//././/..";
        System.out.println(simplifyPath(path));
    }
    public static String simplifyPath(String path) {
        Deque stack =new LinkedList();
        String[] chs=path.split("/");
        System.out.println(Arrays.toString(chs));
        for(int i=0;i<chs.length;i++)
        {
            if(chs[i].equals(" ")||chs[i].equals(".")||chs[i].equals(""))
                continue;
            if(chs[i].equals("..")) stack.pollFirst();
            else stack.addFirst(chs[i]);
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty())
        {
            sb.append("/").append(stack.pollLast());
        }
        if (sb.length()==0) sb.append("/");
        return sb.toString();

    }
}
