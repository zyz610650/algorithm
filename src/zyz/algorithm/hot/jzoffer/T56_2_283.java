package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * @seq: 56_2
 * @address: https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * @idea:
 *
 */
public class T56_2_283 {

	public int singleNumber(int[] nums) {
		int[] counts=new int[32];
		for(int i=0;i<nums.length;i++)
		{
			for(int j=0;j<32;j++)
			{
				counts[j]+=(nums[i]&1);
				nums[i]>>>=1;
			}
		}
		int res=0;
		for(int i=0;i<32;i++)
		{
			res<<=1;
			res|=(counts[31-i]%3);
		}
		return res;

	}
}
