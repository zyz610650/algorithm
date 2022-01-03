package zyz.algorithm.hot.top;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @author zyz
 * @title: 210. 课程表 II
 * @seq: 210
 * @address: https://leetcode-cn.com/problems/course-schedule-ii/
 * @idea:
 */
public class T210_311 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashSet<Integer>[] adjs=new HashSet[numCourses];
        int[] degree=new int[numCourses];
        for(int i=0;i<numCourses;i++)
            adjs[i]=new HashSet<>();
        for(int[] p: prerequisites)
        {
            adjs[p[1]].add(p[0]);
            degree[p[0]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(degree[i]==0) queue.add(i);
        int[] res=new int[numCourses];
        int i=0;
        int t=0;
        while(!queue.isEmpty())
        {
            t=queue.poll();
            res[i++]=t;
            for(int k:adjs[t])
            {
                degree[k]--;
                if(degree[k]==0) queue.add(k);
            }
        }
        if(i==numCourses) return res;
        else return new int[0];
    }
}
