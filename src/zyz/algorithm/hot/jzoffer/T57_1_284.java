package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 57. 和为s的两个数字
 * @seq: 57
 * @address: https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * @idea:
 *
 */
public class T57_1_284 {

	public int[] twoSum(int[] nums, int target) {
		int low=0,high=nums.length-1;
		while(low<high)
		{
//			提醒一下，判断条件最好不要用相加后的结果，应该用target - nums[i] 跟 nums[j]比较，
//			这样保证不会溢出。虽然这题中不会出错。
//			同样的例子还有二分查找，(left + right) / 2 可以用left + ((rigth - left) >> 1))代替
			if(nums[low]+nums[high]==target)
			{
				return new int[]{nums[low],nums[high]};
			}else if(nums[low]+nums[high]<target)
			{
				low++;
			}else{
				high--;
			}
		}
		return new int[2];
	}
}
