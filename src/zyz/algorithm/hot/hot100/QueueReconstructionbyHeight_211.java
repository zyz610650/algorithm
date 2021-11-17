package zyz.algorithm.hot.hot100;

import zyz.algorithm.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zyz
 * @title: 根据身高重建队列
 * @seq: 406
 * @address: https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * @idea:
 *
 * 我写的太繁琐了
 */
public class QueueReconstructionbyHeight_211 {

	// list.toArray(new int[0][0]); list转数组
	public static void main (String[] args) {
		int[][] ans={{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
		ans=reconstructQueue1(ans);
		System.out.println ();
		Utils.print2Arr (ans);
	}
	public static int[][] reconstructQueue(int[][] people) {

		Arrays.sort(people,(o1, o2)->o1[1]==o2[1] ? o1[0]-o2[0]:o1[1]-o2[1]);
		List<int[]> list=new ArrayList<>();
		for(int i=0;i<people.length;i++)
		{
			if(people[i][1]==0)
			{
				list.add(people[i]);
				continue;
			}
			int cnt=0;
			int j;
			for( j=0;j<i;j++)
			{
				if(cnt==people[i][1])
				{
					if(people[i][0]>=list.get (j)[0]) continue;
					else  break;
				}
				if(people[i][0]<=list.get (j)[0]) cnt++;
			}
			list.add(j,people[i]);
		}
		return list.toArray(new int[0][0]);
	}

	/**
	 * 解题思路：先排序再插入
	 * 1.排序规则：按照先H高度降序，K个数升序排序
	 * 2.遍历排序后的数组，根据K插入到K的位置上
	 *
	 * 核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
	 *
	 * @param people
	 * @return
	 */

	public static int[][] reconstructQueue1(int[][] people)
	{
		Arrays.sort (people,(o1 , o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0]);
		Utils.print2Arr (people);
		List<int[]> list=new LinkedList <> ();
		for(int i=0;i<people.length;i++)
		{

				list.add (people[i][1],people[i]);

		}
		return list.toArray (new int[list.size ()][2]);
	}
}
