package zyz.algorithm.type.heap;

import java.util.*;

/**
 * @author zyz
 * @title: 前 K 个高频元素
 * @seq: 347
 * @address: https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @idea:
 *  * 3种方法
 *  * https://leetcode-cn.com/problems/top-k-frequent-elements/solution/leetcode-di-347-hao-wen-ti-qian-k-ge-gao-pin-yuan-/
 *  * 桶排序这个需要会
 */

public class TopKFrequentElements_193 {

	static class Node{
		int val;
		int times;

		public Node (int val , int times) {
			this.val = val;
			this.times = times;
		}
	}
	public static int[] topKFrequent1(int[] nums, int k) {
		Queue<Node> heap=new PriorityQueue <> (new Comparator < Node > () {
			@Override
			public int compare (Node o1 , Node o2) {

				return o2.times-o1.times;
			}
		});
		Map<Integer,Integer> map=new HashMap <> ();

		for (int i=0;i<nums.length;i++)
		{
			map.put (nums[i],map.getOrDefault (nums[i],0)+1);
			new ArrayList<> (heap);
		}
		for (Map.Entry <Integer,Integer> entry:map.entrySet ())
		{
			heap.offer (new Node (entry.getKey (),entry.getValue ()));
		}
		int[] arr=new int[k];
		for(int i=0;i<k;i++)
		{
			arr[i]=heap.poll().val;
		}
		return arr;
	}
	// 使用二维数组比单独创建个节点效率高
	public static int[] topKFrequent(int[] nums, int k) {
		Queue<int[]> heap=new PriorityQueue <> (
				new Comparator < int[] > () {
					@Override
					public int compare (int[] o1 , int[] o2) {
						return o2[1]-o1[1];
					}
				});
		Map<Integer,Integer> map=new TreeMap <> (new Comparator < Integer > () {
			@Override
			public int compare (Integer o1 , Integer o2) {
				return 0;
			}
		});

		for (int i=0;i<nums.length;i++)
		{
			map.put (nums[i],map.getOrDefault (nums[i],0)+1);
		}
		for (Map.Entry <Integer,Integer> entry:map.entrySet ())
		{
			// 这点可以优化 当堆中元素到达K时判断大小 决定是加入还是弹出
			// 这样效率才能到Olog2k
			heap.offer (new int[]{entry.getKey (),entry.getValue ()});
		}
		int[] arr=new int[k];
		for(int i=0;i<k;i++)
		{
			arr[i]=heap.poll()[0];
		}
		return arr;
	}
	public static void main (String[] args) {
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		System.out.println (Arrays.toString (topKFrequent (nums,k)));
	}

}

