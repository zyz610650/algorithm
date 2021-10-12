package zyz.algorithm.bit;

/**
 * @author zyz
 * @title:  颠倒二进制位
 * @seq: 190
 * @address: https://leetcode-cn.com/problems/reverse-bits/
 * @idea:
 */
public class ReverseBits_138 {
	public static void main (String[] args) {

		System.out.println (reverseBits(-3));


	}
	// 13  1101
	// you need treat n as an unsigned value
	public static int reverseBits(int n) {
		int t=0;
		int ans=0;
		t=n;
		int i=0;
		while(i<32)
		{
			i++;
			System.out.print ((t&1));
			ans=(ans<<1)+(t&1);
			t=t>>1;
		}
		System.out.println ();
		return ans;
	}
}
//00111001011110000010100101000000
//00111001011110000010100101000000