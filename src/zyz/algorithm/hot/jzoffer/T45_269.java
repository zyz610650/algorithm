package zyz.algorithm.hot.jzoffer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zyz
 * @title: 剑指 Offer 45. 把数组排成最小的数
 * @seq: 45
 * @address: https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * @idea:
 *
 */
public class T45_269 {
	public String minNumber(int[] nums) {
		PriorityQueue<String> heap=new PriorityQueue<>((a,b)->{
			return (a+b).compareTo(b+a);
		});
		for(int num:nums) heap.add(num+"");
		StringBuilder sb=new StringBuilder();
		while(!heap.isEmpty())
		{
			sb.append(heap.poll());
		}
		return sb.toString();
	}

	/**
	 * 不使用堆效率高
	 * @param nums
	 * @return
	 */
	public String minNumber1(int[] nums) {
		String[] strs = new String[nums.length];
		for(int i = 0; i < nums.length; i++)
			strs[i] = String.valueOf(nums[i]);
		Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
		StringBuilder res = new StringBuilder();
		for(String s : strs)
			res.append(s);
		return res.toString();
	}


}
