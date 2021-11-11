package zyz.algorithm.hot.hot100;

import java.util.*;

/**
 * @author zyz
 * @title: 戳气球
 * @seq: 312
 * @address: https://leetcode-cn.com/problems/burst-balloons/
 * @idea:
 */
public class BurstBalloons_206 {
	public static void main (String[] args) {
		int[] nums = {3,1,5,8};
		System.out.println (maxCoins (nums));
	}
	public static int maxCoins(int[] nums) {
		Map<Integer,List<Integer>> map=new HashMap <> ();
		Queue <Integer> queue=new PriorityQueue<Integer> ();
		int mIndex=0;
		int res=0;
		for(int i=1;i<nums.length-1;i++)
		{
			queue.add(nums[i]);
			List < Integer > list = map.getOrDefault (nums[i] , new ArrayList <> ());
			list.add (i);
			map.put (nums[i],list);
		}

		while(queue.size ()!=0)
		{
			Integer num=queue.poll();
		    int index=map.get(num).get (0);

			int left,right;
            left=nums[index-1];
            right=nums[index+1];
			res+=(left*right*num);
			map.get (num).remove (0);

		}
		res+=(nums[0]*nums[nums.length-1]+nums[0]);
		return res;
	}
}
