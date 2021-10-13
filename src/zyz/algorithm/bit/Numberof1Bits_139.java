package zyz.algorithm.bit;

/**
 * @author zyz
 * @title:   位1的个数
 * @seq: 191
 * @address: https://leetcode-cn.com/problems/number-of-1-bits/
 * @idea:
 */
public class Numberof1Bits_139 {

	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {

		int t=0;
		int i=0;
		while(i<32)
		{
			t+=(n&1);
			n=n>>1;
			i++;
		}
		return t;
	}
}
