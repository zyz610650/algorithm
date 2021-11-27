package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 10- I. 斐波那契数列
 * @seq: 10
 * @address: https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * @idea:
 */
public class T10_232 {
	int[] cache;

	/**
	 * dp也行
	 * @param n
	 * @return
	 */
	public int fib(int n) {
		cache=new int[n+1];

		return dfs(n);
	}
	public int dfs(int n)
	{
		if(n==0||n==1) return n;
		int left=cache[n-1];
		int right=cache[n-2];
		if(left==0)
		{
			left=dfs(n-1);
		}
		if(right==0)
		{
			right=dfs(n-2);
		}
		return cache[n]=(left+right)%1000000007;
	}
}
