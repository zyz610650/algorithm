package zyz.algorithm.array.medium;

/**
 * @author zyz
 * @title:
 * @seq:
 * @address:
 * @idea:
 */
public class ValidSudoku_42 {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] col=new boolean[9][9];
        boolean[][] row=new boolean[9][9];
        boolean[][][] vis=new boolean[3][3][9];
        int ch;
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.') continue;
                ch=board[i][j]-'1';
                if(col[j][ch]||row[i][ch]||vis[i/3][j/3][ch]) return false;

                col[j][ch]=row[i][ch]=vis[i/3][j/3][ch]=true;
            }
        }
        return true;
    }
}
