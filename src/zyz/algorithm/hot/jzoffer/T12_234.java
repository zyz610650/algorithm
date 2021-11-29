package zyz.algorithm.hot.jzoffer;
/**
 * @author zyz
 * @title: 剑指 Offer 12. 矩阵中的路径
 * @seq: 12
 * @address: https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * @idea:
 */
public class T12_234 {
	int[] dx={1,-1,0,0};
	int[] dy={0,0,1,-1};
	boolean[][] flag;
	public boolean exist(char[][] board, String word) {
		flag=new boolean[board.length][board[0].length];
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				if( exist(board,word,0,i,j)) return true;
			}
		}
		return false;
	}

	public boolean exist(char[][] board,String word,int index,int x,int y)
	{

		if(index==word.length()) return true;
		if(x>=board.length||x<0||y>=board[0].length||y<0) return false;
		if(flag[x][y]) return false;
		char ch=word.charAt(index);
		if(board[x][y]!=ch) return false;
		flag[x][y]=true;
		for(int i=0;i<4;i++)
		{

			if( exist(board,word,index+1,x+dx[i],y+dy[i])) return true;
		}
		flag[x][y]=false;
		return false;

	}
}
