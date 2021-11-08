package zyz.algorithm.hot.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 课程表
 * @seq: 207
 * @address: https://leetcode-cn.com/problems/course-schedule/
 * @idea:
 */
public class CourseSchedule_199 {

	static int[] flag;
	static List< List <Integer>> degree;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		flag=new int[numCourses];
		degree=new ArrayList<>();
		for(int i=0;i<numCourses;i++)
		{
			degree.add (new ArrayList <> ());
		}

		for(int i=0;i<prerequisites.length;i++)
		{
			degree.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		// 比如 [2,3][4,5] 2,3和4,5没有必然的联系 一次dfs不能遍历完
		// 所以这里循环
		for(int i=0;i<numCourses;i++)
		{
			if(!dfs(i)) return false;
		}
		return true;

	}

	public static boolean dfs(int index)
	{
		if(flag[index]==1) return true;
		if(flag[index]==-1) return false;
		flag[index]=-1;
		for(int i=0;i<degree.get(index).size();i++)
		{
			if(!dfs(degree.get(index).get(i))) return false;
		}
		flag[index]=1;
		return true;
	}
//BFS

//	static List< List <Integer>> adj;
//	static int[] degree;
//	public boolean canFinish(int numCourses, int[][] prerequisites) {
//		Deque <Integer> queue=new LinkedList <> ();
//		adj=new ArrayList<>();
//		degree=new int[numCourses];
//
//		for(int i=0;i<numCourses;i++)
//		{
//			adj.add (new ArrayList <> ());
//		}
//
//		for(int i=0;i<prerequisites.length;i++)
//		{
//			adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
//			degree[prerequisites[i][0]]++;
//		}
//
//		for(int i=0;i<numCourses;i++)
//		{
//			if(degree[i]==0)
//				queue.add(i);
//		}
//		int t;
//		while(!queue.isEmpty())
//		{
//			t=queue.poll();
//			numCourses--;
//			for(int i=0;i<adj.get(t).size();i++)
//			{
//				if((--degree[adj.get(t).get(i)])==0) queue.add(adj.get(t).get(i));
//			}
//		}
//		if(numCourses==0) return true;
//		return false;
//
//	}
}
