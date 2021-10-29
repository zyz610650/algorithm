package zyz.algorithm.hash;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author zyz
 * @title: 丑数 II
 * @seq: 264
 * @address: https://leetcode-cn.com/problems/ugly-number-ii/
 * @idea:
 */
public class UglyNumber2_181 {

	public static void main (String[] args) {
		System.out.println (nthUglyNumber(10));
	}
	public static int nthUglyNumber1(int n) {

		Queue <Long> heap=new PriorityQueue <> ();
		int[] factors={2,3,5};
		Set <Long> set=new HashSet <> ();
		set.add(1L);
		heap.add(1L);
		long cnt=1L;
		for(int i=0;i<n;i++)
		{
			cnt=heap.poll();
			for(int j=0;j<3;j++)
			{
				long next=cnt*factors[j];
				if(set.add(next))
				{
					heap.add(next);
				}
			}
		}
		return (int)cnt;

	}

	/**
	 * 和上面使用堆的本质其实是一样的
	 * @param n
	 * @return
	 */
	public static int nthUglyNumber(int n) {
		int[] dp=new int[n+1];
		dp[1]=1;
		int p2=1,p3=1,p5=1;
		for(int i=2;i<=n;i++)
		{
			dp[i]=Math.min (Math.min (2*dp[p2],3*dp[p3]),5*dp[p5]);
			if(dp[i]==2*dp[p2])
			{
				p2++;
			}
			if(dp[i]==3*dp[p3])
			{
				p3++;
			}
			if(dp[i]==5*dp[p5])
			{
				p5++;
			}
		}
		return dp[n];
	}
}
