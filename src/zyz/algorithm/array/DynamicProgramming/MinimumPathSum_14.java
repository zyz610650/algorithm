package zyz.algorithm.array.DynamicProgramming;

/**
 * @author zyz
 * @title: 最小路径和
 * @seq: 14
 * @address: https://leetcode-cn.com/problems/minimum-path-sum/$
 * @idea:
 *    1.定义数组 dp[i][j]  表示从（i,j) 这个位置数组总和最小
 *    2. 最优子结构  dp[i][j]=min(dp[i-1][j],dp[i][j-1])+grid[i][j]
 *    3.定义边界 第0行 第0列 设置初值
 */
public class MinimumPathSum_14 {


    public static int minPathSum(int[][] grid) {
        System.out.println();
        int m=grid.length, n=grid[0].length;
        int[][] dp=new int[m][n];
        for (int i=1;i<m;i++)
            dp[i][0]=grid[i][0]+dp[i-1][0];
        for (int j=1;j<n;j++)
            dp[0][j]=grid[0][j]+dp[0][j-1];

        for (int i=1;i<m;i++)
            for (int j=1;j<n;j++)
            {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        return dp[m-1][n-1];
    }
}
