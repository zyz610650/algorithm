package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 39. 数组中出现次数超过一半的数字
 * @seq: 39
 * @address: https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * @idea:
 *
 */
public class T39_263 {

	public int majorityElement(int[] nums) {
		int num=nums[0];
		int n=0;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]==num) n++;
			else{
				n--;
			}
			if(n==0){
				num=nums[i];
				n=1;
			}
		}
		return num;
	}
}
