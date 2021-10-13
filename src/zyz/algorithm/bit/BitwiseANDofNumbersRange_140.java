package zyz.algorithm.bit;

/**
 * @author zyz
 * @title: 数字范围按位与
 * @seq: 201
 * @address: https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * 官方题解所说的 一定存在连续的两个数 xx 和 x+1x+1，满足 xx 的第 i+1i+1 位为 00，后面全为 11
 * 是 在保证了最大前缀为前i位,则第i+1位一定是有两个数是不同的
 * 而n +1 =n (二进制也是+1的关系)  所以一定有一个011 一个100 因为 011+1=110
 */
public class BitwiseANDofNumbersRange_140 {
	public int rangeBitwiseAnd(int left, int right) {
		int n=0;
		while(left<right)
		{
			right>>=1;
			left>>=1;
			n++;

		}

		return left<<n;
	}
}
