package zyz.algorithm.hot.jzoffer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author zyz
 * @title: 剑指 Offer 49. 丑数
 * @seq: 49
 * @address: https://leetcode-cn.com/problems/chou-shu-lcof/
 * @idea:
 *
 */
public class T49_273 {
	/**
	 * 最小堆
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
		PriorityQueue <Long> queue=new PriorityQueue<>();
		Set <Long> set=new HashSet <> ();
		int[] factors={2,3,5};
		long num=0;
		queue.add(1L);
		set.add(1L);
		for(int i=0;i<n;i++)
		{
			num=queue.poll();
			for(int j=0;j<factors.length;j++)
			{
				long next=factors[j]*num;
				if(set.add(next))
				{
					queue.add(next);
				}
			}
		}
		return (int)num;

	}

	/**
	 * 动态规划
	 * @param n
	 * @return
	 */
	public int nthUglyNumber2(int n) {
		int[] dp=new int[n+1];
		dp[1]=1;
		int a=1,b=1,c=1;
		for(int i=2;i<=n;i++)
		{
			int n1=dp[a]*2;
			int n2=dp[b]*3;
			int n3=dp[c]*5;
			int min=Math.min(Math.min(n1,n2),n3);
			dp[i]=min;
			if(n1==min) a++;
			if(n2==min) b++;
			if(n3==min) c++;
		}
		return dp[n];

	}
}
