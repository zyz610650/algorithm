package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 44. 数字序列中某一位的数字
 * @seq: 44
 * @address: https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 * @idea:
 *
 */
public class T44_268 {
	public int findNthDigit(int n) {
		int digit=1;
		long start=1,count=9;
		while(n>count)
		{
			n-=count;
			digit++;
			start*=10;
			count=digit*start*9;
		}
		long num=start+(n-1)/digit;
		return Long.toString(num).charAt((n-1) % digit ) - '0';
	}
}
