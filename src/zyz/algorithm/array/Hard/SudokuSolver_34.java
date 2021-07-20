package zyz.algorithm.array.Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 解数独
 * @seq: 37
 * @address: https://leetcode-cn.com/problems/sudoku-solver/
 * @idea:
 */
public class SudokuSolver_34 {
    static boolean[][] line=new boolean[9][9];
    static boolean[][]  col=new boolean[9][9];
    static boolean[][][] vis=new boolean[3][3][9];
    static List<Integer[]> list=new ArrayList<>();

    public static void main(String[] args) {
        int[][] d= {{1,2},{2,3}};
        for (int i=0;i<4;i++)
            System.out.println(d[0][i]);
//        char[][] board ={{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
//        solveSudoku(board);
//        Integer[] a=new Integer[]{1,2};

    }
    public static void solveSudoku(char[][] board) {
        addBlank(board);
       boolean f= dfs(board,0,list.size());
        System.out.println(f);
    }
    //计算所有没有填充的位置的坐标 并填充数组
    public static void addBlank(char[][] board)
    {
        Integer[] pos;
        char ch;
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                ch=board[i][j];
                if(ch=='.')
                {
                    pos=new Integer[2];
                    pos[0]=i;
                    pos[1]=j;
                    list.add(pos);
                }else{
                    line[i][ch-'1']=true;
                    col[j][ch-'1']=true;
                    vis[i/3][j/3][ch-'1']=true;
                }

            }
        }
    }
    public static boolean dfs(char[][] board,int pos,int n)
    {
        if(pos==n)
        {
            System.out.print("[");
            for(int i=0;i<9;i++)
            {
                System.out.print("[");
                for(int j=0;j<9;j++)
                    System.out.print(board[i][j]);
                System.out.println("],");
            }
            System.out.println("]");
            return true;
        }
        int x=(list.get(pos))[0],y=(list.get(pos))[1];
        for(int i=0;i<9;i++)
        {
            if(!line[x][i]&&!col[y][i]&&!vis[x/3][y/3][i])
            {
                line[x][i]=true;
                col[y][i]=true;
                vis[x/3][y/3][i]=true;
                board[x][y]= (char) (i+'1');
                if(dfs(board,pos+1,n)) return true;
                line[x][i]=false;
                col[y][i]=false;
                vis[x/3][y/3][i]=false;
            }
        }
        return false;


    }


}
class f2{
    //储存每一行存在的数字
    private int[] line = new int[9];
    //储存 每一列存在的数字
    private int[] column = new int[9];
    //储存每一个 3*3宫存在的数字
    private int[][] block = new int[3][3];
    //这个布尔数组用来判断是否填完所有空格
    private boolean valid = false;
    //这个list用来记录所有空格的位置，整数数组第一个位置为行的位置 ，第二个位置为列的位置
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        //遍历所有位置
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                //如果位置为空，我们把该位置加入spaces中
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    //不为空则把该数字分别纳入对应的行，列，3*3宫中
                    int digit = board[i][j] - '0' - 1;
                    flip(i, j, digit);
                }
            }
        }
        //开始搜索
        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        //如果spaces被遍历完了，说明我们填完了空格，将valid改为true，通过return结束这个函数
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        //获取第一个空格的位置
        int[] space = spaces.get(pos);
        //i，j分别为该空格的行数和列数
        int i = space[0], j = space[1];
        //|为or，通过3个或运算我们可以得到一个9位的二进制数字，从右到左分别代表1-9这个9个数是否可以填入该空格，通过~运算（取反），我们用1表示该数字是一个可填入的选项，0x1ff为十六进制 ，等同于111111111）
        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
        //当mask不为0并且 valid为false表示还有数待填入，继续这个循环，mask &= (mask - 1)把最低位的1变为0
        for (; mask != 0 && !valid; mask &= (mask - 1)) {
            //这个操作只保留最低位的1
            int digitMask = mask & (-mask);
            //最低位的1后面的位数，digitMask-1将原本1后面的0全部变为了1
            int digit = Integer.bitCount(digitMask - 1);
            //更新行，列，宫
            flip(i, j, digit);
            //把该数填入板中
            board[i][j] = (char) (digit + '0' + 1);
            //继续搜索
            dfs(board, pos + 1);
            //撤回操作（原理是flip中的~运算，两个 1则为0,0表示这个位置代表的1-9中的那个数 不再是一个可被填入的选项）
            flip(i, j, digit);
        }
    }

    public void flip(int i, int j, int digit) {
        //^代表异或，只有1个1的时候才为1。比如0011^1001=1010
        //<<代表左移，比如 1<<2=4被加入到下面的三个数组中，在二进制4为100，意味着3这个数字被占用了
        line[i] ^= (1 << digit);
        column[j] ^= (1 << digit);
        block[i / 3][j / 3] ^= (1 << digit);
    }
}
