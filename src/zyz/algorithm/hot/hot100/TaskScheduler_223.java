package zyz.algorithm.hot.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyz
 * @title: 任务调度器
 * @seq: 621
 * @address: https://leetcode-cn.com/problems/task-scheduler/
 * @idea:
 *  题解: https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
 *
 */
public class TaskScheduler_223 {
	public static void main (String[] args) {
		char [] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
		int n = 2;

	}

	/**
	 * 贪心
	 * @param tasks
	 * @param n
	 * @return
	 */
	public int leastInterval(char[] tasks, int n) {

		int[] buckets=new int[26];
		int maxTakes=0;

		for(char ch:tasks)
		{
			buckets[ch-'A']++;
			maxTakes=Math.max(maxTakes,buckets[ch-'A']);
		}
		// 任务不多时,发生了冷却时间没有任务执行的情况
		int res=0;
		for(int i=0;i<26;i++)
		{
			if(buckets[i]==maxTakes)
				res++;
		}
		// 任务很多时,冷却时间都被利用上执行其它任务
		return Math.max(tasks.length,(maxTakes-1)*(n+1)+res);
		// 看解析
		// https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
	}

	/**
	 * 暴力
	 * @param tasks
	 * @param n
	 * @return
	 */
	public static int leastInterval1(char[] tasks, int n) {
		Map<Integer,Integer> map=new HashMap<>();
		Map<Integer,Integer> times=new HashMap<>();
		int l=tasks.length;
		int cnt=0;
		for(int i=0;i<l;i++)
		{
			map.put(tasks[i]-'A',map.getOrDefault(tasks[i]-'A',0)+1);
			times.put(tasks[i]-'A',0);
		}

		while(!map.isEmpty())
		{
			int key=-1;
			int t=-1;
			int k;
			for(Map.Entry<Integer,Integer> entry:times.entrySet())
			{

				if(entry.getValue()==0)
				{
					k=entry.getKey();
					int v=map.get (k);
					if(v>t)
					{
						t=v;
						key=k;
					}

				}else{
					times.put(entry.getKey(),entry.getValue()-1);
				}
			}
			cnt++;
			if(key!=-1)
			{
				System.out.println ((char)('A'+key));
			}else{
				System.out.println ("待机");
			}

			if(key!=-1)
			{
				int val=map.get(key);
				if(val==1)
				{
					map.remove(key);
					times.remove(key);
				}else{
					map.put(key,val-1);
					times.put(key,n);
				}
			}
		}
		return cnt;
	}
}
