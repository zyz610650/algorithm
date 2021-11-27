package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 10- I. 斐波那契数列
 * @seq: 10
 * @address: https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * @idea:
 * 同T10
 */
public class T10_2 {

	public int numWays(int n) {
		int l=1,h=1;
		if(n==0||n==1) return 1;

		for(int i=2;i<=n;i++)
		{
			int tmp=(l+h)%1000000007;
			l=h;
			h=tmp;
		}
		return h;
	}
}
