package zyz.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 单词搜索 II
 * @seq: 212
 * @address: https://leetcode-cn.com/problems/word-search-ii/
 * @idea:
 *
 *  使用DFS 太慢，可以用前缀树来解决，但还没学，等学数据结构时再写
 */
public class WordSearch2_88_P {

    static int[] dx={-1,1,0,0},dy={0,0,-1,1};
    static List<String> list=new ArrayList<>();
    static boolean[][] vis;

    public static void main(String[] args) {
        char[][]board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        findWords(board,words);
        for (String str:list)
        System.out.println(str);


    }
    public  static List<String> findWords(char[][] board, String[] words) {
        int m=board.length,n=board[0].length;
        boolean flag=false;
        for(int i=0;i<words.length;i++)
        {
            flag=false;
            for(int j=0;j<m;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(board[j][k]==words[i].charAt(0))
                    {
                        vis=new boolean[m][n];
                        vis[j][k]=true;
                        flag=dfs(board,words[i],j,k,1);
                    }
                    if(flag) break;
                }
                if(flag) break;
            }

        }

        return list;
    }

    static  boolean dfs(char[][] board, String word,int x,int y,int index)
    {

        if(index==word.length())
        {
            list.add(word);
            return true;
        }
        int m=board.length,n=board[0].length;
        int newX,newY;
        boolean flag=false;
        for(int i=0;i<4;i++)
        {
            newX=x+dx[i];
            newY=y+dy[i];
            if(newX<0||newX>=m||newY<0||newY>=n) continue;
            if (vis[newX][newY]||board[newX][newY]!=word.charAt(index)) continue;
            vis[newX][newY]=true;
            flag=dfs(board,word,newX,newY,index+1);
            if(flag) return true;
            vis[newX][newY]=false;
        }
        return false;
    }
}
