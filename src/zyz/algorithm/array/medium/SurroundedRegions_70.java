package zyz.algorithm.array.medium;

import zyz.algorithm.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 被围绕的区域
 * @seq: 70
 * @address: https://leetcode-cn.com/problems/surrounded-regions/
 * @idea:
 */
public class SurroundedRegions_70 {
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
//回溯+剪枝即可解决
    public static void main(String[] args) {
       char[][] board = {{'O','O','O'},{'O','X','O'},{'O','O','O'}};
        Utils.print2Arr(board);
       solve1(board);
        System.out.println();
        Utils.print2Arr(board);

    }

    public static void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(board[i][j]=='O'&&dfs(board,i,j))
                {
                    board[i][j]='X';
                }
            }
        }
    }
    static boolean dfs(char[][] board,int i,int j)
    {
        if((i==0||i==(board.length-1)||j==0||j==(board[0].length-1))&&board[i][j]=='O') return false;
        boolean flag=true;
        for(int t=0;t<4;t++)
        {
            int newX=i+dx[t];
            int newY=j+dy[t];
            if(newX<0||newX>board.length||newY<0||newY>board[0].length||board[newX][newY]=='X') continue;
            flag=dfs(board,newX,newY);
            if(!flag) return false;
        }
        return true;
    }

    //两种思路 一种是从边界开始搜索，搜到'X'或者边界结束 就是该种方法 速度快 另一种是从数组内部开始搜索 搜到边界结束 上面的方法 记得判重
    static List<int[]> list=new ArrayList<>();
    static boolean[][] vis;
    public static void solve1(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        vis=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
                if(board[i][0]=='O')
                    dfs1(board,i,0);
                if(board[i][n-1]=='O')
                    dfs1(board,i,n-1);
        }
        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O')
                dfs1(board,0,i);
            if(board[m-1][i]=='O')
                dfs1(board,m-1,i);
        }
        for(int i=1;i<m-1;i++)
            for(int j=1;j<n-1;j++)
                board[i][j]='X';

         for(int[] arr:list)
            {
                board[arr[0]][arr[1]]='O';
            }
    }
    static void dfs1(char[][] board,int i,int j)
    {

        for(int t=0;t<4;t++)
        {
            int newX=i+dx[t];
            int newY=j+dy[t];
            if(newX<=0||newX>=board.length-1||newY<=0||newY>=board[0].length-1||board[newX][newY]=='X'||vis[newX][newY]) continue;
            int[] arr=new int[2];
            arr[0]=newX;
            arr[1]=newY;
            vis[newX][newY]=true;
            list.add(arr);
            dfs1(board,newX,newY);
        }

    }
}
