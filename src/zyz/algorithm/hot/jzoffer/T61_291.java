package zyz.algorithm.hot.jzoffer;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 剑指 Offer 61. 扑克牌中的顺子
 * @seq: 61
 * @address: https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * @idea:
 *
 */
public class T61_291 {
	public static void main (String[] args) {
		int[] nums={0,0,1,2,5};
		System.out.println (isStraight (nums));
	}
	public static boolean isStraight(int[] nums) {
		Arrays.sort(nums);
		int n=0;
		int res=0;
		if(nums[0]==0) n=1;
		for(int i=1;i<nums.length;i++)
		{
			if(nums[i]==0) n++;
			if(nums[i-1]==0||nums[i]==0) continue;
			if(nums[i]==nums[i-1]) return false;
			if(nums[i]!=(nums[i-1]+1))
			{
				res+=(nums[i]-nums[i-1]-1);
			}
		}
		if(res<=n) return true;
		return false;
	}
}
