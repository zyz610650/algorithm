package zyz.algorithm.hot.hot100;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 找到所有数组中消失的数字
 * @seq: 448
 * @address: https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/zhao-dao-suo-you-shu-zu-zhong-xiao-shi-d-mabl/
 * @idea:
 */
public class FindAllNumbersDisappearedinanArray_215 {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list=new ArrayList<>();
		int n=nums.length;

		for(int i=0;i<n;i++)
		{
			int x=nums[i]%n;
			nums[x]+=n;
		}
		if(nums[0]<=n) list.add(n);
		for(int i=1;i<n;i++)
		{
			if(nums[i]<=n) list.add(i);
		}
		return list;

	}

	/**
	 * 超时
	 * @param nums
	 * @return
	 */
	public List <Integer> findDisappearedNumbers1(int[] nums) {
		List<Integer> list=new ArrayList <> ();
		int n=nums.length;
		for(int i=0;i<n;i++) list.add(i+1);
		for(int i=0;i<n;i++)
		{
			list.remove(Integer.valueOf(nums[i]));
		}
		return list;

	}
}
