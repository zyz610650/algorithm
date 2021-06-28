package zyz.algorithm.array.DynamicProgramming;

/**
 * @author zyz
 * @title: 不同路径
 * @seq: 12
 * @address: https://leetcode-cn.com/problems/unique-paths/$
 * @idea:
 *   动态规划练习  该题用dfs也可以做
 */
public class UniquePaths_13 {

    public static void main(String[] args) {

        int m=3,n=2;

       // System.out.println(uniquePaths(m,n));
    }
    public static int uniquePaths(int m, int n) {

        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)
            dp[i][0]=1;
        for(int j=0;j<n;j++)
            dp[0][j]=1;

        for(int i=0;i<m;i++)
        {
            if(i==0) continue;
            for(int j=0;j<n;j++)
            {
                if(j==0) continue;
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
