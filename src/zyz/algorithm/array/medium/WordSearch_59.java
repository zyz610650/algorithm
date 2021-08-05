package zyz.algorithm.array.medium;

/**
 * @author zyz
 * @title: 单词搜索
 * @seq: 79
 * @address: https://leetcode-cn.com/problems/word-search/
 * @idea:
 */
public class WordSearch_59 {

    static int[] dx={0,0,1,-1},dy={1,-1,0,0};
    static boolean[][] vis;



    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        String word = "SEE";
        System.out.println(exist1(board,word));
    }

// 不存储 每次增加的字符串 速度和内存都降低
    public static  boolean exist1(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        vis=new boolean[m][n];
        boolean flag=false;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {

                if (board[i][j]==word.charAt(0))
                {
                    vis[i][j]=true;
                    flag=dfs1(board,word,1,i,j);
                    vis[i][j]=false;

                    if(flag) return true;
                }
            }
        }
        return flag;

    }
    public static boolean dfs1(char[][] board, String word,int t,int x,int y)
    {
        if(t==word.length()) return true;


        int newX,newY;
        boolean flag=false;
        for(int i=0;i<4;i++)
        {

            newX=x+dx[i];
            newY=y+dy[i];
            if(newX>=0&&newX<board.length&&newY>=0&&newY<board[0].length&&!vis[newX][newY])
            {

                if(board[newX][newY]==word.charAt(t))
                {
                    vis[newX][newY]=true;
                    flag=dfs1(board,word,t+1,newX,newY);
                    if(flag) return true;
                    vis[newX][newY]=false;
                }

            }
        }
        return false;

    }

    public static  boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        vis=new boolean[m][n];
        StringBuilder sb=null;
        boolean flag=false;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {

                if (board[i][j]==word.charAt(0))
                {
                    vis[i][j]=true;
                    sb=new StringBuilder();
                    sb.append(board[i][j]);
                    flag=dfs(board,word,sb,i,j);
                    vis[i][j]=false;

                    if(flag) return true;
                }
            }
        }
        return flag;

    }
    public static boolean dfs(char[][] board, String word,StringBuilder sb,int x,int y)
    {
        if(sb.toString().equals(word)) return true;

        int newX,newY;
        boolean flag=false;
        for(int i=0;i<4;i++)
        {

            newX=x+dx[i];
            newY=y+dy[i];
            if(newX>=0&&newX<board.length&&newY>=0&&newY<board[0].length&&!vis[newX][newY])
            {
                sb.append(board[newX][newY]);
                if(sb.toString().equals(word.substring(0,sb.length())))
                {
                    vis[newX][newY]=true;
                    flag=dfs(board,word,sb,newX,newY);
                    if(flag) return true;
                    vis[newX][newY]=false;
                }
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return false;

    }
}
