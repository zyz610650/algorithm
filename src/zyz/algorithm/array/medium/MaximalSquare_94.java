package zyz.algorithm.array.medium;

import zyz.algorithm.utils.Utils;

/**
 * @author zyz
 * @title: 最大正方形
 * @seq: 221
 * @address: https://leetcode-cn.com/problems/maximal-square/
 * @idea:
 *
 * 评论区解析
 * 做这个题的第一感觉，就是要根据题目的数据量分析一下复杂度。
 *
 * 行列最多300的话，O(N^3)的复杂度差不多就是上限了。
 *
 * 比较直接的，就是先用O(N^2)的复杂度求出二维前缀和，再用O(N^3)算法利用二维前缀和的结果找出最大正方形。
 *
 * 但是，很明显，O(N^3）不可能作为此题的理想做法，因此直觉告诉我存在O(N^2）的方法。
 *
 * 但是这个题又是二维，所以行列两个维度必须保留，所以dp形式估计就是dp[i][j]。
 *
 * 但是怎么定义，不难直接定义dp[i][j]是最大正方形面积，但需要明确这个正方形是怎么和dp[i][j]直接建立联系的。
 *
 * 对于划分一个矩形，可以采用四维方法，例如采用对角线，但这个题目显然不能采用四维，复杂度达到O(N^4)实际上和暴力法没差别了。
 *
 * 还有一种方法，就是把i,j作为某一个矩形的右下角元素，一般而言，就是这两种考虑。
 *
 * 那么采用后者的考虑办法的话，这个题目就已经出来了，考虑dp[i-1][j], dp[i][j-1], dp[i-1][j-1]这三个关键的矩形，就可以推算出，dp[i][j]。
 *
 * 好了，怎么推算，这个交给自己去思考，毕竟关键的dp定义已经搞定了
 */
public class MaximalSquare_94 {
    public static void main(String[] args) {
   // char[][] matrix= {{'1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','0','0','0'},{'0','1','1','1','1','0','0','0'}};
        char[][] matrix=  {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare1(matrix));
        Utils.print2Arr(matrix);
    }

//暴力
    public static int maximalSquare(char[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[][] storage=new int[m+1][n+1];

        for(int i=0;i<m;i++)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(matrix[i][j]=='1') storage[i][j]=storage[i][j+1]+1;
            }
        }
        Utils.print2Arr(storage);
        int ans=0;
        int wid=Integer.MAX_VALUE,len;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                wid=Integer.MAX_VALUE;
                for(int k=i;k<m;k++)
                {
                    if(storage[k][j]==0) break;
                    wid=Math.min(wid,storage[k][j]);
                    len=k-i+1;
                    len=Math.min(len,wid);
                    ans=Math.max(len*len,ans);
                }
            }

        }
        return ans;
    }

    //dp
    public static int maximalSquare1(char[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[][] dp=new int[m+1][n+1];
        int ans=0;

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(matrix[i-1][j-1]=='0') continue;
                dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                ans=Math.max(ans,dp[i][j]);
            }
        }
        Utils.print2Arr(dp);
        return ans*ans;
    }
}
