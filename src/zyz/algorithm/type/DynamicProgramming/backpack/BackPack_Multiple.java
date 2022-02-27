package zyz.algorithm.type.DynamicProgramming.backpack;

/**
 * 多重背包
 */
public class BackPack_Multiple {
    public int f(int W,int[] w,int[] v,int N,int[] n)
    {
        int[][] dp=new int[N+1][W+1];
        for(int i=1;i<=N;i++)
        {

            for(int j=1;j<=W;j++) {
                dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
              for(int k=1;k<=Math.min(n[i],j/w[i]);k++)
              {
                  dp[i][j]=Math.max(dp[i][j-k*w[i]]+k*v[i],dp[i][j]);
              }
            }

        }
        return dp[W][N];
    }

        /**
         * 滚动数组优化
         * @param W
         * @param w
         * @param v
         * @param N
         * @return
         */
        public int f1(int W,int[] w,int[] v,int N)
        {
            int[] dp=new int[W+1];
            for(int i=1;i<=N;i++)
            {
                for(int j=1;j<=W;j++) {
                    dp[i]=Math.max(dp[i],dp[i-1]);
                    if(w[i]<=j)
                    {
                        dp[i]=Math.max(dp[j-w[i]]+v[j],dp[i]);
                    }

                }

            }
            return dp[W];
        }
}
