package zyz.algorithm.type.CharacterString.hard;

/**
 * @author zyz
 * @title: 正则表达式匹配
 * @seq: 10
 * @address: https://leetcode-cn.com/problems/regular-expression-matching/
 * @idea:
 * dp[i][j] s的前i个字符 和p的前j个字符匹配
 * dp[i][j]=
题解: https://leetcode-cn.com/problems/regular-expression-matching/solution/shou-hui-tu-jie-wo-tai-nan-liao-by-hyj8/
对于 * 让 a 重复 >= 2 次的情况, 解释的意思是s去掉末尾的一个a 然后看剩下的字符串和p重新考虑以上几种匹配的情况，
 还有可能再去一个a者也考虑在s去掉末尾的一个a 这种情况里

 和 https://leetcode-cn.com/problems/longest-valid-parentheses/ 同类型
 */

public class RegularExpressionMatching_106 {
    public static void main(String[] args) {
       String s = "aaa",p =  "ab*a*c*a";
        System.out.println(isMatch(s,p));


    }

    public static boolean isMatch(String s, String p) {

        char[] chs=s.toCharArray();
        char[] chp=p.toCharArray();
        int slen=chs.length,plen=chp.length;
        boolean[][] dp=new boolean[slen+1][plen+1];
        dp[0][0]=true;
        for(int i=1;i<=plen;i++)
        {
            if(chp[i-1]=='*') dp[0][i]=dp[0][i-2];
        }

        for(int i=1;i<=slen;i++)
        {
            for(int j=1;j<=plen;j++)
            {
                if(chs[i-1]==chp[j-1]||chp[j-1]=='.') dp[i][j]=dp[i-1][j-1];
                if(chp[j-1]=='*')
                {
                    if(chs[i-1]==chp[j-2]||chp[j-2]=='.')
                    {
                        dp[i][j]=dp[i][j-2]||dp[i-1][j-2]||dp[i-1][j];
                    }else{
                        dp[i][j]=dp[i][j-2];
                    }
                }
            }
        }
        return dp[slen][plen];

    }
}
