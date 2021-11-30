package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 16. 数值的整数次方
 * @seq: 16
 * @address: https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * @idea:
 * 快速幂
 *
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
 *  https://zhuanlan.zhihu.com/p/95902286
 */

public class T16_239 {
	public static void main (String[] args) {

		int x=Integer.MIN_VALUE;
		System.out.println (x);
		long m=-x;
		System.out.println (m);
		long n=x;
		System.out.println (n);
		n=-n;
		System.out.println (n);

	}
	/**
	 * 快速幂 二分(也就是非递归)
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
		if(n==0) return 1;
		if(n==1) return x;
		if(n==-1) return 1/x;
		double tmp=0;
		if((n&1)==1)
		{
			tmp=(myPow(x,(n-1)/2));
			return x*tmp*tmp;
		};
		tmp=(myPow(x,n/2));
		return tmp*tmp;
	}

	/**
	 * 快速幂 二进制法) （也就是非递归法）
	 *
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow1(double x, int n) {
		if(x==0||x==1) return x;
		long m=n;
		double res=1.0;
		if(n<0)
		{
			x=1/x;
			m=-m;
		}

		while(m>0)
		{
			if((m&1)==1) res*=x;
			m=m>>1;
			x=x*x;
		}
		return res;

	}
}
