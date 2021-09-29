package zyz.algorithm.CharacterString.medium;

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
        char[] chs=path.toCharArray();
        char pre='/';
        StringBuilder sb=new StringBuilder();
        sb.append("/");
        String str = null;
        for(int i=0;i<chs.length;i++)
        {
            System.out.println(sb);
            if(chs[i]=='/'&&chs[i]==pre) continue;
            if(chs[i]=='.')
            {
                if (sb.length()>1)
                {
                    str=sb.toString();
                    if (chs[i-1]=='/') str=str.substring(0,str.length()-1);
                }
                sb=new StringBuilder();
                sb.append("/");
                pre='/';
                continue;
            }
            pre=chs[i];
            sb.append(chs[i]);
        }
        if (sb.length()>1)
            str=sb.toString();

        return str;
    }
}
