package zyz.algorithm.hot.top;

/**
 * @author zyz
 * @title: 50. Pow(x, n)
 * @seq: 50
 * @address: https://leetcode-cn.com/problems/powx-n/
 * @idea:
 * 快速幂
 */
public class T50_308 {

	public double myPow(double x, int n) {
		if(n==0) return 1;
		double res=1;
		boolean f=n<0?true:false;
		n=Math.abs(n);
		res=cal(x,n);
		return res=f==true?1/res:res;
	}
	public double cal(double x, int n) {
		if(n==0) return 1;
		if(n==1) return x;

		double res=cal(x,n/2);
		res*=res;
		if(n%2!=0) res*=x;
		return res;

	}
}
