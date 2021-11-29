package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 14- II. 剪绳子 II
 * @seq: 14
 * @address: https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 * @idea:
 *  这题和剑指 Offer 14- I. 剪绳子的区别就是
 *   n 的限制条件变为:
 *    2 <= n <= 1000
 *    需要用Long来保存结果
 */
public class T15_237 {

	public static void main (String[] args) {
		System.out.println (Integer.MAX_VALUE);

	}
	public int cuttingRope(int n) {


		if(n==2) return 1;
		if(n==3) return 2;
		if(n==4) return 4;
		long res=1;
		while(n>4)
		{
			res=(res*3)%1000000007;
			n-=3;
		}
		if(n>0) res=(res*n)%1000000007;
		int r=(int)res;
		return r;
	}
}
