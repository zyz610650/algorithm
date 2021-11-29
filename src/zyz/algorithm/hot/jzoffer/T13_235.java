package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 13. 机器人的运动范围
 * @seq: 13
 * @address: https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @idea:
 */
public class T13_235 {
	int[] dx={1,-1,0,0};
	int[] dy={0,0,1,-1};
	boolean[][] flag;
	int ans=0;
	public int movingCount(int m, int n, int k) {
		flag=new boolean[m][n];
		ans=0;
		dfs(0,0,m,n,k);
		return ans;
	}

	public void dfs(int x,int y,int m,int n,int k)
	{
		if(!judge(x,y,m,n,k)) return;
		flag[x][y]=true;
		ans++;
		for(int i=0;i<4;i++)
		{
			dfs(x+dx[i],y+dy[i],m,n,k);
		}

	}

	boolean judge(int x,int y,int m ,int n,int k)
	{
		if(x<0||x>=m||y<0||y>=n||flag[x][y]) return false;

		int res=0;
		while(x>0)
		{
			res+=x%10;
			x=x/10;
		}
		while(y>0)
		{
			res+=y%10;
			y=y/10;
		}
		if(res>k) return false;
		return true;
	}
}
