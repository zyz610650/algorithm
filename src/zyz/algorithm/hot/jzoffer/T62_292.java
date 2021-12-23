package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 62. 圆圈中最后剩下的数字
 * @seq: 62
 * @address: https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * @idea:
 *
 */
public class T62_292 {


	public int lastRemaining(int n, int m) {
		int index=0;
		for(int i=2;i<=n;i++)
		{
			index=(index+m)%i;
		}
		return index;

	}
	public int f(int n,int m)
	{
		if(n==1) return 0;
		int x=f(n-1,m);
		return (m+x)%n;
	}
}
