package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 65. 不用加减乘除做加法
 * @seq: 65
 * @address: https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * @idea:
 *
 * 把a+b转换成非进位和+进位，由于不能用加法，因此要一直转换直到第二个加数变成0。
 * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/jin-zhi-tao-wa-ru-he-yong-wei-yun-suan-wan-cheng-j/
 *
 */
public class T65_295 {

	public static void main (String[] args) {
		System.out.println (2<<1);
		System.out.println (2>>>1);
	}
	public int add(int a, int b) {
		for(int i=0;i<32;i++)
		{
			int c=a^b;
			a=(a&b)<<1;
			b=a;
			a=c;
		}
		return a;
	}
}
