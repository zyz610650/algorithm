package zyz.algorithm.DynamicProgramming;

/**
 * @author zyz
 * @title: 判断子序列
 * @seq: 18
 * @address: https://leetcode-cn.com/problems/is-subsequence/
 * @idea:
 *
 *   1、dp[i][j]  前i个字符和是否是长度为j的模式串中某个字符匹配上
 *   2. if ((s.charAt(i)==t.charAt(j)||dp[i][j-1])&&dp[i-1][j-1]) dp[i][j] =true;
 */
public class IsSubsequence_18 {
    public static void main(String[] args) {
        String s="b",t="c";

        isSubsequence3(s,t);
    }



    public static  boolean isSubsequence3(String s, String t) {
        if (s.equals("")) return true;
        if(t.equals("")) return false;
        boolean[][] dp=new boolean[s.length()][t.length()];

        boolean flag=false;
        for(int i=0;i<s.length();i++)
            for(int j=0;j<t.length();j++)
            {
                if(j==0)
                {
                    if(s.charAt(i)== t.charAt(j))
                        dp[i][j] =true;

                }
                else if(i==0)
                {
                    if (s.charAt(i)==t.charAt(j)||dp[i][j-1])
                        dp[i][j] =true;
                    continue;
                }
                else if ((s.charAt(i)==t.charAt(j)&&dp[i-1][j-1])||dp[i][j-1])
                    dp[i][j] =true;

            }

        return dp[s.length()-1][t.length()-1];
    }
    /**
     * 上面我写的DP太啰嗦了 这个好 不过效率一样 定义的DP数组含义不同
     *
     * dp[i][j]：表示字符串 t 的前 i 个元素和字符串 s 的前 j 个元素中公共子序列的长度。
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence2(String s, String t) {

        int n = s.length();
        int m = t.length();
        if (n > m) return false;

        int[][] dp = new int[m + 1][n + 1];
        for (int i=1;i<=m;i++) {

            for (int j=1;j<=n;j++) {

                if (t.charAt(i - 1) == s.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if (dp[m][n] == n) return true;
        else return false;
    }

    /**
     * 双指针
     * @param s
     * @param t
     * @return
     */
    boolean isSubsequence1(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i)== t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

}
