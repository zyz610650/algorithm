package zyz.algorithm.hot.jzoffer;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 剑指 Offer 03. 数组中重复的数字
 * @seq: 3
 * @address: https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @idea:
 */
public class T3_226 {
	public int findRepeatNumber(int[] nums) {
		Arrays.sort(nums);
		int n=nums.length;
		for(int i=1;i<n;i++)
		{
			if(nums[i]==nums[i-1]) return nums[i];
		}
		return -1;
	}
}
