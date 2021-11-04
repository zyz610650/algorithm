package zyz.algorithm.heap;

import java.util.*;

/**
 * @author zyz
 * @title: 超级丑数
 * @seq: 23
 * @address: https://leetcode-cn.com/problems/super-ugly-number/
 * @idea:
 */
public class SuperUglyNumber_192 {
	public static void main (String[] args) {
		int[] factors={2,7,13,19};
		System.out.println (nthSuperUglyNumber(12,factors));
	}

	public static int nthSuperUglyNumber1(int n, int[] primes) {
		int[] arr=new int[primes.length];
		// Arrays.fill(arr,1);
		int[] dp=new int[n];
		dp[0]=1;
		for(int i=1;i<n;i++)
		{
			int min=Integer.MAX_VALUE;
			int index=0;
			int t=0;
			for(int j=0;j<arr.length;j++)
			{
				t=dp[arr[j]]*primes[j];
				if(t<min)
				{
					//index=j;
					min=t;
				}
			}
//			arr[index]++;
		    dp[i]=min;
			for(int j=0;j<arr.length;j++)
			{
				// arr[index]++;
				t=dp[arr[j]]*primes[j];
				if(t==min) arr[j]++;
			}
		}
		System.out.println (Arrays.toString (dp));
		return dp[n-1];
	}

	// 超时
	public  static int nthSuperUglyNumber(int n, int[] primes)
	{
		PriorityQueue<Long> queue=new PriorityQueue <> ();
		Set<Long> set=new HashSet <> ();
		queue.add (1L);
		set.add (1L);
		long cnt=0;
		long next;
		for(int i=1;i<=n;i++)
		{
			cnt=queue.poll ();
			for(int j=0;j<primes.length;j++)
			{
				next=primes[j]*cnt;
				if (set.add (next))
				{
					queue.add (next);
				}
			}
		}


		return (int) cnt;


	}
}
