package zyz.algorithm.type.CharacterString.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 复原 IP 地址
 * @seq: 93
 * @address: https://leetcode-cn.com/problems/restore-ip-addresses/
 * @idea:
 */
public class RestoreIPAddresses_121 {
    static List<String> list=new ArrayList<>();

    public static void main(String[] args) {
        String s = "010010";
        System.out.println(restoreIpAddresses(s));
        list.clear();
    }
    public static List<String> restoreIpAddresses(String s) {

        char[] chs=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        dfs(chs,0,4,sb);
        return list;
    }

    static void dfs(char[] chs, int t, int n, StringBuilder sb)
    {
        if(n==0&&t==chs.length)
        {
            sb.deleteCharAt(sb.length()-1);
            list.add(sb.toString());
            return;
        }
        StringBuilder s=new StringBuilder(sb);
        int num=0;
        for(int i=t;i<chs.length;i++)
        {
            if(chs.length-i>n*3) break;
            if(num==0&&i>t) break;
            num=num*10+chs[i]-'0';
            if (num>255) break;
            s.append(chs[i]);
            s.append(".");
            dfs(chs,i+1,n-1,s);
            s.deleteCharAt(s.length()-1);
        }
    }
}
