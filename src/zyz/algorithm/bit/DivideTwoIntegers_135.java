package zyz.algorithm.bit;

/**
 * @author zyz
 * @title: 两数相除
 * @seq: 29
 * @address: https://leetcode-cn.com/problems/divide-two-integers/
 * @idea:
 * 题解:
 * https://leetcode-cn.com/problems/divide-two-integers/solution/jian-dan-yi-dong-javac-pythonjs-liang-sh-ptbw/
 */
public class DivideTwoIntegers_135 {
	public static void main (String[] args) {

		System.out.println (543132133+Integer.MIN_VALUE);
		System.out.println (543132133-Integer.MIN_VALUE);
	}
	// 击败5%
	public int divide1(int dividend, int divisor) {
		if (dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;
		int sign=(dividend>0)^(divisor>0)?-1:1;
		//因为   32 位最小值：-2^31 = -2147483648 Integer.MIN_VALUE无法转换为正数
		if (dividend>0) dividend=-dividend;
		if (divisor>0)  divisor=-divisor;

		int res=0;
		while (dividend<=divisor)
		{
			dividend-=divisor;
			res++;
		}

		return  sign==1?res:-res;
	}

	//优化 100% 空间5%
	public int divide2(int dividend, int divisor) {
		if (dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;
		int sign=(dividend>0)^(divisor>0)?-1:1;
		//因为   32 位最小值：-2^31 = -2147483648 Integer.MIN_VALUE无法转换为正数
		// 所以都转换成负数来计算
		if (dividend>0) dividend=-dividend;
		if (divisor>0)  divisor=-divisor;

		int res=0;
		int k=0;
		int value=0;
		while (dividend<=divisor)
		{
			value=divisor;
			k=1;
			// 0xc0000000 是十进制 -2^30 的十六进制的表示
			while (value>=0xc0000000&&dividend<=value+value)
			{
				value+=value;
				k+=k;
			}
			dividend-=value;
			res+=k;
		}

		return  sign==1?res:-res;
	}

	// 位运算优化
	public int divide3(int dividend, int divisor)
	{
		if (dividend==Integer.MIN_VALUE&&divisor==-1)
			return Integer.MAX_VALUE;
		int sign=(dividend>0)^(divisor>0)?-1:1;
		// 注意 dividend = -2147483648   Math.abs (dividend) 还为-2147483648
		dividend=Math.abs (dividend);
		divisor=Math.abs (divisor);

		int res=0;
		for(int i=31;i>=0;i--)
		{
			// dividend<<i 可能会越界 右移的话，再怎么着也不会越界 因为最小为0 所以将divisor转换为dividend左移
			//  a >= (b << i) 转换成 (a >>> i) - b >= 0 两个效果一样只是把b*2^i改为a/2^i
			// 因为 a >= (b << i)可能会越界 所以这里需要转换

			// 注意，这里不能是 (a >>> i) >= b 而应该是 (a >>> i) - b >= 0
			// 这个也是为了避免 b = -2147483648，如果 b = -2147483648
			// 那么 (a >>> i) >= b 永远为 true，但是 (a >>> i) - b >= 0 为 false
			// 	任何数减去Integer.MIN_VALUE都为负数 所以这里 b = -2147483648正常运算
			if ((dividend>>>i)-divisor>=0)
			{
				// divisor<<i 表示divisor*2^i 所以下面为res+=(1<<i) 相当于dividend减去2^i个divisor
				dividend-=(divisor<<i);
				res+=(1<<i);
			}
		}
		return sign == 1 ? res : -res;
	}

}
