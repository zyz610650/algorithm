package zyz.algorithm.hash;

/**
 * @author zyz
 * @title: 快乐数
 * @seq: 202
 * @address: https://leetcode-cn.com/problems/happy-number/
 * @idea:
 *
 *   Integer.MAX_VALUE 最大11位
 *   假设  11位上都为9 则11*(9*9)<1000 可见不会无限大，只会为1然后循环 或者不为1循环
 */
public class HappyNumber_178 {
	public static void main (String[] args) {
		System.out.println (Integer.MAX_VALUE);

	}
	public boolean isHappy(int n) {

		int slow=n,fast=n;

		do{
			slow=f(slow);
			fast=f(fast);
			fast=f(fast);
		}while(slow!=fast);
		return slow==1;
	}
	public int f(int n)
	{
		int ans=0;
		int t;
		while(n>0)
		{
			t=n%10;
			ans+=t*t;
			n=n/10;
		}
		return ans;
	}
}
