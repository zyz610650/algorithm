package zyz.algorithm.hot.hot100;

import zyz.algorithm.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 根据身高重建队列
 * @seq: 406
 * @address: https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * @idea:
 */
public class QueueReconstructionbyHeight_211 {

	// list.toArray(new int[0][0]); list转数组
	public static void main (String[] args) {
		int[][] ans={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		ans=reconstructQueue(ans);

		System.out.println ("  dsad");
		Utils.print2Arr (ans);
	}
	public static int[][] reconstructQueue(int[][] people) {
		Utils.print2Arr (people);
		Arrays.sort(people,(o1, o2)->o1[1]==o2[1] ? o1[0]-o2[0]:o1[1]-o2[1]);
		System.out.println ("  dsad");
		Utils.print2Arr (people);
		List<int[]> list=new ArrayList<>();
		for(int i=0;i<people.length;i++)
		{
			if(people[i][1]==0)
			{
				list.add(people[i]);
				continue;
			}
			int cnt=0;
			int index=i;
			for(int j=0;j<i;j++)
			{
				if(cnt==people[i][1])
				{
					index=j;
					break;
				}
				if(people[j][0]>=people[i][0]) cnt++;
			}
			list.add(index,people[i]);
		}
		return list.toArray(new int[0][0]);
	}
}
