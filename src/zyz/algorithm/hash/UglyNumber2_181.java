package zyz.algorithm.hash;

import java.util.*;

/**
 * @author zyz
 * @title: 丑数 II
 * @seq: 264
 * @address: https://leetcode-cn.com/problems/ugly-number-ii/
 * @idea:
 *
 * https://leetcode-cn.com/problems/ugly-number-ii/solution/san-zhi-zhen-fang-fa-de-li-jie-fang-shi-by-zzxn/
 * 两种方式都要会
 * 本质就是要质因数组中的每个数循环和这个数组中的数相乘，去除重复元素后第n个就是自己要的第n个丑数 这两种方式都是这样
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
			System.out.print (2*dp[p2]+" "+3*dp[p3]+" "+5*dp[p5]);
			dp[i]=Math.min (Math.min (2*dp[p2],3*dp[p3]),5*dp[p5]);
			System.out.println (": "+dp[i]);
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
		System.out.println (Arrays.toString (dp));
		return dp[n];

		// 注意会出现重复的情况 下面每个if语句判断完不不结束 下面继续判读就解决了重复问题
//		2 3 5: 2
//		4 3 5: 3
//		4 6 5: 4
//		6 6 5: 5
//		6 6 10: 6 重 因为下面是挨着加的 所以去了重 只要和这个值一样的都加了
//		8 9 10: 8
//		10 9 10: 9
//		10 12 10: 10
//		12 12 15: 12
	}
}
