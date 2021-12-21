package zyz.algorithm.hot.jzoffer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 剑指 Offer 59 - I. 滑动窗口的最大值
 * @seq: 59_1
 * @address: https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * @idea:
 *
 */
public class T59_1_288 {

	public int[] maxSlidingWindow(int[] nums, int k) {

		int n=nums.length;
		if(n==0) return new int[0];
		int[] res=new int[n-k+1];
		Deque<Integer> queue=new LinkedList<>();
		queue.add(0);
		for(int i=1;i<k;i++)
		{
			while(!queue.isEmpty()&&nums[queue.peekFirst()]<nums[i])
				queue.pollFirst();
			queue.addFirst(i);
		}
		int high=k;
		int index=0;
		while(high<n)
		{
			res[index++]=nums[queue.peekLast()];
			while(!queue.isEmpty()&&nums[queue.peekFirst()]<nums[high])
				queue.pollFirst();
			queue.addFirst(high);
			int left=high-k+1;
			if(left>queue.peekLast()) queue.pollLast();
			high++;
		}
		res[index]=nums[queue.peekLast()];
		return res;
	}

	public static void main (String[] args) {
		int[] nums = {1,3,1,2,0,5};
		int k = 3;
		T59_1_288 t=new T59_1_288 ();
		System.out.println (Arrays.toString (t.maxSlidingWindow (nums,k)));
	}
}
