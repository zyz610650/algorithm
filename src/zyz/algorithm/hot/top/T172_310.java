package zyz.algorithm.hot.top;

/**
 * @author zyz
 * @title: 172. 阶乘后的零
 * @seq: 172
 * @address: https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * @idea:
 */
public class T172_310 {
	public static void main(String[] args) {
		
	}
	public int trailingZeroes(int n) {
		int cnt=0;
		while(n>0)
		{
			cnt+=n/5;
			n=n/5;
		}
		return cnt;
	}
}
