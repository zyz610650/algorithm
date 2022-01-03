package zyz.algorithm.hot.top;


/**
 * @author zyz
 * @title: 289. 生命游戏
 * @seq: 289
 * @address: https://leetcode-cn.com/problems/game-of-life/
 * @idea:
 */
public class T289_313 {

    // -1 由0->1
    // -2 由1->0
    public void gameOfLife(int[][] board) {
        int m=board.length,n=board[0].length;

        int[] dx={1,1,1,0,0,-1,-1,-1};
        int[] dy={0,-1,1,1,-1,0,-1,1};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int t=0;
                for(int k=0;k<8;k++)
                {
                    int newX=i+dx[k];
                    int newY=j+dy[k];
                    //    System.out.println(newX+" "+newY+" ");

                    if(newX<0||newX>=m||newY<0||newY>=n) continue;
                    if(board[newX][newY]==1||board[newX][newY]==-2) t++;
                }
                // System.out.print(t+" ");
                //   System.out.println();
                //         System.out.println();
                if(t>3) board[i][j]=board[i][j]==0?0:-2;
                if(t==3) board[i][j]=board[i][j]==0?-1:1;
                if(t<2) board[i][j]=board[i][j]==0?0:-2;
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                //    System.out.print(board[i][j]+" ");
                if(board[i][j]==-1) board[i][j]=1;
                else if(board[i][j]==-2) board[i][j]=0;
            }
            // System.out.println();
        }

    }
}
