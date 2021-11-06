package zyz.algorithm.hot.hot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zyz
 * @title: 课程表
 * @seq: 207
 * @address: https://leetcode-cn.com/problems/course-schedule/
 * @idea:
 */
public class CourseSchedule_199 {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Set <Integer> set=new HashSet <> ();

		Arrays.sort (prerequisites , new Comparator < int[] > () {
			@Override
			public int compare (int[] o1 , int[] o2) {
				return o1[0]-o1[0];
			}
	});

		set.add(prerequisites[0][1]);
		for(int i=0;i<prerequisites.length;i++)
		{
			if(!set.contains(prerequisites[i][1]))
			{
				return false;
			}else{
				set.add(prerequisites[i][0]);
			}
		}
		return true;

	}
}
