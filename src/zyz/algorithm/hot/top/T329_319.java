package zyz.algorithm.hot.top;

/**
 * @author zyz
 * @title: 329. 矩阵中的最长递增路径
 * @seq: 329
 * @address: https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 * @idea:
 */
public class T329_319 {

    int max=0;
    int[] dx={1,-1,0,0};
    int[] dy={0,0,1,-1};

    public static void main(String[] args) {

    }
    public int longestIncreasingPath(int[][] matrix) {

        int[][] map=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                dfs(map,i,j,matrix);
        return max;

    }
    public int dfs(int[][] map,int x,int y,int[][] matrix)
    {
        if(map[x][y]!=0) return map[x][y];
        for(int i=0;i<4;i++)
        {
            int newX=x+dx[i];
            int newY=y+dy[i];
            if(newX<0||newX>=map.length||newY<0||newY>=map[0].length||matrix[newX][newY]<=matrix[x][y])
                continue;
            map[x][y]=Math.max(dfs(map,newX,newY,matrix)+1,map[x][y]);
            max=Math.max(map[x][y],max);
        }
        if(map[x][y]==0) map[x][y]=1;
        max=Math.max(map[x][y],max);
        return map[x][y];
    }
}
