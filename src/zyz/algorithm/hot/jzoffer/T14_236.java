package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 14- I. 剪绳子
 * @seq: 14
 * @address: https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * @idea:
 */
public class T14_236 {

	/**
	 * dp
	 * @param n
	 * @return
	 */
	public int cuttingRope(int n) {
		int[] dp=new int[n+1];
		dp[1]=1;
		dp[2]=1;
		for(int i=3;i<=n;i++)
		{
			for(int j=1;j<i;j++)
			{
				dp[i]=Math.max(dp[i],Math.max(dp[i-j]*j,(i-j)*j));
			}
		}
		return dp[n];

	}

	/**
	 * 贪心
	 * @param n
	 * @return
	 */
	public int cuttingRope1(int n) {

		if(n==2) return 1;
		if(n==3) return 2;
		if(n==4) return 4;
		int res=1;
		while(n>4)
		{
			res*=3;
			n-=3;
		}
		if(n>0) res*=n;
		return res;


	}
}
