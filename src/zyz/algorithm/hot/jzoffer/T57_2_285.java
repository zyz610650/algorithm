package zyz.algorithm.hot.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 剑指 Offer 57 - II. 和为s的连续正数序列
 * @seq: 57_2
 * @address: https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * @idea:
 *
 */
public class T57_2_285 {
	public static void main (String[] args) {

		System.out.println (Arrays.toString (findContinuousSequence (9)));
	}
	public static int[][] findContinuousSequence(int target) {
		List <int[]> list=new ArrayList <> ();
		int low=1,high=1;
		int cnt=1;

		while(high<target)
		{
			if(cnt==target)
			{
				int[] res=new int[high-low+1];
				int k=0;
				for(int i=low;i<=high;i++)
					res[k++]=i;
				list.add(res);
				cnt-=low;
				low++;

			}else if(cnt>target)
			{
				cnt-=low;
				low++;

			}else {
				high++;
				cnt+=high;
			}
		}
		return list.toArray(new int[0][0]);
	}
}
