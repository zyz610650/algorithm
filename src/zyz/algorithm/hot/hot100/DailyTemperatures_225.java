package zyz.algorithm.hot.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: @zyz
 */
public class DailyTemperatures_225 {

	/**
	 * dp的思路
	 * @param temperatures
	 * @return
	 */
	public int[] dailyTemperatures(int[] temperatures)
	{
		int n=temperatures.length;
		int[] dp=new int[n];
		int[] res=new int[n];
		res[n-1]=0;
		for(int i=n-2;i>=0;i--){
			for (int j=i+1;j<n;)
			{
				if (temperatures[i]<temperatures[j])
				{
					dp[i]=j;
					break;
				}
				if(dp[j]==0) break;
				j=dp[j];
			}
			if (dp[i]!=0)
				res[i]=dp[i]-i;
		}
		return res;
	}


	/**
	 *  单调递增栈
	 * @param temperatures
	 * @return
	 */
	public int[] dailyTemperatures1(int[] temperatures)
	{
		int n=temperatures.length;
		int[] res=new int[n];

		Deque <Integer> stack=new ArrayDeque <> ();

		for(int i=n-1;i>=0;i--)
		{
			while(!stack.isEmpty()&&temperatures[stack.peek()]<=temperatures[i])
			{
				stack.pop();
			}
			if(!stack.isEmpty())
				res[i]=stack.peek()-i;
			stack.push(i);
		}
		return res;
	}
}
