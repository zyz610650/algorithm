package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 47. 礼物的最大价值
 * @seq: 47
 * @address: https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * @idea:
 *
 */
public class T47_271 {


	boolean[][] flag;
	int[] dx={1,0};
	int[] dy={0,1};
	int max=0;

	/**
	 * 深搜 超时
	 * @param grid
	 * @return
	 */
	public int maxValue1(int[][] grid) {
		int m=grid.length,n=grid[0].length;
		flag=new boolean[m][n];
		dfs(grid,m,n,0,0,grid[0][0]);
		return max;
	}
	public void dfs(int[][] grid,int m,int n,int x,int y,int v)
	{
		if(x==m-1&&y==n-1)
		{
			max=Math.max(v,max);
			return;
		}
		for(int i=0;i<2;i++)
		{
			int newX=x+dx[i];
			int newY=y+dy[i];
			if(newX>=m||newY>=n||newX<0||newY<0||flag[newX][newY]) continue;
			flag[newX][newY]=true;
			dfs(grid,m,n,newX,newY,v+grid[newX][newY]);
			flag[newX][newY]=false;

		}
	}

	/**
	 * dp
	 * @param grid
	 * @return
	 */
	public int maxValue(int[][] grid) {
		int m=grid.length,n=grid[0].length;
		int[][] dp=new int[m+1][n+1];
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
			}
		}
		return dp[m][n];

	}
}
