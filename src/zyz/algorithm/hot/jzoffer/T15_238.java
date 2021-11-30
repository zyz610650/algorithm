package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 15. 二进制中1的个数
 * @seq: 15
 * @address: https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * @idea:
 *  这道题 负数求的就是它补码中1的个数
 *
 * 		 注意int类型 32位
 * 		 >> 和>>>的区别
 */



public class T15_238 {
	public int hammingWeight(int n) {
		int res=0;

		while(n!=0)
		{
			if((n&1)==1) res++;
			n=n>>>1;
		}
		return res;
	}


}
