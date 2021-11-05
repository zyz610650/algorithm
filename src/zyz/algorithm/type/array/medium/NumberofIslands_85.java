package zyz.algorithm.type.array.medium;

import zyz.algorithm.utils.Utils;

/**
 * @author zyz
 * @title: 岛屿数量
 * @seq: 200
 * @address: https://leetcode-cn.com/problems/number-of-islands/
 * @idea:
 */
public class NumberofIslands_85 {

    static boolean[][] vis=null;
    static int cnt=0;
    static int[] dx={0,0,-1,1},dy={-1,1,0,0};

    public static void main(String[] args) {

       char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        Utils.print2Arr(grid);
        System.out.println(numIslands(grid));

    }
    public static int numIslands(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        vis=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1'&&!vis[i][j])
                {
                    vis[i][j]=true;
                    dfs(grid,m,n,i,j);

                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(char[][] grid,int m,int n,int x,int y)
    {

        int newX,newY;
        for(int i=0;i<4;i++)
        {
            newX=x+dx[i];
            newY=y+dy[i];
            if(newX<0||newX>=m||newY<0||newY>=n||vis[newX][newY]||grid[newX][newY]=='0') continue;
            vis[newX][newY]=true;
            dfs(grid,m,n,newX,newY);
        }
    }
}
