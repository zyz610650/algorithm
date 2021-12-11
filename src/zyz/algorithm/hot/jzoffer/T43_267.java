package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * @seq: 43
 * @address: https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * @idea:
 *
 */
public class T43_267 {

	public int countDigitOne(int n) {
		int num=0;

		//    n/10^k+  Math.min(Math.max(n%10^k-100+1,0),100)
		long mulk=1;
		for(;n>=mulk;)
		{
			num+=(n/(mulk*10)*mulk+Math.min(Math.max(n%(mulk*10)-mulk+1,0),mulk));
			mulk=mulk*10;
		}
		return num;
	}
}
