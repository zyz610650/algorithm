package zyz.algorithm.hot.hot100;

/**
 * @author zyz
 * @title: 移动零
 * @seq: 283
 * @address: https://leetcode-cn.com/problems/move-zeroes/
 * @idea:
 */
public class MoveZeroes_201 {

	public static void main (String[] args) {
		System.out.println (Integer.valueOf ("0022"));

	}
	public void moveZeroes(int[] nums) {
		int t=0;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]==0) t++;
			else nums[i-t]=nums[i];
		}
		int i=nums.length;
		while(t>0)
		{
			nums[i-t]=0;
			t--;
		}
	}
}
