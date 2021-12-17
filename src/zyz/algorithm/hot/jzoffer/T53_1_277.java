package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * @seq: 53
 * @address: https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @idea:
 *
 */
public class T53_1_277 {

	public int search(int[] nums, int target) {
		if(nums.length==0) return 0;
		int left=searchLeft(nums,target);
		int right=searchLeft(nums,target+1);
		if(left==nums.length||nums[left]!=target) return 0;
		return right-left;
	}
	public int searchLeft(int[] nums,int target)
	{
		int left=0,right=nums.length;
		int mid=0;
		while(left<right)
		{
			mid=left+((right-left)>>1);
			if(nums[mid]==target)
			{
				right=mid;
			}else if(nums[mid]<target)
			{
				left=mid+1;
			}else{
				right=mid;
			}
		}
		return left;
	}
}
