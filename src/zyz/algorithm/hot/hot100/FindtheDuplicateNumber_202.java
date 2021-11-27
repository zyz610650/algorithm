package zyz.algorithm.hot.hot100;

/**
 * @author zyz
 * @title: 寻找重复数
 * @seq: 287
 * @address: https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @idea:
 * Floyd判圈算法
 *  要求会多解法
 *  https://leetcode-cn.com/problems/linked-list-cycle-ii/ 变形
 */
public class FindtheDuplicateNumber_202 {

	/**
	 * Floyd判圈算法
	 * @param nums
	 * @return
	 */
	public int findDuplicate(int[] nums) {
		int slow=0,fast=0;
		slow=nums[slow];
		fast=nums[nums[fast]];
		while(slow!=fast)
		{
			slow=nums[slow];
			fast=nums[nums[fast]];
		}

		fast=0;
		while(fast!=slow)
		{
			fast=nums[fast];
			slow=nums[slow];
		}
		return slow;
	}

	/**
	 * 二分
	 * @param nums
	 * @return
	 */
	public int findDuplicate1(int[] nums) {
		int slow=0,fast=nums.length-1;

		int mid=0;
		int cnt=0;
		int ans=0;
		while(slow<=fast)
		{
			mid=(slow+fast)>>1;
			cnt=0;
			for(int i=0;i<nums.length;i++)
			{
				if(nums[i]<=mid) cnt++;
			}
			if(cnt<=mid) slow=mid+1;
			else{
				fast=mid-1;
				ans=mid;
			}
		}
		return slow;
	}
}
