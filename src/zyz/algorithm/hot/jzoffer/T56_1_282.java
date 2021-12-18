package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 56 - I. 数组中数字出现的次数
 * @seq: 56_1
 * @address: https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * @idea:
 *
 */
public class T56_1_282 {

	public static void main (String[] args) {
		int[] nums={1,2,5,2};
		System.out.println (singleNumbers(nums));
	}
	public static int[] singleNumbers(int[] nums) {

		int m=1,n=0;
		for(int i=0;i<nums.length;i++)
			n^=nums[i];
		while((m&n)==0) m<<=1;
		int a=0,b=0;
		for(int i=0;i<nums.length;i++)
		{
			// 根据每个数二进制的第m为是1还是0进行划分
			// 分为两个组
			System.out.println (m&nums[i]);
			if((m&nums[i])!=0)
			{
				a^=nums[i];
			}else b^=nums[i];
		}
		return new int[]{a,b};
	}
}
