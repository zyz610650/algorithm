package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * @seq: 52_2
 * @address: https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 * @idea:
 *
 */
public class T53_2_278 {

	public int missingNumber(int[] nums) {
		int n=nums.length;
		for(int i=0;i<n;i++)
		{
			if(nums[i]!=i) return i;
		}
		return n;
	}

	public int missingNumber1(int[] nums) {
		int n=nums.length;
		int low=0,high=n;
		while(low<high)
		{
			int mid=(low+high)>>1;
			if(nums[mid]!=mid) high=mid;
			else low=mid+1;

		}
		return low;
	}
}
