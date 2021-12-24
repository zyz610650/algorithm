package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 64. 求1+2+…+n
 * @seq: 64
 * @address: https://leetcode-cn.com/problems/qiu-12n-lcof/
 * @idea:
 *
 */
public class T64_294 {
	public int sumNums(int n) {
		boolean x=n>1&&(n+=sumNums(n-1))>0;
		return n;
	}
}
