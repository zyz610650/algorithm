package zyz.algorithm.array.DynamicProgramming.medium;

import zyz.algorithm.utils.Utils;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 不同路径 II
 * @seq: 23
 * @address: https://leetcode-cn.com/problems/unique-paths-ii/
 * @idea:
 *  简单题
 *   思路1:dfs +剪枝
 *   思路2:Dp
 */
public class UniquePathsII_23 {

    public static void main(String[] args) {
        int[][] obstacleGrid= {{1,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
    public static  int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        if (obstacleGrid[0][0] == 1)
            return 0;
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0)
                dp[i][0] = dp[i - 1][0];
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0)
                dp[0][i] = dp[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

            return dp[m - 1][n - 1];

        }


    //滚动数组
    public static  int uniquePathsWithObstacles1(int[][] obstacleGrid)
    {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp=new int[n];

        dp[0]=obstacleGrid[0][0]==0?1:0;
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                if (obstacleGrid[i][j]==1)
                {
                    dp[j]=0;
                    continue;
                }
                if (j-1>=0&&obstacleGrid[i][j-1]==0)
                {
                    dp[j]+=dp[j-1];
                }
            }
        }
        return dp[n-1];
    }

}
